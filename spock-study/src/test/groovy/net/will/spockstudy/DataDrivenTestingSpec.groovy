package net.will.spockstudy

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class DataDrivenTestingSpec extends Specification {
    @Shared
    sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
    
    def setupSpec() {
        sql.execute("create table maxdata (id int primary key, a int, b int, c int)")
        sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
    }
    
    def "minimum of #a and #b is #c"() {
        expect:
            Math.min(a, b) == c
        
        where:
            a = 3
            b = Math.random() * 100
            c = a < b ? a : b
    }
    
    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c
    
        where:
        [a, b, c] << sql.rows("select a, b, c from maxdata")
    }
    
    def "single column test"() {
        expect:
        a > 0
        
        where:
        a | _
        1 | _
        7 | _
    }
}
