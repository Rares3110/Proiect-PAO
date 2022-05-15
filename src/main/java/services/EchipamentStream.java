package services;

import entities.Echipament;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EchipamentStream {
    private static EchipamentStream instance = new EchipamentStream();

    private EchipamentStream() {}
    public static EchipamentStream getInstance() {
        return instance;
    }

    public ArrayList<Echipament> readEchipamente() throws IOException {
        ArrayList<Echipament> result = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateEchipamente.csv"));
        csvReader.readLine();

        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Echipament(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    data[3],
                    data[4],
                    Double.parseDouble(data[5])
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeEchipamente(ArrayList<Echipament> echipamente) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateEchipamente.csv");
        csvWriter.append("Id,id_sala,id_ambulanta,tip_echipament,stare_echipament,cost_achizitionare\n");

        for (Echipament echip : echipamente) {
            csvWriter.append(echip.getIdEchipament() + ",");
            csvWriter.append(echip.getIdSala() + ",");
            csvWriter.append(echip.getIdAmbulanta() + ",");
            csvWriter.append(echip.getTipEchipament() + ",");
            csvWriter.append(echip.getStareEchipament() + ",");
            csvWriter.append(echip.getCostAchizitionare() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}