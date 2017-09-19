package net.will.independenttests.basic

import static org.junit.Assert.*

import org.junit.Test

import groovy.test.GroovyAssert

class ModTest extends GroovyAssert {
    
    @Test
    public void test() {
        assert 0 % 5 == 0
        assert 1 % 5 == 1
        assert 5 % 5 == 0
    }
    
}
