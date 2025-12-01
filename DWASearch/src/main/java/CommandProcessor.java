package main.java;

import java.io.File;
import java.util.*;

public class CommandProcessor {
    private static Map<String, Runnable> COMMANDS = new HashMap<>();
    private static Set<String> competitionNames = new HashSet<>();
    private static List<Athlete> athletes;
    private static OutputModule coreModule = new CoreModule();

    static {
        List<File> resourceFiles = DWAFile.loadFiles();
        for (File file : resourceFiles){
            String fileName = file.getName();
            String commandName = fileName.substring(0, fileName.indexOf(".json"));

            if (commandName.equals("athletes")){
                athletes = JsonParser.<Athlete>parserArray(file, Athlete.class);
                COMMANDS.put("players", () ->
                coreModule.displayAllPlayersInfo(DWAFile.getOutputFile().getPath(), athletes)
            );}
            else{
                competitionNames.add(commandName);
                CompetitionResultRoot competitionResultRoot;
                competitionResultRoot = JsonParser.<CompetitionResultRoot>parser(file, CompetitionResultRoot.class);
                COMMANDS.put("result " + commandName.toLowerCase(), () ->
                    coreModule.displayResultsForEachEvent(DWAFile.getOutputFile().getPath(), competitionResultRoot));
                COMMANDS.put("result " + commandName.toLowerCase() + " detail", () ->
                    coreModule.displayDetailResultsForEachEvent(DWAFile.getOutputFile().getPath(), competitionResultRoot));
            }
        }
    }
    public static void runCommand(String command){
        command = command.replaceAll("\\s+", " ");
        String [] args = command.split("\\s+");
        String wrongMessage;
        if (COMMANDS.containsKey(command)){
            COMMANDS.get(command).run();
        }else if (command.startsWith("players")){
            if (!command.equals("players")){
                wrongMessage = "Error";
                coreModule.displayWrongMessage(DWAFile.getOutputFile().getPath(), wrongMessage);
            }
        }
        else if (command.startsWith("result ")){
            if (!competitionNames.contains(args[1])){
                wrongMessage = "N/A";
                coreModule.displayWrongMessage(DWAFile.getOutputFile().getPath(), wrongMessage);
            }
            else if (!args[2].equals("detail")){
                wrongMessage = "N/A";
                coreModule.displayWrongMessage(DWAFile.getOutputFile().getPath(), wrongMessage);
            }

        }
        else {
            wrongMessage = "Error";
            coreModule.displayWrongMessage(DWAFile.getOutputFile().getPath(), wrongMessage);
        }
    }
//    public static void  main(String[] args){
//        for (String command : COMMANDS.keySet()){
//            System.out.println(command);
//            if (!COMMANDS.containsKey(command)) {
//                System.out.println("Invalid command");
//            }
//        }
//    }
}
