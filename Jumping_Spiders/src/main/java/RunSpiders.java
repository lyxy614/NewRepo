import Exceptions.GenerateRandomException;
import Models.Spider;

import java.util.Random;
import java.util.Scanner;
public class RunSpiders {
    private Spider[] spiders = new Spider[3];

    public RunSpiders(Spider spider1, Spider spider2) {
        this.spiders[1] = spider1;
        this.spiders[2] = spider2;
    }
    public void runSpiders(){
        displayRules();
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String choice = "0";
        int counter = 0;
        //优先进攻权抽取
        Random rand = new Random();
        int flag = rand.nextInt(2) + 1;
        if(flag == 1){
            if(spiders[2].getIsEnemy()){
                System.out.println("本回合玩家优先进攻");
            }
            else{
                System.out.println("本回合玩家1优先攻击");
            }
        }
        else if(flag == 2){
            if(spiders[2].getIsEnemy()){
                System.out.println("本回合电脑优先进攻");
            }
            else{
                System.out.println("本回合玩家2优先攻击");
            }
        }
        else{
            throw new GenerateRandomException("优先进攻随机数生成错误");
        }
        while(!spiders[1].getIsDead() && !spiders[2].getIsDead()){
            counter++;
            System.out.println("——————第" + counter + "回合——————");
            //回合逻辑
            //优先进攻方先进攻或使用技能
            if(spiders[2].getIsEnemy()){
                System.out.println("人机对战功能尚未实现，敬请期待");
                break;
            }
            //（1）判断优先进攻方
            //（2）让玩家选择是否进攻和使用技能
            System.out.println("玩家" + spiders[flag].getPlayerNumber() +"：");
            spiders[flag].displayAttackColumns();
            choice = sc.nextLine();
            if(choice.equals("2") && spiders[flag].getIsSkillAvailable()){
                if(flag == 1){
                    spiders[1].skill();
                }
                else{
                    spiders[2].skill();
                }
            }
            else if(choice.equals("12") && spiders[flag].getIsSkillAvailable()){
                if(flag == 1){
                    spiders[1].skill();
                    spiders[2].passiveSkill(spiders[1]);
                    spiders[1].attack(spiders[2]);
                }
                else{
                    spiders[2].skill();
                    spiders[1].passiveSkill(spiders[2]);
                    spiders[2].attack(spiders[1]);
                }
            }
            else{
                if(flag == 1){
                    spiders[2].passiveSkill(spiders[1]);
                    spiders[1].attack(spiders[2]);
                }
                else{
                    spiders[1].passiveSkill(spiders[2]);
                    spiders[2].attack(spiders[1]);
                }
            }
            System.out.println();
            if(spiders[1].getIsDead() || spiders[2].getIsDead()){
                break;
            }
            //防守方选择是否防御或使用技能
            if(flag == 1){
                flag = 2;
            }
            else{
                flag = 1;
            }
            System.out.println("玩家" + spiders[flag].getPlayerNumber() +"：");
            spiders[flag].displayDefendColumns();
            choice = sc.nextLine();
            if(choice.equals("2") && spiders[flag].getIsSkillAvailable()){
                if(flag == 1){
                    spiders[1].skill();
                }
                else{
                    spiders[2].skill();
                }
            }
            else if(choice.equals("12") && spiders[flag].getIsSkillAvailable()){
                if(flag == 1){
                    spiders[1].skill();
                    spiders[1].defend();
                }
                else{
                    spiders[2].skill();
                    spiders[2].defend();
                }
            }
            else{
                if(flag == 1){
                    spiders[1].defend();
                }
                else{
                    spiders[2].defend();
                }
            }
            System.out.println();
            //下一回合进攻优先权
            if(spiders[1].getIsPrior() && spiders[2].getIsPrior()){

            }
            else if(spiders[1].getIsPrior()){
                flag = 1;
            }
            else if(spiders[2].getIsPrior()){
                flag = 2;
            }
            for(int i = 1; i < spiders.length; i++){
                spiders[i].resetAttackPower();
                spiders[i].resetDefendPower();
                spiders[i].resetPrior();
            }
        }
        //判断跳蛛是否死亡，宣布胜者，结束游戏
        System.out.println("——————本局游戏结束——————");
        System.out.println("共" + counter + "回合");
        System.out.println();
    }
    public static void displayRules(){
        String rules = """
                ————————————游戏规则————————————
                1.随机分配进攻方，之后每一回合反转
                2.可以选择是否进攻、防御或使用技能
                  每个技能每局只能使用一次
                3.一回合内可以同时使用进攻和单个技能
                  (输入示例：1,2,12)
                  (输入其他字符将默认只进攻或防御)
                  .....请按任意键开始游戏.....
                """;
        System.out.println(rules);
    }
}
