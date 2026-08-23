package Models;

public class ClamSandSpider extends Spider{
    private final static Ability[] abilityArray;
    private final static int maxLevel = 5;
    static{
        abilityArray = new Ability[maxLevel + 1];
        abilityArray[1] = new Ability(30, 10, 5, 1, 2);
        abilityArray[2] = new Ability(40, 25, 8, 3, 5);
        abilityArray[3] = new Ability(50, 40, 12, 5, 7);
        abilityArray[4] = new Ability(65, 60, 16, 6.5, 10);
        abilityArray[5] = new Ability(80, 80, 20, 7.5, 15);
    }
    public ClamSandSpider() {
        super("花蛤沙蛛", 1);
        this.skillNames[0] = "躲藏（免伤一回合）";
    }
    @Override
    public String toString(){
        return "花蛤沙蛛";
    }
    @Override
    public void skill(){
        System.out.println("花蛤沙蛛使用了 躲藏 ，免伤一回合");
        isAssaultable = false;
        isSkillAvailable = false;
    }
    @Override
    public Ability[] getAbilityArray() {
        return abilityArray;
    }
    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
}
