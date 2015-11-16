package net.will.ggs.testingguide

import org.junit.Test;

class GdkMethodsTest {
    @Test
    void testCombinations() {
        def combinations = [[2, 3],[4, 5, 6]].combinations()
        assert combinations == [[2, 4], [3, 4], [2, 5], [3, 5], [2, 6], [3, 6]]
    }
    
    @Test
    void testEachCombination() {
        [[2, 3],[4, 5, 6]].eachCombination { println it[0] + it[1] }
    }
}
