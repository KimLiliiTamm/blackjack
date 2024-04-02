import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Kaart> kaardid;
    private int kaartideSumma;

    public Player() {
        this.kaardid = new ArrayList<>();
        this.kaartideSumma = 0;
    }

    public void lisaKaart(Kaart kaart) {
        kaardid.add(kaart);
    }

    public void lisaVäärtus(int väärtus) {
        kaartideSumma += väärtus;
    }

    public int getKaartideSumma() {
        return kaartideSumma;
    }

    public List<Kaart> getKaardid() {
        return kaardid;
    }

}
