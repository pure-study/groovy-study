package net.will.gls.closures.delegationstrategy.meaningofthis

import groovy.test.GroovyAssert

import org.junit.Test

class NestedClosures extends GroovyAssert {
    @Test
    void run() {
        def nestedClosures = {
            def cl = { this }
            cl()
        }
        assert nestedClosures() == this
    }
}
