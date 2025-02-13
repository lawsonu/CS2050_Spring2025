public class UnruhTestSimpleRectangle {   
    public static void main(String[] args) {
    //Creating all rectangles 
        SimpleRectangle rectangle1 = new SimpleRectangle();
        SimpleRectangle rectangle2 = new SimpleRectangle(2.0, 2.0);
        SimpleRectangle rectangle3 = new SimpleRectangle(1.5, 3.0);
    //Printing all rectangles area and perimeters with getter methods 
        System.out.println("Rectangle 1's area: " + rectangle1.getArea() + "\nRectangle1's perimeter: " + rectangle1.getPerimeter());
        System.out.println("Rectangle 2's area: " + rectangle2.getArea() + "\nRectangle2's perimeter: " + rectangle2.getPerimeter());
        System.out.println("Rectangle 3's area: " + rectangle3.getArea() + "\nRectangle3's perimeter: " + rectangle3.getPerimeter());
    }
}
//Defining SimpleRectangle class
class SimpleRectangle { 
//Attributes of a simple rectangle
    private double length;
    private double width;
//Basic constructor
    public SimpleRectangle(){
        this.length = 1.0;
        this.width = 1.0;
    }
//Parameterized constructor
    public SimpleRectangle(double newLength, double newWidth){
        this.length = newLength;
        this.width = newWidth;
    }
//Get area method
    public double getArea(){
        return length * width;
    }
//Get perimeter method
    public double getPerimeter(){
        return 2 * (length + width);
    }
//Set length method
    public void setLength(double length) {
        this.length = length;
    }
//Set width method
    public void setWidth(double width){
        this.width = width;
    }

}
