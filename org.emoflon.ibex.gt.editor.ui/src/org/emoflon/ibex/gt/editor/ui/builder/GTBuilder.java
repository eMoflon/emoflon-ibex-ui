package org.emoflon.ibex.gt.editor.ui.builder;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * Builder for Graph Transformation Projects.
 */
public class GTBuilder extends IncrementalProjectBuilder implements IResourceDeltaVisitor {
	public static final String BUILDER_ID = "org.emoflon.ibex.gt.editor.ui.builder";

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		switch (kind) {
		case AUTO_BUILD:
		case CLEAN_BUILD:
		case FULL_BUILD:
		case INCREMENTAL_BUILD:
			generate();
			break;
		default:
			break;
		}
		return null;
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	private void generate() {
		System.out.println("Code generation for " + this.getProject().getName());
	}
}
