package groovykickstart.basics

print("Hello ") //System.out.print
println("world!") //System.out.println



//null-safe references
String s = "Hello", _null = null

assert s.toUpperCase().size() == 5
assert _null?.toUpperCase()?.size() == null




//elvis
s = _null ?: 'default'
assert s == 'default'

s = s ?: 'nope'
assert s == 'default'
