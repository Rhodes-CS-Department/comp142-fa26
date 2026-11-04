package lab10;

import java.util.*;

public class FishTest {
    public static void main(String[] args) {
        testZigzagFish();
        //testPolymorphism();
    }

    public static void testZigzagFish() {
        ZigzagFish zzfish = new ZigzagFish(40, 40, 40);
        System.out.println("This should say that it is a zigzag fish:");
        System.out.println(zzfish);
    }

    public static void testPolymorphism() {
        Fish fish = new Fish(40, 0, 0);
        System.out.println(fish);

        ZigzagFish zzfish = new ZigzagFish(40, 0, 0);
        System.out.println(zzfish);

        // --- STAGE 1: Uncomment the code below ---
        /*
        Fish polymorphFish = new ZigzagFish(40, 0, 0);
        System.out.println("polymorphFish prints as: " + polymorphFish);
        System.out.println("fish is worth: " + fish.getPoints());
        System.out.println("zzfish is worth: " + zzfish.getPoints());
        System.out.println("polymorphFish is worth: " + polymorphFish.getPoints());
        */

        // --- STAGE 2: Uncomment the code below ---
        /*
        ArrayList<Fish> listOfManyKindsOfFish = new ArrayList<Fish>();
        listOfManyKindsOfFish.add(fish);            // add a regular Fish
        listOfManyKindsOfFish.add(zzfish);          // add a ZigzagFish
        listOfManyKindsOfFish.add(polymorphFish);   // add a ZigzagFish stored in a Fish variable

        for (Fish f : listOfManyKindsOfFish) {
            System.out.println(f);
            System.out.println("This fish is worth: " + f.getPoints());
        }
        */
    }
}
