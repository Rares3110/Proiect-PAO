package servicesDB;

import entities.Institutie;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InstitutieDB {
    private Statement stmt;

    public InstitutieDB(@NotNull Connection connection) {
        try{
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("""
                            SELECT COUNT(*)
                            FROM information_schema.tables
                            WHERE table_name = "Institutie";
                          """);

            rs.next();
            if(rs.getInt(1) == 0) {
                stmt.executeUpdate("""
                        CREATE TABLE Institutie(
                            idInstitutie INT,
                            idAutoritate INT,
                            nume VARCHAR(40),
                            adresa VARCHAR(100),
                            tipInstitutie VARCHAR(100),
                            primary key(idInstitutie)
                        );
                        """);
                System.out.println("Tabel Institutie creat");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }
    }

    public ArrayList<Institutie> select() {
        ArrayList<Institutie> institutii = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery("""
                            SELECT *
                            FROM Institutie;
                          """);

            while(rs.next()){
                institutii.add(new Institutie(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }

        return institutii;
    }

    public String insert(@NotNull Institutie institutie){
        try{
            stmt.executeUpdate(String.format("""
                            INSERT INTO Institutie
                            VALUES(%d,%d,"%s","%s","%s");
                            """,
                    institutie.getIdInstitutie(),
                    institutie.getIdAutoritate(),
                    institutie.getNume(),
                    institutie.getAdresa(),
                    institutie.getTipInstitutie()));
        }
        catch(SQLException e)
        {
            return "Nu a fost inserat";
        }

        return "A fost inserat";
    }

    public String update(@NotNull Institutie institutie){
        try{
            stmt.executeUpdate(String.format("""
                            UPDATE Institutie
                            SET idAutoritate = %d, nume = "%s", adresa = "%s", tipInstitutie = "%s"
                            WHERE idInstitutie = %d;
                            """,
                    institutie.getIdAutoritate(),
                    institutie.getNume(),
                    institutie.getAdresa(),
                    institutie.getTipInstitutie(),
                    institutie.getIdInstitutie()));
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
                            DELETE FROM Institutie
                            WHERE idInstitutie = %d;
                            """, id));
        }
        catch(SQLException e)
        {
            return "Nu a fost sters";
        }

        return "A fost sters";
    }
}
