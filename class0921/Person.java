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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        age = newAge;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        Person otherPerson = (Person) other;
        return this.name.equals(otherPerson.name)
            && this.age == otherPerson.age;
    }

    public static void main(String[] args) {
        Person person1 = new Person("Archer");
        Person person2 = new Person("Archer");
        System.out.println(person1.equals(person2));
        System.out.println(person1 == person2);
    }
}