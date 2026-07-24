package Models;

public class ClamSandSpider extends Spider{
    public ClamSandSpider() {
        super("花蛤沙蛛", 80, 20, 7.5, 10);
        this.maxHealth = 80;
    }
    @Override
    public void skill(){
        System.out.println("花蛤沙蛛使用了躲藏");
        isAssaultable = false;
        isSkillAvailable = false;
    }
    @Override
    public void displayAttackColumns(){
        String skillName = "躲藏";
        String columns = name + "\n" + """
                ————请选择进攻或使用技能————
                1.进攻（力量20）
                """;
        if(isSkillAvailable){
            columns = columns + "2." + skillName + "\n";
        }
        System.out.println(columns);
    }
    @Override
    public void displayDefendColumns(){
        String skillName = "躲藏";
        String columns = name + "\n" + """
                ————请选择防御或使用技能————
                1.防御（防御力10）
                """;
        if(isSkillAvailable){
            columns = columns + "2." + skillName + "\n";
        }
        System.out.println(columns);
    }
}
