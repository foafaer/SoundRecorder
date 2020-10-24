public class FondantCandy extends Candy {

    private double fondantContent;

    public FondantCandy(String candyName, double weight, double sugarContent, double price, boolean isWithFilling) {
        super(candyName, weight, sugarContent, price, isWithFilling);
    }

    public double getFondantContent() {
        return fondantContent;
    }

    public void setFondantContent(double fondantContent) {
        this.fondantContent = fondantContent;
    }
}
