package com.main;

import data.Admin;
import data.Student;
import exception.custom.IllegalAdminAccess;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Objects;

public class LibrarySystem extends Application {
    private static LibrarySystem instance;
    public static String NIM;
    private Admin adminObj; // Declare adminObj as an instance variable
    private Student studentObj;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        instance = this;
        adminObj = new Admin();
        studentObj = new Student();

        primaryStage.setTitle("UMM Library");

        // Label
        Label sceneTitle = new Label("UMM Library");
        sceneTitle.getStyleClass().add("scene-title");

        Label usernameLabel = new Label("Username");
        usernameLabel.getStyleClass().add("login-label");

        Label passwordLabel = new Label("Password");
        passwordLabel.getStyleClass().add("login-label");

        // Notification label
        Label errorLoginMessage = new Label("Pengguna tidak ditemukan");
        errorLoginMessage.getStyleClass().add("error-message");
        errorLoginMessage.setVisible(false);

        // Field
        TextField usernameField = new TextField();
        usernameField.getStyleClass().add("login-field");

        PasswordField passwordField = new PasswordField();
        passwordField.getStyleClass().add("login-field");

        // Button
        Button loginButton = new Button("Login");
        loginButton.getStyleClass().add("login-button");

        // Grid Layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(5);

        grid.add(sceneTitle, 0, 0); // Judul di baris 0, kolom 0
        grid.add(usernameLabel, 0, 1); // Label username di baris 1, kolom 0
        grid.add(passwordLabel, 0, 2); // Label password di baris 2, kolom 0
        grid.add(errorLoginMessage, 0, 3); // Label error di baris 3, kolom 0

        grid.add(usernameField, 1, 1); // Field username di baris 1, kolom 1
        grid.add(passwordField, 1, 2); // Field password di baris 2, kolom 1
        grid.add(loginButton, 1, 3);   // Tombol login di baris 3, kolom 1

        // Create Window
        Scene scene = new Scene(grid, 1360, 720);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

        loginButton.setOnAction(_ -> {
            if (usernameField.getText().equals(Admin.adminusername) && passwordField.getText().equals(Admin.adminpassword)) {
                adminObj.menu();
                primaryStage.close();
            } else if (usernameField.getText().length() == 15 && passwordField.getText().length() < 15) {
                try {
                    if (studentObj.isStudents(usernameField)) { // Use the existing studentObj
                        errorLoginMessage.setVisible(false);
                        NIM = usernameField.getText();
                        studentObj.menu();
                    } else {
                        errorLoginMessage.setVisible(true);
                    }
                } catch (IllegalAdminAccess pesanError) {
                    errorLoginMessage.setText(pesanError.getMessage());
                    errorLoginMessage.setVisible(true);
                }
            } else {
                errorLoginMessage.setVisible(true);
            }
        });
    }

    public static LibrarySystem getInstance() {
        return instance;
    }

    public Admin getAdmin() {
        return adminObj;
    }

    public Student getStudent() {
        return studentObj;
    }
}
