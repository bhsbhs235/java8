package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalPractice {

    /*
        - Optional은 리턴값으로만 쓰기를 권장한다 (메소드 매개변수 타입, 맵의 킵 타입, 인스턴스 필드 타입)으로 쓰지말자
        - 프리미티브 타입은 따로 있다 OptionalInt.of(10) 등등
        - 당연히 null을 리턴하면 안되겠지? 만약 해야되면 Optional.empty();
        - Collection, Map, Stream Array, Optional은 Opiontal로 감싸지 말 것 why? 저걸로 빈 것을 확인 가능 Collection.isEmpty()

        Optional에 값이 있는 경우에 그 값을 가지고 ~~를 하라.
        ifPresent(Consumer)
        예) Spring으로 시작하는 수업이 있으면 id를 출력하라.

        Optional에 값이 있으면 가져오고 없는 경우에 ~~를 리턴하라.
        orElse(T)
        예) JPA로 시작하는 수업이 없다면 비어있는 수업을 리턴하라.

        Optional에 값이 있으면 가져오고 없는 경우에 ~~를 하라.
        orElseGet(Supplier)
        예) JPA로 시작하는 수업이 없다면 새로 만들어서 리턴하라.

        Optional에 값이 있으면 가졍고 없는 경우 에러를 던져라.
        orElseThrow()

        Optional에 들어있는 값 걸러내기
        Optional filter(Predicate)

        Optional에 들어있는 값 변환하기
        Optional map(Function)
        Optional flatMap(Function): Optional 안에 들어있는 인스턴스가 Optional인 경우에 사용하면 편리하다.

     */
    public void go(){
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        boolean present = spring.isPresent();
        System.out.println(present);

        spring.ifPresent(oc -> System.out.println(oc.getTitle()));
        
        OnlineClass onlineClass = spring.orElse(createNewClass());
        OnlineClass onlineClass1 = spring.orElseGet(this::createNewClass);
        OnlineClass onlineClass2 = spring.orElseThrow(IllegalArgumentException::new);

        Optional<OnlineClass> onlineClass3 = spring.filter(oc -> !oc.isClosed());

        Optional<Integer> integer = spring.map(OnlineClass::getId);

        Optional<Optional<Progress>> progress = spring.map(OnlineClass::getProcess);
        Optional<Progress> progress1 = spring.flatMap(OnlineClass::getProcess);

    }

    private OnlineClass createNewClass() {
        System.out.println(" orElse만 실행됨!");
        return new OnlineClass(10, "New class", false);
    }
}
