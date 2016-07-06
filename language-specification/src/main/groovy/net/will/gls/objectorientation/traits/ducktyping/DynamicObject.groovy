package net.will.gls.objectorientation.traits.ducktyping

trait DynamicObject {
    private Map props = [:]
    
    def methodMissing(String name, args) {
        name.toUpperCase()
    }
    
    def propertyMissing(String prop) {
        props[prop]
    }
    
    void setProperty(String prop, Object value) {
        props[prop] = value
    }
}
