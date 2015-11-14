new File('ResourceManagement.groovy').eachLine('UTF-8') {
    println it
}

new File('ResourceManagement.groovy').withReader('UTF-8') { reader ->
    reader.eachLine {
        println it
    }
}

public class HelloWorld {
    public static void main(def args) {
        println "Hello World!"
    }
}
