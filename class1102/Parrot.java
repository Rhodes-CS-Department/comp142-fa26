package class1102;

import java.awt.*;

public class Parrot {
    private int energy;
    private Color color;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int newEnergy) {
        energy = newEnergy;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public String toString() {
        return "Parrot object: energy=" + energy + " color=" + color;
    }

    public void fly() {
        // flying takes three units of energy
        if (energy >= 3) {
            energy -= 3;
            System.out.println("The parrot flies!");
        } else {
            System.out.println("The parrot is too tired to fly.");
        }
    }

    public static void main(String[] args) {
        Parrot polly = new Parrot();
        polly.setColor(Color.BLUE);
        polly.setEnergy(3);
        polly.fly();
        polly.fly();
    }
}
