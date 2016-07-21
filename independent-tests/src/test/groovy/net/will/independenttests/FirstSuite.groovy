package net.will.independenttests

import org.junit.Test;

class FirstSuite {
    @Test
    void stringComparisonIgnoringCase() {
        String str = "completed"
        
        assert str?.equalsIgnoreCase("Completed")
        assert str ==~ "(?i)COMPLETED"  // equivalent of equalsIgnoreCase()
    }
    
    @Test
    void string_replaceAll() {
        String src = 'before ${to_replace} after';
        String dest = "before middle after";
        
        assert src.replaceAll('\\$\\{to_replace\\}', 'middle') == dest
    }
}
