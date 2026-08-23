package Models;

public class BlackJumpingSpider extends Spider {
    private static final Ability[] abilityArray;
    private static final int maxLevel = 5;
    static{
        abilityArray = new Ability[maxLevel + 1];
        abilityArray[1] = new Ability(35, 25, 5, 1.5, 2);
        abilityArray[2] = new Ability(50, 50, 10, 3.5, 6);
        abilityArray[3] = new Ability(70, 85, 20, 6, 15);
        abilityArray[4] = new Ability(100, 125, 35, 8, 25);
        abilityArray[5] = new Ability(120, 160, 45, 10, 35);
    }
    public BlackJumpingSpider() {
        super("黑色蝇虎", 1);
        this.skillNames[0] = "潜行（优先进攻权）";
    }
    @Override
    public String toString() {
        return "黑色蝇虎";
    }
    @Override
    public void skill(){
        System.out.println("黑色蝇虎使用了 潜行 ，下一回合优先进攻");
        isPrior = true;
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
