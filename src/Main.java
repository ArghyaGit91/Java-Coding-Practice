import _interface.Vehicle;
import _interface.implementation.Car;
import inheritence.Child;
import inheritence.Parent;
import lambda.LambdaExpression;
import lambda.SumCalculatorInterface;
import lambda.data.User;
import static_practice.ChildStatic;
import static_practice.ParentStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {


        Vehicle v = new Car();
        v.start();


        Parent p = new Child();
//        p.show();

        System.out.println(args.length);
        for(String s : args){
            System.out.println(s);
        }

        ParentStatic parentStatic = new ChildStatic();
        parentStatic.show();

        ChildStatic childStatic = new ChildStatic();
        childStatic.show();

        ParentStatic pr = new ChildStatic();
        pr.print();

        System.out.println("Hello world!\n \n");
        LambdaExpression lambdaExpression = new LambdaExpression();
        int result = lambdaExpression.addition(10,15);
        System.out.println("result without lambda: "+result);

        SumCalculatorInterface sumCalculatorInterface = (a,b) -> a + b;
        int sum = sumCalculatorInterface.addition(12, 13);
        System.out.println("result with lambda: "+sum);

        SumCalculatorInterface sumCalculatorInterface2 = Integer::sum;
        int addition = sumCalculatorInterface2.addition(20, 10);
        System.out.println("result with method reference: "+addition);

        SumCalculatorInterface obj = new LambdaExpression();
        System.out.println(obj.print());

        SumCalculatorInterface.show();

        List<String> names = Arrays.asList("Arghya", "Subhayan","Loki","Babbar");
//        Consumer cons = new Consumer() {
//            @Override
//            public void accept(Object object) {
//                System.out.println(object);
//            }
//        };

//        Consumer cons1 = object -> System.out.println(object);

//        names.forEach(object -> System.out.println(object));
        names.forEach(System.out::println);

        List<User> userList = new ArrayList<>();
        userList.add(new User("Arghya",
                "Mitra",
                33));

        userList.add(new User("Subhayan",
                "Kaviraj",
                32));

        userList.add(new User("Arijit",
                "Das",
                32));

        System.out.println("Size: "+userList.size());

        userList.forEach(users -> System.out.println(users.getAge()) );
        System.out.println("consumer!\n \n");
        Consumer<List<User>> cons = users -> {
            userList.add(new User("Ram",
                    "Mitra",
                    33));

            userList.add(new User("Shyam",
                    "Kaviraj",
                    32));

            userList.add(new User("Jodu",
                    "Das",
                    32));
        };



        List<User> newUserList = new ArrayList<>();
        Consumer<List<User>> cons1 = users -> {
            for (User userName: users){

                System.out.println(userName.getfName() + userName.getlName());
            }
        };

        cons1.accept(List.of(new User("Arghya", "Mitra", 32),
                new User(
                       "Arka","Banik", 32
                )));



    }
}