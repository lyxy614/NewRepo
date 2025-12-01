package main.java;

import java.io.*;

public class DWASearch {

    private static BufferedReader br;

    public static void main(String[] args) {
        //用listFiles()遍历目录下文件初始化文件对象(finished)
        //用Map装命令(finished)
        //把detail功能完善好(finished)
        //判断输入的命令(finished?)
        //实现命令行参数的读取，以及配套的文件读写相关异常处理
        //编写JUnit单元测试

        try{
            br = new BufferedReader(new FileReader(DWAFile.getInputFile()));
            String command;
             while ((command = readInputFile(DWAFile.getInputFile().getPath())) != null){
                 CommandProcessor.runCommand(command);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }


    static String readInputFile(String inputFile) {
        try{
            return br.readLine();
        }catch(IOException e){
            System.out.println("读取输入文件错误" + e.getMessage());
            return null;
        }
    }

}
