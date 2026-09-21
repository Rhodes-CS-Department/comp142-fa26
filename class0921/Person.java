package class0921;

public class Person {
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
        age = 18;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public static void main(String[] args) {
        Person person1 = new Person("Archer");
        Person person2 = null;
        System.out.println(person1.getAge());
        // System.out.println(person2.getAge());
    }
}