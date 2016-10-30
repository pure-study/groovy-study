package net.will.gls.closures.delegationstrategy.meaningofthis

import groovy.test.GroovyAssert

import org.junit.Test

class EnclosedInInnerClassTest {
    @Test
    void run() {
        def inner = new EnclosedInInnerClass.Inner()
        assert inner.cl() == inner
    }
}
