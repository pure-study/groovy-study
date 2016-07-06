package net.will.gls.objectorientation.traits.ducktyping

trait SpeakingDuck {
    String speak() {
        // expects the quack method to be defined
        quack()
    }
}
