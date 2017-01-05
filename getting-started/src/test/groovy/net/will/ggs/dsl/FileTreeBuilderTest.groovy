package net.will.ggs.dsl

import org.junit.Test

import groovy.test.GroovyAssert

class FileTreeBuilderTest extends GroovyAssert {
    @Test
    void test_fullStyle() {
        def tmpDir = File.createTempDir()
        def fileTreeBuilder = new FileTreeBuilder(tmpDir)
        fileTreeBuilder.dir('src') {
            dir('main') {
               dir('groovy') {
                  file('Foo.groovy', 'println "Hello"')
               }
            }
            dir('test') {
               dir('groovy') {
                  file('FooTest.groovy', 'class FooTest extends GroovyTestCase {}')
               }
            }
        }
        
        assert new File(tmpDir, '/src/main/groovy/Foo.groovy').text == 'println "Hello"'
        assert new File(tmpDir, '/src/test/groovy/FooTest.groovy').text == 'class FooTest extends GroovyTestCase {}'
    }
    
    @Test
    void test_shortStyle() {
        def tmpDir = File.createTempDir()
        def fileTreeBuilder = new FileTreeBuilder(tmpDir)
        fileTreeBuilder.src {
            main {
               groovy {
                  'Foo.groovy'('println "Hello"')
               }
            }
            test {
               groovy {
                  'FooTest.groovy'('class FooTest extends GroovyTestCase {}')
               }
            }
        }
        
        assert new File(tmpDir, '/src/main/groovy/Foo.groovy').text == 'println "Hello"'
        assert new File(tmpDir, '/src/test/groovy/FooTest.groovy').text == 'class FooTest extends GroovyTestCase {}'
    }
}
