import java.util.ArrayList;
import java.util.Arrays;
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

        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("-------");
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings,"");
        System.out.println(Arrays.toString(emptyStrings));

        System.out.println("------------------");
        Arrays.setAll(emptyStrings,i->""+i+i+1+"."+switch (i){
            case 0->"cero";
            case 1->"uno";
            case 2->"dos";
            default->"";
        });
        System.out.println(Arrays.toString(emptyStrings));

    }
}
