package org.emoflon.ibex.common.slimgt.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SlimGTCollectionUtil {
	/**
	 * cast collection elements to clazz without checking actual type
	 * 
	 * @param <T>
	 * @param collection
	 * @param clazz
	 * @return
	 */
	public static <T> Collection<T> castCollection(Collection<?> collection, Class<T> clazz) {
		return collection.stream() //
//				.filter(clazz::isInstance) //
				.map(clazz::cast) //
				.collect(Collectors.toSet());
	}
	
	/**
	 * cast collection and filter all elements that are no instance of clazz
	 * 
	 * @param <T>
	 * @param collection
	 * @param clazz
	 * @return
	 */
	public static <T> Collection<T> castSafelyCollection(Collection<?> collection, Class<T> clazz) {
		return collection.stream() //
				.filter(clazz::isInstance) //
				.map(clazz::cast) //
				.collect(Collectors.toSet());
	}
	
	/**
	 * Joins two collections
	 * 
	 * @param <T>
	 * @param collections
	 * @return
	 */
	@SafeVarargs
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> join(Collection<T>... collections) {
		var joinedCollection = new HashSet<T>();
		for(var collection : collections) {
			joinedCollection.addAll(collection);
		}
		return joinedCollection;
	}
}
