package Models;

public class ClamSandSpider extends Spider{
    public ClamSandSpider() {
        super("花蛤沙蛛", 80, 20, 7.5, 10);
        this.maxHealth = 80;
        this.skillNames[0] = "躲藏（免伤一回合）";
    }
    @Override
    public void skill(){
        System.out.println("花蛤沙蛛使用了 躲藏 ，免伤一回合");
        isAssaultable = false;
        isSkillAvailable = false;
    }
    @Override
    public void resetAttackPower(){
        attackPower = 20;
    }
    @Override
    public void resetDefendPower(){
        defendPower = 10;
    }
    @Override
    public void displayAttackColumns(){
        String columns = name + "\n" + """
                ————请选择进攻或使用技能————
                1.进攻（力量20）
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
                1.防御（防御力10）
                """;
        if(isSkillAvailable){
            columns = columns + "2." + skillNames[0] + "\n";
        }
        System.out.println(columns);
    }
}
