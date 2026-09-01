package Models;

public abstract class Spider {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected double bodyLength;
    protected int defendPower;
    protected int level;
    protected int empiricalValue;
    protected int maxEmpiricalValue;
    protected String[] skillNames = new String[3];

    protected boolean isEnemy = false;
    protected boolean isAssaultable = true;
    protected boolean isPrior = false;
    protected boolean isDead = false;
    protected boolean isSkillAvailable = true;
    protected boolean isPassiveSkillAvailable = true;

    protected int playerNumber = 0;
    public Spider(String name, int level) {
        this.name = name;
        this.level = level;

        Ability[] abilityArray = getAbilityArray();
        this.maxHealth = abilityArray[level].maxHealth;
        this.health = maxHealth;
        this.maxEmpiricalValue = abilityArray[level].maxEmpiricalValue;
        this.attackPower = abilityArray[level].attackPower;
        this.bodyLength = abilityArray[level].bodyLength;
        this.defendPower = abilityArray[level].defendPower;
    }

    public void attack(Spider enemySpider){
        if(enemySpider.isAssaultable){
            enemySpider.beAttacked(attackPower);
            empiricalValue += attackPower;
        }
        else{
            System.out.println("您暂时无法攻击" + enemySpider.name);
            enemySpider.isAssaultable = true;
        }
    }
    protected void beAttacked(int p){
        if(isEnemy){
            if(health <= p){
                System.out.println("你成功击败了敌人!");
                isDead = true;
            }
            else{
                health -= p;
                System.out.println(name + "损失了" + p + "点生命值，敌人当前生命值为" + health);
            }
        }
        else if(playerNumber == 1){
            if(health <= p){
                System.out.println("玩家2成功击败了敌人!");
                isDead = true;
            }
            else{
                health -= p;
                System.out.println(name + "损失了" + p + "点生命值，玩家1当前生命值为" + health);
            }
        }
        else if(playerNumber == 2){
            if(health <= p){
                System.out.println("玩家1成功击败了敌人!");
                isDead = true;
            }
            else{
                health -= p;
                System.out.println(name + "损失了" + p + "点生命值，玩家2当前生命值为" + health);
            }
        }
        else{
            if(health <= p){
                System.out.println("你失败了!");
                isDead = true;
            }
            else{
                health -= p;
                System.out.println("你损失了" + p + "点生命值，当前生命值为 " + health);
            }
        }
    }
    public void defend(){
        int restoration;
        if(health + defendPower > maxHealth){
            restoration = maxHealth - health;
        }
        else{
            restoration = defendPower;
        }
        health += restoration;
        if(isEnemy){
            System.out.println(name + "通过防御恢复了" + restoration + "点生命值，当前生命值为 " + health);
        }
        else if(playerNumber == 1){
            System.out.println("玩家1的" + name + "通过防御恢复了" + restoration + "点生命值，当前生命值为 " + health);
        }
        else if(playerNumber == 2){
            System.out.println("玩家2的" + name + "通过防御恢复了" + restoration + "点生命值，当前生命值为 " + health);
        }
        else{
            System.out.println("你的" + name + "通过防御恢复了" + restoration + "点生命值，当前生命值为 " + health);
        }
        empiricalValue += restoration;
    }

    public abstract void skill();
    public void passiveSkill(){}
    public void passiveSkill(Spider enemySpider){}
    public void addEmpiricalValue(int p){
        empiricalValue += p;
    }
    public void upgrade(){
        if(level < getMaxLevel()){
            if(empiricalValue >= maxEmpiricalValue){
                empiricalValue -= maxEmpiricalValue;
                level++;
                Ability[] abilityArray = getAbilityArray();
                maxEmpiricalValue = abilityArray[level].maxEmpiricalValue;
                maxHealth = abilityArray[level].maxHealth;
                health = maxHealth;
                attackPower = abilityArray[level].attackPower;
                bodyLength = abilityArray[level].bodyLength;
                defendPower = abilityArray[level].defendPower;
                isSkillAvailable = true;
                System.out.println(name + " 升级至 " + "Lv." + level);
            }
        }
    }
    public abstract String toString();
    public void displayAttackColumns(){
        String columns = name + "Lv." + level + "\n"
                + "————请选择进攻或使用技能————" + "\n"
                + "1.进攻（力量" + attackPower + "）" + "\n";
        if(isSkillAvailable){
            columns = columns + "2." + skillNames[0] + "\n";
        }
        System.out.println(columns);
    }
    public void displayDefendColumns(){
        String columns = name + "Lv." + level + "\n"
                + "————请选择防御或使用技能————" + "\n"
                + "1.防御（防御力" + defendPower + "）" + "\n";
        if(isSkillAvailable){
            columns = columns + "2." + skillNames[0] + "\n";
        }
        System.out.println(columns);
    }
    public void resetAttackPower(){
        Ability[] abilityArray = getAbilityArray();
        attackPower = abilityArray[level].attackPower;
    }
    public void resetDefendPower(){
        Ability[] abilityArray = getAbilityArray();
        defendPower = abilityArray[level].defendPower;
    }

    public void setEnemy(){
        isEnemy = true;
    }
    public void setPlayerNumber(int pn){
        playerNumber = pn;
    }
    public void resetAssaultable(){
        isAssaultable = true;
    }
    public void resetIsSkillAvailable(){isSkillAvailable = true;}
    public void resetIsPassiveSkillAvailable(){isPassiveSkillAvailable = true;}
    public void resetPrior(){
        isPrior = false;
    }

    public String getName() {
        return name;
    }
    public boolean getIsEnemy(){
        return isEnemy;
    }
    public int getHealth() {
        return health;
    }
    public  int getMaxHealth() {return maxHealth;}
    public int getEmpiricalValue() {return empiricalValue;}
    public int getMaxEmpiricalValue() {return maxEmpiricalValue;}
    public int getLevel() {return level;}
    public int getAttackPower() {
        return attackPower;
    }
    public double getBodyLength() {
        return bodyLength;
    }
    public int getDefendPower() {
        return defendPower;
    }
    public boolean getIsDead() {
        return isDead;
    }
    public int  getPlayerNumber() {
        return playerNumber;
    }
    public boolean getIsSkillAvailable() {
        return isSkillAvailable;
    }
    public boolean getIsAssaultable() {
        return isAssaultable;
    }
    public boolean getIsPrior() {
        return isPrior;
    }

    public abstract Ability[]  getAbilityArray();
    public abstract int getMaxLevel();
}
