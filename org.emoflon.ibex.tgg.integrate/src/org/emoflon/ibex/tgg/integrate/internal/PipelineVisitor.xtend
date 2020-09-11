package org.emoflon.ibex.tgg.integrate.internal

import org.eclipse.emf.ecore.EObject
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageCount
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageCreated
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageDeleted
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageExists
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageSrc
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageTrg
import org.emoflon.ibex.tgg.integrate.integrate.PipelineStageType
import org.emoflon.ibex.tgg.integrate.integrate.Variable

class PipelineVisitor {

	final Variable variable;
	(PipelineStageSrc)=>void srcConsumer;
	(PipelineStageTrg)=>void trgConsumer;
	(PipelineStageCreated)=>void createdConsumer;
	(PipelineStageDeleted)=>void deletedConsumer;
	(PipelineStageType)=>void typeFilterConsumer;
	(PipelineStageCount)=>void countConsumer;
	(PipelineStageExists)=>void existsConsumer;

	new(Variable variable) {
		this.variable = variable;
	}

	def PipelineVisitor src((PipelineStageSrc)=>void consumer) {
		this.srcConsumer = consumer
		return this;
	}

	def PipelineVisitor trg((PipelineStageTrg)=>void consumer) {
		this.trgConsumer = consumer
		return this;
	}

	def PipelineVisitor created((PipelineStageCreated)=>void consumer) {
		this.createdConsumer = consumer
		return this;
	}

	def PipelineVisitor deleted((PipelineStageDeleted)=>void consumer) {
		this.deletedConsumer = consumer
		return this;
	}

	def PipelineVisitor type((PipelineStageType)=>void consumer) {
		this.typeFilterConsumer = consumer
		return this;
	}

	def PipelineVisitor count((PipelineStageCount)=>void consumer) {
		this.countConsumer = consumer
		return this;
	}

	def PipelineVisitor exists((PipelineStageExists)=>void consumer) {
		this.existsConsumer = consumer
		return this;
	}

	def void visit() {
		val start = variable.pipeline.start
		visitNext(start)
	}

	private def void visit(PipelineStageSrc p) {
		if (srcConsumer !== null) {
			srcConsumer.apply(p)
		}
		
		visitNext(p.next)
	}

	private def void visit(PipelineStageTrg p) {
		if (trgConsumer !== null) {
			trgConsumer.apply(p)
		}
		
		visitNext(p.next)
	}

	private def void visit(PipelineStageCreated p) {
		if (createdConsumer !== null) {
			createdConsumer.apply(p)
		}
		
		visitNext(p.next)
	}

	private def void visit(PipelineStageDeleted p) {
		if (deletedConsumer !== null) {
			deletedConsumer.apply(p)
		}
		
		visitNext(p.next)
	}

	private def void visit(PipelineStageType p) {
		if (typeFilterConsumer !== null) {
			typeFilterConsumer.apply(p)
		}
		
		visitNext(p.next)
	}

	private def void visit(PipelineStageCount p) {
		if (countConsumer !== null) {
			countConsumer.apply(p)
		}
	}

	private def void visit(PipelineStageExists p) {
		if (existsConsumer !== null) {
			existsConsumer.apply(p)
		}
	
	}

	private def void visitNext(EObject p) {
		switch p {
			PipelineStageSrc: p.visit
			PipelineStageTrg: p.visit
			PipelineStageCreated: p.visit
			PipelineStageDeleted: p.visit
			PipelineStageType: p.visit
			PipelineStageCount: p.visit
			PipelineStageExists: p.visit
		}
	}
}
