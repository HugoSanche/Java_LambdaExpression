import java.util.ArrayList;
import java.util.List;

public class Example_Consumer {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(List.of("Hugo","Pedro","Pablo","Karina","Cecilia"));
        for(String names:list){
            System.out.println(names);
        }
        System.out.println("****");
        list.forEach( names-> System.out.println(names));

        list.forEach( names-> {
            char first=names.charAt(0);
            System.out.println( names+" initial "+first);
        });
        list.removeIf(s->s.equalsIgnoreCase("hugo"));//delete Hugo
        list.forEach(s-> System.out.println(s));

        System.out.println("---");
        list.removeIf(s->s.startsWith("P")); //delete Pedro and pablo
        list.forEach(s-> System.out.println(s));
    }
}
