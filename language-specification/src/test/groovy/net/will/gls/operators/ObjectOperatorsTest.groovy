package net.will.gls.operators

import groovy.test.GroovyAssert
import net.will.gls.Person

import org.junit.Test

class ObjectOperatorsTest extends GroovyAssert {
    @Test
    void testSafeNavigationOperator() {
        def person = null
        def name = person?.name  // avoid NullPointException
        
        assert name == null
    }
    
    @Test
    void testDirectFieldAccessOperator() {
        def user = new User('Bob')
        assert user.name == 'Name: Bob'
        
        assert user.@name == 'Bob'
    }
    
    @Test
    void testMethodPointerOperator() {
        def str = 'example of method reference'
        def fun = str.&toUpperCase
        def upper = fun()
        assert upper == str.toUpperCase()
    }
    
    @Test
    void testMethodPointer_AsClosure() {
        def action = this.&describe
        def list = [
            new Person(name: 'Bob',   age: 42),
            new Person(name: 'Julia', age: 35)]
        
        assert transform(list, action) == ['Bob is 42', 'Julia is 35']
    }
    
    String describe(Person p) {
        "$p.name is $p.age"
    }
    
    def transform(List elements, Closure action) {
        def result = []
                elements.each {
            result << action(it)
        }
        result
    }
    
    @Test
    void testMethodPointer_OverloadedMethod() {
        def reference = this.&doSomething
        assert reference('foo') == 'FOO'
        assert reference(123) == 246
    }
    
    def doSomething(String str) { str.toUpperCase() }
    def doSomething(Integer x) { 2*x }
}
