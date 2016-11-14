package net.will.ggs.dsl

import org.junit.Test

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import groovy.test.GroovyAssert

class CommandChainsTest extends GroovyAssert {
    def please(action) {
        [the: { what ->
            [of: { n -> action(what(n)) }]
        }]
    }
    
    @Test
    void test_exp01() {
        def show = { println it }
        def square_root = { Math.sqrt(it) }
        
        // equivalent to: please(show).the(square_root).of(100)
        please show the square_root of 100
        assert true
    }
    
    def split(originalString) {
        [on: { sep ->
             [trimming: { trimChar ->
                  Splitter.on(sep).trimResults(CharMatcher.is(trimChar as char)).split(originalString).iterator().toList()
             }]
        }]
    }
    
    @Test
    void test_exp02() {
        // Splitter.on(',').trimResults(CharMatcher.is('_' as char)).split("_a ,_b_ ,c__").iterator().toList()
        List result = split "_a ,_b_ ,c__" on ',' trimming '_'
        println result
        
        assert result.contains('a ')
        assert result.contains('b_ ')
        assert result.contains('c')
    }
}
