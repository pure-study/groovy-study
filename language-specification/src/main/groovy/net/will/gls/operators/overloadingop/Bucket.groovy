package net.will.gls.operators.overloadingop

class Bucket {
    int size

    Bucket(int size) {
        this.size = size
    }

    Bucket plus(int capacity) {
        return new Bucket(this.size + capacity)
    }
}
