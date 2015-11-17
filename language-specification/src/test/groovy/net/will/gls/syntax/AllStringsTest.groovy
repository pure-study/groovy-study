package net.will.gls.syntax

import org.junit.Test;

class AllStringsTest extends groovy.test.GroovyAssert {
    @Test
    void testStringConcatenation() {
        assert 'ab' == 'a' + 'b'
        shouldFail {
            assert 'abc' == 'a' + 'b'
        }
    }
    
    @Test
    void testMultipleLinesString() {
        def strippedFirstNewline = '''\
line one
line two
'''
        
        assert !strippedFirstNewline.startsWith('\n')
    }
    
    @Test
    void testStringInterpolation() {
        def person = [name: 'Guillaume', age: 36]
        assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'
        assert '${name}' == "\${name}"
    }
    
    @Test
    void testInterpolatingClosureExpressions() {
        def sParameterLessClosure = "1 + 2 == ${-> 3}"
        assert sParameterLessClosure == '1 + 2 == 3'
        
        def sOneParamClosure = "1 + 2 == ${ w -> w << 3}"
        assert sOneParamClosure == '1 + 2 == 3'
    }
    
    @Test
    void testInterpolation_LazyEvaluationFeature() {
        def number = 1
        def eagerGString = "value == ${number}"
        def lazyGString = "value == ${ -> number }"
        
        assert eagerGString == "value == 1"
        assert lazyGString ==  "value == 1"
        
        number = 2
        assert eagerGString == "value == 1"
        assert lazyGString ==  "value == 2"
    }
    
    @Test
    void testTakeString() {
        def message = "The message is ${'hello'}"
        assert message instanceof GString
        
        def result = takeString(message)
        assert result instanceof String
        assert result == 'The message is hello'
    }
    
    String takeString(String message) {
        assert message instanceof String
        return message
    }
    
    @Test
    void testGstringHashcode() {
        assert "one: ${1}".hashCode() != "one: 1".hashCode()
        
        def key = "a"
        assert key instanceof String  // java.lang.String for now
        def m = ["${key}": "letter ${key}"]  // but GString for this line
        assert m["a"] == null
    }
    
    @Test
    void testTrippleDoubleQuotedString() {
        def name = 'Groovy'
        def template = """
            Dear Mr ${name},
        
            You're the winner of the lottery!
        
            Yours sincerely,
        
            Dave
        """
        
        assert template.toString().contains('Groovy')
    }
    
    @Test
    void testSlashyString() {
        def fooPattern = /.*foo.*/
        assert fooPattern == '.*foo.*'
        
        def escapeSlash = /The character \/ is a forward slash/
        assert escapeSlash == 'The character / is a forward slash'
        
        def multilineSlashy = /one
            two
            three/
        assert multilineSlashy.contains('\n')
        
        def color = 'blue'
        def interpolatedSlashy = /a ${color} car/
        assert interpolatedSlashy == 'a blue car'
    }
    
    @Test
    void testDollarSlashyString() {
        def name = "Guillaume"
        def date = "April, 1st"
        
        def dollarSlashy = $/
            Hello $name,
            today we're ${date}.
            
            $ dollar sign
            $$ escaped dollar sign
            \ backslash
            / forward slash
            $/ escaped forward slash
            $/$ escaped dollar slashy string delimiter
        /$
        
        assert [
            'Guillaume',
            'April, 1st',
            '$ dollar sign',
            '$ escaped dollar sign',
            '\\ backslash',
            '/ forward slash',
            '$/ escaped forward slash',
            '/$ escaped dollar slashy string delimiter'
        ].each { dollarSlashy.contains(it) }
    }
}
