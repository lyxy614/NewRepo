package Models;

public class BlackJumpingSpider extends Spider {
    public BlackJumpingSpider() {
        super("黑色蝇虎", 120, 50, 12.0, 40);
        this.maxHealth = 120;
    }
    @Override
    public void skill(){
        System.out.println("黑色蝇虎使用了潜行，下一回合优先进攻");
        //isAssaultable = false;
        isPrior = true;
        isSkillAvailable = false;
    }
    @Override
    public void displayAttackColumns(){
        String skillName = "潜行";
        String columns = name + "\n" + """
                ————请选择进攻或使用技能————
                1.进攻（力量50）
                """;
        if(isSkillAvailable){
            columns = columns + "2." + skillName + "\n";
        }
        System.out.println(columns);
    }
    @Override
    public void displayDefendColumns(){
        String skillName = "潜行";
        String columns = name + "\n" + """
                ————请选择防御或使用技能————
                1.防御（防御力40）
                """;
        if(isSkillAvailable){
            columns = columns + "2." + skillName + "\n";
        }
        System.out.println(columns);
    }
}
