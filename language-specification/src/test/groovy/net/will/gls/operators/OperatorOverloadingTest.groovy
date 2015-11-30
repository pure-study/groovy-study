package net.will.gls.operators

import groovy.test.GroovyAssert

import org.junit.Test

class OperatorOverloadingTest extends GroovyAssert {
    @Test
    void testOperatorOverloading_Normal() {
        def b1 = new Bucket(4)
        def b2 = new Bucket(11)
        assert (b1 + b2).size == 15
    }
    
    @Test
    void testOperatorOverloading_ArbitraryArgument() {
        def b1 = new net.will.gls.operators.overloadingop.Bucket(4)
        assert (b1 + 11).size == 15
    }
}
