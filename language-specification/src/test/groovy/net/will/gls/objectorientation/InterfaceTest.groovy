package net.will.gls.objectorientation

import org.junit.Test;

import groovy.test.GroovyAssert

class InterfaceTest extends GroovyAssert {
    @Test
    void testExplicitImplementation() {
        def greeter = new SystemGreeter()
        assert greeter instanceof Greeter
    }
    
    @Test
    void testNoImplementation() {
        def greeter = new DefaultGreeter()
        assert !(greeter instanceof Greeter)
    }
    
    @Test
    void testCoerceToImplementation() {
        def greeter = new DefaultGreeter()
        shouldFail {
            assert greeter instanceof Greeter
        }
        
        def coerced = greeter as Greeter
        assert coerced instanceof Greeter
    }
}
