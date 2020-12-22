package org.emoflon.ibex.tgg.integrate.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.Conflict;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_DeleteCorrs;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_MergeAndPreserve;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_PreferSource;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_PreferTarget;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_RevokeAddition;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.CRS_RevokeDeletion;
import org.emoflon.ibex.tgg.operational.strategies.integrate.conflicts.resolution.ConflictResolutionStrategy;

public class ConflictResolutionStrategyRegistry {

	public static String MERGE_AND_PRESERVE_NAME = "mergeAndPreserve";
	public static String PREFER_SOURCE_NAME = "preferSource";
	public static String PREFER_TARGET_NAME = "preferTarget";
	public static String REVOKE_ADDITION_NAME = "revokeAddition";
	public static String REVOKE_DELETION_NAME = "revokeDeletion";
	public static String DELETE_CORRESPONDENCES = "deleteCorrespondences";
	public static String CONTINUE_NAME = "continue";

	public static Set<String> RESOLUTION_STRATEGY_NAMES = new HashSet<>(
			Arrays.asList(MERGE_AND_PRESERVE_NAME, REVOKE_ADDITION_NAME, REVOKE_DELETION_NAME));
	public static Set<String> FALLBACK_STRATEGY_NAMES = new HashSet<>(
			Arrays.asList(PREFER_SOURCE_NAME, PREFER_TARGET_NAME));

	private static final Map<String, Container> NAME_MAPPING = buildNameMapping();

	private static Map<String, Container> buildNameMapping() {
		HashMap<String, Container> mapping = new HashMap<>();
		mapping.put(MERGE_AND_PRESERVE_NAME, new Container(CRS_MergeAndPreserve.class, conflict -> ((CRS_MergeAndPreserve) conflict).crs_mergeAndPreserve()));
		mapping.put(PREFER_SOURCE_NAME, new Container(CRS_PreferSource.class, conflict -> ((CRS_PreferSource) conflict).crs_preferSource()));
		mapping.put(PREFER_TARGET_NAME, new Container(CRS_PreferTarget.class, conflict -> ((CRS_PreferTarget) conflict).crs_preferTarget()));
		mapping.put(REVOKE_ADDITION_NAME, new Container(CRS_RevokeAddition.class, conflict -> ((CRS_RevokeAddition) conflict).crs_revokeAddition()));
		mapping.put(REVOKE_DELETION_NAME, new Container(CRS_RevokeDeletion.class, conflict -> ((CRS_RevokeDeletion) conflict).crs_revokeDeletion()));
		mapping.put(DELETE_CORRESPONDENCES, new Container(CRS_DeleteCorrs.class, conflict -> ((CRS_DeleteCorrs) conflict).crs_deleteCorrs()));
		return mapping;
	}

	private static class Container {
		private Class<? extends ConflictResolutionStrategy> crsInterface;
		private Consumer<Conflict> resolver;

		public Container(Class<? extends ConflictResolutionStrategy> crsInterface, Consumer<Conflict> resolver) {
			this.crsInterface = crsInterface;
			this.resolver = resolver;
		}
	}

	public static Class<? extends ConflictResolutionStrategy> getCRSInterface(String resolutionStrategyName) {
		return NAME_MAPPING.get(resolutionStrategyName).crsInterface;
	}

	public static Consumer<Conflict> getConflictResolver(String resolutionStrategyName) {
		return NAME_MAPPING.get(resolutionStrategyName).resolver;
	}
}