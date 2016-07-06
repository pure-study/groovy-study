package net.will.gls.objectorientation.traits.compositionofbehaviors

class DuckWithOverriding implements FlyingAbility, SpeakingAbility {
    String quack() {
        "Quack!"
    }
    
    String speak() {
        quack()
    }
}
