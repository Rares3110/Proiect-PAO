package services;

import entities.Spital;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SpitalStream {
    private static SpitalStream instance = new SpitalStream();

    private SpitalStream() {}
    public static SpitalStream getInstance() {
        return instance;
    }

    public ArrayList<Spital> readSpitale() throws IOException {
        ArrayList<Spital> result = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateSpitale.csv"));
        csvReader.readLine();

        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Spital(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    data[2],
                    data[3],
                    data[4],
                    data[5],
                    Integer.parseInt(data[6])
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeSpitale(ArrayList<Spital> spitale) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateSpitale.csv");
        csvWriter.append("Id,id_autoritate,nume,adresa,tip_institutie,specializare,id_ambulatoriu\n");

        for(Spital spital : spitale) {
            csvWriter.append(spital.getIdInstitutie() + ",");
            csvWriter.append(spital.getIdAutoritate() + ",");
            csvWriter.append(spital.getNume() + ",");
            csvWriter.append(spital.getAdresa() + ",");
            csvWriter.append(spital.getTipInstitutie() + ",");
            csvWriter.append(spital.getSpecializare() + ",");
            csvWriter.append(spital.getIdAmbulatoriu() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
