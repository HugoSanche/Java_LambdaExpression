import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChallengeThree {
    public static void main(String[] args) {

        String[] n={"bob","elle","HUGO","CAROLINA"};

       // String string = new StringBuilder(n);

        System.out.println("*****************TO UPPER CASE ARRAY***************");
        Arrays.setAll(n,(i)->n[i].toUpperCase()
                );

        System.out.println(Arrays.toString(n));
        Arrays.setAll(n,(i)->
                (i+1)+
                        switch (i){
                            case 0->"1 ";
                            case 1->"2 "+n[i];
                            case 2->"3 "+n[i];
                            case 3->"4 "+n[i];
                            case 4->"5 "+n[i];
                            default -> "";
                        }
        );
        System.out.println(Arrays.toString(n));

        System.out.println("*********************************");
        List<String> names =new ArrayList<>(List.of("bob","elle","hugo","carolina"));
        List<String> names2=new ArrayList<>(names);

        names2.replaceAll(x->x.toUpperCase());
        names2.forEach(x->System.out.println(x));

        System.out.println("******************REVERSE***************");
        names.forEach(x->{
            String r=new StringBuffer(x).reverse().toString();
            System.out.println(r);

        });

        System.out.println("******************REMOVE***************");
        names.removeIf(s->{
            boolean r=false;
            String y=new StringBuffer(s).reverse().toString();
                if (s.equalsIgnoreCase(y)) {
                    r = true;
                }
            return r;
        });
        names.forEach(x->System.out.println(x));


    }
}
