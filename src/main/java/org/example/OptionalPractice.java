package org.example;

import java.util.ArrayList;
import java.util.List;

public class OptionalPractice {

    /*
        - Optional은 리턴값으로만 쓰기를 권장한다 (메소드 매개변수 타입, 맵의 킵 타입, 인스턴스 필드 타입)으로 쓰지말자
        - 프리미티브 타입은 따로 있다 OptionalInt.of(10) 등등
        - 당연히 null을 리턴하면 안되겠지? 만약 해야되면 Optional.empty();
        - Collection, Map, Stream Array, Optional은 Opiontal로 감싸지 말 것 why? 저걸로 빈 것을 확인 가능 Collection.isEmpty()
     */
    public void go(){
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));



    }
}
