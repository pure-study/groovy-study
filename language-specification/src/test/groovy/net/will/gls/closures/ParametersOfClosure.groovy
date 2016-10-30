package net.will.gls.closures

import groovy.test.GroovyAssert

import org.junit.Test

class ParametersOfClosure extends GroovyAssert {

    @Test
    public void test_AcceptsNoArguments() {
        def magicNumber = { -> 42 }
        
        shouldFail {
            magicNumber(11)
        }
    }

    @Test
    public void test_varargs() {
        def multiConcat = { int n, String... args ->
            args.join('') * n
        }
        
        assert multiConcat(2, 'abc','def') == 'abcdefabcdef'
    }

    @Test
    public void test_varargs_DeclaredAsAnArray() {
        def concat2 = { String[] args -> args.join('') }
        assert concat2('abc', 'def') == 'abcdef'
    }

}
