package services;

import databaseUtils.Date;
import entities.Pacient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class PacientStream {
    private static PacientStream instance = new PacientStream();

    private PacientStream() {}
    public static PacientStream getInstance() {
        return instance;
    }

    public TreeSet<Pacient> readPacienti() throws IOException {
        TreeSet<Pacient> result = new TreeSet<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DatePacienti.csv"));
        csvReader.readLine();

        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Pacient(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    Date.parse(data[3])
            ));
        }

        csvReader.close();
        return result;
    }

    public void writePacienti(TreeSet<Pacient> pacienti) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DatePacienti.csv");
        csvWriter.append("Id,nume,prenume,zi_nastere\n");

        for(Pacient pac : pacienti) {
            csvWriter.append(pac.getIdPacient() + ",");
            csvWriter.append(pac.getNume() + ",");
            csvWriter.append(pac.getPrenume() + ",");
            csvWriter.append(pac.getZiNastere() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}