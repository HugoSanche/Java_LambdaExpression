import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Examples{
    public static void main(String[] args) {

        int result=calculator((a, b)-> a+b,5,7);
        int result2=calculator((a, b)-> {
                                        int c=a+b;
                                        return c;
                                         }   ,5,7);

        var result3=calculator((a,b)->a.toUpperCase()+" "+b.toUpperCase(),"Hugo","Baltazar");
        System.out.println(result3);


        /***CONSUMER***/
        var coords=Arrays.asList(
                new double[]{15.00,-10.50},
                new double []{10.25,11.21},
                new double[]{9.14,10.25}
        );
        coords.forEach(s-> System.out.println(Arrays.toString(s)));
        BiConsumer<Double,Double> p1=(la, lon)->{
            System.out.printf("Lat:%.3f lon:%.3f \n",la,lon);
        };

    }
    public static <T> T calculator(Operation<T> function, T value1,T value2){
        T result=function.Operate(value1,value2);
        System.out.println("Result of operation "+result);
        return result;
    }

}
