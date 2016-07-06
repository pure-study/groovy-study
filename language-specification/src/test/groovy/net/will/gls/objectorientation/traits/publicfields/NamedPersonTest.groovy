package net.will.gls.objectorientation.traits.publicfields

import org.junit.Test;

class NamedPersonTest {
    @Test
    void test() {
        def p = new Person()
        p.net_will_gls_objectorientation_traits_publicfields_Named__name = 'Bob'
        
        assert p.net_will_gls_objectorientation_traits_publicfields_Named__name == 'Bob'
    }
}
