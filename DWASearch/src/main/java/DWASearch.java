package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DWASearch {
    private static List<Athlete> athletes;
    private static CompetitionResultRoot competitionResultRoot;
    private static BufferedReader br;

    public static void main(String[] args) {

        File inputFile = new File("src\\main\\resources\\input.txt");
        File outputFile = new File("src\\main\\resources\\output.txt");
        File athleteResourceFile = new File("src\\main\\resources\\athletes.json");
        File women1mSpringBoardResourceFile = new File("src\\main\\resources\\Women 1m SpringBoard.json");
        File women10mPlatformResourceFile = new File("src\\main\\resources\\Women 10m Platform.json");

        athletes = JsonParser.<Athlete>parserArray(athleteResourceFile, Athlete.class);
        competitionResultRoot = JsonParser.<CompetitionResultRoot>parser(women1mSpringBoardResourceFile, CompetitionResultRoot.class);

        try{
            br = new BufferedReader(new FileReader(inputFile));
            String command;
             while ((command = readInputFile(inputFile.getPath())) != null){
                 processCommand(outputFile.getPath(), command);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }


    static void processCommand(String outputFile, String command) {
        if (command.equals("players")) {
            CoreModule.displayAllPlayersInfo(outputFile, athletes);
        }
        else if (command.equals("result women 1m springboard")) {
            CoreModule.displayResultsForEachEvent(outputFile, competitionResultRoot);
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
     static List<Athlete> getListOfAthletes() {
        return athletes;
     }
}
