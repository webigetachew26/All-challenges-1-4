
package wheather;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AeroWheather extends Application {

    @Override
    public void start(Stage stage) {


        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");

        // TOP
        TextField cityField = new TextField();
        cityField.setPromptText("Enter Airport City");

        Label city = new Label("Aero Dynamics Weather");
        city.getStyleClass().add("title");

        VBox top = new VBox(5, city, cityField);
        top.setAlignment(Pos.CENTER);
        root.setTop(top);

        // CENTER
        Label temp = new Label("18°C");
        temp.getStyleClass().add("temp");

        Label condition = new Label("Clear Sky");
        Label wind = new Label("Wind: 12 km/h NE");
        Label visibility = new Label("Visibility: Good");
        Label flight = new Label("Flight Conditions: GOOD");

        // Aircraft Shape
        Polygon plane = new Polygon(0,10, 20,0, 40,10, 20,20);
        plane.getStyleClass().add("plane");

        VBox center = new VBox(8, temp, condition, plane, wind, visibility, flight);
        center.setAlignment(Pos.CENTER);
        root.setCenter(center);

        // BOTTOM
        HBox forecast = new HBox(20,
                new Label("Mon\n17°C"),
                new Label("Tue\n19°C"),
                new Label("Wed\n18°C")
        );
        forecast.setAlignment(Pos.CENTER);

        Button refresh = new Button("Refresh");
        refresh.disableProperty().bind(
                Bindings.isEmpty(cityField.textProperty())
        );

        VBox bottom = new VBox(10, forecast, refresh);
        bottom.setAlignment(Pos.CENTER);
        root.setBottom(bottom);

        // Animation (plane movement)
        TranslateTransition move = new TranslateTransition(Duration.seconds(3), plane);
        move.setByX(60);
        move.setAutoReverse(true);
        move.setCycleCount(TranslateTransition.INDEFINITE);
        move.play();

        Scene scene = new Scene(root, 420, 520);
        scene.getStylesheets().add(getClass().getResource("/aero.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Aero Dynamics");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
