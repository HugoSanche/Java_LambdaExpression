package Examples;

public class MyLambdaEx {
    public static void main(String[] args) {

        MyFuntionalInterface myFunction=()->{
            System.out.println("Say Hello");
        };
        myFunction.sayHello();
    }
}
