package Models;

public class WhiteSpottedCatJumpingSpider extends Spider{
    public WhiteSpottedCatJumpingSpider() {
        super("白斑猫跳蛛", 100, 35, 8.75, 25);
        this.maxHealth = 100;
        this.skillNames[0] = "探索";

    }
    @Override
    public void skill(){
        System.out.println("白斑猫跳蛛使用了 探索 ，吃到了更多飞虫，额外恢复至多30的生命值");
        if(maxHealth - health <= 30){
            health = maxHealth;
        }
        else{
            health += 30;
        }
        System.out.println("白斑猫跳蛛当前生命值为" + health);
        isSkillAvailable = false;
    }
    @Override
    public void resetAttackPower(){
        attackPower = 35;
    }
    @Override
    public void resetDefendPower(){
        defendPower = 25;
    }
    @Override
    public void displayAttackColumns(){
        String columns = name + "\n" + """
                ————请选择进攻或使用技能————
                1.进攻（力量35）
                """;
        if(isSkillAvailable){
            columns = columns + "2." + skillNames[0] + "\n";
        }
        System.out.println(columns);
    }
    @Override
    public void displayDefendColumns(){
        String columns = name + "\n" + """
                ————请选择防御或使用技能————
                1.防御（防御力25）
                """;
        if(isSkillAvailable){
            columns = columns + "2." + skillNames[0] + "\n";
        }
        System.out.println(columns);
    }
}
