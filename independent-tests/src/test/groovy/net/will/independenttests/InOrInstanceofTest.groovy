package net.will.independenttests;

import static groovy.test.GroovyAssert.shouldFail
import spock.lang.Specification

public class InOrInstanceofTest extends Specification {
    def "test0"() {
        setup:
        def var = ['a', 'b', 'c']
        
        expect:
        assert var instanceof List
    }
    
    def "test 1st"() {
        setup:
        def ele = 'abc'
        
        expect:
        shouldFail {
            assert ele in List
        }
    }
    
    def "test 2nd"() {
        setup:
        def var = ['a', 'b', 'c']
        
        expect:
        assert var in List
    }
    
    def "test 3rd"() {
        setup:
        def var = ['a', 'b', 'c']
        def ele = 'a'
        
        expect:
        assert ele in var
    }
    
    def "test 4th"() {
        setup:
        def var = ['a', 'b', 'c']
        def ele = 'd'
        
        expect:
        shouldFail {
            assert ele in var
        }
    }
}
