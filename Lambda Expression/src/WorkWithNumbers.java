import java.util.Arrays;
import java.util.List;

public class WorkWithNumbers {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,3,4,6,7,8,9);
        int resultado=sumNumbers2(numbers);
        System.out.println(resultado);
    }
    public static Integer sumNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(y->y%2!=0)
                .reduce(0,Integer::sum);
    }
    public static Integer sumNumbers2(List<Integer> integers){
        Integer resultado=0;

//        integers.stream()
//                .forEach(x-> System.out.println(x)  );
        //integers.stream()

        return resultado;
    }
}
