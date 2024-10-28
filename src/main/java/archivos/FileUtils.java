package archivos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

  public static List<String> readFile(String filePath) throws IOException {
    return Files.readAllLines(Paths.get(filePath));
  }

  public static void writeFile(String filePath, List<String> content) throws IOException {
    Files.write(Paths.get(filePath), content);
  }

  public static void appendToFile(String filePath, String text) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
      writer.write(text);
      writer.newLine();
    }
  }

  public static boolean fileExists(String filePath) {
    return Files.exists(Paths.get(filePath));
  }
}
