package net.will.ggs.testingguide

import org.junit.Test;

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor

class FamilyTest {
    @Test
    void testNameOfMotherWithMockFor() {
        def mockedPerson = new MockFor(Person)
        
        mockedPerson.demand.getFirst{ 'dummy' }
        mockedPerson.demand.getLast{ 'name' }
        mockedPerson.use {
            def mary = new Person(first:'Mary', last:'Smith')
            def f = new Family(mother:mary)
            assert f.nameOfMother() == 'dummy name'
        }
        
        mockedPerson.expect.verify()
    }
    
    @Test
    void testNameOfMotherWithStubFor() {
        def stub = new StubFor(Person)
        
        stub.demand.with {
            getLast{ 'name' }
            getFirst{ 'dummy' }
        }
        
        stub.use {
            def john = new Person(first:'John', last:'Smith')
            def f = new Family(father:john)
            assert f.father.first == 'dummy'
            assert f.father.last == 'name'
        }
        
        stub.expect.verify()
    }
}
