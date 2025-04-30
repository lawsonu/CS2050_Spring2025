package ClassExamples;


/*
 * Stack Example
 * Add comments to explain the code
 */

 import java.util.ArrayList;
 import java.util.NoSuchElementException;
 
 public class StackTest {
     public static void main(String[] args) {
 
         
         Stack<Integer> stack = new Stack<>();

         Stack<String> stackS = new Stack<>();
 
 
         System.out.println("Pushing elements: 10, 20, 30, 40");
         stack.push(10);
         stack.push(20);
         stack.push(30);
         stack.push(40);
         
         stackS.push("String 1");
         stackS.push("String 2");
         stackS.push("String 3");
         stackS.push("String 4");
 
         System.out.println("Stack after pushing: " + stack);

        System.out.println("Stack after pushing: " + stackS);
 
 
         int popped = stack.pop();
         System.out.println("Popped element: " + popped);
         System.out.println("Stack after popping: " + stack);
 
         String poppedS = stackS.pop();
         System.out.println("Popped element: " + poppedS);
         System.out.println("Stack after popping: " + stackS);
 
         int topElement = stack.peek();
         System.out.println("Top element: " + topElement);

        String topElementS = stackS.peek();
        System.out.println("Top element: " + topElementS);
 
 
         System.out.println("Is stack empty? " + stack.isEmpty());

        System.out.println("Is stackS empty? " + stackS.isEmpty());
         
         popped = stack.pop();
         System.out.println("Popped element: " + popped);
         System.out.println("Stack after popping: " + stack);
         
         poppedS = stackS.pop();
         System.out.println("Popped element: " + poppedS);
         System.out.println("Stack after popping: " + stackS);

         popped = stack.pop();
         System.out.println("Popped element: " + popped);
         System.out.println("Stack after popping: " + stack);

        poppedS = stackS.pop();
        System.out.println("Popped element: " + poppedS);
        System.out.println("Stack after popping: " + stackS);

         
         popped = stack.pop();
         System.out.println("Popped element: " + popped);
         System.out.println("Stack after popping: " + stack);

        poppedS = stackS.pop();
        System.out.println("Popped element: " + poppedS);
        System.out.println("Stack after popping: " + stackS);

     }
 }
 
 
 
 class Stack<T> {
     
 
     private ArrayList<T> items; 
 
 
     public Stack() {
         this.items = new ArrayList<>();
     }
 
 
     public boolean isEmpty() {
         return this.items.isEmpty();
     }
 
 
     public void push(T item) {
         this.items.add(item);
     }
 
 
     public T pop() {
         if (this.isEmpty()) {
             throw new NoSuchElementException("Stack is empty.");
         }
         return this.items.remove(items.size() - 1);
     }
 
 
     public T peek() {
         if (this.isEmpty()) {
             throw new NoSuchElementException("Stack is empty.");
         }
         return this.items.get(items.size() - 1);
     }
 
 
     public int size() {
         return this.items.size();
     }
 
 
     @Override
     public String toString() {
         if (!this.items.isEmpty()) {
             return "bottom ->" + this.items.toString() + "<- top";
         } else {
             return "<<empty stack>>";
         }
     }
 }
 