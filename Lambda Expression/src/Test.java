import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String[] names={"bob C. bob","elle H. elle","HUGO B. Hugo","CAROLINA b. Caro"};
        List<String> listNames= new ArrayList<>(Arrays.asList(names));

        listNames.removeIf(s->{
           String s1=  s.substring(0, s.indexOf(" "));
           String s2=s.substring(s.lastIndexOf(" ")+1);
           //boolean x=s1.equals(s2);
          // System.out.println(s1+" "+s2+" "+x);
           return  s1.equals(s2);
        });
        listNames.forEach(s->System.out.println(s));
    }
}
