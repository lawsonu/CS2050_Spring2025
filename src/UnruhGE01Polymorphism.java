import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnruhGE01Polymorphism {
    public static void main(String[] args) throws FileNotFoundException{

        final File ANIMAL_FILE = new File ("/Users/lawsonunruh/Documents/GitHub/CS2050_Spring2025/VSCode/src/Animals.txt");

        Scanner fileReader = null;
        try {
            fileReader = new Scanner(ANIMAL_FILE); 
            int i = 0;
            int size = fileReader.nextInt();
            Animal[] animals = new Animal[size];
            while (fileReader.hasNextLine()) {
                String type = fileReader.next();
                String name = fileReader.next();
                String food = fileReader.next();
                int weight = fileReader.nextInt();
                int sleep = fileReader.nextInt();
                String location = fileReader.next() + " " + fileReader.next();
                if (type.equals("Bear")){
                    Animal currentAnimal = new Bear(name, food, weight, sleep, location);
                    animals[i] = currentAnimal;
                    i++;
                } else if (type.equals("Elephant")){
                    Animal currentAnimal = new Elephant(name, food, weight, sleep, location);
                    animals[i] = currentAnimal;
                    i++;
                } else if (type.equals("Monkey")){
                    Animal currentAnimal = new Monkey(name, food, weight, sleep, location);
                    animals[i] = currentAnimal;
                    i++;
                } else if (type.equals("Sloth")){
                    Animal currentAnimal = new Sloth(name, food, weight, sleep, location);
                    animals[i] = currentAnimal;
                    i++;
                }
            }
            for (int j = 0; j < animals.length; j++){
                if (animals[j] instanceof Bear){
                    System.out.print("Animal[" + j + "] is a Bear\nBear: ");
                } else if (animals[j] instanceof Elephant){
                    System.out.print("Animal[" + j + "] is a Elephant\nElephant: ");
                } else if (animals[j] instanceof Monkey){
                    System.out.print("Animal[" + j + "] is a Monkey\nMonkey: ");
                } else if (animals[j] instanceof Sloth){
                    System.out.print("Animal[" + j + "] is a Sloth\nSloth: ");
                }
                System.out.println(animals[j]);
                animals[j].eat();
                animals[j].sleep();
                animals[j].swim();
                System.out.println();
            }
            } finally {
                if (fileReader != null){
                    fileReader.close();
                }
        }
    }
}


class Animal {
    String name;
    String food;
    int weight;
    int sleep;
    String location;

    public Animal(String name, String food, int weight, int sleep, String location){
        this.name = name;
        this.food = food;
        this.weight = weight;
        this.sleep = sleep;
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public String getFood(){
        return food;
    }

    public int getWeight(){
        return weight;
    }

    public int getSleep(){
        return sleep;
    }

    public String getLocation(){
        return location;
    }

    public void eat(){
        System.out.println("Animal is eating");
    }

    public void sleep(){
        System.out.println("Animal is sleeping - do not disturb");
    }

    public void swim(){
        System.out.println("Animal is swimming");
    }
    @Override
    public String toString(){
        return "Name: " + name + " - Weighs: " + weight + " lbs - Sleeps: " + sleep + " hours - Location: " + location; 
    }

}

class Bear extends Animal {
    public Bear(String name, String food, int weight, int sleep, String location){
        super(name, food, weight, sleep, location);
    }
    @Override
    public void eat(){
        System.out.println("Bear is eating " + getFood());
    }
    @Override
    public void sleep(){
        System.out.println("Bear is sleeping " + getSleep() + " hours");
    }
    @Override
    public void swim(){
        System.out.println("Bear is swimming");
    }
}

class Elephant extends Animal {
    public Elephant(String name, String food, int weight, int sleep, String location){
        super(name, food, weight, sleep, location);
    }
    @Override
    public void sleep(){
        System.out.println("Elephant is sleeping " + getSleep() + " hours");
    }
}

class Monkey extends Animal {
    public Monkey(String name, String food, int weight, int sleep, String location){
        super(name, food, weight, sleep, location);
    }
    @Override
    public void eat(){
        System.out.println("Monkey is eating " + getFood());
    }
    @Override
    public void swim(){
        System.out.println("Monkey is swimming");
    }
}

class Sloth extends Animal {
    public Sloth(String name, String food, int weight, int sleep, String location){
        super(name, food, weight, sleep, location);
    }
}