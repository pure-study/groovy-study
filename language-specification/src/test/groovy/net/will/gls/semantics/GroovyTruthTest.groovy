package net.will.gls.semantics

import org.junit.Test;

import groovy.test.GroovyAssert

class GroovyTruthTest extends GroovyAssert {
    @Test
    void test() {
        assert new Color(name: 'green')
        assert !new Color(name: 'red')
    }
}
