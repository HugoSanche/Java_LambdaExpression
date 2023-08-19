import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    record Person(String firstName, String lastName){
        @Override
        public String toString() {
            return firstName+" "+lastName;
        }
    }
    public static void main(String[] args) {

        List<Person> persons=new ArrayList<>(Arrays.asList(
        new Main.Person("Carolina","Sanchez"),
        new Person("Veronica","Perez"),
        new Person("Arely","Vite"),
        new Person("Miguel","Cervantes")));

        var comparePersom=new Comparator<Person>(){

            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };
      persons.sort(new Comparator<Person>() {
          @Override
          public int compare(Person o1, Person o2) {
              return o1.firstName.compareTo(o2.firstName);
          }
      });
        System.out.println(persons);
    }
}









