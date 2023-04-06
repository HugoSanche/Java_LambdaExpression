import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class Nothing{
     private static int last_id=1;
     private int id;
     public Nothing() {
         id=Nothing.last_id++;
         System.out.println("Creating nothing Object: id = "+id);

     }
 }
public class MethodReference {
    public static void main(String[] args) {
        List<String> names =new ArrayList<>(List.of("Hugo","Pedro", "Pablo","Veronica"));

        //calculator((a,b)->(a+b),5,8); //Lambda Expression
        calculator(Integer::sum,5,8);//Method Reference

        //calculator((a,b)->(a+b),8.2,8.3); //Lambda Expression
        calculator((a,b)->(a+b),8.2,8.3); //Method Reference

        // Supplier<nothing> object=()->new nothing(); //Lambda Expression
        Supplier<Nothing> object= Nothing::new; //Method Reference

        Nothing pojo=object.get();

        System.out.println("Getting array");
        //Nothing[] pojo1=seedArray(()->new Nothing(),10);//Lambda Expression
        Nothing[] pojo1=seedArray(Nothing::new,10);//Method Reference

    }
    public static <T>  void calculator(BinaryOperator<T> biOperator, T t1, T t2 ){
        biOperator.apply(t1,t2);
    }
    public static Nothing[] seedArray(Supplier<Nothing> reference, int count){
        Nothing[] array=new Nothing[count];
        Arrays.setAll(array,i->reference.get());
        return array;
    }

}
