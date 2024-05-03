import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class Example_Supplier {
    public static void main(String[] args) {
        String[]names= {"Karina","Teresa","Tania","Magda","Yolanda","Carolina","Maria"};
        String[] randomNames=randomlySelectedValues(15,names,()-> new Random().nextInt(0,names.length));
        System.out.println(Arrays.toString(randomNames));
    }
    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
        String[] selectValues=new String[count];
        for(int i=0; i<count; i++){
            selectValues[i]=values[s.get()];
        }
        return selectValues;
    }
}
