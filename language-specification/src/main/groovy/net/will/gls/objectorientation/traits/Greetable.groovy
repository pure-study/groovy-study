package net.will.gls.objectorientation.traits

trait Greetable {
    abstract String name()
    
    String greeting() {
        "Hello, ${name()}!"
    }
}
