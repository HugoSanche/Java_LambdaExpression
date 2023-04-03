import java.util.ArrayList;
import java.util.List;

public class OtherExample {
    public static void main(String[] args) {
        List<String> names=new ArrayList<>(List.of("Pedro","Julio","Sofia","Carolina","Paty"));
//        for (var n:names){
//            System.out.println(n);
//        }
        String año=" 2000";
        //String myString="Error because I used myString in lambda expresion in forEach";
        names.forEach(myString -> { //here i used variable myString

            String escuela="TESE ";
            System.out.println(escuela+myString+año);

        });
        //año="2005"; you can't modify the variable año
        //System.out.println(escuela); error does not recognize escuela
    }
}
