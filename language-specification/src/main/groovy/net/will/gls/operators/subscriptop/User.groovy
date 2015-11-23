package net.will.gls.operators.subscriptop

class User {
    Integer id
    String name
    
    def getAt(int i) {
        switch (i) {
            case 0:
                return id
            case 1:
                return name
        }
        throw new IllegalArgumentException("No such element $i")
    }
    
    void putAt(int i, def value) {
        switch (i) {
            case 0:
                id = value
                return
            case 1:
                name = value
                return
        }
        throw new IllegalArgumentException("No such element $i")
    }
}
