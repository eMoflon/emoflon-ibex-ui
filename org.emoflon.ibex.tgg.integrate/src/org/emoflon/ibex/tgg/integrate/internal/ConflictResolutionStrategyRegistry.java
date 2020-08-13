package org.emoflon.ibex.tgg.integrate.internal;

import java.util.Map;
import java.util.function.Consumer;

import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_MergeAndPreserve;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_PreferSource;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_PreferTarget;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_RevokeAddition;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_RevokeDeletion;

public class ConflictResolutionStrategyRegistry {
	//public static final String ACT_AND_LET_REPAIR = "actAndLetRepair";
	public static final String MERGE_AND_PRESERVE = "mergeAndPreserve";
	public static final String PREFER_SOURCE = "preferSource";
	public static final String PREFER_TARGET = "preferTarget";
	public static final String REVOKE_ADDITION = "revokeAddition";
	public static final String REVOKE_DELETION = "revokeDeletion";

	private static final Map<String, Container> NAME_MAPPING = Map.of(
			MERGE_AND_PRESERVE, new Container(CRS_MergeAndPreserve.class, conflict -> ((CRS_MergeAndPreserve) conflict).crs_mergeAndPreserve()) ,
			PREFER_SOURCE, new Container(CRS_PreferSource.class, conflict -> ((CRS_PreferSource) conflict).crs_preferSource()),
			PREFER_TARGET, new Container(CRS_PreferTarget.class, conflict -> ((CRS_PreferTarget) conflict).crs_preferTarget()),
			REVOKE_ADDITION, new Container(CRS_RevokeAddition.class, conflict -> ((CRS_RevokeAddition) conflict).crs_revokeAddition()),
			REVOKE_DELETION, new Container(CRS_RevokeDeletion.class, conflict -> ((CRS_RevokeDeletion) conflict).crs_revokeDeletion())	
	);
	
	private static class Container {
		private Class<?> crsInterface;
		private Consumer<Conflict> resolver;
		
		public Container(Class<?> crsInterface, Consumer<Conflict> resolver) {
			super();
			this.crsInterface = crsInterface;
			this.resolver = resolver;
		}
	}
	
	public static Class<?> getCRSInterface(String crsInterfaceName) {
		return NAME_MAPPING.get(crsInterfaceName).crsInterface;
	}
	
	public static Consumer<Conflict> getConflictResolver(String crsInterfaceName) {
		return NAME_MAPPING.get(crsInterfaceName).resolver;
	}
}