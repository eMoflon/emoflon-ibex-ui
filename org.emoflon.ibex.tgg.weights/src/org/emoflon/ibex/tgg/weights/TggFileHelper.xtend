package org.emoflon.ibex.tgg.weights

import com.google.common.hash.HashCode
import com.google.common.hash.Hashing
import com.google.common.io.Files
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap
import java.io.File
import java.io.FileNotFoundException
import java.net.URL
import org.eclipse.emf.common.CommonPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil

class TggFileHelper {

	static val hashCodes = new Object2ObjectOpenHashMap<String, HashCode>()
	static val resourceSet = new ResourceSetImpl()

	def static Resource getResource(URI importUri) {
		val resolvedUri = importUri.resolve(URI.createPlatformResourceURI("/", true))
		val fileUri = new URL(CommonPlugin.asLocalURI(resolvedUri).toString).toURI
		val file = new File(fileUri.path)

		var importedTgg = resourceSet.getResource(resolvedUri, false);

		if (!file.exists) {
			resourceSet.resources.remove(importedTgg)
			hashCodes.put(importUri.toString, null)
			throw new FileNotFoundException("The file at " + (importUri) + "does not exist")
		}

		val hash = Files.asByteSource(file).hash(Hashing.md5)

		if (importedTgg === null) {
//			resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore", LanguagePackage.eINSTANCE)
//			resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#/", LanguagePackage.eINSTANCE)
//			val l = resourceSet.getResource(URI.createPlatformResourceURI("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore"), true)
//			l.load(null)
			
			importedTgg = resourceSet.createResource(resolvedUri);
			importedTgg.load(null);
			EcoreUtil.resolveAll(importedTgg);
			hashCodes.put(importUri.toString, hash)
		} else if(hash != hashCodes.get(importUri.toString)) {
//			resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore", LanguagePackage.eINSTANCE)
//			resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#/", LanguagePackage.eINSTANCE)
//			val l = resourceSet.getResource(URI.createPlatformResourceURI("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore"), true)
//			l.load(null)
			
			resourceSet.resources.remove(importedTgg)
			importedTgg = resourceSet.createResource(resolvedUri);
			importedTgg.load(null);
			EcoreUtil.resolveAll(importedTgg);
			hashCodes.put(importUri.toString, hash)
		}

		return importedTgg
	}

}
