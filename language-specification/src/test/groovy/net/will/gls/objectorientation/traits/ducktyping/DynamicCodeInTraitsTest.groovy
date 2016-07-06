package net.will.gls.objectorientation.traits.ducktyping

import org.junit.Test;

class DynamicCodeInTraitsTest {
    @Test
    void test_DynamicCode() {
        def d = new Duck()
        assert d.speak() == 'Quack!'
    }
    
    @Test
    void test_DynamicMethods() {
        def d = new Dynamic()
        
        assert d.existingProperty == 'ok'
        
        assert d.foo == null
        d.foo = 'bar'
        assert d.foo == 'bar'
        
        assert d.existingMethod() == 'ok'
        
        assert d.someMethod() == 'SOMEMETHOD'
    }
}
