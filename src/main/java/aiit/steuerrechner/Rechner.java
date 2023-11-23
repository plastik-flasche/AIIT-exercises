package aiit.steuerrechner;

public class Rechner {
    private final double einkommenBrutto;
    private double steuerAbgaben;

    private double alreadyTaxed;

    public Rechner(double einkommenBrutto) throws Exception {
        this.einkommenBrutto = einkommenBrutto;
        if (einkommenBrutto <= 0) {
            throw new Exception("Einkommen muss groesser 0 sein!");
        }
        rechnen();
    }

    public double getSteuerabgaben() {
        return steuerAbgaben;
    }

    private void rechnen() {
        addToTax(11E3, 0.0);
        addToTax(18E3, 0.2);
        addToTax(31E3, 0.3);
        addToTax(60E3, 0.4);
        addToTax(90E3, 0.48);
        addToTax(1E6, 0.5);
        addToTax(Double.MAX_VALUE, 0.55);
    }

    private void addToTax(double upper, double rate) {
        double leftToTax = einkommenBrutto - alreadyTaxed;

        double affected;
        if (einkommenBrutto > upper) {
            affected = upper - alreadyTaxed;
            alreadyTaxed = upper;
        } else {
            affected = leftToTax;
            alreadyTaxed = einkommenBrutto;
        }

        steuerAbgaben += affected * rate;
    }
}
