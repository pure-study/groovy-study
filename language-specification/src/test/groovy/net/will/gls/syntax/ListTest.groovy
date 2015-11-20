package net.will.gls.syntax

import org.junit.Test;

import groovy.test.GroovyAssert

class ListTest extends GroovyAssert {
    @Test
    void testHeterogeneousList() {
        def heterogeneous = [1, "a", true]
        
        assert heterogeneous instanceof List
        assert heterogeneous.size() == 3
    }
    
    @Test
    void testUsingSpecifiedListType() {
        def arrayList = [1, 2, 3]
        assert arrayList instanceof java.util.ArrayList
        
        def linkedList = [2, 3, 4] as LinkedList
        assert linkedList instanceof java.util.LinkedList
        
        LinkedList otherLinked = [3, 4, 5]
        assert otherLinked instanceof java.util.LinkedList
    }
    
    @Test
    void testListAccess() {
        def letters = ['a', 'b', 'c', 'd']
        
        assert letters[0] == 'a'
        assert letters[1] == 'b'
        
        assert letters[-1] == 'd'
        assert letters[-2] == 'c'
        
        letters[2] = 'C'
        assert letters[2] == 'C'
        
        letters << 'e'
        assert letters[ 4] == 'e'
        assert letters[-1] == 'e'
        
        letters.add 'f'
        assert letters[-1] == 'f'
        
        assert letters[1, 3] == ['b', 'd']
        assert letters[2..4] == ['C', 'd', 'e']
    }
    
    @Test
    void testListAccess_AddAll() {
        def letters = ['a', 'b', 'c', 'd', 'e', 'f']
        
        shouldFail {
            //groovy.lang.MissingPropertyException: Exception evaluating property 'addAll' for java.util.ArrayList, Reason: groovy.lang.MissingPropertyException: No such property: addAll for class: java.lang.String
            letters.addAll ['g', 'h']  // groovy.lang.MissingPropertyException
        }
        
        letters.addAll(['g', 'h'])
        assert letters[-2] == 'g'
        assert letters.size() == 8
    }
    
    @Test
    void testMultiDimensionalList() {
        def multi = [[0, 1], [2, 3]]
        assert multi[1][0] == 2
    }
}
