package Models;

public abstract class Spider {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackPower;
    protected double bodyLength;
    protected int defendPower;

    protected boolean isEnemy = false;
    protected boolean isAssaultable = true;
    protected boolean isPrior = false;
    protected boolean isDead = false;
    protected boolean isSkillAvailable = true;

    protected int playerNumber = 0;
    public Spider(String name, int health,  int attackPower, double bodyLength, int defendPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.bodyLength = bodyLength;
        this.defendPower = defendPower;
    }

    public void attack(Spider enemySpider){
        if(enemySpider.isAssaultable){
            enemySpider.beAttacked(attackPower);
        }
        else{
            System.out.println("您暂时无法攻击" + enemySpider.name);
            enemySpider.isAssaultable = true;
        }
    }
    public void beAttacked(int p){
        if(isEnemy){
            if(health <= p){
                System.out.println("你成功击败了敌人!");
                //抛出运行时错误，以结束游戏
                //throw new HealthException("生命值耗尽");
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
                //抛出运行时错误，以结束游戏
                //throw new HealthException("生命值耗尽");
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
                //抛出运行时错误，以结束游戏
                //throw new HealthException("生命值耗尽");
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
                //抛出运行时错误，以结束游戏
                //throw new HealthException("生命值耗尽");
                isDead = true;
            }
            else{
                health -= p;
                System.out.println("你损失了" + p + "点生命值，当前生命值为 " + health);
            }
        }
    }
    public void defend(){
        int restoration = 0;
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
    }
    public void jump(){

    }

    public abstract void skill();
    public abstract void displayAttackColumns();
    public  abstract void displayDefendColumns();

    public void setEnemy(){
        isEnemy = true;
    }
    public void setPlayerNumber(int pn){
        playerNumber = pn;
    }
    public void resetAssaultable(){
        isAssaultable = true;
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
}
