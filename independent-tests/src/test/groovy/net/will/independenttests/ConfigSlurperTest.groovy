package net.will.independenttests

import org.junit.Test

import groovy.test.GroovyAssert

class ConfigSlurperTest extends GroovyAssert {
    def configContentInMultipleLines = """
profile {
    functions {
        includes = [
            [module:"m1", function:["f1","f2"]],
            [module:"m2", function:["f3"]]
        ]
        excludes = [
        ]
        queries = [
            [id:"q1", query:{it.some.prop}]
        ]
    }
    groups = [
    ]
 }
        """
    
    def configContentInOneLine = """
profile { functions { includes = [ [module:"m1", function:["f1","f2"]], [module:"m2", function:["f3"]] ] excludes = [ ] } groups = [ ] }
        """
    
    @Test
    public void testReadConfigFileWithNoError() {
        def config = new ConfigSlurper().parse(configContentInMultipleLines)
        
        assert config?.profile?.functions?.includes?.size() == 2
        assert config?.profile?.groups?.size() == 0
    }
    
    @Test
    public void testReadConfigFileWithErrors() {
        shouldFail {
            new ConfigSlurper().parse(configContentInOneLine)
        }
    }
}
