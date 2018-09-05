package net.will.gim

class Family {
    Person father, mother
    def nameOfMother() {
        "$mother.first $mother.last"
    }
}
