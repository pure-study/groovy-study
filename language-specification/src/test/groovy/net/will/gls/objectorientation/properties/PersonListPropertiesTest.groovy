package net.will.gls.objectorientation.properties

import org.junit.Test;

class PersonListPropertiesTest {
    @Test
    void test() {
        def p = new PersonListProperties()
        assert p.properties.keySet().containsAll(['name','age'])
    }
}
