package org.example;

public interface Foo {

    void printName();

    default void printUpperCase(){
        System.out.println("hyoseong");
    }

    /*
     - 인터페이스에 메소드 선언이 아니라 구현체를 제공하는 방법
     - 해당 인터페이스를 구현한 클래스를 깨트리지 않고 새 기능을 추가할 수 있다.
     */
    /*
        기본 메소드를 만든이유
        - WebMvcConfigurer interface에 기본 메소드로 구현되어 있어 WebMvcConfigurerAdapter에서 필요없는 메소드는 오버라이드로 내용없는 메소드를 구현해 안쓰도록 만들수 있다.
     */
}
