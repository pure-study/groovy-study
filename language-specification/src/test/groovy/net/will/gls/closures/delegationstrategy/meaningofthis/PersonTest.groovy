package net.will.gls.closures.delegationstrategy.meaningofthis

import groovy.test.GroovyAssert

import org.junit.Test

class PersonTest extends GroovyAssert {
    @Test
    void run() {
        def p = new Person(name:'Janice', age:74)
        assert p.dump() == 'Janice is 74 years old'
    }
}
