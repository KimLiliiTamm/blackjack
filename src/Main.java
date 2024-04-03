import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    /**
     * Standardse 52 kaardiga kaardipaki loomine
     * @return Standardne kaardipakk
     */
    public static List<Kaart> kaardipakiLoomine() {

        java.lang.String kaartideKogu = "2♥,3♥,4♥,5♥,6♥,7♥,8♥,9♥,10♥,J♥,Q♥,K♥,A♥," +
                "2♦,3♦,4♦,5♦,6♦,7♦,8♦,9♦,10♦,J♦,Q♦,K♦,A♦," +
                "2♣,3♣,4♣,5♣,6♣,7♣,8♣,9♣,10♣,J♣,Q♣,K♣,A♣," +
                "2♠,3♠,4♠,5♠,6♠,7♠,8♠,9♠,10♠,J♠,Q♠,K♠,A♠";
        List<Kaart> kaardid = new ArrayList<>();
        String[] tükid = kaartideKogu.split(",");

        int j = 2;
        int primaarneVäärtus;
        int sekundaarneVäärtus = 0;
        for (int i = 0; i < 52; i++, j++) {

            // Äss
            if (j==14) {
                primaarneVäärtus = 11;
                sekundaarneVäärtus = 1;
                j = 1;
            }

            // Pildiga kaart
            else if (j > 10 && j < 14)
                primaarneVäärtus = 10;

            // Numbriga kaart
            else
                primaarneVäärtus = j;

            Kaart kaart = new Kaart(tükid[i], primaarneVäärtus, sekundaarneVäärtus, false);
            kaardid.add(kaart);
            sekundaarneVäärtus = 0;
        }

        return kaardid;
    }

    /**
     * Üldine kaardi jagamise meetod
     * @param mängija Player isend, kellele kaart jagatakse
     * @param kaardipakk Kaardipakk, millest kaart jagatakse
     */
    public static void jagaKaart(Player mängija, List<Kaart> kaardipakk) {
        int suvalineArv = (int)(Math.random() * kaardipakk.size());
        Kaart kaart = kaardipakk.get(suvalineArv);
        mängija.lisaKaart(kaart);
        int väärtus = kaart.getPrimaarneVäärtus();
        if (väärtus != 11)
            mängija.lisaVäärtus(väärtus);
        else {
            if (mängija.getKaartideSumma() + väärtus > 21)
                mängija.lisaVäärtus(1);
            else
                mängija.lisaVäärtus(väärtus);
        }
        kaardipakk.remove(suvalineArv);
    }

    public static void main(String[] args) {

        // Kaardipaki ja mängijate loomine
        List<Kaart> kaardipakk = kaardipakiLoomine();
        Player dealer = new Player();
        Player player = new Player();

        // Esimesed 2 kaarti kummagile
        for (int i = 0; i < 4; i++) {

            int suvalineArv = (int)(Math.random() * kaardipakk.size());
            Kaart kaart = kaardipakk.get(suvalineArv);

            // Kordamööda kaartide jagamine ning jagatud kaardi eemaldamine kaardipakist
            if (i % 2 == 0) {
                player.lisaKaart(kaart);
                // Juhul, kui peaks saama kaks ässa
                if (dealer.getKaartideSumma() + kaart.getPrimaarneVäärtus() > 21)
                    dealer.lisaVäärtus(kaart.getSekundaarneVäärtus());
                else
                    dealer.lisaVäärtus(kaart.getPrimaarneVäärtus());
                kaardipakk.remove(suvalineArv);
            }

            else {
                if (i==3)
                    kaart.kasOnPeidetud = true;
                dealer.lisaKaart(kaart);
                // Juhul, kui peaks saama kaks ässa
                if (dealer.getKaartideSumma() + kaart.getPrimaarneVäärtus() > 21)
                    dealer.lisaVäärtus(kaart.getSekundaarneVäärtus());
                else
                    dealer.lisaVäärtus(kaart.getPrimaarneVäärtus());
                kaardipakk.remove(suvalineArv);
            }
        }

        System.out.println("Diileri kaardid: " + dealer.getKaardid());
        System.out.println("Mängija kaardid: " + player.getKaardid() + ", summa: " + player.getKaartideSumma());

        boolean kasMängJätkub = true;
        int mängijaleJagatudKaartideArv = 2;
        while (kasMängJätkub) {

            String sisestatakse = JOptionPane.showInputDialog(null, "Sisesta 'HIT' või 'STAND'", "Andmete sisestamine",
                    JOptionPane.QUESTION_MESSAGE);

            if (sisestatakse.toLowerCase().equals("hit")) {
                System.out.println("hit");
                break;
            }
            else if (sisestatakse.toLowerCase().equals("stand")) {
                System.out.println("stand");
                if (dealer.getKaartideSumma() < 17) {
                    jagaKaart(dealer, kaardipakk);
                }
            }
            else {
                System.out.println("Sisestasid valesti, lõpp");
                break;
            }
            mängijaleJagatudKaartideArv++;
        }
    }
}
