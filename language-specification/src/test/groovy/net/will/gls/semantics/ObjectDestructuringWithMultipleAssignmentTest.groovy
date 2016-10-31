package net.will.gls.semantics

import org.junit.Test;

import groovy.test.GroovyAssert

class ObjectDestructuringWithMultipleAssignmentTest extends GroovyAssert {
    @Test
    void run() {
        def coordinates = new Coordinates(latitude: 43.23, longitude: 3.67)
        def (la, lo) = coordinates
        
        assert la == 43.23
        assert lo == 3.67
    }
}
