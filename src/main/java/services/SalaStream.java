package services;

import entities.Sala;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SalaStream {
    private static SalaStream instance = new SalaStream();
    private SalaStream() {}

    public static SalaStream getInstance() {
        return instance;
    }

    public ArrayList<Sala> readSali() throws IOException {
        ArrayList<Sala> result = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateSali.csv"));
        csvReader.readLine();

        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Sala(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    data[2],
                    Double.parseDouble(data[3]),
                    Integer.parseInt(data[4])
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeSali(ArrayList<Sala> sali) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateSali.csv");
        csvWriter.append("Id,id_sala,tip_sala,spatiu_sala,etaj\n");

        for(Sala sala : sali) {
            csvWriter.append(sala.getIdSala() + ",");
            csvWriter.append(sala.getIdInstitutie() + ",");
            csvWriter.append(sala.getTipSala() + ",");
            csvWriter.append(sala.getSpatiuSala() + ",");
            csvWriter.append(sala.getEtaj() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
