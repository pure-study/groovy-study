package net.will.gls.closures.delegationstrategy.owner

import org.junit.Test;

import groovy.test.GroovyAssert

class EnclosedInInnerClassTest extends GroovyAssert {
    @Test
    void run() {
        def inner = new EnclosedInInnerClass.Inner()
        assert inner.cl() == inner
    }
}
