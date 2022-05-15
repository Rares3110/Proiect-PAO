package services;

import databaseUtils.Date;
import entities.Programare;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class ProgramareStream {
    private static ProgramareStream instance = new ProgramareStream();

    private ProgramareStream() {}
    public static ProgramareStream getInstance() {
        return instance;
    }

    public TreeSet<Programare> readProgramari() throws IOException {
        TreeSet<Programare> result = new TreeSet<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateProgramari.csv"));
        csvReader.readLine();

        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Programare(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    Date.parse(data[4]),
                    data[5],
                    data[6]
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeProgramari(TreeSet<Programare> programari) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateProgramari.csv");
        csvWriter.append("Id,id_pacient,id_angajat,id_sala,zi,ora_start,ora_incheiat\n");

        for(Programare prog : programari) {
            csvWriter.append(prog.getIdProgramare() + ",");
            csvWriter.append(prog.getIdPacient() + ",");
            csvWriter.append(prog.getIdAngajat() + ",");
            csvWriter.append(prog.getIdSala() + ",");
            csvWriter.append(prog.getZi() + ",");
            csvWriter.append(prog.getOraStart() + ",");
            csvWriter.append(prog.getOraIncheiat() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
