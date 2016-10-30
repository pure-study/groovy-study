package net.will.gls.closures

import groovy.test.GroovyAssert

import org.junit.Test

class CallingAClosure extends GroovyAssert {

    @Test
    public void test() {
        def isOdd = { int i -> i%2 == 1 }
        assert isOdd(3) == true
        assert isOdd.call(2) == false
        
        def isEven = { it%2 == 0 }
        assert isEven(3) == false
        assert isEven.call(2) == true
    }

}
