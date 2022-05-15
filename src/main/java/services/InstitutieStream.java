package services;

import entities.Institutie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class InstitutieStream {
    private static InstitutieStream instance = new InstitutieStream();

    private InstitutieStream() {}
    public static InstitutieStream getInstance() {
        return instance;
    }

    public ArrayList<Institutie> readInstitutii() throws IOException {
        ArrayList<Institutie> result = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateInstitutii.csv"));
        csvReader.readLine();

        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Institutie(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    data[2],
                    data[3],
                    data[4]
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeInstitutii(ArrayList<Institutie> institutii) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateInstitutii.csv");
        csvWriter.append("Id,id_autoritate,nume,adresa,tip_institutie\n");

        for (Institutie inst : institutii) {
            csvWriter.append(inst.getIdInstitutie() + ",");
            csvWriter.append(inst.getIdAutoritate() + ",");
            csvWriter.append(inst.getNume() + ",");
            csvWriter.append(inst.getAdresa() + ",");
            csvWriter.append(inst.getTipInstitutie() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}