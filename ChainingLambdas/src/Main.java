import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        String name = "Hugo";
        //Function<String, String> cha=(source->source.toUpperCase());
        Function<String, String> uCase = (String::toUpperCase);
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Baltazar");
        Function<String, String> uCaseLastName = uCase
                .andThen((lastName));
        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        //System.out.println(uCase);
        System.out.println("*******************UNO**************************");
        Function<String, String[]> f0 = uCase
                .andThen(s -> s.concat(" Baltazar"))
                .andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));

        System.out.println("*******************DOS**************************");
        Function<String, String> f1 = uCase
                .andThen(s -> s.concat(" Baltazar"))
                .andThen(s -> s.split(""))
                .andThen(s -> s[3].toUpperCase() + ", " + s[5]);
        System.out.println(f1.apply(name));

        System.out.println("*******************TRES*************************");
        Function<String, Integer> f2 = uCase
                .andThen(s -> s.concat(" Baltazar"))
                .andThen(s -> s.split(" "))
                .andThen(s -> String.join(", ", s))
                // .andThen(s->s.split(" "))
                .andThen(s -> s.concat("Sanchez"))
                .andThen(String::length);
        System.out.println(f2.apply(name));

        System.out.println("*********************CUATRO**********************************");
        String[] names = {"Hugo", "Paco", "Louis"};
        Consumer<String> s0 = s -> System.out.println(s.charAt(0));
        Consumer<String> s1 = System.out::println;

        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.println(" - "))
                .andThen(s1)
        );

        Predicate<String> e1 = s -> s.equals("HUGO");
        Predicate<String> e2 = s -> s.equalsIgnoreCase("Hugo");
        Predicate<String> e3 = s -> s.startsWith("H");
        Predicate<String> e4 = s -> s.endsWith("o");

        Predicate<String> test1=e1.or(e2);
        System.out.println(test1.test(name));

        Predicate<String> test2=e3.and(e4);
        System.out.println(test2.test(name));

        Predicate<String> test3 =e3.and(e4).negate();
        System.out.println("test3 = "+test3.test(name));

        record Person(String firstName, String lastName){}
        List<Person> list =new ArrayList<>(Arrays.asList(
                new Person("Hugo", "Baltazar"),
                new Person("Ricardo", "Rodriguez"),
                new Person("Rodrigo","Perez"),
                new Person("Pedro", "Paramo"),
                new Person("Hugo","Sanchez")
        ));
        list.sort((o1,o2)->o1.lastName.compareTo(o2.lastName));
        list.forEach(s->System.out.println(s));

        System.out.println("*********************************");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
        );
        list.forEach(s->System.out.println(s));

        System.out.println("*********************************");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName)
        );

        System.out.println("*********************************");
        list.sort(Comparator.comparing(Person::lastName)
                .thenComparing(Person::firstName).reversed()
        );
        list.forEach(s->System.out.println(s));

    }
}