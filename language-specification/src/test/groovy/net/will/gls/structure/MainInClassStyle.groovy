package net.will.gls.structure

import org.codehaus.groovy.runtime.InvokerHelper

class MainInClassStyle extends Script {
    int power(int n) {
        2 ** n
    }
    
    def run() {
        println 'Hello'
        println "2^6 == ${power(6)}"
    }
    
    static void main(String[] args) {
        InvokerHelper.runScript(MainInClassStyle, args)
    }
}
