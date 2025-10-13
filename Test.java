public class Test {

}

enum Gender {
    MALE, FEMALE, UNKNOWN
}
abstract class Animal{
    protected String name;
    protected int age;
    protected Gender sex;
    protected double price;
    public Animal(String name, int age, Gender sex, double price){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.price = price;
    }

    public abstract String toString();
}

class ChineseRuralDog extends Animal{
    protected boolean isVaccineInjected;
    public ChineseRuralDog(String name, int age, Gender sex, boolean isVaccineInjected){
        super(name, age, sex, 100);
        this.isVaccineInjected = isVaccineInjected;
    }
    @Override
    public String toString(){
        return String.format("中华田园犬 [名字: %s, 年龄: %d, 性别: %s, 价格: %.2f, 已接种疫苗: %s]", name, age, sex, price, isVaccineInjected ? "是" : "否");
    }
}

class Cat extends Animal{
    public Cat(String name, int age, Gender sex){
        super(name, age, sex, 200);
    }
    @Override
    public String toString(){
        return String.format("猫猫 [名字: %s, 年龄: %d, 性别: %s, 价格: %.2f]", name, age, sex, price);
    }
}

class Pig extends Animal{
    public Pig(String name, int age, Gender sex){
        super(name, age, sex, 200);
    }
    @Override
    public String toString(){
        return String.format("小猪 [名字: %s, 年龄: %d, 性别: %s, 价格: %.2f]", name, age, sex, price);
    }
}

class LocalDate{
    protected int year;
    protected int month;
    protected int day;
    public LocalDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    @Override
    public String toString(){
        return String.format("%d-%d-%d", year, month, day);
    }
}

class Customer{
    protected String name;
    protected int times;
    protected LocalDate date;
    public Customer(String name, int times, LocalDate date){
        this.name = name;
        this.times = times;
        this.date = date;
    }
    @Override
    public String toString(){
        return String.format("名字: %s, 到店次数: %d, 最新到店时间: %s", name, times, date.toString());
    }
}

interface AnimalShop{

}

class MyAnimalShop implements AnimalShop{

}

//自定义异常类
