package net.will.gls.syntax

import org.junit.Test;

class CharacterTest extends groovy.test.GroovyAssert {
    @Test
    void testCharacterInGroovy() {
        char c1 = 'A'
        assert c1 instanceof Character
        
        def c2 = 'B' as char
        assert c2 instanceof Character
        
        def c3 = (char)'C'
        assert c3 instanceof Character
    }
}
