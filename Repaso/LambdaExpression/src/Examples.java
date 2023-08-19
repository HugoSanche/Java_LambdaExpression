import java.util.ArrayList;
import java.util.List;

public class Examples{
    public static void main(String[] args) {
        List<String> list=new ArrayList<>(List.of("Hugo","Pedro","Pablo","Karina","Cecilia"));
        for(String names:list){
            System.out.println(names);
        }
        System.out.println("****");
        list.forEach( names-> System.out.println(names));

        list.forEach( names-> {
            char first=names.charAt(0);
            System.out.println( names+" initial "+first);
        });
        int result=calculator((a, b)-> a+b,5,7);
        int result2=calculator((a, b)-> {
                                        int c=a+b;
                                        return c;
                                         }   ,5,7);

        var result3=calculator((a,b)->a.toUpperCase()+" "+b.toUpperCase(),"Hugo","Baltazar");
        System.out.println(result3);

    }
    public static <T> T calculator(Operation<T> function, T value1,T value2){
        T result=function.Operate(value1,value2);
        System.out.println("Result of operation "+result);
        return result;
    }

}
