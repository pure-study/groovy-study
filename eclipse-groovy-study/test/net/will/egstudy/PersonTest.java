package net.will.egstudy;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

    @Test
    public void testToString() {
        Person p = new Person();
        p.setName("ddd");
        p.setAge(18);
        assertEquals("ddd, 18", p.toString());
    }

}
