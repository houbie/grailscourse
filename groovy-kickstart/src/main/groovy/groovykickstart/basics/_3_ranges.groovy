package groovykickstart.basics

import static groovykickstart.basics.Month.*

Range range = 0..10
assert 5 in range
assert range.size() == 11

assert 10 in 0..10
assert !(10 in 0..<10)

def end = 3
assert 0..<end == 0..end - 1

//any class having next and previous methods that implements Comparable can be used as Range
enum Month {
    JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEPT, OCT, NOV, DEC
}

assert MAR..JUN as List == [MAR, APR, MAY, JUN]
