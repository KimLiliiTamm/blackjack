import java.util.List;
import java.util.ArrayList;

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


        // ARVUTAB VALESTI, POLE VIGA LAHENDANUD
        int j = 2;
        int primaarneVäärtus;
        int sekundaarneVäärtus = 0;
        for (int i = 0; i < 52; i++, j++) {

            // Äss
            if (j==14) {
                primaarneVäärtus = 11;
                sekundaarneVäärtus = 1;
                j = 2;
            }

            // Pildiga kaart
            else if (j > 10 && j < 14)
                primaarneVäärtus = 10;

            // Numbriga kaart
            else
                primaarneVäärtus = j;

            Kaart kaart = new Kaart(tükid[i], primaarneVäärtus, sekundaarneVäärtus);
            kaardid.add(kaart);
            sekundaarneVäärtus = 0;
        }

        return kaardid;
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
                player.lisaVäärtus(kaart.getPrimaarneVäärtus());
                kaardipakk.remove(suvalineArv);
            }

            else {
                dealer.lisaKaart(kaart);
                dealer.lisaVäärtus(kaart.getPrimaarneVäärtus());
                kaardipakk.remove(suvalineArv);
            }
        }

        System.out.println("Diileri kaardid: " + dealer.getKaardid() + ", summa: " + dealer.getKaartideSumma());
        System.out.println("Mängija kaardid: " + player.getKaardid() + ", summa: " + player.getKaartideSumma());

        // Siia peaks lisama ka võimaluse mäng lõpetada
        // TODO

        /*
        boolean kasMängJätkub = true;
        while (kasMängJätkub) {
        }

         */
    }
}
