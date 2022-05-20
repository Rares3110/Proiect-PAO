import databaseUtils.Date;
import entities.*;
import services.*;
import servicesDB.AutoritateDB;
import servicesDB.InstitutieDB;
import servicesDB.PacientDB;
import servicesDB.SalaDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    static public void main(String[] args) throws IOException {
        Database db = new Database(true);
        db.Save();

        String url = "jdbc:mysql://localhost:3306/proiect_pao";
        String username = "Rares";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            SalaDB salaDB = new SalaDB(connection);
            InstitutieDB institutieDB = new InstitutieDB(connection);
            AutoritateDB autoritateDB = new AutoritateDB(connection);
            PacientDB pacientDB = new PacientDB(connection);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
