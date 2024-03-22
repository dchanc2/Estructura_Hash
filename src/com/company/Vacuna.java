package com.company;
import java.io.*;
import java.util.Hashtable;

public class Vacuna implements Serializable {
    String PrimeraDosis;
    String SegundaDosis;

    public Vacuna(String PrimeraDosis, String SegundaDosis) {
        this.PrimeraDosis = PrimeraDosis;
        this.SegundaDosis = SegundaDosis;
    }

    @Override
    public String toString() {
        return "Vacuna:" +
                "Covid Dosis 1 Fecha: '" + PrimeraDosis + '\'' +
                ", Covid Dosis 2 Fecha: '" + SegundaDosis + '\'' +
                '}';
    }
}

class ControlVacunas {
    private Hashtable<String, Vacuna> vacunas;
    private File file;

    public ControlVacunas(String filename) {
        this.file = new File(filename);
        vacunas = new Hashtable<>();
        CargarVacunas();
    }

    private void CargarVacunas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            vacunas = (Hashtable<String, Vacuna>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void GuardarVacunas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(vacunas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addVacuna(String cui, Vacuna vacuna) {
        vacunas.put(cui, vacuna);
        GuardarVacunas();
    }

    public Vacuna getVacuna(String cui) {
        return vacunas.get(cui);
    }
}