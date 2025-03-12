import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UnruhLeture15 {
    public static void main(String[] args) throws FileNotFoundException {
    
    ArrayList <Bird> birds = readBridsFromFile("birds.txt");

    
    }
    public static ArrayList<Bird> readBridsFromFile(String fileName) throws FileNotFoundException{

        File inputFileName = new File(fileName);
        Scanner inputFile = null;
        ArrayList<Bird> birds = new ArrayList<>();

        inputFile = new Scanner(inputFileName);

        inputFile.close();

        return birds;

        
    }
}


interface Swimmer{
    void swim();
}

abstract class Bird{
    String name;
    int swimSpeed;

    Bird(String name, int swimSpeed){
        this.name = name;
        this.swimSpeed = swimSpeed;
    }

    abstract String funFact();
}

class Penguin extends Bird implements Swimmer{

    Penguin(String name, int swimSpeed){
        super(name, swimSpeed);
    }

    @Override
    public void swim(){
        System.out.print(swimSpeed);
        
    }

    @Override
    String funFact(){
        return "I can't fly, but I'm the fastest swimmer and deepest diver.";
    }
}

class Duck extends Bird implements Swimmer{

    Duck(String name, int swimSpeed){
        super(name, swimSpeed);
    }

    @Override
    public void swim(){
        System.out.print(swimSpeed);
        
    }

    @Override
    String funFact(){
        return "My highest documented flight is 21,000 feet!";
    }
}

class SootyTern extends Bird{

    SootyTern(String name, int swimSpeed){
        super(name, swimSpeed);
    }

    @Override
    String funFact(){
        return "I spend most of my time at sea but can't swim!";
    }
}

class Ostrich extends Bird{

    Ostrich(String name, int swimSpeed){
        super(name, swimSpeed);
    }

    @Override
    String funFact(){
        return "Who needs flying when you're the biggest bird on Earth!";
    }
}