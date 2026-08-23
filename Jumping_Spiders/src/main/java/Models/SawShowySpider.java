package Models;

public class SawShowySpider extends Spider{
    private static final Ability[] abilityArray;
    private static final int maxLevel = 5;
    static{
        abilityArray = new Ability[maxLevel + 1];
        abilityArray[1] = new Ability(25, 20, 8, 1.5, 2);
        abilityArray[2] = new Ability(35, 40, 15, 3.5, 8);
        abilityArray[3] = new Ability(60, 60, 20, 6, 12);
        abilityArray[4] = new Ability(75, 90, 27, 7, 16);
        abilityArray[5] = new Ability(95, 120, 35, 8, 20);
    }
    public SawShowySpider() {
        super("锯艳蛛", 1);
        this.skillNames[0] = "奇袭（攻击力+10）";
        this.skillNames[2] = "极限逃生（被动技能）";
    }
    @Override
    public String toString(){
        return "锯艳蛛";
    }
    @Override
    public void skill(){
        System.out.println("锯艳蛛使用了 奇袭 ，本次攻击+10");
        attackPower += 10;
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
}
