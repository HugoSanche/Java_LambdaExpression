import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//Functional interface
//A functional interface is that only have one method abstract
//to use a lambda expression the interface only would have ONE method abstract
//https://www.arquitecturajava.com/java-functional-interface/
public class Main {
    public record Person(String firstName, String lastName){
        @Override
        public String toString() {
            return firstName+" "+lastName;
        }
    }
    public static void main(String[] args) {

        List<Person> list =new ArrayList<>(Arrays.asList(new Main.Person("Lionel","Baltazar"),
                new Person("Veronica","Perez"),
                new Person("Arely","Vite"),
                new Person("Miriam","Vazquez")));
        var comparator= new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };
        System.out.println("Order by Anonymous class");
        list.sort(comparator);
        System.out.println(list);

        System.out.println("\nOrder by Lambda Expression");
        list.sort((o1,o2) -> o1.lastName.compareTo(o2.lastName));
        System.out.println(list);

        interface EnhancedComparator<T> extends Comparator<T>{
             int secondLevel(T o1, T o2 );
        }
        var enhancedComparator= new EnhancedComparator<Person>() {
            @Override
            public int secondLevel(Person o1, Person o2) {
                int result= o1.firstName.compareTo(o2.lastName);
                return  result==0 ? secondLevel(o1,o2) : result;
            }
            @Override
            public int compare(Person o1, Person o2) {
                 return o1.firstName.compareTo(o2.lastName);

            }
        };
        System.out.println("\nOrder by Enhanced");
        list.sort(enhancedComparator);
        System.out.println(list);

    }
}