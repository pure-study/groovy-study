package net.will.gls.objectorientation

class SystemGreeter implements Greeter {

    @Override
    public void greet(String name) {
        println "Hello $name"
    }

}
