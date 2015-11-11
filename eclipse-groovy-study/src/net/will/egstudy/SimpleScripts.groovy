package net.will.egstudy

def var = "say something"

def repeat(info, repeat=3) {
    for (i in 0..<repeat) {
        println 'Raw string ' + i
        println "This is ${i}: ${info}"
    }
}

repeat(var)
repeat(var, 5)