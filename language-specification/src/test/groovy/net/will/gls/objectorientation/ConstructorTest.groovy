package net.will.gls.objectorientation

import groovy.test.GroovyAssert

import org.junit.Test

class ConstructorTest extends GroovyAssert {
    @Test
    void testPositionalArgumentConstructor() {
        def person1 = new PersonConstructor('Marie', 1)
        assert person1.name == 'Marie'
        assert person1.age == 1
        
        def person2 = ['Marie', 2] as PersonConstructor
        assert person2.name == 'Marie'
        assert person2.age == 2
        
        PersonConstructor person3 = ['Marie', 3]
        assert person3.name == 'Marie'
        assert person3.age == 3
        
        shouldFail {
            def person_err1 = new PersonConstructor()
        }
        
        shouldFail {
            def person_err2 = new PersonConstructor(name: 'Marie', age: 2)
        }
    }
    
    @Test
    void testNamedArgumentConstructor() {
        def person4 = new PersonWOConstructor()
        assert person4 != null
        
        def person5 = new PersonWOConstructor(name: 'Marie')
        assert person5.name == 'Marie'
        
        def person6 = new PersonWOConstructor(age: 1)
        assert person6.age == 1
        
        def person7 = new PersonWOConstructor(name: 'Marie', age: 2)
        assert person7.name == 'Marie'
        assert person7.age == 2
    }
}
