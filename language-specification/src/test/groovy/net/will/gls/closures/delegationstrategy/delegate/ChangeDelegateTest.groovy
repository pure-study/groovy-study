package net.will.gls.closures.delegationstrategy.delegate

import org.junit.Test

import groovy.test.GroovyAssert

class ChangeDelegateTest extends GroovyAssert {
    def p = new Person(name: 'Norman')
    def t = new Thing(name: 'Teapot')
    
    @Test
    void run() {
        def upperCasedName = {
            delegate.name.toUpperCase()
        }
        
        upperCasedName.delegate = p
        assert upperCasedName() == 'NORMAN'
        
        upperCasedName.delegate = t
        assert upperCasedName() == 'TEAPOT'
    }
}
