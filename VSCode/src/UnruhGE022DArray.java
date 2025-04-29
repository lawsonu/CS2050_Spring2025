// public class UnruhGE022DArray {
//     public static void main(String[] args) {

//         Car[][] Cars = new Car[2][3];

//         Cars[0][0] = new Car("Ford");
//         Cars[0][1] = new Car("Toyota");
//         Cars[0][2] = new Car("Honda");
//         Cars[1][0] = new Car("Subaru");
//         Cars[1][1] = new Car("Chevy");
//         Cars[1][2] = new Car("BMW");

//         for (int col = 0; col < Cars.length; col++){
//             for (int row = 0; row < Cars[0].length; row++){
//                 Cars[col][row].printMake();
//             }
//         }
//     }
    
// }

// class Car{
//     private String make;

//     public Car() { 
//     this.make = "Unknown"; 
//     }
    
//     public Car(String make) {
//     this.make = make;
//     }

//     public void printMake() {
//     System.out.print(this.make + " ");
//     }
// } // Car