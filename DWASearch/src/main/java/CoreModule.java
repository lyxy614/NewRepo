package main.java;

import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CoreModule {
    private static boolean isWritten = false;
    public static void displayAllPlayersInfo(String outputFile, List<Athlete> athletes) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile, isWritten))){
            for (Athlete athlete : athletes) {
                if (athlete.getParticipations() != null){
                    for (Participations participation : athlete.getParticipations()) {
                        bufferedWriter.write(participation + "\n" + athlete + "\n" + "-----" + "\n");

                    }
                }
            }
            isWritten = true;
        }catch (IOException e){
            System.out.println("写入失败" + e.getMessage());
        }
    }

    public static void displayResultsForEachEvent(String outputFile, CompetitionResultRoot competitionResultRoot) {
        List<Results> results = competitionResultRoot.getHeats().getFirst().getResults();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile, isWritten))){
            for (Results result : results) {
                bufferedWriter.write(result.toString());
            }
            isWritten = true;
        }catch (IOException e){
            System.out.println("写入失败" + e.getMessage());
        }
    }
}
