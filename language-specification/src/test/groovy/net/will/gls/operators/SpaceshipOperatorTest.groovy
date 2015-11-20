package net.will.gls.operators

import org.junit.Test;

class SpaceshipOperatorTest {
    @Test
    void testSpaceshipOperator() {
        assert (1 <=> 1) == 0
        assert (1 <=> 2) == -1
        assert (2 <=> 1) == 1
        assert ('a' <=> 'z') == -1
    }
}
