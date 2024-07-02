package org.emoflon.ibex.tgg.tggl.validation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.emoflon.ibex.tgg.tggl.util.TGGLWorkspaceUtil;

public class TGGLResourceValidator extends ResourceValidatorImpl {

	@Override
	protected void validate(Resource resource, CheckMode mode, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		TGGLWorkspaceUtil.clearResourceCache();
		super.validate(resource, mode, monitor, acceptor);
	}

}
