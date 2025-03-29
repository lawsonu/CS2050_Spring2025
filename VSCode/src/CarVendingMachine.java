import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CarVendingMachine {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of floors for the car vending machine: ");
        int floors = input.nextInt();
        System.out.print("Enter the number of spaces for the car vending machine: ");
        int spaces = input.nextInt();

        VendingMachine Carvana = new VendingMachine(floors, spaces);

        while (true) {

            menu();

            System.out.println("Enter your choice: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the file name: (cars1.txt) (cars2.txt)");
                    String fileName = input.next();
                    Carvana.loadCars("VSCode\\src\\" + fileName);
                    break;
                case 2:
                    Carvana.displayTower();
                    break;
                case 3:
                    System.out.println("Enter floor to retrieve car: ");
                    int floor = input.nextInt() - 1;
                    System.out.println("Enter space to retrieve car: ");
                    int space = input.nextInt() - 1;
                    Carvana.retrieveCar(floor, space);
                    break;
                case 4:
                    System.out.println("Sorted Inventory by Price: ");
                    Carvana.printSortedInventory("Price");
                    break;
                case 5:
                    System.out.println("Sorted Inventory by Year: ");
                    Carvana.printSortedInventory("Year");
                    break;
                case 6:
                    System.out.println("Exiting the program. Goodbye!");
                    input.close();
                    return;
                default:
                    System.out.println("Try again.");
            }
        }

    }

    private static void menu() {
        System.out.println("=== Car Vending Machine Menu === \n"
                + "1. Load Car Data\n"
                + "2. Display Vending Machine\n"
                + "3. Retrieve Car\n"
                + "4. Print Sorted Inventory (Price)\n"
                + "5. Print Sorted Inventory (Year)\n"
                + "6. Exit\n");
    }
}

class VendingMachine {

    Car tower[][];

    public VendingMachine(int floors, int spaces) {
        tower = new Car[floors][spaces];
    }

    public void loadCars(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        try (Scanner fileReader = new Scanner(file);) {
            while (fileReader.hasNext()) {
                int floor = fileReader.nextInt();
                int space = fileReader.nextInt();
                int year = fileReader.nextInt();
                double price = fileReader.nextDouble();
                String make = fileReader.next();
                String model = fileReader.next();

                Car currentCar = new Car(year, price, make, model);

                addCar(floor, space, currentCar);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }
    }

    void addCar(int floor, int space, Car currentCar) {
        if (floor >= tower.length || space >= tower[0].length) {
            System.out.println("Error: Invalid position at Floor: " + (floor + 1) + " Space: " + (space + 1)
                    + "\nCan not place " + currentCar);
        } else {
            if (tower[floor][space] == null) {
                tower[floor][space] = currentCar;
                System.out.println("Car has been added.");
            } else {
                System.out.println(
                        "Error: Slot at Floor: " + (floor + 1) + " Space: " + (space + 1) + " is already occupied.\n"
                                + currentCar + " cannot be placed.");
            }
        }
    }

    void displayTower() {

        System.out.println("Inventory Location");
        int floor = 1;

        for (int i = 0; i < tower.length; i++) {
            System.out.println("Floor " + floor + ":");
            int space = 1;
            floor++;
            for (int j = 0; j < tower[0].length; j++) {
                System.out.print("     Space " + space);
                if (tower[i][j] != null) {
                    System.out.println(": " + tower[i][j]);
                } else {
                    System.out.println(" EMPTY");
                }
                space++;
            }
        }
    }

    void retrieveCar(int floor, int space) {
        if (floor <= tower.length && space <= tower[0].length) {
            if (tower[floor][space] != null) {
                System.out.println(tower[floor][space]);
            } else {
                System.out.println("No car located at Floor " + (floor + 1) + " Space " + (space + 1));
            }
        } else {
            System.out.println("Error: Invalid position at Floor: " + (floor + 1) + " Space: " + (space + 1));
        }
    }

    public void printSortedInventory(String by) {
        ArrayList<Car> cars = new ArrayList<>();

        for (Car[] floor : tower) {
            for (Car car : floor) {
                if (car != null) {
                    cars.add(car);
                }
            }
        }

        for (int i = 0; i < cars.size() - 1; i++) {
            for (int j = 0; j < cars.size() - i - 1; j++) {
                boolean swap = false;

                if (by.equalsIgnoreCase("price")) {
                    if (cars.get(j).getPrice() > cars.get(j + 1).getPrice()) {
                        swap = true;
                    }
                } else if (by.equalsIgnoreCase("year")) {
                    if (cars.get(j).getYear() > cars.get(j + 1).getYear()) {
                        swap = true;
                    }
                }

                if (swap) {
                    Car temp = cars.get(j);
                    cars.set(j, cars.get(j + 1));
                    cars.set(j + 1, temp);
                }
            }
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}

class Car {

    int year;
    double price;
    String make;
    String model;

    public Car(int year, double price, String make, String model) {
        this.year = year;
        this.price = price;
        this.make = make;
        this.model = model;
    }

    public String toString() {
        return make + " " + model + " " + year + " - $" + price;
    }

    int getYear() {
        return year;
    }

    double getPrice() {
        return price;
    }
}