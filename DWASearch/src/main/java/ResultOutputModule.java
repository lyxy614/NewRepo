package main.java;

import java.util.List;

public interface ResultOutputModule {
    void displayAllPlayersInfo(String outputFile, List<Athlete> athletes);

    void displayResultsForEachEvent(String outputFile, CompetitionResultRoot competitionResultRoot);

    void displayDetailResultsForEachEvent(String outputFile, CompetitionResultRoot competitionResultRoot);
}
