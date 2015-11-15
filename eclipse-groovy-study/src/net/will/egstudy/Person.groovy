package net.will.egstudy

class Person {
    def name
    def age
    String toString() {
        "$name, $age"  // by default, Groovy returns the value of the last line of code
    }
    
    static main(args) {
        def p1 = new Person()
        p1.name = 'p1'
        p1.age = 21
        println p1
        
        def p2 = new Person(['name':'p2', 'age':22])
        println p2
        
        def p3 = new Person('name':'p3', 'age':23)
        println p3
    }
}
