

public class M03LoopsConditionsMethods
{
    public static void main(String[] args) {
        String startingString = "SquarePants";
        methodOutputs(startingString);
        System.out.printf("\nString after method: ", startingString);
    }
    public static void methodOutputs(String stringParamaterInput)
    {
        int stringLength = stringParamaterInput.length();

        for (int i = (stringLength-1); i >= 0; i--)
        {
            char currentChar = stringParamaterInput.charAt(i);
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u') {
                currentChar = Character.toLowerCase(currentChar);
            } else {
                currentChar = Character.toUpperCase(currentChar);
            }
            System.out.print(currentChar);
        }
    }
}