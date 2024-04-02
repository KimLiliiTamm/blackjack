import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private List<Kaart> kaardid;
    private int kaartideSumma;

    public Player(List<Kaart> kaardid, int kaartideSumma) {
        this.kaardid = kaardid;
        this.kaartideSumma = kaartideSumma;
    }

    public void lisaKaart(Kaart kaart) {
        kaardid.add(kaart);
    }

    public int getKaartideSumma() {
        return kaartideSumma;
    }

    public List<Kaart> getKaardid() {
        return kaardid;
    }
}
