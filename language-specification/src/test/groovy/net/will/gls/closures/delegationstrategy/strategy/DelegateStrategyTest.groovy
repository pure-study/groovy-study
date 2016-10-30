package net.will.gls.closures.delegationstrategy.strategy

import groovy.test.GroovyAssert

import org.junit.Test

class DelegateStrategyTest extends GroovyAssert {
    
    @Test
    void ownerFirstTest() {
        def p = new Person(name: 'Sarah')
        def t = new Thing(name: 'Teapot')
        assert p.toString() == 'My name is Sarah'
        
        p.pretty.delegate = t
        assert p.toString() == 'My name is Sarah'
    }
    
    @Test
    void delegateFirstTest() {
        def p = new Person(name: 'Sarah')
        def t = new Thing(name: 'Teapot')
        
        p.pretty.delegate = t
        p.pretty.resolveStrategy = Closure.DELEGATE_FIRST
        assert p.toString() == 'My name is Teapot'
    }
}
