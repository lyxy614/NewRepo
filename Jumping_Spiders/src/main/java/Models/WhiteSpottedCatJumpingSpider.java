package Models;

public class WhiteSpottedCatJumpingSpider extends Spider{
    private static final Ability[] abilityArray;
    private final static int maxLevel = 5;
    static{
        abilityArray = new Ability[maxLevel + 1];
        abilityArray[1] = new Ability(30, 20, 6, 1.5, 2);
        abilityArray[2] = new Ability(45, 40, 12, 3, 9);
        abilityArray[3] = new Ability(65, 65, 22, 5.5, 12);
        abilityArray[4] = new Ability(85, 85, 29, 7, 20);
        abilityArray[5] = new Ability(100, 100, 35, 8.75, 25);
    }
    public WhiteSpottedCatJumpingSpider() {
        super("白斑猫跳蛛", 1);
        this.skillNames[0] = "探索（额外恢复生命值）";
    }
    @Override
    public String toString() {
        return "白斑猫跳蛛";
    }
    @Override
    public void skill(){
        int originalHealth = health;
        int restoration;
        switch(level){
            case 1:
            case 2:
               restoration = 10;
               break;
            case 3:
            case 4:
                restoration = 20;
                break;
            case 5:
                restoration = 30;
                break;
            default:
                restoration = -1000;
                System.err.println("白斑猫跳蛛等级出错，请退出游戏检查");
        }
        if(maxHealth - health <= restoration){
            health = maxHealth;
        }
        else{
            health += restoration;
        }
        System.out.println("白斑猫跳蛛使用了 探索 ，吃到了更多飞虫，额外恢复" + (health - originalHealth) + "的生命值");
        System.out.println("白斑猫跳蛛当前生命值为" + health);
        empiricalValue += (health - originalHealth);
        isSkillAvailable = false;
    }
    @Override
    public Ability[] getAbilityArray(){
        return abilityArray;
    }
    @Override
    public int getMaxLevel(){
        return maxLevel;
    }
}
