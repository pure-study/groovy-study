package net.will.gls.objectorientation.traits.ducktyping

class Duck implements SpeakingDuck {
    String methodMissing(String name, args) {
        "${name.capitalize()}!"
    }
}
