package net.will.ggs.testingguide

import org.junit.Test;

class PowerAssertionsTest {
    @Test
    void testPowerAssertions() {
        println([[1,2,3,3,3,3,4]].first())
        println([[1,2,3,3,3,3,4]].first().unique())
        
        assert [[1,2,3,3,3,3,4]].first().unique() != [1,2,3]
    }
}

