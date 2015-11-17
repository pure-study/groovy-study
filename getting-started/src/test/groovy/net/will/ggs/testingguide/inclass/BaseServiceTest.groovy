package net.will.ggs.testingguide.inclass

import org.junit.Test;

class BaseServiceTest {
    @Test
    void testDoSomethingWithClosureCoercion() {
        BaseService service = { -> println 'doing something' }
        service.doSomething()
    }
}
