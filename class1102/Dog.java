package class1102;

public class Dog {
    private String name;
    private int age;

    public void speak() {
        System.out.println(name + " says woof woof!");
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge;
        }
    }

    public String toString() {
        return "Dog object: name=" + name + " age=" + age;
    }

    public static void main(String[] args) {
        Dog fido = new Dog();
        fido.setName("Fido");
        fido.setAge(2);

        Dog toto = new Dog();
        toto.setName("Toto");
        toto.setAge(3);

        System.out.println(fido);
        System.out.println(toto);
        fido.speak();
    }
}
