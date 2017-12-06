package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
public class Zoo {
    public static void main(String args[]) {
        Animal animal = new Dog();

        // Exception in thread "main" java.lang.ClassCastException: idv.carl.scjp.Dog cannot be cast
        // to idv.carl.scjp.Cat
        Cat cat = (Cat) animal;
        System.out.println(cat.noise());
    }

}


class Animal {
    public String noise() {
        return "peep";
    }
}


class Dog extends Animal {
    public String noise() {
        return "bark";
    }
}


class Cat extends Animal {
    public String noise() {
        return "meow";
    }
}
