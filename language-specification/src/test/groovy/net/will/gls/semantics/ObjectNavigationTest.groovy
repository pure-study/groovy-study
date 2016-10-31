package net.will.gls.semantics

import org.junit.Test;

import groovy.test.GroovyAssert
import groovy.util.XmlSlurper

class ObjectNavigationTest extends GroovyAssert {
    void aMethodFoo() {
        println "This is aMethodFoo."
    }
    
    void aMethodBar() {
        println "This is aMethodBar."
    }
    
    void anotherFooMethod() {
        println "This is anotherFooMethod."
    }
    
    void aSecondMethodBar() {
        println "This is aSecondMethodBar."
    }
    
    @Test
    void run() {
        assert ['aMethodBar', 'aSecondMethodBar'] as Set == this.class.methods.name.grep(~/.*Bar/) as Set
        
        assert 'aSecondMethodBar' == this.class.methods.name.grep(~/.*Bar/).sort()[1]
    }
    
    @Test
    void testGPathForXmlNavigation() {
        def xmlText = """
              | <root>
              |   <level>
              |      <sublevel id='1'>
              |        <keyVal>
              |          <key>mykey</key>
              |          <value>value 123</value>
              |        </keyVal>
              |      </sublevel>
              |      <sublevel id='2'>
              |        <keyVal>
              |          <key>anotherKey</key>
              |          <value>42</value>
              |        </keyVal>
              |        <keyVal>
              |          <key>mykey</key>
              |          <value>fizzbuzz</value>
              |        </keyVal>
              |      </sublevel>
              |   </level>
              | </root>
              """
        
          def root = new XmlSlurper().parseText(xmlText.stripMargin())
          assert root.level.size() == 1
          assert root.level.sublevel.size() == 2
          assert root.level.sublevel.findAll { it.@id == 1 }.size() == 1
          assert root.level.sublevel[1].keyVal[0].key.text() == 'anotherKey'
    }
}
