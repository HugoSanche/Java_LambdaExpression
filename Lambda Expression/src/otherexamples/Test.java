package otherexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Arrays.asList("Hugo, David, Pedro","Julio","Cesar", "Soledad", "Jorge")
                .stream().filter(s->s.charAt(0)=='J')
                .sorted()
                .forEach(System.out::println);

        List<Integer> numbers=Arrays.asList(15,14,24,26,1,2,3,5,7,8,9,10,12,13,15,16);
        numbers.stream()
                .filter(Test::pares)
                .sorted()
                .forEach(s-> System.out.println(s));

        List<Integer> listNumbers=numbers.stream()
                .filter(Test::pares)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(listNumbers);

        int sumNumbers=numbers.stream()
                .filter(Test::pares)
                .reduce(0,Integer::sum);

        System.out.println(sumNumbers);

    }

    public static boolean pares(int num){
        if (num%2==0){
            return true;
        }
        return false;
    }

}
