package net.will.egstudy

// --------------------------
def var = "say something"

def repeat(info, repeat=3) {
    for (i in 0..<repeat) {
        println 'Raw string ' + i
        println "This is ${i}: ${info}"
    }
}

repeat(var)
repeat(var, 2)

// --------------------------
int sum(int... var) {
    def total = 0
    for (i in var)
        total += i
    
    return total
}

println sum(1)
println sum(1, 2)
println sum(1, 2, 3)

// --------------------------
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

def today = Day.THURSDAY
switch (today) {
    case [Day.SATURDAY, Day.SUNDAY]:
        println "Weekends are cool"
        break
        
    case Day.MONDAY .. Day.FRIDAY:
        println "Boring work day"
        break
    
    default:
        println "Invalid day"
}

// --------------------------
enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27,7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7)
    
    double mass
    double radius
    
    Planet(double mass, double radius) {
        this.mass = mass
        this.radius = radius
    }
    
    void printMe() {
        println "${name()} has a mass of ${mass} and a radius of ${radius}"
    }
}

Planet.EARTH.printMe()

// --------------------------
def msg = "Hello!"
println msg.metaClass 
String.metaClass.up = { delegate.toUpperCase() }
println msg.up()

println "-----"
msg.metaClass.methods.each { println it.name }
println "-----"
msg.metaClass.properties.each { println it.name }
println "-----"

if (msg.metaClass.respondsTo(msg, 'up')) {
    println msg.toUpperCase()
}

if (msg.metaClass.hasProperty(msg, 'bytes')) {
    println msg.bytes.encodeBase64()
}

// --------------------------
