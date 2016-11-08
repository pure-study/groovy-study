package net.will.gls.semantics.coercion

interface Predicate<T> {
    boolean accept(T obj)
}
