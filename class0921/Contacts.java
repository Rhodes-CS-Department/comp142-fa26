package class0921;

public class Contacts {
    private Person[] people;
    private int next;
    
    // create a contacts book w/ given maximum size.
    public Contacts(int size) {
        people = new Person[size];
        next = 0;
    }

    public void addContact(Person person) {
        people[next] = person;
        next++;
    }

    public void deleteContact(String name) {
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null && people[i].getName().equals(name)) {
                people[i] = null;
            }
        }
    }

    public Person lookupContact(String name) {
        return null;
    }
}