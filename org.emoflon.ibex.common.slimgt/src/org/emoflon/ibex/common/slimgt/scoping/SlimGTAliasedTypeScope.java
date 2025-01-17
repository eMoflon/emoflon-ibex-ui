package org.emoflon.ibex.common.slimgt.scoping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.emoflon.ibex.common.slimgt.slimGT.Import;
import org.emoflon.ibex.common.slimgt.slimGT.PackageReferenceAlias;
import org.emoflon.ibex.common.slimgt.slimGT.SlimRuleNode;

import com.google.common.collect.Iterables;
import com.google.inject.Provider;

public class SlimGTAliasedTypeScope extends SimpleScope {

	public SlimGTAliasedTypeScope(Collection<Import> imports, Collection<? extends EObject> objects) {
		super(new SimpleScope(Scopes.scopedElementsFor(objects, new AliasedNamedProvider(imports))),
				Scopes.scopedElementsFor(objects, new RootPackageAwareQualifiedNamedProvider()));
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

	private Map<String, PackageReferenceAlias> package2alias = new HashMap<>();
	
	public AliasedNamedProvider(Collection<Import> imports) {
		for(var reference : imports.stream().flatMap(i -> i.getPackageAliases().stream()).toList()) {
			if(reference instanceof PackageReferenceAlias alias)
				package2alias.put(getFQN(alias.getImportedPackage()), alias);
		}
	}
	
	private String getFQN(EPackage pkg) {
		String fqn = "";
		EPackage currentPkg = pkg;
		while(currentPkg != null) {
			fqn = currentPkg.getName() + "." + fqn;
			if(currentPkg.getESuperPackage() == null)
				break;
			currentPkg = currentPkg.getESuperPackage();
		}
		
		if(currentPkg == null)
			return null;
		
		fqn = currentPkg.getNsURI() + " - " + currentPkg.getNsPrefix() + " - " + fqn;
		return fqn;
	}
	
	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof EClass eClass) {
			var pkg = eClass.getEPackage();
			if(package2alias.containsKey(getFQN(pkg))) {
				var alias = package2alias.get(getFQN(pkg));
				IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
				return converter.toQualifiedName(alias.getName() + "." + eClass.getName());
			}
		}
		
		return super.getFullyQualifiedName(obj);
	}
}

class RootPackageAwareQualifiedNamedProvider extends DefaultDeclarativeQualifiedNameProvider {

	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof EClass eClass) {
			String fqn = "";
			EPackage currentPkg = eClass.getEPackage();
			while(currentPkg != null) {
				fqn = currentPkg.getName() + "." + fqn;
				currentPkg = currentPkg.getESuperPackage();
			}
			IQualifiedNameConverter converter = new IQualifiedNameConverter.DefaultImpl();
			return converter.toQualifiedName(fqn + eClass.getName());
		}
		
		return super.getFullyQualifiedName(obj);
	}
}