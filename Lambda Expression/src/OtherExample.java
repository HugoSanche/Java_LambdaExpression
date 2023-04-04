import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherExample {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>(List.of("Pedro","Julio","Sofia","Carolina","Paty"));
//        for (var n:names){
//            System.out.println(n);
//        }
        String año=" 2000";
        //String myString="Error because I used myString in lambda expression in forEach";
        names.forEach(myString -> { //here i used variable myString

            String escuela="TESE ";
            System.out.println(escuela+myString+año);

        });
        //año="2005"; you can't modify the variable año because you used in lambda expression
        //System.out.println(escuela); error does not recognize escuela

        //Predicate Lambda expression
        names.removeIf(x->x.equalsIgnoreCase("pedro"));//delete "pedro" from the list
        names.forEach(x->System.out.println(x));

        names.addAll(List.of("Paco","Pancho","Hugo"));
        names.forEach(x->System.out.println(x));

        System.out.println("------");
        names.removeIf(x->x.startsWith("Pa"));
        names.forEach(x->System.out.println(x));

        System.out.println("Examples lambda expression for function");
        //Examples lambda expression for function
        System.out.println("------------");
        names.replaceAll(x->x.charAt(0)+" "+x.toUpperCase());
        System.out.println(names);

        String[] emptyString=new String[10];
        System.out.println(Arrays.toString(emptyString));


        Arrays.fill(emptyString,"");
        System.out.println(Arrays.toString(emptyString));

        Arrays.setAll(emptyString,(i)->
                ""+(i+1)+". "+
                        switch (i){
                            case 0->"one";
                            case 1->"two";
                            case 2->"three";
                            case 3->"four";
                            case 4->"five";
                            default -> "";
                }
        );
        System.out.println(Arrays.toString(emptyString));

        System.out.println("Examples lambda expression for the supplier interface");
        //Examples lambda expression for the supplier interface

    }

}
