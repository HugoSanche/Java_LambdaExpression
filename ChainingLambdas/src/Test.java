import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        String[] nombres={"Ulises","Gera","Janneth","Monica"};

        Function<String[],Integer> length= s->s.length;
        System.out.println(length.apply(nombres));

        String names="Nallely";
        Function<String,String> uCase= s->s.toUpperCase();

        Function<String,String> f0=uCase
                .andThen(s->s.concat(" y Hugo"));


        System.out.println(f0.apply(names));

    }
}
