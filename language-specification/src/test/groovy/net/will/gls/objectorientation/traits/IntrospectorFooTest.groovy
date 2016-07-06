package net.will.gls.objectorientation.traits

import org.junit.Test;

class IntrospectorFooTest {
    @Test
    void test() {
        def foo = new Foo()
        
        assert foo.whoAmI().is(foo)
    }
}
