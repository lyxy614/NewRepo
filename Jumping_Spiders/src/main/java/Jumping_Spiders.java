import Models.BlackJumpingSpider;
import Models.ClamSandSpider;
import Models.Spider;

import java.util.Scanner;
import java.util.Random;
public class Jumping_Spiders {
    public static void main(String[] args) {
        Spider spider1, spider2;
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
                        spider1 = new BlackJumpingSpider();
                        System.out.println("你选择了" + spider1.getName());
                        break;
                    case 2:
                        spider1 = new ClamSandSpider();
                        System.out.println("你选择了" + spider1.getName());
                        break;
                    default:
                        System.out.println("你选择的序号不在范围内，请重新选择");
                        flag1 = 1;
                        continue;
                }
                Random random = new Random();
                flag2 = random.nextInt(2) + 1;
                switch (flag2) {
                    case 1:
                        spider2 = new BlackJumpingSpider();
                        System.out.println("电脑选择了" + spider2.getName());
                        break;
                    case 2:
                        spider2 = new ClamSandSpider();
                        System.out.println("电脑选择了" + spider2.getName());
                        break;
                    default:
                        System.err.println("随机数生成出错");
                        return;
                }
                spider2.setEnemy();
                //游戏主程序
                RunSpiders runSpiders = new RunSpiders(spider1, spider2);
                runSpiders.runSpiders();
                displayStartColumns();
                flag1 = sc.nextInt();
            }
            //双人模式
            else if(flag1 == 2){
                System.out.println("玩家1：");
                displaySpiderColumns();
                flag2 = sc.nextInt();
                //玩家1选择创建对象逻辑
                switch (flag2) {
                    case 1:
                        spider1 = new BlackJumpingSpider();
                        System.out.println("玩家1选择了" + spider1.getName());
                        break;
                    case 2:
                        spider1 = new ClamSandSpider();
                        System.out.println("玩家1选择了" + spider1.getName());
                        break;
                    default:
                        System.out.println("玩家1选择的序号不在范围内，请重新选择");
                        flag1 = 1;
                        continue;
                }
                spider1.setPlayerNumber(1);
                System.out.println("玩家2：");
                displaySpiderColumns();
                flag2 = sc.nextInt();
                //玩家2选择创建对象逻辑
                switch (flag2) {
                    case 1:
                        spider2 = new BlackJumpingSpider();
                        System.out.println("玩家2选择了" + spider2.getName());
                        break;
                    case 2:
                        spider2 = new ClamSandSpider();
                        System.out.println("玩家2选择了" + spider2.getName());
                        break;
                    default:
                        System.out.println("玩家2选择的序号不在范围内，请两名玩家重新选择");
                        flag1 = 1;
                        continue;
                }
                spider2.setPlayerNumber(2);
                //游戏主程序
                RunSpiders runSpiders = new RunSpiders(spider1, spider2);
                runSpiders.runSpiders();
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

        String choices = s + s1 + s2;
        System.out.println(choices);
    }
}

