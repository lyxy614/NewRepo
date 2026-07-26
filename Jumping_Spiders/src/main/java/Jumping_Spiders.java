import Exceptions.GenerateRandomException;
import Models.*;

import java.util.Scanner;
import java.util.Random;
public class Jumping_Spiders {
    public static void main(String[] args) {
        Spider spiders[] = new Spider[3];
        //开始界面
        displayStartColumns();
        Scanner sc = new Scanner(System.in);
        int flag1 = sc.nextInt();
        int flag2;
        while(flag1 != 3){
            //单人模式
            if(flag1 == 1){
                displaySpiderColumns();
                flag2 = sc.nextInt();
                switch (flag2) {
                    case 1:
                        spiders[1] = new BlackJumpingSpider();
                        break;
                    case 2:
                        spiders[1] = new ClamSandSpider();
                        break;
                    case 3:
                        spiders[1] = new SawShowySpider();
                        break;
                    case 4:
                        spiders[1] = new WhiteSpottedCatJumpingSpider();
                        break;
                    default:
                        System.out.println("你选择的序号不在范围内，请重新选择");
                        flag1 = 1;
                        continue;
                }
                System.out.println("你选择了" + spiders[1].getName());
                //电脑抽取跳蛛
                Random random = new Random();
                flag2 = random.nextInt(4) + 1;
                switch (flag2) {
                    case 1:
                        spiders[2] = new BlackJumpingSpider();
                        break;
                    case 2:
                        spiders[2] = new ClamSandSpider();
                        break;
                    case 3:
                        spiders[2] = new SawShowySpider();
                        break;
                    case 4:
                        spiders[2] = new WhiteSpottedCatJumpingSpider();
                        break;
                    default:
                        System.err.println("随机数生成出错");
                        return;
                }
                System.out.println("电脑选择了" + spiders[2].getName());
                spiders[2].setEnemy();
                //游戏主程序
                try{
                    RunSpiders runSpiders = new RunSpiders(spiders[1], spiders[2]);
                    runSpiders.runSpiders();
                }catch (GenerateRandomException e){
                    System.err.println(e);
                }
                displayStartColumns();
                flag1 = sc.nextInt();
            }
            //双人模式
            else if(flag1 == 2){
                for(int i = 1; i < 3; i++){
                    System.out.println("玩家" + i + "：");
                    displaySpiderColumns();
                    flag2 = sc.nextInt();
                    //玩家选择创建对象逻辑

                    switch (flag2) {
                        case 1:
                            spiders[i] = new BlackJumpingSpider();
                            break;
                        case 2:
                            spiders[i] = new ClamSandSpider();
                            break;
                        case 3:
                            spiders[i] = new SawShowySpider();
                            break;
                        case 4:
                            spiders[i] = new WhiteSpottedCatJumpingSpider();
                            break;
                        default:
                            System.out.println("玩家" + i + "选择的序号不在范围内，请重新选择");
                            flag1 = 3;
                    }
                    if(flag1 == 3){
                        break;
                    }
                    System.out.println("玩家" + i + "选择了" + spiders[i].getName());
                    spiders[i].setPlayerNumber(i);
                }
                if(flag1 == 3){
                    flag1 = 2;
                    continue;
                }

                //游戏主程序
                try{
                    RunSpiders runSpiders = new RunSpiders(spiders[1], spiders[2]);
                    runSpiders.runSpiders();
                }catch (GenerateRandomException e){
                    System.err.println(e);
                }
                displayStartColumns();
                flag1 = sc.nextInt();
            }
            //退出游戏
            else{
                displayStartColumns();
                flag1 = sc.nextInt();
            }
        }
        System.out.println("游戏已退出");
    }
    public static void displayStartColumns(){
        String s = """
                ————————跳蛛大战————————
                       1.单人模式
                       2.双人模式
                       3.退出游戏
                输入对应数字并按下回车以选择
                (请勿输入字符串！！！)
                """;
        System.out.println(s);
    }
    public static void displaySpiderColumns(){
        String s = """
                ————————选择跳蛛———————
                """;
        String s1 = "1." + "黑色蝇虎" + "\n";
        String s2 = "2." + "花蛤沙蛛" + "\n";
        String s3 = "3." + "锯艳蛛" + "\n";
        String s4 = "4." + "白斑猫跳蛛" + "\n";

        String choices = s + s1 + s2 + s3 + s4;
        System.out.println(choices);
    }
}

