package net.will.gls.closures.delegationstrategy.strategy

class Person {
    String name
    
    def pretty = { 
        "My name is $name"
    }
    
    String toString() {
        pretty()
    }
}
