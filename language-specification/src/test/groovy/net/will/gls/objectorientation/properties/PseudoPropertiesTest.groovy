package net.will.gls.objectorientation.properties

import org.junit.Test;

class PseudoPropertiesTest {
    @Test
    void test() {
        def p = new PseudoProperties()
        p.name = 'Foo'
        assert p.age == 42
        p.groovy = true
    }
}
