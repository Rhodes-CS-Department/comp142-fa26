package class1102;

public class DogDemo {
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
