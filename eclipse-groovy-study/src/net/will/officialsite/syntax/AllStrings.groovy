package net.will.officialsite.syntax

class AllStrings {
    static main(args) {
        method02()
    }
    
    static method01() {
        assert 'ab' == 'a' + 'b'
        
        assert 'abc' == 'a' + 'b'  // ERROR
    }
    
    static method02() {
        def strippedFirstNewline = '''\
line one
line two
line three
'''
        
        assert !strippedFirstNewline.startsWith('\n')
    }
}
