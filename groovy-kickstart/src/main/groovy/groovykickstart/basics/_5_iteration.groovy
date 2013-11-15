package groovykickstart.basics

//classic for loop
String s1 = ''
for (int i = 0; i < 5; i++) {
    s1 += i
}
assert s1 == '01234'

//java style iterator
String s2 = ''
for (int i : 0..4) {
    s2 += i
}
assert s2 == s1

//groovy style iterator
String s3 = ''
for (i in 0..4) {
    s3 += i
}
assert s3 == s1

//loop over one object
def count = 0
def o = new Object()
for (i in o) {
    count++
}
assert count == 1

//same for each
count = 0
o.each { count++ }
assert count == 1

//beware of Strings
def list = []
for (c in 'Hello') {
    list << c
}
assert list == ['H', 'e', 'l', 'l', 'o']