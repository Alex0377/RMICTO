import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class klientData {
    private final IntegerProperty klientId_mastera;
    private final StringProperty klientmachina;
    private final IntegerProperty klientgood;
    private final StringProperty klientFIO;
    private final StringProperty klientnomer;
    private final StringProperty KlientnomerKyzova;
    private final StringProperty klientKomentarii;


    public klientData(Integer klientId_mastera, String klientmachina, Integer klientgood, String klientFIO, String klientnomer, String klientKomentarii, String KlientnomerKyzova) {
        this.klientId_mastera = new SimpleIntegerProperty(klientId_mastera);
        this.klientmachina = new SimpleStringProperty(klientmachina);
        this.klientgood = new SimpleIntegerProperty(klientgood);
        this.klientFIO = new SimpleStringProperty(klientFIO);
        this.klientnomer = new SimpleStringProperty(klientnomer);
        this.klientKomentarii = new SimpleStringProperty(klientKomentarii);
        this.KlientnomerKyzova = new SimpleStringProperty(KlientnomerKyzova);
    }

    public int getKlientgood() {
        return klientgood.get();
    }

    public String getKlientFIO() {
        return klientFIO.get();
    }

    public int getKlientId_mastera() {
        return klientId_mastera.get();
    }

    public String getKlientmachina() {
        return klientmachina.get();
    }

    public String getKlientnomer() {
        return klientnomer.get();
    }

    public String getKlientKomentarii() {
        return klientKomentarii.get();
    }

    public String getKlientnomerKyzova() {
        return KlientnomerKyzova.get();
    }

}
