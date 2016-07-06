package net.will.gls.objectorientation.traits.ducktyping

class Dynamic implements DynamicObject {
    String existingProperty = 'ok'
    
    String existingMethod() {
        'ok'
    }
}
