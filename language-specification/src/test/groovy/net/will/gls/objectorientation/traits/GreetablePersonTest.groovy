package net.will.gls.objectorientation.traits

import org.junit.Test;

class GreetablePersonTest {
    @Test
    void test() {
        def p = new Person()
        assert p.greeting() == 'Hello, Bob!'
    }
}
