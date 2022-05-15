package services;

import databaseUtils.Date;
import entities.Ambulantier;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AmbulantierStream {
    private static AmbulantierStream instance = new AmbulantierStream();

    private AmbulantierStream() {}
    public static AmbulantierStream getInstance() {
        return instance;
    }

    public ArrayList<Ambulantier> readAmbulantieri() throws IOException {
        ArrayList<Ambulantier> result = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateAmbulantieri.csv"));
        csvReader.readLine();

        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Ambulantier(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    data[2],
                    data[3],
                    Double.parseDouble(data[4]),
                    Date.parse(data[5]),
                    data[6],
                    Integer.parseInt(data[7])
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeAmbulantieri(ArrayList<Ambulantier> ambulantieri) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateAmbulantieri.csv");
        csvWriter.append("Id,id_institutie,nume,prenume,salariu,data_angajare,denumire_job,id_ambulanta\n");

        for(Ambulantier amb : ambulantieri) {
            csvWriter.append(amb.getIdAngajat() + ",");
            csvWriter.append(amb.getIdInstitutie() + ",");
            csvWriter.append(amb.getNume() + ",");
            csvWriter.append(amb.getPrenume() + ",");
            csvWriter.append(amb.getSalariu() + ",");
            csvWriter.append(amb.getDataAngajare() + ",");
            csvWriter.append(amb.getDenumireJob() + ",");
            csvWriter.append(amb.getIdAmbulanta() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
