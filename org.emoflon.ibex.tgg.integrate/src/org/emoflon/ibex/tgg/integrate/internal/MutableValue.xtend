package org.emoflon.ibex.tgg.integrate.internal

class MutableValue<T> {
	T value;

	def T get() {
		this.value
	}

	def void set(T value) {
		this.value = value
	}

	def static <T> of(T value) {
		val container = new MutableValue<T>()
		container.set(value)
		container
	}
}
