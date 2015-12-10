package net.will.gls.structure

import net.will.gls.structure.thirdpartylib.MultiplyTwo as OrigMultiplyTwo

class MultiplyTwo extends OrigMultiplyTwo {
    def static multiply(def value) {
        return value * 2 // fixed here
    }
}
