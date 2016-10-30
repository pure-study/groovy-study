package net.will.gls.closures.delegationstrategy.owner

import org.junit.Test;

import groovy.test.GroovyAssert

class NestedClosures extends GroovyAssert {
    @Test
    void run() {
        def nestedClosures = {
            def cl = { owner }
            cl()
        }
        assert nestedClosures() == nestedClosures
    }
}
