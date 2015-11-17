package net.will.gls.operators

import org.junit.Test;

import groovy.test.GroovyAssert;

class ConditionalOperatorsTest extends GroovyAssert {
    @Test
    void testNotOperator() {
        assert (!true)    == false
        assert (!'foo')   == false
        assert (!'')      == true
    }
    
    @Test
    void testElvisOperator() {
        def username = ''
        def displayName = username ? username : 'Anonymous'
        assert displayName == 'Anonymous'
        
        username = 'Micheal'
        displayName = username ?: 'Anonymous'
        assert displayName == 'Micheal'
    }
}
