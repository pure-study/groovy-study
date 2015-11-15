package net.will.egstudy

import static org.junit.Assert.*;

import org.junit.Test;

class GroovyPersonTest {
    @Test
    void testToString() {
        Person p = new Person("name":"ddd", "age":18)
        assertEquals("ddd, 18", p.toString())
    }
}
