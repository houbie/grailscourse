package groovykickstart.advanced;

public class Cat {
}

class Lion extends Cat {
}

class Man {
    Man() {
    }

    void meet(Cat cat) {
        System.out.println("Hello kitty");
    }

    void meet(Lion lion) {
        System.out.println("Run for your life!");
    }

    public static void main(String[] args) {
        Cat[] cats = {new Cat(), new Lion()};
        Man man = new Man();
        for (Cat cat : cats) {
            man.meet(cat);
        }
    }
}
