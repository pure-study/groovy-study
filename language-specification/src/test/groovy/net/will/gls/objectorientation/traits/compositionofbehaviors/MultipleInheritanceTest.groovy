package net.will.gls.objectorientation.traits.compositionofbehaviors

import static org.junit.Assert.*;

import org.junit.Test;

class MultipleInheritanceTest {
    @Test
    void test_Basic() {
        def d = new Duck()
        assert d.fly() == "I'm flying!"
        assert d.speak() == "I'm speaking!"
    }
    
    @Test
    void test_WithOverriding() {
        def d = new DuckWithOverriding()
        assert d.fly() == "I'm flying!"
        assert d.quack() == "Quack!"
        assert d.speak() == "Quack!"
    }
}
