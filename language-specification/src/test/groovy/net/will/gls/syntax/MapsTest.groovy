package net.will.gls.syntax

import org.junit.Test;

import groovy.test.GroovyAssert

class MapsTest extends GroovyAssert {
    @Test
    void testMapBasic() {
        def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
        
        assert colors['red'] == '#FF0000'
        assert colors.green  == '#00FF00'
        
        colors['pink'] = '#FF00FF'
        colors.yellow  = '#FFFF00'
        
        assert colors.pink == '#FF00FF'
        assert colors['yellow'] == '#FFFF00'
        
        assert colors instanceof java.util.LinkedHashMap
        
        assert colors.unknown == null
    }
    
    @Test
    void testNumberAsKeys() {
        def numbers = [1: 'one', 2: 'two']
        
        assert numbers[1] == 'one'
    }
    
    @Test
    void testVariableAsKeys_Invalid() {
        def key = 'name'
        def person = [key: 'Guillaume']
        
        shouldFail {
            assert person.containsKey('name')
        }
        assert person.containsKey('key')
    }
    
    @Test
    void testVariableAsKeys_Valid() {
        def key = 'name'
        def person = [(key): 'Guillaume']
        
        assert person.containsKey('name')
        shouldFail {
            assert person.containsKey('key')
        }
    }
}
