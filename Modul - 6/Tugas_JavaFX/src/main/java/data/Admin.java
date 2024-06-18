package data;

import Util.iMenu;
import com.main.LibrarySystem;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

import static data.Student.arr_userStudent;


public class Admin extends User implements iMenu {

    //=================================== ATRIBUT =====================================
    public static String adminusername = "admin";
    public static String adminpassword = "admin";

//=================================== Main & Start Method ==================================


    //======================================= MENU Method =======================================
    @Override
    public void menu() {
        Stage adminMenuStage = new Stage();
        adminMenuStage.setTitle("UMM Library - Admin Menu");

        //Label
        Label sceneTitle = new Label("Menu Admin");

        //Font Style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));

        //Font Color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        //Button
        Button addStudentButton = new Button("Tambah Mahasiswa");
        Button displayStudentButton = new Button("Daftar Mahasiswa");
        Button addBookButton = new Button("Tambah Buku");
        Button logoutButton = new Button("Logout");

        //Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        // Style
        sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        sceneTitle.setTextFill(Color.web("#A91D3A"));
        grid.add(sceneTitle, 0, 1);
        grid.add(addStudentButton, 2, 0);
        grid.add(displayStudentButton, 2, 1);
        grid.add(addBookButton, 2, 2);
        grid.add(logoutButton, 2, 3);

        grid.setVgap(10);
        grid.setHgap(6);

        Scene scene = new Scene(grid, 1360, 720);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        adminMenuStage.setScene(scene);
        adminMenuStage.show();

        //Action Button
        addStudentButton.setOnAction(event -> {
            addStudent();
            adminMenuStage.close();
        });

        displayStudentButton.setOnAction(event -> {
            displayStudent();
            adminMenuStage.close();
        });

        addBookButton.setOnAction(event -> {
            inputBook();
            adminMenuStage.close();
        });

        logoutButton.setOnAction(event -> {
            LibrarySystem librarySystemObj = new LibrarySystem();
            librarySystemObj.start(new Stage());
            adminMenuStage.close();
        });

    }

    //===================================== Other Method =======================================
    public void addStudent() {

        // Membuat form baru
        Stage addStudentStage = new Stage();
        addStudentStage.setTitle("Tambah Mahasiswa");

        // Label
        Label sceneTitle = new Label("Tambah Mahasiswa");
        Label nameLabel = new Label("Nama");
        Label nimLabel = new Label("NIM");
        Label fakultasLabel = new Label("Fakultas");
        Label jurusanLabel = new Label("Jurusan");

        // Notification Label
        Label submitFailed = new Label("NIM harus 15 digit!");
        submitFailed.setVisible(false);
        submitFailed.getStyleClass().add("error-message"); // Tambahkan style class untuk error message

        // Field
        TextField nameField = new TextField();
        TextField nimField = new TextField();
        TextField fakultasField = new TextField();
        TextField jurusanField = new TextField();

        // Style
        sceneTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        sceneTitle.setTextFill(Color.web("#A91D3A")); // Warna merah maroon UMM
        nameLabel.getStyleClass().add("form-label");
        nimLabel.getStyleClass().add("form-label");
        fakultasLabel.getStyleClass().add("form-label");
        jurusanLabel.getStyleClass().add("form-label");
        nameField.getStyleClass().add("form-field");
        nimField.getStyleClass().add("form-field");
        fakultasField.getStyleClass().add("form-field");
        jurusanField.getStyleClass().add("form-field");

        // Button
        Button submitButton = new Button("Submit");
        submitButton.getStyleClass().add("login-button"); // Menggunakan gaya tombol yang sama

        // Tombol Kembali
        Button backButton = new Button("Kembali");
        backButton.getStyleClass().add("login-button");

        // Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // ColumnConstraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHalignment(HPos.RIGHT);
        col1.setHgrow(Priority.NEVER);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHalignment(HPos.LEFT);
        col2.setHgrow(Priority.ALWAYS);

        grid.getColumnConstraints().addAll(col1, col2);

        grid.add(sceneTitle, 0, 0, 2, 1); // Span 2 kolom
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        grid.add(nimLabel, 0, 2);
        grid.add(nimField, 1, 2);
        grid.add(fakultasLabel, 0, 3);
        grid.add(fakultasField, 1, 3);
        grid.add(jurusanLabel, 0, 4);
        grid.add(jurusanField, 1, 4);
        grid.add(submitButton, 1, 5); // Tombol submit di kolom kedua
        grid.add(backButton, 0, 5); // Tombol kembali di kolom pertama
        grid.add(submitFailed, 0, 6, 2, 1); // Pesan error di bawah, span 2 kolom

        Scene scene = new Scene(grid, 400, 350); // Sesuaikan ukuran form
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        addStudentStage.setScene(scene);
        addStudentStage.show();

        // Action Button
        submitButton.setOnAction(event -> {
            if (nimField.getText().length() == 15) {
                arr_userStudent.add(new Student.UserStudent(nameField.getText(), nimField.getText(), fakultasField.getText(), jurusanField.getText()));
                menu(); // Kembali ke menu admin setelah menambah mahasiswa
                addStudentStage.close();
            } else {
                submitFailed.setVisible(true);
            }
        });

        // Action Button Kembali
        backButton.setOnAction(event -> {
            menu(); // Kembali ke menu admin
            addStudentStage.close();
        });
    }


    public void displayStudent() {
        // Membuat stage baru
        Stage displayStudentStage = new Stage();
        displayStudentStage.setTitle("UMM Library - Daftar Mahasiswa");

        // Label
        Label sceneTitle = new Label("Daftar Mahasiswa");
        sceneTitle.getStyleClass().add("scene-title");

        // Membuat ListView untuk menampilkan mahasiswa
        ListView<String> listView = new ListView<>();
        listView.getStyleClass().add("list-view");

        // Menampilkan daftar mahasiswa (dengan pemisah)
        for (Student.UserStudent student : arr_userStudent) {
            String studentInfo = String.format(
                    "Nama: %s\nNIM: %s\nFakultas: %s\nProdi: %s\n---------------------------",
                    student.nama, student.nim, student.fakultas, student.prodi
            );
            listView.getItems().add(studentInfo);
        }

        // Tombol Kembali
        Button backButton = new Button("Kembali");
        backButton.getStyleClass().add("login-button");

        // Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        grid.add(sceneTitle, 0, 0, 2, 1); // Span 2 kolom
        grid.add(listView, 0, 1, 2, 1);   // Span 2 kolom dan beberapa baris
        grid.add(backButton, 0, 2, 2, 1); // Span 2 kolom, di bawah ListView

        Scene scene = new Scene(grid, 600, 400);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        displayStudentStage.setScene(scene);
        displayStudentStage.show();

        // Action Button Kembali
        backButton.setOnAction(event -> {
            menu(); // Kembali ke menu admin
            displayStudentStage.close();
        });
    }


    public void inputBook() {
        super.inputBook();
    }

    public String generateId() {
        Random random = new Random();

        StringBuilder idTengah = new StringBuilder();
        StringBuilder idAkhir = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            idTengah.append(random.nextInt(10));
            idAkhir.append(random.nextInt(10));

        }
        return ("UMM-" + idTengah + "-" + idAkhir);

    }


}