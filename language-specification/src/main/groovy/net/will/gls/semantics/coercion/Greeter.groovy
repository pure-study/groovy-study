package net.will.gls.semantics.coercion

abstract class Greeter {
    abstract String getName()
    
    void greet() {
        println "Hello, $name"
    }
}
