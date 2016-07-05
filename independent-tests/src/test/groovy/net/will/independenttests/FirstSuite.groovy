package net.will.independenttests

import org.junit.Test;

class FirstSuite {
    @Test
    void stringComparisonIgnoringCase() {
        String str = "completed"
        
        assert str?.equalsIgnoreCase("Completed")
        assert str ==~ "(?i)COMPLETED"  // equivalent of equalsIgnoreCase()
    }
}
