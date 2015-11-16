package net.will.ggs.testingguide

import org.junit.After;
import org.junit.Test;

class ExpandoMetaClassTest {
    @Test
    void testMetaClassOnString() {
        String.metaClass.swapCase = {->
            def sb = new StringBuffer()
            delegate.each {
                sb << (Character.isUpperCase(it as char) ? Character.toLowerCase(it as char) :
                    Character.toUpperCase(it as char))
            }
            sb.toString()
        }
        
        def s = "heLLo, worLD!"
        assert s.swapCase() == 'HEllO, WORld!'
    }
    
    @Test
    void testNewStaticMethod() {
        Book.metaClass.static.create << { String title ->
            new Book(title:title)
        }
        
        def b = Book.create("The Stand")
        assert b.title == 'The Stand'
    }
    
    @Test
    void testNewConstructor() {
        Book.metaClass.constructor << { String title ->
            new Book(title:title)
        }
        
        def b = new Book("The Stand")
        assert b.title == 'The Stand'
    }
    
    @Test
    void testOnPerObjectLevel() {
        def b = new Book(title: "The Stand")
        b.metaClass.getTitle {-> 'My Title' }
        
        assert b.title == 'My Title'
    }
    
    /**
     * Make sure that I change the metaClass property on a per test method level.
     */
    @After
    void cleanUpMetaClass() {
        GroovySystem.metaClassRegistry.setMetaClass(String, null)
        GroovySystem.metaClassRegistry.setMetaClass(Book, null)
    }
}
