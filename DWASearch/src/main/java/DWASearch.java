package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DWASearch {

    private static BufferedReader br;

    public static void main(String[] args) {
        //用listFiles()初始化文件对象(finished)
        //用Map装命令(finished?)
        //把detail功能完善好(finished?)
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
