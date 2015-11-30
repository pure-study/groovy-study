package net.will.gls.operators;

import org.junit.Test;

import groovy.test.GroovyAssert;
import net.will.gls.operators.coercionop.Identifiable;
import net.will.gls.operators.coercionop.User;

class CoercionOperatorTest extends GroovyAssert {
    @Test
    void testCoercionOperator_Basic() {
        Integer x = 123
        
        String s1 = (String) x
        String s2 = x as String
    }
    
    @Test
    void testCoercionOperator_CustomConversionRule() {
        def u = new User(id: 1, name: 'Xavier')
        def p = u as Identifiable
        
        assert p instanceof Identifiable
        assert !(p instanceof User)
        assert p.name == 'Xavier'
        shouldFail {
            assert p.id == 1
        }
    }
}
