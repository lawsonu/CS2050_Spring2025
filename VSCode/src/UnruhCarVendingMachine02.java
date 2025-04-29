import java.util.*;
import java.util.Queue;
import java.io.*;

// Main class for the Car Vending Machine program
public class UnruhCarVendingMachine02 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner user = new Scanner(System.in);

        VendingMachine Carvana = new VendingMachine(user); // create VendingMachine object

        Carvana.create(); // initialize the vending machine dimensions

        while(true){

            Carvana.menu(); // display menu options

            int choice = user.nextInt(); // get user input

            switch(choice){
                case 1:
                    Carvana.loadCars(); // load cars from file
                    break;
                case 2:
                    Carvana.displayVendingMachine(); // display all cars
                    break;
                case 3:
                    Carvana.retrieveCar(); // retrieve car by location
                    break;
                case 4:
                    Carvana.printSortedInventory("Price"); // sort inventory by price
                    break;
                case 5:
                    Carvana.printSortedInventory("Year"); // sort inventory by year
                    break;
                case 6:
                    Carvana.search(); // search cars by make and type
                    break;
                case 7:
                    Carvana.addCarToWash(); // add car to wash queue
                    break;
                case 8:
                    Carvana.processCarWash(); // process (wash) cars
                    break;
                case 9:
                    Carvana.sellCar(); // sell a car
                    break;
                case 10:
                    System.out.println("Exiting program. Goodbye!"); // exit
                    break;
                default:
                    System.out.println("Invalid Choice"); // invalid input
                    user.close();
            }
        }
    }
}

// VendingMachine class to manage cars
class VendingMachine {

    LinkedList<Car> VendingMachine; // list of cars
    HashMap<String, Car> Location; // map for location lookup
    Queue<Car> CarWash; // queue for car wash

    int floors;
    int spaces;
    Scanner user;

    VendingMachine(Scanner user){
        VendingMachine = new LinkedList<>();
        Location = new HashMap<>();
        CarWash = new LinkedList<>();
        floors = 0;
        spaces = 0;
        this.user = user;
    }

    // Create vending machine with floors and spaces
    void create(){

        System.out.print("Enter the number of floors for the car vending machine: ");
        this.floors = user.nextInt();
        System.out.print("Enter the number of spaces for the car vending machine: ");
        this.spaces = user.nextInt();

    }

    // Display menu options
    void menu(){
        System.out.println("=== Car Vending Machine Menu ===\n"
            + "1. Load car data from file\n"
            + "2. Display vending machine\n" 
            + "3. Retrieve a car by location (Floor and Space)\n"
            + "4. Print sorted inventory (Price)\n"
            + "5. Print sorted inventory (Year)\n"
            + "6. Search for cars (Make and Type)\n"
            + "7. Add car to Car Wash\n"
            + "8. Process car in Car Wash\n"
            + "9. Sell a car\n"
            + "10. Exit\n\n"
            + "Enter your choice: ");
    }

    // Load car data from a file
    void loadCars() throws FileNotFoundException {

        System.out.print("Enter the file name: ");
        user.nextLine(); // consume leftover newline
        String fileName = user.nextLine();
         
        File file = new File(fileName);
        Car currCar;

        try (Scanner fileReader = new Scanner(file);) {
            while (fileReader.hasNext()) {
                // Read car details
                String type = fileReader.next();
                int floor = fileReader.nextInt();
                int space = fileReader.nextInt();
                int year = fileReader.nextInt();
                double price = fileReader.nextDouble();
                String make = fileReader.next();
                String model = fileReader.next();
                String location = floor + "-" + space;

                // Create the appropriate car type
                if (type.equalsIgnoreCase("B")){
                    currCar = new BasicCar(floor, space, year, price, make, model);
                } else {
                    currCar = new PremiumCar(floor, space, year, price, make, model);
                }

                // Check if floor or space exceeds limits
                if (currCar.getFloor() > floors || currCar.getSpace() > spaces){
                    System.out.println("Error: Invalid position at Floor " + currCar.getFloor() + " Space " + currCar.getSpace() + "\n"
                    + "Cannot place Car: " + currCar);
                }

                // Check if slot is already occupied
                if (Location.containsKey(location)){
                    System.out.println("Error: Slot at Floor " + floor + "Space " + space + " is already occupied.\n" 
                    + currCar + "cannot be placed.");
                }

                // Add car to machine
                VendingMachine.add(currCar);
                Location.put(location, currCar);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    // Display all cars in the vending machine
    void displayVendingMachine(){
        while(!VendingMachine.isEmpty()){
            for (int i = 0; i < VendingMachine.size(); i++){
                System.out.println(VendingMachine.get(i));
            }
            break;
        }
    }

    // Retrieve car by location
    void retrieveCar(){

        System.out.print("Enter floor: ");
        int floor = user.nextInt();
        System.out.print("Enter space: ");
        int space = user.nextInt();
        String location = floor + "-" + space;

        if (Location.containsKey(location)){
            System.out.println(Location.get(location));
        } else {
            System.out.println("Car not found at this location.");
        }
    }

    // Print inventory sorted by price or year
    void printSortedInventory(String how){

        LinkedList<Car> sortedLinkedList = new LinkedList<>(VendingMachine);

        if (how.equalsIgnoreCase("Price")){
            System.out.println("sorted Inventory by Price: ");
            sortedLinkedList.sort(Comparator.comparing(Car::getPrice));
        } else if (how.equalsIgnoreCase("Year")){
            System.out.println("sorted Inventory by Year: ");
            sortedLinkedList.sort(Comparator.comparing(Car::getYear));
        }

        for (int i = 0; i < sortedLinkedList.size(); i++){
            System.out.println(sortedLinkedList.get(i));
        }
    }

    // Search cars by make and type
    void search(){

        LinkedList<Car> searchCars = new LinkedList<>();

        System.out.print("Enter make: ");
        String make = user.nextLine();
        System.out.print("Enter car type (Basic / Premium): ");
        String type = user.nextLine();

        for (int i = 0; i < VendingMachine.size(); i++){
            if (VendingMachine.get(i).getMake().equalsIgnoreCase(make) && VendingMachine.get(i).getType().equalsIgnoreCase(type)){
                searchCars.add(VendingMachine.get(i));
            }
        }

        for (int i = 0; i < searchCars.size(); i++){
            System.out.println(searchCars.get(i));
        }
    }

    // Add car to wash queue
    void addCarToWash(){

        System.out.print("Enter floor: ");
        int floor = user.nextInt();
        System.out.print("Enter Space: ");
        int space = user.nextInt();
        String location = floor + "-" + space;

        if (Location.containsKey(location)){
            CarWash.add(Location.get(location));
            System.out.println("Car retrieved: " + Location.get(location) + "\n"
            + "Car added to Wash Queue.");
        } else {
            System.out.println("Error: No car at Floor " + floor + " Space " + space);
        }
    }

    // Wash and remove cars from wash queue
    void processCarWash(){
        while (!CarWash.isEmpty()){
            Car currCar = CarWash.poll(); // remove from queue
            System.out.println("Washing: " + currCar);
        }
    }

    // Sell car by location
    void sellCar(){

        System.out.print("Enter floor of car to sell: ");
        int floor = user.nextInt();
        System.out.print("Enter space of car to sell: ");
        int space = user.nextInt();
        String location = floor + "-" + space;

        if (Location.containsKey(location)){
            System.out.println("Car sold: " + Location.get(location));
            Location.remove(location);
        } else {
            System.out.println("No car found at Floor " + floor + " Space " + space);
        }
    }
}

// Abstract Car class
abstract class Car {

    int floor;
    int space;
    int year;
    double price;
    String make;
    String model;

    Car (int floor, int space, int year, double price, String make, String model){
        this.floor = floor;
        this.space = space;
        this.year = year;
        this.price = price;
        this.make = make;
        this.model = model;
    }

    // Getters
    int getFloor(){
        return floor;
    }

    int getSpace(){
        return space;
    }

    int getYear(){
        return year;
    }

    double getPrice(){
        return price;
    }

    String getMake(){
        return make;
    }

    String getModel(){
        return model;
    }

    // Abstract method for car type
    abstract String getType();

    @Override
    public String toString(){
        return getType() + " Car: " + getMake() + " " + getModel() + " " + getYear() +
        " - $" + getPrice() + "(Floor: " + getFloor() + ", Space: " + getSpace() + ")";
    }
}

// BasicCar class extending Car
class BasicCar extends Car{

    BasicCar(int floor, int space, int year, double price, String make, String model) {
        super(floor, space, year, price, make, model);
    }

    @Override
    String getType(){
        return "Basic";
    }
}

// PremiumCar class extending Car
class PremiumCar extends Car{

    PremiumCar(int floor, int space, int year, double price, String make, String model) {
        super(floor, space, year, price, make, model);
    }

    @Override
    String getType(){
        return "Premium";
    }
}