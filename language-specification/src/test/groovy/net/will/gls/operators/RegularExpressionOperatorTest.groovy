package net.will.gls.operators

import groovy.test.GroovyAssert

import java.util.regex.Matcher
import java.util.regex.Pattern

import org.junit.Test

class RegularExpressionOperatorTest extends GroovyAssert {
    @Test
    void testPatternOperator() {
        def p = ~/foo/
        assert p instanceof Pattern
        
        p = ~'foo'
        assert p instanceof Pattern
        p = ~"foo"
        assert p instanceof Pattern
        
        def pattern = 'foo'
        p = ~"${pattern}"
        assert p instanceof Pattern
        
        // the dollar-slashy string lets you use slashes and the dollar sign without having to escape them
        p = ~$/dollar/slashy $ string/$
        assert p instanceof Pattern
    }
    
    @Test
    void testFindOperator() {
        def text = "some text to match"
        def m = text =~ /match/
        assert m instanceof Matcher
        if (!m) {  // equivalent to calling if (!m.find())
            throw new RuntimeException("Oops, text not found!")
        }
    }
    
    @Test
    void testMatchOperator() {
        def text = "some text to match"
        def m = text ==~ /match/   // requires a strict match of the input string
        assert m instanceof Boolean
        if (m) {  // equivalent to calling if (text ==~ /match/)
            throw new RuntimeException("Should not reach that point!")
        }
    }
}
