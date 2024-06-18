package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Form Login");

        // Membuat GridPane untuk mengatur tata letak
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Membuat elemen-elemen GUI
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        Label userName = new Label("User Name:");
        TextField userTextField = new TextField();
        Label pw = new Label("Password:");
        PasswordField pwBox = new PasswordField();
        Button btn = new Button("Sign in");
        Text actiontarget = new Text();

        // Menambahkan elemen ke GridPane
        grid.add(scenetitle, 0, 0, 2, 1);
        grid.add(userName, 0, 1);
        grid.add(userTextField, 1, 1);
        grid.add(pw, 0, 2);
        grid.add(pwBox, 1, 2);

        // Membuat HBox untuk tombol
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        grid.add(actiontarget, 1, 6);

        // Menangani aksi klik tombol
        btn.setOnAction(_ -> {
            String username = userTextField.getText();
            String password = pwBox.getText();

            // Validasi sederhana (ganti dengan logika validasi Anda)
            if (username.equals("admin") && password.equals("password")) {
                // Login berhasil, pindah ke halaman baru
                actiontarget.setFill(Color.GREEN);
                actiontarget.setText("Login berhasil!");
                // ... (Kode untuk pindah ke halaman baru)
            } else {
                // Login gagal, tampilkan pesan error
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Username atau password salah!");
            }
        });

        // Membuat scene dan menampilkan stage
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
