package org.emoflon.ibex.tgg.weights

import org.emoflon.ibex.common.collections.CollectionFactory
import com.google.common.hash.Hashing
import com.google.common.io.Files
import java.io.File
import java.io.FileNotFoundException
import java.net.URL
import org.apache.log4j.Logger
import org.eclipse.emf.common.CommonPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil

class TggFileHelper {

	static val hashCodes = CollectionFactory.cfactory.createObjectToObjectHashMap()
	static val resourceSet = new ResourceSetImpl()
	static val logger = Logger.getLogger(TggFileHelper)

	def static Resource getResource(URI importUri) {
		logger.debug("Attempting to load TGG from "+importUri.toString)
		try {
			val resolvedUri = importUri.resolve(URI.createPlatformResourceURI("/", true))
			val fileUri = new URL(CommonPlugin.asLocalURI(resolvedUri).toString).toURI
			val file = new File(fileUri.path)

			var importedTgg = resourceSet.getResource(resolvedUri, false);

			if (!file.exists) {
				resourceSet.resources.remove(importedTgg)
				hashCodes.put(importUri.toString, null)
				throw new FileNotFoundException("The file at " + (importUri) + " does not exist")
			}

			val hash = Files.asByteSource(file).hash(Hashing.md5)

			if (importedTgg === null) {
				logger.debug("TGG was not loaded before: "+importUri.toString)
//				resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore", LanguagePackage.eINSTANCE)
//				resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#/", LanguagePackage.eINSTANCE)
//				val l = resourceSet.getResource(URI.createPlatformResourceURI("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore"), true)
//				l.load(null)
				importedTgg = resourceSet.createResource(resolvedUri);
				importedTgg.load(null);
				EcoreUtil.resolveAll(importedTgg);
				hashCodes.put(importUri.toString, hash)
			} else if (hash != hashCodes.get(importUri.toString)) {
				logger.debug("File changed, reloading TGG "+importUri.toString)
//				resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore", LanguagePackage.eINSTANCE)
//				resourceSet.packageRegistry.put("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore#/", LanguagePackage.eINSTANCE)
//				val l = resourceSet.getResource(URI.createPlatformResourceURI("platform:/resource/org.emoflon.ibex.tgg.core.language/model/Language.ecore"), true)
//				l.load(null)
				resourceSet.resources.remove(importedTgg)
				importedTgg = resourceSet.createResource(resolvedUri);
				importedTgg.load(null);
				EcoreUtil.resolveAll(importedTgg);
				hashCodes.put(importUri.toString, hash)
			}

			return importedTgg

		} catch (Exception e) {
			logger.warn("Cannot load TGG from " + importUri.toString + "\n" + e)
			throw e
		}
	}

}
