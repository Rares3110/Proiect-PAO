package servicesDB;

import entities.Autoritate;
import entities.Institutie;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

public class AutoritateDB {
    private Statement stmt;

    public AutoritateDB(@NotNull Connection connection){
        try{
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("""
                            SELECT COUNT(*)
                            FROM information_schema.tables
                            WHERE table_name = "Autoritate";
                          """);

            rs.next();
            if(rs.getInt(1) == 0) {
                stmt.executeUpdate("""
                        CREATE TABLE Autoritate(
                            idAutoritate INT,
                            nume VARCHAR(60),
                            judet VARCHAR(20),
                            primary key(idAutoritate)
                        );
                        """);
                System.out.println("Tabel Autoritate creat");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }
    }

    public TreeSet<Autoritate> select() {
        TreeSet<Autoritate> autoritati = new TreeSet<>();

        try {
            ResultSet rs = stmt.executeQuery("""
                      SELECT *
                      FROM Autoritate;
                    """);

            while (rs.next()) {
                autoritati.add(new Autoritate(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                ));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }

        return autoritati;
    }

    public String insert(@NotNull Autoritate autoritate){
        try{
            stmt.executeUpdate(String.format("""
                            INSERT INTO Autoritate
                            VALUES(%d,"%s","%s");
                            """,
                    autoritate.getIdAutoritate(),
                    autoritate.getNume(),
                    autoritate.getJudet()));
        }
        catch(SQLException e)
        {
            return "Nu a fost inserat";
        }

        return "A fost inserat";
    }

    public String update(@NotNull Autoritate autoritate){
        try{
            stmt.executeUpdate(String.format("""
                            UPDATE Autoritate
                            SET nume = "%s", judet = "%s"
                            WHERE idAutoritate = %d;
                            """,
                    autoritate.getNume(),
                    autoritate.getJudet(),
                    autoritate.getIdAutoritate()));
        }
        catch(SQLException e)
        {
            return "Nu a fost actualizat";
        }

        return "A fost actualizat";
    }

    public String delete(int id){
        try{
            stmt.executeUpdate(String.format("""
                            DELETE FROM Autoritate
                            WHERE idAutoritate = %d;
                            """, id));
        }
        catch(SQLException e)
        {
            return "Nu a fost sters";
        }

        return "A fost sters";
    }
}
