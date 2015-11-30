package net.will.gls.operators

import org.junit.Test;

import groovy.test.GroovyAssert

class CallOperatorTest extends GroovyAssert {
    @Test
    void testCallOperator() {
        def mc = new MyCallable()
        assert mc.call(2) == 4
        assert mc(2) == 4
    }
}
