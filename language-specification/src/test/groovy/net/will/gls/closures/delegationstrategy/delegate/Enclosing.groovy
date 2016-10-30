package net.will.gls.closures.delegationstrategy.delegate

import org.junit.Test;

import groovy.test.GroovyAssert

class Enclosing extends GroovyAssert {
    @Test
    void run() {
        def cl = { getDelegate() }
        def cl2 = { delegate }
        assert cl() == cl2()
        assert cl() == this
        
        def enclosed = {
            { -> delegate }.call()
        }
        assert enclosed() == enclosed
    }
}
