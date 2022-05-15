import entities.Spital;
import services.*;

import java.io.IOException;

public class Main {

    static public void main(String[] args) throws IOException {
        Database db = new Database(true);
        db.Save();
    }
}
