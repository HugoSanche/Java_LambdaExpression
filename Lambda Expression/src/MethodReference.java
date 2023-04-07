import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

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


        calculator((c1,c2)->(c1+c2),"Hugo","Baltazar");

        //calculator((c1,c2)->c1.concat(c2),"Hugo","Baltazar");
        calculator(String::concat,"Hugo","Baltazar");//Method Reference.- Dado que el metodo calculator recibe 3 parametros (BinaryOperator,
                                                           // T t1, T t2) al usar concat por default sabe que estas concatenando los 2 parametros de
                                                            // BinaryOperator

        System.out.println("*********************************************************************");
        //BinaryOperator<String> binaryOperator=((t1,t2)->t1.concat(t2));//Lambda Expression
        BinaryOperator<String> binaryOperator=(String::concat);//Method Reference.- Binary operator recibe 2 parametros por regla y te esta diciendo que los
                                                    //esta concatenando

        //BiFunction<String, String, String> bifunction=((a1,a2)->a1.concat(a2));
        BiFunction<String, String, String> biFunction=(String::concat);

        //UnaryOperator<String> unary=(t1->t1.toUpperCase());//Lambda Expression
        UnaryOperator<String> unary=(String::toUpperCase); //Sabe que UnaryOperator recibe 1 parametro te esta diciendo que ese parametro
                                                            // lo convierte a mayusculas

        System.out.println(binaryOperator.apply("Hola","Mundo"));
        System.out.println(biFunction.apply("Hola","Mundo"));
        System.out.println(unary.apply("Hugo Baltazar"));

        System.out.println("****************** transform **********************");
        String result="Hello ".transform(unary);
        System.out.println(result);

        //result =result.transform((a)->a.toLowerCase());//Lambda Expression
        result =result.transform(String::toLowerCase);

       // Function<String, boolean> f0=((a)->a.isEmpty());//Lambda Expression
        Function<String, Boolean> f0=(String::isEmpty);
        boolean resultBoolean=result.transform(f0);
        System.out.println("Result "+resultBoolean);
        
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
