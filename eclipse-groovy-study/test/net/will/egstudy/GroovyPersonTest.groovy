package net.will.egstudy

import org.junit.Test;

class GroovyPersonTest extends groovy.test.GroovyAssert {
    @Test
    void testToString() {
        Person p = new Person("name":"ddd", "age":18)
        assertEquals("ddd, 18", p.toString())
    }
}
