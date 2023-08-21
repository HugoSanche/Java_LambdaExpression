import java.util.Arrays;
import java.util.function.BiConsumer;

public class Example_BiConsumer {
    public static void main(String[] args) {

        var coords= Arrays.asList(
                new double[]{15.00,-10.50},
                new double []{10.25,11.21},
                new double[]{9.14,10.25}
        );
        BiConsumer<Double,Double> p1=(lat, lon)-> System.out.printf("Lat :%.3f Lon:%.3f \n",lat,lon);


        var firstCoor=coords.get(0);
        processPoint(firstCoor[0],firstCoor[1],p1);

       coords.forEach(s->processPoint(s[0],s[1],
               (lat, lon)-> System.out.printf("Lat :%.3f Lon:%.3f \n",lat,lon)));
    }

    public static <T> void processPoint(T t1,T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1,t2);
    }
}
