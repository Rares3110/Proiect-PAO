package services;

import databaseUtils.Date;
import entities.Angajat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AngajatStream {
    private static AngajatStream instance = new AngajatStream();

    private AngajatStream() {}
    public static AngajatStream getInstance() {
        return instance;
    }

    public ArrayList<Angajat> readAngajati() throws IOException {
        ArrayList<Angajat> result = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateAngajati.csv"));
        csvReader.readLine();

        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Angajat(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    data[2],
                    data[3],
                    Double.parseDouble(data[4]),
                    Date.parse(data[5]),
                    data[6]
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeAngajati(ArrayList<Angajat> angajati) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateAngajati.csv");
        csvWriter.append("Id,id_institutie,nume,prenume,salariu,data_angajare,denumire_job\n");

        for(Angajat angajat : angajati) {
            csvWriter.append(angajat.getIdAngajat() + ",");
            csvWriter.append(angajat.getIdInstitutie() + ",");
            csvWriter.append(angajat.getNume() + ",");
            csvWriter.append(angajat.getPrenume() + ",");
            csvWriter.append(angajat.getSalariu() + ",");
            csvWriter.append(angajat.getDataAngajare() + ",");
            csvWriter.append(angajat.getDenumireJob() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
