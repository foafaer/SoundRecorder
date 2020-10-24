public class ChocoCandy extends Candy {

    private double chocoContent;

    public ChocoCandy(String candyName, double weight, double sugarContent, double price, boolean isWithFilling) {
        super(candyName, weight, sugarContent, price, isWithFilling);
    }

    public double getChocoContent() {
        return chocoContent;
    }

    public void setChocoContent(double chocoContent) {
        this.chocoContent = chocoContent;
    }
}
