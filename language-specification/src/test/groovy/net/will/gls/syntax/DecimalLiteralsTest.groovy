package net.will.gls.syntax

import org.junit.Test;

import groovy.test.GroovyAssert

class DecimalLiteralsTest extends GroovyAssert {
    @Test
    void testUsingExponents() {
        assert 1e3  ==  1_000.0
        assert 2E4  == 20_000.0
        assert 3e+1 ==     30.0
        assert 4E-2 ==      0.04
        assert 5e-1 ==      0.5
        
        assert 1e3  ==  1000
    }
    
    @Test
    void testUnderscoreInLiterals() {
        long maxLong = 0x7fff_ffff_ffff_ffffL
        assert maxLong == Long.MAX_VALUE
        
        long creditCardNumber = 1234_5678_9012_3456L
        assert creditCardNumber instanceof Long
    }
}
