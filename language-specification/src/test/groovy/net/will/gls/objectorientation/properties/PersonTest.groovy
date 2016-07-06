package net.will.gls.objectorientation.properties

import org.junit.Test

import groovy.test.GroovyAssert

class PersonTest extends GroovyAssert {

    @Test
    void test() {
        def p = new Person()
        p.name = 'Marge'
        assert p.name == 'Marge'
        p.name('Marge')
        assert p.wonder() == 'WonderMarge'
    }

}
