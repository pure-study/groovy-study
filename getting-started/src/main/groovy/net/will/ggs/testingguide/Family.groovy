package net.will.ggs.testingguide

class Family {
    Person father, mother
    def nameOfMother() {
        "$mother.first $mother.last"
    }
}
