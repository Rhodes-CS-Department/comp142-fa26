package class0921;

public class Test {
    public static void main(String[] args) {
        Contacts contacts = new Contacts(1000);
        Person p1 = new Person("Matt", 35);
        contacts.addContact(p1);
        Person p2 = new Person("Carmela", 6);
        contacts.addContact(p2);

        System.out.println(contacts.lookupContact("Carmela"));
        // System.out.println(contacts.lookupContact("Roman"));

        // contacts.deleteContact("Carmela");
        // System.out.println(contacts.lookupContact("Carmela"));
    }
}