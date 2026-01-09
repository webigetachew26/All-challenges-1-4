import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Chapter1_Challenge_1_4 {

    // Custom exception for invalid config version
    static class InvalidConfigVersionException extends Exception {
        public InvalidConfigVersionException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("config.txt"));

            // Read config version
            String versionLine = reader.readLine();
            if (versionLine == null) {
                throw new IOException("Config file is empty or missing version line.");
            }
            int configVersion = Integer.parseInt(versionLine);

            if (configVersion < 2) {
                throw new InvalidConfigVersionException("Config version too old!");
            }

            // Read file path
            String filePath = reader.readLine();
            if (filePath == null) {
                throw new IOException("Config file is missing file path line.");
            }
            File file = new File(filePath);
            if (!file.exists()) {
                throw new IOException("File specified in config.txt does not exist: " + filePath);
            }

            System.out.println("Config read successfully. Version: " + configVersion + ", Path: " + filePath);

        } catch (FileNotFoundException e) {
            System.err.println("Error: config.txt not found. Please ensure the file exists in the project directory.");
        } catch (NumberFormatException e) {
            System.err.println("Error: The first line of config.txt must be a valid number for the config version.");
        } catch (InvalidConfigVersionException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: A general I/O error occurred while reading config.txt: " + e.getMessage());
        } finally {
            System.out.println("Config read attempt finished.");
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file reader: " + e.getMessage());
                }
            }
        }
    }
}
