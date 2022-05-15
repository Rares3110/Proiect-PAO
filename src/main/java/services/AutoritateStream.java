package services;

import entities.Autoritate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

public class AutoritateStream {
    private static AutoritateStream instance = new AutoritateStream();

    private AutoritateStream() {}
    public static AutoritateStream getInstance() {
        return instance;
    }

    public TreeSet<Autoritate> readAutoritati() throws IOException {
        TreeSet<Autoritate> result = new TreeSet<>();
        BufferedReader csvReader = new BufferedReader(new FileReader("src/main/resources/keptData/DateAutoritati.csv"));
        csvReader.readLine();

        String row;
        while((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            result.add(new Autoritate(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2]
            ));
        }

        csvReader.close();
        return result;
    }

    public void writeAutoritati(TreeSet<Autoritate> autoritati) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/keptData/DateAutoritati.csv");
        csvWriter.append("Id,nume,judet\n");

        for(Autoritate aut : autoritati) {
            csvWriter.append(aut.getIdAutoritate() + ",");
            csvWriter.append(aut.getNume() + ",");
            csvWriter.append(aut.getJudet() + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
