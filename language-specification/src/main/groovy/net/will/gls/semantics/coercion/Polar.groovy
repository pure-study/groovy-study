package net.will.gls.semantics.coercion

import static java.lang.Math.cos
import static java.lang.Math.sin

class Polar {
    double r
    double phi
    
    def asType(Class target) {
        if (Cartesian==target) {
            return new Cartesian(x: r*cos(phi), y: r*sin(phi))
        }
    }
}
