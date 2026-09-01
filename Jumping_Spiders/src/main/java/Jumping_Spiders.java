import Exceptions.GenerateRandomException;
import Models.*;

import java.util.*;

public class Jumping_Spiders {
    public static void main(String[] args) {
        List<Spider> spiderList = new ArrayList<>();
        Spider[] spiders = new Spider[3];
        //装填所有蜘蛛
        spiderList.add(new BlackJumpingSpider());
        spiderList.add(new ClamSandSpider());
        spiderList.add(new SawShowySpider());
        spiderList.add(new WhiteSpottedCatJumpingSpider());
//        spiderList.add();
//        spiderList.add();
//        spiderList.add();
        //开始界面
        displayStartColumns();
        Scanner sc = new Scanner(System.in);
        int flag1;
        try{
            flag1 = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("未输入数字，游戏退出");
            flag1 = 3;
        }
        int flag2;
        while(flag1 != 3){
            //单人模式
            if(flag1 == 1){
                displaySpiderColumns(spiderList);
                try{
                    flag2 = sc.nextInt();
                }catch(InputMismatchException e){
                    sc.next();
                    flag2 = 0;
                }
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
                try{
                    flag1 = sc.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("未输入数字，游戏退出");
                    flag1 = 3;
                }
            }
            //双人模式
            else if(flag1 == 2){
                for(int i = 1; i < 3; i++){
                    System.out.println("玩家" + i + "：");
                    displaySpiderColumns(spiderList);
                    try{
                        flag2 = sc.nextInt();
                    }catch(InputMismatchException e){
                        sc.next();
                        flag2 = 0;
                    }
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
                try{
                    flag1 = sc.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("未输入数字，游戏退出");
                    flag1 = 3;
                }
            }
            else{
                System.out.println("数字不在范围内，请重新选择");
                displayStartColumns();
                try{
                    flag1 = sc.nextInt();
                }catch(InputMismatchException e){
                    System.out.println("未输入数字，游戏退出");
                    flag1 = 3;
                }
            }
        }
        //退出游戏
        System.out.println("游戏已退出");
    }
    public static void displayStartColumns(){
        String s = """
                ————————跳蛛大战————————
                       1.单人模式
                       2.双人模式
                       3.退出游戏
                输入对应数字并按下回车以选择
                """;
        System.out.println(s);
    }
    public static void displaySpiderColumns(List<Spider> spiderList){
        String s = "————————选择跳蛛———————";
        System.out.println(s);
        int i = 1;
        for(Iterator<Spider> spiderIterator = spiderList.iterator(); spiderIterator.hasNext();){
            System.out.println(i++ + "." + spiderIterator.next());
        }
    }
}

