package net.will.gls.semantics

import groovy.transform.Immutable;

@Immutable
class Coordinates {
    double latitude
    double longitude

    double getAt(int idx) {
        if (idx == 0) latitude
        else if (idx == 1) longitude
        else throw new Exception("Wrong coordinate index, use 0 or 1")
    }
}
