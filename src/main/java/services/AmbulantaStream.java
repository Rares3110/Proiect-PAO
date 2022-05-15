package services;

import entities.Ambulanta;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AmbulantaStream {
    private static AmbulantaStream instance = new AmbulantaStream();

    private AmbulantaStream() {}
    public static AmbulantaStream getInstance() {
        return instance;
    }

    public ArrayList<Ambulanta> readAmbulante() throws IOException {
        ArrayList<Ambulanta> result = new ArrayList<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateAmbulante.csv"));
        csvReader.readLine();

        String row;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Ambulanta(
                    Integer.parseInt(data[0]),
                    Integer.parseInt(data[1]),
                    data[2],
                    Double.parseDouble(data[3])
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeAmbulante(ArrayList<Ambulanta> ambulante) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateAmbulante.csv");
        csvWriter.append("Id,an_achizitionare,stare_ambulanta,cost_achizitionare\n");

        for (Ambulanta ambulanta : ambulante) {
            csvWriter.append(ambulanta.getIdAmbulanta() + ",");
            csvWriter.append(ambulanta.getAnAchizitionare() + ",");
            csvWriter.append(ambulanta.getStareAmbulanta() + ",");
            csvWriter.append(ambulanta.getCostAchizitionare() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}