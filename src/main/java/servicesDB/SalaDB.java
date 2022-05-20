package servicesDB;

import entities.Sala;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SalaDB {
    private Statement stmt;

    public SalaDB(@NotNull Connection connection){

        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("""
                            SELECT COUNT(*)
                            FROM information_schema.tables
                            WHERE table_name = "Sala";
                          """);

            rs.next();
            if(rs.getInt(1) == 0) {
                stmt.executeUpdate("""
                        CREATE TABLE Sala(
                            idSala INT,
                            idInstitutie INT,
                            tipSala VARCHAR(40),
                            spatiuSala DOUBLE,
                            etaj INT,
                            primary key(idSala)
                        );
                        """);
                System.out.println("Tabel Sala creat");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }
    }

    public ArrayList<Sala> select() {
        ArrayList<Sala> sali = new ArrayList<>();

        try{
            ResultSet rs = stmt.executeQuery("""
                            SELECT *
                            FROM Sala;
                          """);

            while(rs.next()){
                sali.add(new Sala(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5)
                ));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }

        return sali;
    }

    public String insert(@NotNull Sala sala) {
        try{
            stmt.executeUpdate(String.format("""
                            INSERT INTO Sala
                            VALUES(%d,%d,"%s",%f,%d);
                            """,
                    sala.getIdSala(),
                    sala.getIdInstitutie(),
                    sala.getTipSala(),
                    sala.getSpatiuSala(),
                    sala.getEtaj()));
        }
        catch(SQLException e)
        {
            return "Nu a fost inserat";
        }

        return "A fost inserat";
    }

    public String update(@NotNull Sala sala){
        try{
            stmt.executeUpdate(String.format("""
                            UPDATE Sala
                            SET idInstitutie = %d, tipSala = "%s", spatiuSala = %f, etaj = %d
                            WHERE idSala = %d;
                            """,
                    sala.getIdInstitutie(),
                    sala.getTipSala(),
                    sala.getSpatiuSala(),
                    sala.getEtaj(),
                    sala.getIdSala()));
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
                            DELETE FROM Sala
                            WHERE idSala = %d;
                            """, id));
        }
        catch(SQLException e)
        {
            return "Nu a fost sters";
        }

        return "A fost sters";
    }
}
