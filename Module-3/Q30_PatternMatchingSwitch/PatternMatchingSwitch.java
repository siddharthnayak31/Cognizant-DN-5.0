package Q30_PatternMatchingSwitch;

public class PatternMatchingSwitch {

    public static void checkType(Object obj) {

        String result = switch (obj) {
            case Integer i -> "Integer value: " + i;
            case String s -> "String value: " + s;
            case Double d -> "Double value: " + d;
            case Long l -> "Long value: " + l;
            case null -> "Null value";
            default -> "Unknown type";
        };

        System.out.println(result);
    }

    public static void main(String[] args) {

        checkType(100);
        checkType("Hello");
        checkType(45.67);
        checkType(500L);
    }
}