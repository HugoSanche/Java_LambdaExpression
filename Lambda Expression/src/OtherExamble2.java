import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class OtherExamble2 {
    public static void main(String[] args) {
        var coordenadas=new ArrayList<>(Arrays.asList(new double[]{35.1505,35.1517},
                new double[]{38.1526,39.2418},
                new double[]{31.1524,35.1514})
        );
        coordenadas.forEach(coord->System.out.println(Arrays.toString(coord)));

        BiConsumer<Double,Double> p1=(lat, lng)->System.out.printf("[lat:%.3f lon:%.3f]%n",lat,lng);

        var firstPoint=coordenadas.get(0);
        processPoint(firstPoint[0],firstPoint[1],p1);
        coordenadas.forEach(x->processPoint(x[0],x[1],p1));
        String[] na= {"Hugo","Pedro","Paco","Caralina","Veronica","Lucia"};
        String[] ramdomList=ramdomStringNames(20,na,
                //check no parameters in this lambda expression
                //because interface supplier have method get() who don't have any parameters
                ()->new Random().nextInt(0,na.length)
                );
        System.out.println(Arrays.toString(ramdomList));
    }
    public static <T> void processPoint(T t1, T t2, BiConsumer<T,T> consumer){
        consumer.accept(t1, t2);
    }
    public static String[] ramdomStringNames(int count, String[] names, Supplier<Integer> s){
        String[] values=new String[count];
        for (int i=0; i<count; i++){
            values[i]=names[s.get()];//execute method get() of Supplier interface
        }
        return values;
    }
}
