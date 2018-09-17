package net.will.ggs.groovydevkit

def config = new ConfigSlurper().parse('''
    app {
        name = "Test${42}"
        age = 40
    }
''')

println config.app
println config.app.name
println config.app.age

config2 = new ConfigSlurper().parse('''
    app = {
        name = "Test${42}"
        age = 40
    }
''')

println config2.app
println config2.app.name
println config2.app.age
