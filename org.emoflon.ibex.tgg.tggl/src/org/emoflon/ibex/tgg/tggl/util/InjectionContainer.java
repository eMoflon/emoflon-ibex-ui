package org.emoflon.ibex.tgg.tggl.util;

import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

record InjectionContainer(ResourceDescriptionsProvider resourceDescriptionsProvider, IContainer.Manager containerManager){

}
