package groovykickstart.advanced

println 'man meets cat and lion in java'

Man.main()

println 'man meets cat and lion in Groovy'

Cat[] cats = [new Cat(), new Lion()]
def man = new Man()
for (Cat cat in cats) {
    man.meet(cat)
}