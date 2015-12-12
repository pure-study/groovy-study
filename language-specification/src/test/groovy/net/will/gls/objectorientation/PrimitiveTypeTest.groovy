package net.will.gls.objectorientation

import org.junit.Test;

import groovy.test.GroovyAssert;

class PrimitiveTypeTest extends GroovyAssert {
    @Test
    void testPrimitiveType() {
        assert Foo.class.getDeclaredField('i').type == int.class
//        print Foo.i
        assert Foo.i != int.class
        assert Foo.i.class == Integer.class
    }
}
