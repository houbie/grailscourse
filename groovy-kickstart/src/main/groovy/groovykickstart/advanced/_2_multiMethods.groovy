package groovykickstart.advanced

println 'Java programmer meets cat and lion'

Man.main()

println 'Groovy programmer meets cat and lion'

Cat[] cats = [new Cat(), new Lion()]
def man = new Man()
for (Cat cat in cats) {
    man.meet(cat)
}