import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.util.Iterator;
public class MyAnimalShop implements AnimalShop{
    protected double balance;
    protected double previousBalance;
    protected List<Animal> animalList = new ArrayList<>();
    protected List<Customer> customerList = new ArrayList<>();
    protected List<Customer> todayCustomerList = new ArrayList<>();
    protected boolean isOpen;
    public MyAnimalShop(double balance) {
        this.balance = balance;
        previousBalance = balance;
        this.isOpen = true;
    }
    @Override
    public void purchaseAnimal(Animal animal){
        if (balance >= animal.price) {
            animalList.add(animal);
            balance -= animal.price;
            animal.price += 100;
        }
        else {
            throw new InsufficientBalanceException("余额不足");
        }
    }
    @Override
    public void serveCustomer(Customer customer, String animalName){
        Iterator<Animal> iterator = animalList.iterator();
        if (isOpen){
            customerList.add(customer);
            customer.setTimes();
            customer.setDate();
            if (animalList.isEmpty()){
                throw new AnimalNotFoundException("店内没有动物可出售");
            }
            else{
                double balanceBefore = balance;
                while (iterator.hasNext()){
                    Animal animal = iterator.next();
                    if (animal.name.equals(animalName)){
                        System.out.println("出售动物:" + animal);
                        balance += animal.price ;
                        iterator.remove();
                        break;
                    }

                }
                if (balanceBefore == balance){
                    throw new AnimalNotFoundException("店内没有你想要的动物");
                }
            }
        }
        else {
            System.out.println("宠物店已歇业,无法购买动物");
        }
    }
    @Override
    public void closeShop(){
        List<Customer> tempTodayCustomerList = new ArrayList<>();
        if (isOpen){
            System.out.println("宠物店今日歇业");
            for (Customer customer : customerList){
                if(customer.getLastDate().equals(LocalDate.now())){
                    tempTodayCustomerList.add(customer);
                }
            }
            todayCustomerList.addAll(tempTodayCustomerList);
            System.out.println(Arrays.toString(todayCustomerList.toArray()));
            todayCustomerList.clear();
            System.out.println("今日利润:" + (balance - previousBalance));
            previousBalance = balance;
            isOpen = false;
        }
        else{
            System.out.println("宠物店已歇业");
        }
    }
    public void openShop(){
        isOpen = true;
        System.out.println("宠物店开业");
    }
}
