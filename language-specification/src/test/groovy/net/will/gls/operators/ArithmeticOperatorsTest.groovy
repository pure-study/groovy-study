package net.will.gls.operators

import org.junit.Test;

import groovy.test.GroovyAssert

class ArithmeticOperatorsTest extends GroovyAssert {
    @Test
    void testIntdiv() {
        assert 3 / 2 == 1.5
        
        assert 3.intdiv(2) == 1
    }
    
    @Test
    void testUnaryOperators() {
        assert +3 == 3
        assert -4 == 0 - 4
        
        assert -(-1) == 1
    }
    
    @Test
    void testAssignmentArithmeticOperators() {
        def a = 4
        a += 3
        
        assert a == 7
        
        def b = 5
        b -= 3
        
        assert b == 2
        
        def c = 5
        c *= 3
        
        assert c == 15
        
        def d = 10
        d /= 2
        
        assert d == 5
        
        def e = 10
        e %= 3
        
        assert e == 1
        
        def f = 3
        f **= 2
        
        assert f == 9
    }
}
