package Models;

public class SawShowySpider extends Spider{
    public SawShowySpider() {
        super("锯艳蛛", 95, 35, 8.0, 20);
        this.maxHealth = 95;
        this.skillNames[0] = "奇袭（攻击力+10）";
        this.skillNames[2] = "极限逃生（被动技能）";
    }
    @Override
    public void skill(){
        System.out.println("锯艳蛛使用了 奇袭 ，本次攻击+10");
        attackPower = 45;
        isSkillAvailable = false;
    }
    //被动技能
    @Override
    public void passiveSkill(Spider enemySpider){
        if(isPassiveSkillAvailable){
            if(enemySpider.getAttackPower() >= this.health){
                isAssaultable = false;
                System.out.println("锯艳蛛使用了 " + this.skillNames[2] + " ，免疫本次攻击伤害");
                isPassiveSkillAvailable = false;
            }
        }
    }
    @Override
    public void resetAttackPower(){
        attackPower = 35;
    }
    @Override
    public void resetDefendPower(){
        defendPower = 20;
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
                1.防御（防御力20）
                """;
        if(isSkillAvailable){
            columns = columns + "2." + skillNames[0] + "\n";
        }
        System.out.println(columns);
    }
}
