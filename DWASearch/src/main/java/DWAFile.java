package main.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class DWAFile {
    private static final String resourcePath = "src\\main\\resources";
    private static final File inputFile = new File("src\\main\\resources\\input.txt");
    private static final File outputFile = new File("src\\main\\resources\\output.txt");
    public static List<File> loadFiles(){
        List<File> resourceFiles = new ArrayList<>();
        File folder = new File(resourcePath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println(resourcePath + " is not exist or is not a directory");
            return null;
        }
        File[] allFiles = folder.listFiles();
        for (File file : allFiles) {
            if (file.isFile() && file.getName().endsWith(".json")) {
                resourceFiles.add(file);
            }
        }
        return resourceFiles;
    }

    public static File getInputFile() {
        return inputFile;
    }
    public  static File getOutputFile() {
        return outputFile;
    }

}
