package Q39_ReflectionInJava;

import java.lang.reflect.Method;

class Student {

    public void display() {
        System.out.println("Reflection Method Invoked");
    }

    public void greet(String name) {
        System.out.println("Hello " + name);
    }
}

public class ReflectionDemo {

    public static void main(String[] args) {

        try {

            Class<?> cls = Class.forName("Q39_ReflectionInJava.Student");

            System.out.println("Methods in Student class:");

            Method[] methods = cls.getDeclaredMethods();

            for (Method method : methods) {

                System.out.print("Method Name: " + method.getName());

                Class<?>[] params = method.getParameterTypes();

                System.out.print(" | Parameters: ");

                if (params.length == 0) {
                    System.out.print("None");
                } else {
                    for (Class<?> param : params) {
                        System.out.print(param.getSimpleName() + " ");
                    }
                }

                System.out.println();
            }

            Object obj = cls.getDeclaredConstructor().newInstance();

            Method method = cls.getDeclaredMethod("display");

            method.invoke(obj);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}