package net.will.independenttests

import org.junit.Ignore
import org.junit.Test

import groovy.test.GroovyAssert

class UrlFileTest extends GroovyAssert {
    
    @Test
    @Ignore("This is just a manual test")
    public void testFileOnHttp() {
        def text = new URL("http://10.116.53.91:8081/some/path/Config.groovy").text
        System.out.print(text)
        assertNotNull(text)
    }
    
    @Test
    @Ignore("This is just a manual test")
    public void testFileOnLocal() {
        def text = new URL("file:/some/path/Config.groovy").text
        System.out.print(text)
        assertNotNull(text)
    }
    
}
