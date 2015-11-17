package net.will.ggs.testingguide

import org.junit.Test

import groovy.transform.NotYetImplemented;;

class MyTestCaseWithJUnit extends groovy.test.GroovyAssert {
    @Test
    void testAssertions() {
        assertTrue(1 == 1)
        assertEquals("test", "test")

        def x = "42"
        assertNotNull "x must not be null", x
        assertNull null

        assertSame x, x
    }
    
    @Test
    void testScriptAssertions() {
        assertScript '''
        def x = 1
        def y = 2

        assert x + y == 3
        '''
    }
    
    @Test
    void testInvalidIndexAccess_WithoutExceptionJudgement() {
        def numbers = [1,2,3,4]
        shouldFail {
            numbers.get(4)
        }
    }
    
    @Test
    void testInvalidIndexAccess_WithExceptionJudgement() {
        def numbers = [1,2,3,4]
        shouldFail IndexOutOfBoundsException, {
            numbers.get(4)
        }
    }
    
    @Test
    void testInvalidIndexAccess_WithExceptionMessage() {
        def numbers = [1,2,3,4]
        def exception = shouldFail IndexOutOfBoundsException, {
            numbers.get(4)
        }
        assert exception.message.contains('Index: 4, Size: 4')
    }
    
    @Test
    @NotYetImplemented
    void testNotYetImplemented() {
        assert 1 == 2
    }
    
}
