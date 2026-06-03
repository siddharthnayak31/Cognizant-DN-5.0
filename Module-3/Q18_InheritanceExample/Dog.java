package Q18_InheritanceExample;

class Animal {

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

public class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    public static void main(String[] args) {

        Animal animal = new Animal();
        Dog dog = new Dog();

        animal.makeSound();
        dog.makeSound();
    }
}