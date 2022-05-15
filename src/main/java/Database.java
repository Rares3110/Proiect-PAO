import databaseUtils.Date;
import entities.*;
import org.jetbrains.annotations.NotNull;
import services.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Database {
    private TreeSet<Autoritate> autoritati;
    private ArrayList<Institutie> institutii;
    private ArrayList<Spital> spitale;
    private ArrayList<Sala> sali;
    private ArrayList<Echipament> echipamente;
    private ArrayList<Ambulanta> ambulante;
    private ArrayList<Angajat> angajati;
    private ArrayList<Ambulantier> ambulantieri;
    private TreeSet<Programare> programari;
    private TreeSet<Pacient> pacienti;

    private AmbulantaStream ambulantaStream;
    private AmbulantierStream ambulantierStream;
    private AngajatStream angajatStream;
    private AutoritateStream autoritateStream;
    private EchipamentStream echipamentStream;
    private InstitutieStream institutieStream;
    private PacientStream pacientStream;
    private ProgramareStream programareStream;
    private SalaStream salaStream;
    private SpitalStream spitalStream;
    private ActivityStream activityStream;

    private void GenerateEntities(){
        autoritati = new TreeSet<Autoritate>();
        institutii = new ArrayList<Institutie>();
        spitale = new ArrayList<Spital>();
        sali = new ArrayList<Sala>();
        echipamente = new ArrayList<Echipament>();
        ambulante = new ArrayList<Ambulanta>();
        angajati = new ArrayList<Angajat>();
        ambulantieri = new ArrayList<Ambulantier>();
        programari = new TreeSet<Programare>();
        pacienti = new TreeSet<Pacient>();

        autoritati.add(new Autoritate(1, "Primaria Sectorului 2", "Bucuresti"));
        autoritati.add(new Autoritate(2, "Consiliu Judetean Prahova", "Prahova"));

        institutii.add(new Institutie(1, 1, "Spitalul Fundeni",
                "Soseaua Fundeni. Nr 258", "spital"));
        spitale.add(new Spital(2, 1, "Spitalul Fundeni",
                "Soseaua Fundeni. Nr 258", "spital", "cardio-vasculare",
                2));
        institutii.add(new Institutie(3, 1, "Policlinica Dorobanti",
                "Calea Dorobantilor. Nr 20", "policlinica"));

        sali.add(new Sala(10, 1, "radiologie", 67, 4));
        sali.add(new Sala(11, 1, "internare", 94, 1));
        sali.add(new Sala(12, 2, "operatie", 91, 1));
        sali.add(new Sala(13, 3, "consult", 66, 3));

        angajati.add(new Angajat(100, 1, "Dabija", "Iustin",
                27000, new Date(13, 1, 1978), "manager"));
        angajati.add(new Angajat(101, 2, "Nitu", "Clara",
                22000, new Date(1, 11, 1992), "doctor"));
        ambulante.add(new Ambulanta(10000, 2005, "in folosinta", 40000));
        ambulantieri.add(new Ambulantier(102, 2, "Ursu", "Sofia",
                9000, new Date(10, 3, 1987), "ambulantier", 10000));
        angajati.add(new Angajat(103, 3, "Petrescu", "Alesio",
                4000, new Date(2, 2, 1982), "asistent"));

        pacienti.add(new Pacient(300, "Fratila", "Sofia", new Date(24, 4, 1962)));
        pacienti.add(new Pacient(301, "Lupu", "Mirabela", new Date(25, 5, 1963)));
        pacienti.add(new Pacient(302, "Ciobanu", "Darius", new Date(22, 9, 2009)));
        pacienti.add(new Pacient(303, "Dima", "Ana", new Date(7, 8, 2001)));
        pacienti.add(new Pacient(304, "Moisescu", "Rodica", new Date(10, 11, 1993)));
        pacienti.add(new Pacient(305, "Dinescu", "Luca", new Date(11, 5, 1987)));
        pacienti.add(new Pacient(306, "Pop", "Aryan", new Date(19, 1, 2007)));

        programari.add(new Programare(5000, 300, 101, 12,
                new Date(10, 4, 2010), "12:00", "16:00"));
        programari.add(new Programare(5001, 300, 101, 12,
                new Date(12, 6, 2016), "08:00", "17:00"));
        programari.add(new Programare(5002, 305, 103, 13,
                new Date(5, 10, 2018), "14:30", "15:30"));
        programari.add(new Programare(5003, 306, 103, 13,
                new Date(30, 7, 2013), "09:00", "09:30"));

        echipamente.add(new Echipament(70000, 12, -1, "sigilant microbian",
                "in folosinta", 170000));
        echipamente.add(new Echipament(70001, -1, 10000, "targa",
                "in folosinta", 14600));
        echipamente.add(new Echipament(70002, 13, -1, "monitor functii vitale",
                "in folosinta", 26000));
    }
    public void Save() throws IOException {
        ambulantaStream.writeAmbulante(ambulante);
        ambulantierStream.writeAmbulantieri(ambulantieri);
        angajatStream.writeAngajati(angajati);
        autoritateStream.writeAutoritati(autoritati);
        echipamentStream.writeEchipamente(echipamente);
        institutieStream.writeInstitutii(institutii);
        pacientStream.writePacienti(pacienti);
        programareStream.writeProgramari(programari);
        salaStream.writeSali(sali);
        spitalStream.writeSpitale(spitale);
    }

    public Database(boolean startWithData) throws IOException {
        ambulantaStream = AmbulantaStream.getInstance();
        ambulantierStream = AmbulantierStream.getInstance();
        angajatStream = AngajatStream.getInstance();
        autoritateStream = AutoritateStream.getInstance();
        echipamentStream = EchipamentStream.getInstance();
        institutieStream = InstitutieStream.getInstance();
        pacientStream = PacientStream.getInstance();
        programareStream = ProgramareStream.getInstance();
        salaStream = SalaStream.getInstance();
        spitalStream = SpitalStream.getInstance();
        activityStream = ActivityStream.getInstance();

        if(startWithData)
            GenerateEntities();
        else {
            ambulante = ambulantaStream.readAmbulante();
            ambulantieri = ambulantierStream.readAmbulantieri();
            angajati = angajatStream.readAngajati();
            autoritati = autoritateStream.readAutoritati();
            echipamente = echipamentStream.readEchipamente();
            institutii = institutieStream.readInstitutii();
            pacienti = pacientStream.readPacienti();
            programari = programareStream.readProgramari();
            sali = salaStream.readSali();
            spitale = spitalStream.readSpitale();
        }
    }

    public String insert(@NotNull Institutie institutie) {
        if(institutie.getIdInstitutie() < 0)
            return "Id institutie trebuie sa fie >= 0\n";

        for(Institutie i : institutii)
            if(i.getIdInstitutie() == institutie.getIdInstitutie())
                return "Id folosit\n";

        for(Spital i : spitale)
            if(i.getIdInstitutie() == institutie.getIdInstitutie())
                return "Id folosit\n";

        boolean ok = false;
        if(institutie.getIdAutoritate() < 0)
            ok = true;
        else {
            for (Autoritate i : autoritati)
                if (i.getIdAutoritate() == institutie.getIdAutoritate()){
                    ok = true;
                    break;
                }
        }

        if(!ok)
            return "Autoritati id nu exista\n";

        institutii.add(institutie);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    public String insert(@NotNull Autoritate autoritate) {
        if(autoritate.getIdAutoritate() < 0)
            return "Id autoritate trebuie sa fie >= 0\n";

        for (Autoritate i : autoritati)
            if(i.getIdAutoritate() == autoritate.getIdAutoritate())
                return "Id folosit\n";

        autoritati.add(autoritate);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    public String insert(@NotNull Spital spital){
        if(spital.getIdInstitutie() < 0)
            return "Id institutie trebuie sa fie >= 0\n";

        for(Institutie i : institutii)
            if(i.getIdInstitutie() == spital.getIdInstitutie())
                return "Id folosit\n";

        for(Spital i : spitale)
            if(i.getIdInstitutie() == spital.getIdInstitutie())
                return "Id folosit\n";

        boolean ok = false;
        if(spital.getIdAutoritate() < 0)
            ok = true;
        else {
            for (Autoritate i : autoritati)
                if (i.getIdAutoritate() == spital.getIdAutoritate()){
                    ok = true;
                    break;
                }
        }

        if(!ok)
            return "Autoritati id nu exista\n";

        spitale.add(spital);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    public String insert(@NotNull Sala sala){
        if(sala.getIdSala() < 0)
            return "id sala trebuie sa fie >= 0\n";

        for(Sala i : sali)
            if(i.getIdSala() == sala.getIdSala())
                return "Id folosit\n";

        boolean ok = false;
        for (Institutie i : institutii)
            if (i.getIdInstitutie() == sala.getIdInstitutie()) {
                ok = true;
                break;
            }

        if(!ok)
            return "Institutii id nu exista\n";

        sali.add(sala);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    public String insert(@NotNull Pacient pacient){
        if(pacient.getIdPacient() < 0)
            return "Id pacient trebuie sa fie >= 0\n";

        for(Pacient i : pacienti)
            if(i.getIdPacient() == pacient.getIdPacient())
                return "Id folosit\n";

        pacienti.add(pacient);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    public String insert(@NotNull Ambulanta ambulanta){
        if(ambulanta.getIdAmbulanta() < 0)
            return "Id ambulanta trebuie sa fie >= 0\n";

        for(Ambulanta i : ambulante)
            if(i.getIdAmbulanta() == ambulanta.getIdAmbulanta())
                return "Id folosit\n";

        ambulante.add(ambulanta);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    public String insert(@NotNull Echipament echipament){
        if(echipament.getIdEchipament() >= 0)
            return "Id echipament trebuie sa fie >= 0\n";

        if(echipament.getIdAmbulanta() >= 0 && echipament.getIdSala() >=  0)
            return "Echipamentul nu poate fi alocat in mai multe locuri\n";

        for(Echipament i : echipamente)
            if(i.getIdEchipament() == echipament.getIdEchipament())
                return "Id folosit\n";

        if(echipament.getIdAmbulanta() >= 0){
            boolean ok = false;
            for(Ambulanta i : ambulante)
                if(i.getIdAmbulanta() == echipament.getIdAmbulanta()){
                    ok = true;
                    break;
                }

            if(!ok)
                return "Id ambulanta nu exista\n";
        }

        if(echipament.getIdSala() >= 0){
            boolean ok = false;
            for(Sala i : sali)
                if(i.getIdSala() == echipament.getIdSala()){
                    ok = true;
                    break;
                }

            if(!ok)
                return "Id sala nu exista\n";
        }

        echipamente.add(echipament);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    public String insert(@NotNull Angajat angajat) {
        if(angajat.getIdAngajat() < 0)
            return "Id angajat trebuie sa fie >= 0";

        for(Angajat i : angajati)
            if(i.getIdAngajat() == angajat.getIdAngajat())
                return "Id folosit\n";

        for(Ambulantier i : ambulantieri)
            if(i.getIdAngajat() == angajat.getIdAngajat())
                return "Id folosit\n";

        boolean ok = false;
        if(angajat.getIdInstitutie() < 0)
            ok = true;
        else {
            for (Institutie i : institutii)
                if (i.getIdInstitutie() == angajat.getIdInstitutie()){
                    ok = true;
                    break;
                }
        }

        if(!ok)
            return "Institutie id nu exista\n";

        angajati.add(angajat);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    public String insert(@NotNull Ambulantier ambulantier){
        if(ambulantier.getIdAngajat() < 0)
            return "Id angajat trebuie sa fie >= 0";

        for(Angajat i : angajati)
            if(i.getIdAngajat() == ambulantier.getIdAngajat())
                return "Id folosit\n";

        for(Ambulantier i : ambulantieri)
            if(i.getIdAngajat() == ambulantier.getIdAngajat())
                return "Id folosit\n";

        boolean ok = false;
        if(ambulantier.getIdInstitutie() < 0)
            ok = true;
        else {
            for (Institutie i : institutii)
                if (i.getIdInstitutie() == ambulantier.getIdInstitutie()){
                    ok = true;
                    break;
                }
        }

        if(!ok)
            return "Institutie id nu exista\n";

        ok = false;
        if(ambulantier.getIdAmbulanta() < 0)
            ok = true;
        else {
            for (Ambulanta i : ambulante)
                if (i.getIdAmbulanta() == ambulantier.getIdAmbulanta()){
                    ok = true;
                    break;
                }
        }

        if(!ok)
            return "Ambulanta id nu exista\n";

        ambulantieri.add(ambulantier);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }
    //de imbunatatit orele
    public String insert(@NotNull Programare programare){
        if(programare.getIdProgramare() < 0)
            return "Id programare trebuie sa fie >= 0\n";

        for(Programare i : programari)
            if(i.getIdProgramare() == programare.getIdProgramare())
                return "Id folosit\n";

        boolean ok = false;
        for(Pacient i : pacienti)
            if(i.getIdPacient() == programare.getIdPacient()){
                ok = true;
                break;
            }

        if(!ok)
            return "Id pacient nu exista\n";

        ok = false;
        for(Angajat i : angajati)
            if(i.getIdAngajat() == programare.getIdAngajat()){
                ok = true;
                break;
            }

        if(!ok)
            for(Ambulantier i : ambulantieri)
                if(i.getIdAngajat() == programare.getIdAngajat()){
                    ok = true;
                    break;
                }

        if(!ok)
            return "Id angajat nu exista\n";

        ok = false;
        for(Sala i : sali)
            if(i.getIdSala() == programare.getIdSala()){
                ok = true;
                break;
            }

        if(!ok)
            return "Id sala nu exista\n";

        programari.add(programare);
        activityStream.AddActivity("Insert");
        return "Introdus\n";
    }

    public String delete(@NotNull Autoritate autoritate){
        if(!autoritati.contains(autoritate))
            return "Nu exista\n";

        for(Institutie i : institutii)
            if(i.getIdAutoritate() == autoritate.getIdAutoritate())
                i.setIdAutoritate(-1);

        autoritati.remove(autoritate);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Programare programare){
        if(!programari.contains(programare))
            return "Nu exista\n";

        programari.remove(programare);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Pacient pacient){
        if(!pacienti.contains(pacient))
            return "Nu exista\n";

        ArrayList<Programare> to_remove = new ArrayList<>();
        for(Programare prog : programari)
            if(prog.getIdPacient() == pacient.getIdPacient())
                to_remove.add(prog);

        for(Programare prog : to_remove)
            delete(prog);

        pacienti.remove(pacient);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Angajat angajat){
        if(!angajati.contains(angajat))
            return "Nu exista\n";

        ArrayList<Programare> to_remove = new ArrayList<>();
        for(Programare prog : programari)
            if(prog.getIdAngajat() == angajat.getIdAngajat())
                to_remove.add(prog);

        for(Programare prog : to_remove)
            delete(prog);

        angajati.remove(angajat);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Ambulantier ambulantier){
        if(!angajati.contains(ambulantier))
            return "Nu exista\n";

        ArrayList<Programare> to_remove = new ArrayList<>();
        for(Programare prog : programari)
            if(prog.getIdAngajat() == ambulantier.getIdAngajat())
                to_remove.add(prog);

        for(Programare prog : to_remove)
            delete(prog);

        ambulantieri.remove(ambulantier);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Echipament echipament){
        if(!echipamente.contains(echipament))
            return "Nu exista\n";

        echipamente.remove(echipament);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Ambulanta ambulanta){
        if(!ambulante.contains(ambulanta))
            return "Nu exista\n";

        for(Echipament echip : echipamente)
            if(echip.getIdAmbulanta() == ambulanta.getIdAmbulanta())
                echip.setIdAmbulanta(-1);

        ambulante.remove(ambulanta);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Sala sala){
        if(!sali.contains(sala))
            return "Nu exista\n";

        for(Echipament echip : echipamente)
            if(echip.getIdSala() == sala.getIdSala())
                echip.setIdSala(-1);

        ArrayList <Programare> to_remove = new ArrayList<>();
        for(Programare prog : programari)
            if(prog.getIdSala() == sala.getIdSala())
                to_remove.add(prog);

        for(Programare prog : to_remove)
            delete(prog);

        sali.remove(sala);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Institutie institutie){
        if(!institutii.contains(institutie))
            return "Nu exista\n";

        for(Angajat angajat : angajati)
            if(angajat.getIdInstitutie() == institutie.getIdInstitutie())
                angajat.setIdInstitutie(-1);

        for(Ambulantier ambulantier : ambulantieri)
            if(ambulantier.getIdInstitutie() == institutie.getIdInstitutie())
                ambulantier.setIdInstitutie(-1);

        ArrayList <Sala> to_remove = new ArrayList<>();
        for(Sala sala : sali)
            if(sala.getIdInstitutie() == institutie.getIdInstitutie())
                to_remove.add(sala);

        for(Sala sala : to_remove)
            delete(sala);

        institutii.remove(institutie);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }
    public String delete(@NotNull Spital spital){
        if(!spitale.contains(spital))
            return "Nu exista\n";

        for(Angajat angajat : angajati)
            if(angajat.getIdInstitutie() == spital.getIdInstitutie())
                angajat.setIdInstitutie(-1);

        for(Ambulantier ambulantier : ambulantieri)
            if(ambulantier.getIdInstitutie() == spital.getIdInstitutie())
                ambulantier.setIdInstitutie(-1);

        ArrayList <Sala> to_remove = new ArrayList<>();
        for(Sala sala : sali)
            if(sala.getIdInstitutie() == spital.getIdInstitutie())
                to_remove.add(sala);

        for(Sala sala : to_remove)
            delete(sala);

        institutii.remove(spital);
        activityStream.AddActivity("Delete");
        return "Sters\n";
    }

    public String update(@NotNull Autoritate autoritate){
        boolean ok = false;
        for(Autoritate i : autoritati)
            if(i.getIdAutoritate() == autoritate.getIdAutoritate()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(autoritate);
        else
            return "Nu exista id autoritate\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }
    public String update(@NotNull Institutie institutie){
        boolean ok = false;
        for(Institutie i : institutii)
            if(i.getIdInstitutie() == institutie.getIdInstitutie()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(institutie);
        else
            return "Nu exista id institutii\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }
    public String update(@NotNull Spital spital){
        boolean ok = false;
        for(Spital i : spitale)
            if(i.getIdInstitutie() == spital.getIdInstitutie()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(spital);
        else
            return "Nu exista id spital\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }
    public String update(@NotNull Sala sala){
        boolean ok = false;
        for(Sala i : sali)
            if(i.getIdSala() == sala.getIdSala()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(sala);
        else
            return "Nu exista id sala\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }
    public String update(@NotNull Pacient pacient){
        boolean ok = false;
        for(Pacient i : pacienti)
            if(i.getIdPacient() == pacient.getIdPacient()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(pacient);
        else
            return "Nu exista id pacient\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }
    public String update(@NotNull Ambulanta ambulanta){
        boolean ok = false;
        for(Ambulanta i : ambulante)
            if(i.getIdAmbulanta() == ambulanta.getIdAmbulanta()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(ambulanta);
        else
            return "Nu exista id ambulanta\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }
    public String update(@NotNull Echipament echipament){
        boolean ok = false;
        for(Echipament i : echipamente)
            if(i.getIdEchipament() == echipament.getIdEchipament()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(echipament);
        else
            return "Nu exista id echipament\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }
    public String update(@NotNull Angajat angajat){
        boolean ok = false;
        for(Angajat i : angajati)
            if(i.getIdAngajat() == angajat.getIdAngajat()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(angajat);
        else
            return "Nu exista id angajat\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }
    public String update(@NotNull Ambulantier ambulantier){
        boolean ok = false;
        for(Ambulantier i : ambulantieri)
            if(i.getIdAngajat() == ambulantier.getIdAngajat()){
                delete(i);
                ok = true;
                break;
            }

        if(ok)
            insert(ambulantier);
        else
            return "Nu exista id ambulantier\n";
        activityStream.AddActivity("Update");
        return "Modificat\n";
    }

    public TreeSet<Autoritate> getAutoritati(){
        activityStream.AddActivity("Select");
        return autoritati;
    }
    public ArrayList<Institutie> getInstitutii(){
        activityStream.AddActivity("Select");
        return institutii;
    }
    public ArrayList<Spital> getSpitale(){
        activityStream.AddActivity("Select");
        return spitale;
    }
    public ArrayList<Sala> getSali(){
        activityStream.AddActivity("Select");
        return sali;
    }
    public ArrayList<Echipament> getEchipamente(){
        activityStream.AddActivity("Select");
        return echipamente;
    }
    public ArrayList<Ambulanta> getAmbulante(){
        activityStream.AddActivity("Select");
        return ambulante;
    }
    public ArrayList<Angajat> getAngajati(){
        activityStream.AddActivity("Select");
        return angajati;
    }
    public ArrayList<Ambulantier> getAmbulantieri(){
        activityStream.AddActivity("Select");
        return ambulantieri;
    }
    public TreeSet<Programare> getProgramari(){
        activityStream.AddActivity("Select");
        return programari;
    }
    public TreeSet<Pacient> getPacienti(){
        activityStream.AddActivity("Select");
        return pacienti;
    }

    public ArrayList<Pacient> pacientiTratati(int angajatId){
        ArrayList<Integer> id_pacienti = new ArrayList<Integer>();
        for(Programare i : programari)
            if(i.getIdAngajat() == angajatId)
                id_pacienti.add(i.getIdPacient());

        ArrayList<Pacient> result = new ArrayList<Pacient>();
        for(Integer i : id_pacienti)
            for(Pacient pac : pacienti)
                if(pac.getIdPacient() == i){
                    if(!result.contains(pac))
                        result.add(pac);
                    break;
                }

        activityStream.AddActivity("Select pacienti tratati");
        return result;
    }
    public ArrayList<Pacient> pacientiCuVarsta(Date minim, Date maxim){
        ArrayList<Pacient> result = new ArrayList<Pacient>();
        for(Pacient i : pacienti)
            if (i.getZiNastere().compareTo(minim) >= 0 && i.getZiNastere().compareTo(maxim) <= 0)
                result.add(i);
        activityStream.AddActivity("Select pacienti cu varsta");
        return result;
    }
    public ArrayList<Programare> programareInInstitutie(int id_institutie){
        ArrayList<Programare> result = new ArrayList<Programare>();
        for(Programare prog : programari){
            boolean ok = false;
            for(Sala sala : sali)
                if(sala.getIdSala() == prog.getIdSala()){
                    for(Institutie inst : institutii)
                        if(inst.getIdInstitutie() == sala.getIdInstitutie()){
                            ok = true;
                            break;
                        }
                    break;
                }
            if(ok)
                result.add(prog);
        }

        activityStream.AddActivity("Select programare in institutie");
        return result;
    }
    public ArrayList<Programare> programareInInstitutie(int id_institutie, Date minim, Date maxim){
        ArrayList<Programare> result = new ArrayList<Programare>();
        for(Programare prog : programari){
            if(prog.getZi().compareTo(minim) < 0 || prog.getZi().compareTo(maxim) > 0)
                continue;

            boolean ok = false;
            for(Sala sala : sali)
                if(sala.getIdSala() == prog.getIdSala()){
                    for(Institutie inst : institutii)
                        if(inst.getIdInstitutie() == sala.getIdInstitutie()){
                            ok = true;
                            break;
                        }
                    break;
                }
            if(ok)
                result.add(prog);
        }

        activityStream.AddActivity("Select programare in institutie");
        return result;
    }
    public ArrayList<Echipament> echipamenteInInstitutie(int id_institutie){
        ArrayList<Echipament> result = new ArrayList<>();
        ArrayList<Integer> id_sali = new ArrayList<>(), id_ambulante = new ArrayList<>();

        for(Sala sala : sali)
            if(sala.getIdInstitutie() == id_institutie)
                id_sali.add(sala.getIdSala());

        for(Ambulantier ambulantier : ambulantieri)
            if (ambulantier.getIdInstitutie() == id_institutie && ambulantier.getIdAmbulanta() >= 0)
                id_ambulante.add(ambulantier.getIdAmbulanta());

        for(Echipament echip : echipamente)
            if(id_sali.contains(echip.getIdSala()) || id_ambulante.contains(echip.getIdAmbulanta()))
                result.add(echip);

        activityStream.AddActivity("Select echipamente in institutie");
        return result;
    }
    public void maresteSalarii(double suma_fixa, double procent, String denumire_job){
        for(Angajat angajat : angajati)
            if(angajat.getDenumireJob().compareTo(denumire_job) == 0)
                angajat.setSalariu(Math.max(angajat.getSalariu() * procent + suma_fixa, 0.0));
        activityStream.AddActivity("Update salarii");
    }
    public void trimitereEchipamenteRevizie(Sala sala) {
        for(Echipament echipament : echipamente)
            if(echipament.getIdSala() == sala.getIdSala()) {
                echipament.setIdSala(-1);
                echipament.setStareEchipament("in revizie");
            }
        activityStream.AddActivity("Update salarii");
    }
    public void trimitereEchipamenteRevizie(Ambulanta ambulanta){
        for(Echipament echipament : echipamente)
            if(echipament.getIdAmbulanta() == ambulanta.getIdAmbulanta()) {
                echipament.setIdAmbulanta(-1);
                echipament.setStareEchipament("in revizie");
            }
        activityStream.AddActivity("Update trimitere echipamente in revizie");
    }
    public ArrayList<Programare> getProgramariInInterval(Date zi_minim, Date zi_maxim, String ora_minim, String ora_maxim){
        ArrayList<Programare> result = new ArrayList<>();
        for(Programare programare : programari)
            if(programare.getZi().compareTo(zi_minim) >= 0 && programare.getZi().compareTo(zi_maxim) <= 0
                    && programare.getOraStart().compareTo(ora_minim) >= 0 && programare.getOraIncheiat().compareTo(ora_maxim) <= 0)
                result.add(programare);

        activityStream.AddActivity("Select programari in interval");
        return result;
    }
}