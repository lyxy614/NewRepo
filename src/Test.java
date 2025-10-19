import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class Test {
    public static void main(String[] args) {
        MyAnimalShop myAnimalShop = new MyAnimalShop(1000);
        List<Animal> animalList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        ChineseRuralDog dog = new ChineseRuralDog("大黄", 2, Gender.MALE, true);
        Cat cat = new Cat("小猫", 3, Gender.FEMALE);
        Pig pig = new Pig("小猪", 1, Gender.MALE);
        try{
            myAnimalShop.purchaseAnimal(dog);
            myAnimalShop.purchaseAnimal(pig);
            myAnimalShop.purchaseAnimal(cat);
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        Customer ZhangSan = new Customer("张三");
        Customer LiSi = new Customer("李四");
        Customer WangWu = new Customer("王五");
        try{
            myAnimalShop.serveCustomer(ZhangSan, "大黄");
        }catch (AnimalNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            myAnimalShop.serveCustomer(LiSi, "大黄");
        }catch (AnimalNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            myAnimalShop.serveCustomer(WangWu, "鼠王");
        }catch (AnimalNotFoundException e){
            System.out.println(e.getMessage());
        }
        myAnimalShop.closeShop();
        try{
            myAnimalShop.serveCustomer(LiSi, "小猫");
        }catch (AnimalNotFoundException e){
            System.out.println(e.getMessage());
        }
        myAnimalShop.closeShop();
        myAnimalShop.openShop();
        try{
            myAnimalShop.serveCustomer(LiSi, "小猫");
        }catch (AnimalNotFoundException e){
            System.out.println(e.getMessage());
        }
        myAnimalShop.closeShop();
    }

}
enum Gender {
    MALE, FEMALE, UNKNOWN
}
//自定义异常类
class AnimalNotFoundException extends RuntimeException{
    public AnimalNotFoundException(String message){
        super(message);
    }
}

class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message){
        super(message);
    }
}