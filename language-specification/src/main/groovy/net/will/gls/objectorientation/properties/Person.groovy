package net.will.gls.objectorientation.properties

class Person {
    String name
    
    void name(String name) {
        this.name = "Wonder$name"
    }
    
    String wonder() {
        this.name
    }
}
