package org.example;

@FunctionalInterface // 추상 메소드가 하나이어야 한다.
public interface RunSomething {

    // (abstract)추상 void doIt();

    int doIt(int a);

    static void printName(){
        System.out.println("hyoseong");
    }

    default void printAge(){
        System.out.println("21");
    }
}
