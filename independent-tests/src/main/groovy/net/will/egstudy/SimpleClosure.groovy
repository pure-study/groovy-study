package net.will.egstudy

def say={ word ->
    println "Hi, $word!"
}

say("groovy")
say.call('groovy & grails')