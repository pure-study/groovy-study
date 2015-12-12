package net.will.gls.objectorientation

class MethodsDefinition {
    static def fooWithNamedArguments(Map args) {
        "${args.name}: ${args.age}"
    }
    
    static def fooWithDefaultArguments(String par1, Integer par2 = 1) {
        [name: par1, age: par2]
    }
    
    def fooVarargsNormal(Object... args) {
        args.length
    }
    
    def fooVarargsArray(Object[] args) {
        args.length
    }
    
    def fooVarargsReturnNormal(Object... args) {
        args
    }
    
    def varargsOverloading(Object... args) {
        1
    }
    
    def varargsOverloading(Object x) {
        2
    }
}
