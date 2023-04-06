import java.util.Arrays;
import java.util.function.Consumer;

public class ChallengeOne {
    public static void main(String[] args) {
        Consumer<String> printTheParts=new Consumer<String>(){

            @Override
            public void accept(String s) {
                String[] parts=s.split("");
                for(String part:parts){
                    System.out.println(part);
                }
            }
        };

        Consumer<String>  printTheParts2=s-> {
            String[] parts=s.split("");
            for(String part:parts){
                System.out.println(part);
            }
        };
        Consumer<Integer>  sum=i-> {
            double PI=3.1416; //static not valid
           int sum2=i+(int)PI;
           System.out.println(sum2);
        };

        String name="Hugo Baltazar Sanchez";
        getConsumer(printTheParts2,name);

        getConsumer(sum,10);

        System.out.println("*********Teacher Example ***********");

        //Lambda expression behind other
        Consumer<String> printPart=s->{
            String[] parts=s.split("");
            Arrays.asList(parts).forEach(p->System.out.println(p));
        };
        printPart.accept("Sofia Sanchez");
    }
    public static<T> void getConsumer(Consumer<T> c, T t){
        c.accept(t);
    }
}
