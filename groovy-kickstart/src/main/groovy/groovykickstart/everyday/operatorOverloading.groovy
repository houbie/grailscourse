package groovykickstart.everyday

import static groovykickstart.everyday.WeekDay.*


enum WeekDay {
    MON, TUE, WEN, THU, FRI, SAT, SUN

    WeekDay plus(int i) {
        values()[(ordinal() + i) % values().size()]
    }

    WeekDay minus(int i) {
        plus(-i)
    }

    int plus(WeekDay weekDay) {
        return 2
    }
}

//+ and -
assert TUE + 2 == FRI - 1
def day = TUE
day += 10
assert day == FRI
day -= 3
assert day == TUE

assert MON + THU == 2

//operators provided out of the box
day = MON
day++ //day = day.next()
assert day == TUE
assert --day == MON //day = day.previous()

assert day == MON //equals
assert day < THU //compareTo
assert day <=> MON == 0 //compareTo

//other operators
def l = [1, 2]
l << ['x', 'y'] //leftShift
assert l == [1, 2, ['x', 'y']]