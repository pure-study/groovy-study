package net.will.gls.operators.coercionop

class User {
    Long id
    String name
    
    def asType(Class target) {
        if (target == Identifiable) {
            return new Identifiable(name: name)
        }
        throw new ClassCastException("User cannot be coerced into $target")
    }
}
