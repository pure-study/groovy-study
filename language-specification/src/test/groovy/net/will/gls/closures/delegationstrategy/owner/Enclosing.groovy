package net.will.gls.closures.delegationstrategy.owner

import groovy.test.GroovyAssert

import org.junit.Test

class Enclosing extends GroovyAssert {
    @Test
    void run() {
        def whatIsOwnerMethod = { getOwner() }
        assert whatIsOwnerMethod() == this
        
        def whatIsOwner = { owner }
        assert whatIsOwner() == this
    }
}
