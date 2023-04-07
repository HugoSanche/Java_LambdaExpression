import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class ChallengeFour {
    private static Random random=new Random();
    public static void main(String[] args) {
        String[] myString={"Keira","Lionel","Hugo","Veronica"};
        Arrays.setAll(myString,(i)->myString[i].toUpperCase());
        System.out.println(Arrays.toString(myString));

        List<String> names = new ArrayList<>(List.of(myString));
        names.replaceAll(String::toLowerCase);
        names.forEach(System.out::println);
        reverse(names);

        List<UnaryOperator<String>> list=new ArrayList<>(List.of(
                String::toUpperCase,
                s->s+=" "+getRandomChar('D','M')+".",
                s->s+=" "+reverse(s,0,s.indexOf(" ")),
                ChallengeFour::reverse, //static Method
                String::new,
                String::new
                ));
        applyChallenges(myString,list);
    }
    public static <T> void reverse(List<String> names){
        names.forEach((a)->{
            String reverseNames=new StringBuffer(a).reverse().toString();
            System.out.println(reverseNames);
        });

    }
    private static void applyChallenges(String[] names, List<UnaryOperator<String>> stringFunctions){
        List<String> backedByArray=Arrays.asList(names);
        for (var function:stringFunctions){
            backedByArray.replaceAll(s->s.transform(function));
            System.out.println(Arrays.toString(names));
        }
    }
    private static char getRandomChar(char startChar, char endChar){
        return (char) random.nextInt((int) startChar,(int) endChar+1);
    }
    private static String reverse(String s){
        return reverse(s,0,s.length());
    }
    private static String reverse (String s, int start, int end){
        return new StringBuilder(s.substring(start, end)).reverse().toString();
    }
}
