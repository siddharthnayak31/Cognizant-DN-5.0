package Q7_TypeCastingExample;

public class TypeCastingExample {

    public static void main(String[] args) {

        
        double doubleValue = 45.78;
        int intValue = (int) doubleValue;

        System.out.println("Original Double Value: " + doubleValue);
        System.out.println("After Casting to Int: " + intValue);

        
        int number = 25;
        double convertedDouble = (double) number;

        System.out.println("Original Int Value: " + number);
        System.out.println("After Casting to Double: " + convertedDouble);
    }
}