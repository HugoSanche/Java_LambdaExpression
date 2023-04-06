import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ChallengeTwo {
    public static void main(String[] args) {

        UnaryOperator<String> everySecondChar= source->{
          StringBuilder returnVal=new StringBuilder();
          for (int i=0; i<source.length();i++){
              if(i%2==1){
                  returnVal.append(source.charAt(i));
              }
          }
          return  returnVal.toString();
        };
        System.out.println(everySecondChar.apply("Hugo Baltazar"));

        System.out.println("*********************");
        Function<String, String> everySecondChar2= source->{
            StringBuilder returnVal=new StringBuilder();
            for (int i=0; i<source.length();i++){
                if(i%2==1){
                    returnVal.append(source.charAt(i));
                }
            }
            return  returnVal.toString();
        };
        System.out.println(everySecondChar.apply("1234567890"));
        System.out.println("*************Challenge Four *****************");
        System.out.println(everySecondChar(everySecondChar,"1234567890"));

        System.out.println("*************Challenge Six *****************");
        Supplier<String> love=()->{//remember when you used "return" you need to use "{"
            String supplierResul="I love Java";

            return supplierResul;
        };
        String iLoveJava= love.get();
    }
    public static <T> String everySecondChar(UnaryOperator<T> t, T s){
       return (String)t.apply(s);
    }
}
