package net.will.independenttests;

import spock.lang.Specification

public class VariousTypesOfCleanUpTest extends Specification {
    def cleanupSpec() {
        println 'in cleanupSpec method'
    }
    
    def cleanup() {
        println 'in cleanup method'
    }

    def "case 01"() {
        expect:
            println 'in expect of case 01'
            
        cleanup:
            println 'in cleanup of case 01'
    }

    def "case 02"() {
        expect:
            println 'in expect of case 02'
            assert false
            
        cleanup:
            println 'in cleanup of case 02'
    }

    def "case 03"() {
        expect:
            println 'in expect of case 03'
            throw new Exception("let's try")
            
        cleanup:
            println 'in cleanup of case 03'
    }
}
