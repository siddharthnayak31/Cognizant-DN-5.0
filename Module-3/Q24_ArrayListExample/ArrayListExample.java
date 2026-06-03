package Q24_ArrayListExample;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();

        System.out.print("How many student names do you want to enter? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name " + (i + 1) + ": ");
            studentNames.add(sc.nextLine());
        }

        System.out.println("\nStudent Names:");

        for (String name : studentNames) {
            System.out.println(name);
        }

        sc.close();
    }
}