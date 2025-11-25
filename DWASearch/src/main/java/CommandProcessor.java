package main.java;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class CommandProcessor {
    private static Map<String, Runnable> COMMANDS = new HashMap<>();
    private static List<Athlete> athletes;
    private static CompetitionResultRoot competitionResultRoot;

    static {
        List<File> resourceFiles = DWAFile.loadFiles();
        for (File file : resourceFiles){
            String fileName = file.getName();
            String commandName = fileName.substring(0, fileName.indexOf(".json"));

            if (commandName.equals("athletes")){
                athletes = JsonParser.<Athlete>parserArray(file, Athlete.class);
                COMMANDS.put("players", () ->
                CoreModule.displayAllPlayersInfo(DWAFile.getOutputFile().getPath(), athletes)
            );}
            else{
                competitionResultRoot = JsonParser.<CompetitionResultRoot>parser(file, CompetitionResultRoot.class);
                COMMANDS.put("result " + commandName.toLowerCase(), () ->
                CoreModule.displayResultsForEachEvent(DWAFile.getOutputFile().getPath(), competitionResultRoot));}
        }
    }
    public static void runCommand(String command){
        if (COMMANDS.containsKey(command)){
            COMMANDS.get(command).run();
        }else{
            System.out.println("Invalid command");
        }
    }
}
