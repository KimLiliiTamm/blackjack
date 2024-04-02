public class Main {
    public static Kaardipakk kaardipakiLoomine() {
        java.lang.String kaartideKogu = "2♥,3♥,4♥,5♥,6♥,7♥,8♥,9♥,10♥,J♥,Q♥,K♥,A♥," +
                "2♦,3♦,4♦,5♦,6♦,7♦,8♦,9♦,10♦,J♦,Q♦,K♦,A♦," +
                "2♣,3♣,4♣,5♣,6♣,7♣,8♣,9♣,10♣,J♣,Q♣,K♣,A♣," +
                "2♠,3♠,4♠,5♠,6♠,7♠,8♠,9♠,10♠,J♠,Q♠,K♠,A♠";
        List<Kaart> kaardid= new ArrayList<>();
        String[] tükid = kaartideKogu.split(",");
        int j = 0; // Kuna piltidega kaartidel tuleb väärtuseks 10 ja ässal 11 ning 1, siis paremat meetodit järje pidamiseks ei suutnud välja mõelda xd
        for (int i = 0; i < 52; i++, j++) {
            // TODO
        }
        Kaardipakk kaardipakk = new Kaardipakk(kaardid);

        return kaardipakk;
    }

    public static void main(String[] args) {
        Kaardipakk kaardipakk = kaardipakiLoomine();
        // TODO
    }
}
