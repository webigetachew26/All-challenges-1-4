public class DiaryManager {
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;

    public class DiaryManager extends Application {

        TextArea diaryText;
        Label statusLabel;

        @Override
        public void start(Stage stage) {

            diaryText = new TextArea();
            diaryText.setPromptText("Write your diary here...");

            Button saveBtn = new Button("Save Entry");
            Button loadBtn = new Button("Load Entry");

            statusLabel = new Label("Ready");

            saveBtn.setOnAction(e -> saveDiary());
            loadBtn.setOnAction(e -> loadDiary());

            HBox buttons = new HBox(10, saveBtn, loadBtn);
            VBox root = new VBox(10, diaryText, buttons, statusLabel);

            Scene scene = new Scene(root, 600, 400);
            stage.setTitle("Diary Manager");
            stage.setScene(scene);
            stage.show();
        }

        private void saveDiary() {
            try (FileWriter fw = new FileWriter("diary.txt")) {
                fw.write(diaryText.getText());
                statusLabel.setText("Saved");
            } catch (IOException e) {
                statusLabel.setText("Save error");
            }
        }

        private void loadDiary() {
            Task<String> task = new Task<>() {
                @Override
                protected String call() throws Exception {
                    File f = new File("diary.txt");
                    if (!f.exists()) return "";
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) sb.append(line).append("\n");
                    br.close();
                    return sb.toString();
                }
            };

            task.setOnSucceeded(e -> diaryText.setText(task.getValue()));
            new Thread(task).start();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }}
