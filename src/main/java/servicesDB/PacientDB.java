package servicesDB;

import databaseUtils.Date;
import entities.Pacient;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

public class PacientDB {
    private Statement stmt;

    public PacientDB(@NotNull Connection connection){
        try{
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("""
                            SELECT COUNT(*)
                            FROM information_schema.tables
                            WHERE table_name = "Pacient";
                          """);

            rs.next();
            if(rs.getInt(1) == 0) {
                stmt.executeUpdate("""
                        CREATE TABLE Pacient(
                            idPacient INT,
                            nume VARCHAR(20),
                            prenume VARCHAR(20),
                            ziNastere DATE,
                            primary key(idPacient)
                        );
                        """);
                System.out.println("Tabel Pacient creat");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }
    }

    public TreeSet<Pacient> select(){
        TreeSet<Pacient> pacienti = new TreeSet<>();

        try {
            ResultSet rs = stmt.executeQuery("""
                      SELECT *
                      FROM Pacient;
                    """);

            while (rs.next()) {
                String[] numere = rs.getString(4).split("-");
                pacienti.add(new Pacient(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        new Date(Integer.parseInt(numere[2]),
                                Integer.parseInt(numere[1]),
                                Integer.parseInt(numere[0]))
                ));
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            e.fillInStackTrace();
        }

        return pacienti;
    }

    public String insert(@NotNull Pacient pacient){
        try{
            stmt.executeUpdate(String.format("""
                            INSERT INTO Pacient
                            VALUES(%d,"%s","%s","%d-%d-%d");
                            """,
                    pacient.getIdPacient(),
                    pacient.getNume(),
                    pacient.getPrenume(),
                    pacient.getZiNastere().getYear(),
                    pacient.getZiNastere().getMonth(),
                    pacient.getZiNastere().getDay()));
        }
        catch(SQLException e)
        {
            return "Nu a fost inserat";
        }

        return "A fost inserat";
    }

    public String update(@NotNull Pacient pacient){
        try{
            stmt.executeUpdate(String.format("""
                            UPDATE Pacient
                            SET nume = "%s", prenume = "%s", ziNastere = "%d-%d-%d"
                            WHERE idPacient = %d;
                            """,
                    pacient.getNume(),
                    pacient.getPrenume(),
                    pacient.getZiNastere().getYear(),
                    pacient.getZiNastere().getMonth(),
                    pacient.getZiNastere().getDay(),
                    pacient.getIdPacient()));
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
                            DELETE FROM Pacient
                            WHERE idPacient = %d;
                            """, id));
        }
        catch(SQLException e)
        {
            return "Nu a fost sters";
        }

        return "A fost sters";
    }
}
