public class cs2050ClassWork {
    public static void main(String[] args) {

        int[][] numbers = new int[2][2];

        numbers[0][0] = 1;
        numbers[0][1] = 2;
        numbers[1][0] = 3;
        numbers[1][1] = 4;

        for (int col = 0; col < numbers.length; col++){
            for (int row = 0; row < numbers[0].length; row++){
                System.out.println(numbers[col][row]);
            }
        }

        double doubleNum = 10.5;
        int num = (int) doubleNum;


    }

}






