package org.emoflon.ibex.common.slimgt.scoping;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.emoflon.ibex.common.slimgt.slimGT.Import;
import org.emoflon.ibex.common.slimgt.slimGT.PackageReference;
import org.emoflon.ibex.common.slimgt.slimGT.PackageReferenceAlias;
import org.emoflon.ibex.common.slimgt.slimGT.PackageReferencePlain;

import com.google.common.collect.Iterables;
import com.google.inject.Provider;

public class SlimGTAliasedTypeScope extends SimpleScope {

	public SlimGTAliasedTypeScope(Collection<? extends EPackage> packages, Collection<? extends Import> imports) {
		super(new SimpleScope(Scopes.scopedElementsFor(getPackagesWithAlias(packages, imports), new AliasedNamedProvider())),
				Scopes.scopedElementsFor(packages, new RootPackageAwareQualifiedNamedProvider()));
	}

	private static Collection<EObject> getPackagesWithAlias(Collection<? extends EPackage> packages, Collection<? extends Import> imports) {
		var aliasedPackages = imports.parallelStream().flatMap(i -> i.getPackageAliases().stream()).map(a -> a.getImportedPackage()).toList();
		return packages.parallelStream().filter(aliasedPackages::contains).collect(Collectors.toSet());
	}

	@Override
	public Iterable<IEObjectDescription> getElements(final EObject object) {
		Iterable<IEObjectDescription> defaultImpl = super.getElements(object);
		if (defaultImpl.iterator().hasNext())
			return defaultImpl;

		// If default does not work, try using the exact URI of object (no normalization etc)
		Iterable<IEObjectDescription> localElements = getLocalElementsByEObject(object, EcoreUtil.getURI(object));
		Iterable<IEObjectDescription> parentElements = getParentElements(new Provider<Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> get() {
				return getParent().getElements(object);
			}
		});
		Iterable<IEObjectDescription> result = Iterables.concat(localElements, parentElements);
		return result;
	}

}

class AliasedNamedProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof Import imp) {
			for(PackageReference packageReference : imp.getPackageAliases()) {
				if(packageReference instanceof PackageReferenceAlias alias) {
					IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
					return converter.toQualifiedName(alias.getName());
				}
			}
		}
		
		return super.getFullyQualifiedName(obj);
	}
}

class RootPackageAwareQualifiedNamedProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof EPackage) {
			EPackage pack = EPackage.class.cast(obj);
			if (pack.eContainer() == null) {
				IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
				return converter.toQualifiedName(pack.getName());
			}
		}

		return super.getFullyQualifiedName(obj);
	}
}