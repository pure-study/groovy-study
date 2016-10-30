package net.will.gls.closures.delegationstrategy.strategy

import groovy.test.GroovyAssert
import net.will.gls.closures.delegationstrategy.delegate.Person

import org.junit.Test

class StrategySimpleTest extends GroovyAssert {
    @Test
    void simple() {
        def p = new Person(name:'Igor')
        def cl = {
            name.toUpperCase()
        }
        cl.delegate = p
        assert cl() == 'IGOR'
    }
}
