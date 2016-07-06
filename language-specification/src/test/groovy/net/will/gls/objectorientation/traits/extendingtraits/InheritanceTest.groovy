package net.will.gls.objectorientation.traits.extendingtraits

import org.junit.Test;

class InheritanceTest {
    @Test
    void test() {
        def si = new SomeIdentifier()
        si.id = 10
        si.name = "somename"
        
        assert si.id == 10
        assert si.name == "somename"
    }
}
