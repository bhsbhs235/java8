package org.example;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
@Hyoseong("aaa")
@Hyoseong("bbb")
public class App 
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        /*int baseNumber = 10;
        RunSomething runSomething = (number) -> {
            return number + baseNumber;
        };

        // baseNumber++; 함수 밖에 있는 값을 변경하지 못한다.

        runSomething.printAge();
        RunSomething.printName();

        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));

        Function<Integer, Integer> anoPlus10 = (i) -> i+10;
        //Function<파라미너타입, 리턴타입>
        Function<Integer, Integer> multi2 = (i) -> i * 2;

        Function<Integer, Integer> multi2plus10 = plus10.compose(multi2);
        System.out.println(anoPlus10.apply(1));
        System.out.println(anoPlus10.compose(multi2).apply(2));
        System.out.println(multi2plus10.apply(2));

        Function<Integer, Integer> plus10multi2 = plus10.andThen(multi2);
        System.out.println(plus10multi2.apply(2));*/

        // Consumer<T> Consumer<Integer> printT = (i) -> System.out.println(i); 파라미터 타입
        // Supplier<Integer> get10 = () -> 10; 리턴타입
        // Predicate<Integer> isEven = (i)-> i%2 == 0; 파라미터 타입을 받아서 boolean을 리턴한다
        // UnaryOperator<Integer> noPlus10 = (i) -> i + 10; 파라미터 타입과 리턴타입이 같다
        //Function<T, R> T: 파라미터 타입, R : 리턴 타입
        //BiFunction<T, U, R>
        //Consumer<T>
        //Supplier<T>
        //Predicate<T>
        //UnaryOperator<T>
        //BinaryOperator<T>

        /*Supplier<Integer> get10 = () -> 10;

        // 메소드 레퍼런스 ::
        Greeting greeting = new Greeting();
        UnaryOperator<String> hi = Greeting::hi;
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hi.apply("hyoseong"));
        System.out.println(hello.apply("hyoseong"));

        Supplier<Greeting> newGreeting= Greeting::new; // 레퍼런스가 없는 생성자
        Greeting greeting1 = newGreeting.get();

        Function<String, Greeting> greeting2 = Greeting::new; // String

        String[] names = {"a", "b", "C"};
        Arrays.sort(names, (o1, o2) -> 0); // -> 람다는 메소드 레퍼런스로 표현할 수 있다. Array.sort(names, String::compareToIgnoreCase);
        */

        /*List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("orange");*/

       /* Spliterator<String> spliterator = fruits.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(s -> System.out.println(s)));
        System.out.println("=====================================");
        while (spliterator1.tryAdvance(s -> System.out.println(s)));*/


        /*Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        fruits.sort(compareToIgnoreCase.reversed());*/
        // stream 은 spliterator로 구현되어 있다.

        /*
         - 스트림을 이용해 내용을 변경하거나 해도 원본은 바뀌지 않는다.
         - 스트림은 한번만 사용 가능하다
         - 종료형 오퍼레이터가 있어야한다.(한개만 가능)
         */

        /*fruits.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }); // 출력안됨 (종료형 오퍼레이터가 없어서)

        List<String> collect = fruits.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList()); // 출력됨

        collect.forEach(System.out::println);

        System.out.println("====================");

        fruits.forEach(System.out::println);*/

        /*List<String> collect = fruits.parallelStream().map((s) -> {
            System.out.println(s + "   " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);*/

        //StreamApiPractice streamApiPractice = new StreamApiPractice();
        //streamApiPractice.go();

        //OptionalPractice optionalPractice = new OptionalPractice();
        //optionalPractice.go();

        /*DatePractice datePractice = new DatePractice();
        datePractice.go();*/

        /*ThreadPractice threadPractice = new ThreadPractice();
        try {
            threadPractice.go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        /*CompletableFuturePractice com = new CompletableFuturePractice();
        com.go();*/

        /*Hyoseong[] hyoseongs = App.class.getAnnotationsByType(Hyoseong.class);
        Arrays.stream(hyoseongs).forEach(c -> {
            System.out.println(c.value());
        });*/

        HyoseongContainer annotation = App.class.getAnnotation(HyoseongContainer.class);
        Arrays.stream(annotation.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }

    /*
    class Foo {
        private void run(){
            final int baseNumber = 10; // 버전 업글 final 안붙혀도됨

            //로컬 클래스
            class LocalClass{
                void printBaseNumber(){
                    int baseNumber = 11;
                    System.out.println(baseNumber); // 11
                }
            }

            //익명 클래스
            Consumer<Integer> integerConsumer = new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) {
                    System.out.println(baseNumber);
                }
            };

            IntConsumer printInt = (i) -> { // 파라미터로 baseNumber를 할 수 없다
                System.out.println(i + baseNumber);
            };

            printInt.accept(10);

        }
    }*/

    /*static class abcd<@Hyoseong T> {

        public static <@Hyoseong*//* Type_parameter *//* C> void print(@Hyoseong *//* type *//* C c){
            System.out.println(c);
        }

    }*/
}
