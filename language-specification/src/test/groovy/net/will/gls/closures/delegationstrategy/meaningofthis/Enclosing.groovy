package net.will.gls.closures.delegationstrategy.meaningofthis

import groovy.test.GroovyAssert

import org.junit.Test

class Enclosing extends GroovyAssert {
    @Test
    void run() {
        def whatIsThisObject = { getThisObject() }
        assert whatIsThisObject() == this
        
        def whatIsThis = { this }
        assert whatIsThis() == this
    }
}
