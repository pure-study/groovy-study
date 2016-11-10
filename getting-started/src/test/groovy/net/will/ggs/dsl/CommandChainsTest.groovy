package net.will.ggs.dsl

import org.junit.Test;

import groovy.test.GroovyAssert

class CommandChainsTest extends GroovyAssert {
    def please(action) {
        [the: { what ->
            [of: { n -> action(what(n)) }]
        }]
    }
    
    @Test
    void test() {
        def show = { println it }
        def square_root = { Math.sqrt(it) }
        
        please show the square_root of 100
        assert true
    }
}
