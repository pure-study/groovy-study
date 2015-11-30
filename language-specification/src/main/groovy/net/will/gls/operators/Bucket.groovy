package net.will.gls.operators

class Bucket {
    int size

    Bucket(int size) {
        this.size = size
    }

    Bucket plus(Bucket other) {
        return new Bucket(this.size + other.size)
    }
}
