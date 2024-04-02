public class Kaart {
    private String tähis;
    private int primaarneVäärtus;
    private int sekundaarneVäärtus;

    public Kaart(String tähis, int primaarneVäärtus, int sekundaarneVäärtus) {
        this.tähis = tähis;
        this.primaarneVäärtus = primaarneVäärtus;
        this.sekundaarneVäärtus = sekundaarneVäärtus;
    }

    public String getTähis() {
        return tähis;
    }

    public int getPrimaarneVäärtus() {
        return primaarneVäärtus;
    }

    public int getSekundaarneVäärtus() {
        return sekundaarneVäärtus;
    }
}
