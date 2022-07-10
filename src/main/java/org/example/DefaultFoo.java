package org.example;

public class DefaultFoo implements Foo, Bar{


    @Override
    public void printName() {

    }

    @Override
    public void printUpperCase() { // Foo, Bar의 기본 메소드가 충돌할 때는 반드시 구현해줘야 한다.

    }
}
