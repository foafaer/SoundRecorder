public class Candy {
    private String candyName;
    private double weight;
    private double sugarContent;
    private double price;
    private boolean isWithFilling;

    public Candy (String candyName, double weight, double sugarContent, double price, boolean isWithFilling) {
        this.candyName = candyName;
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.price = price;
        this.isWithFilling = isWithFilling;
    }

    public String getCandyName() {
        return candyName;
    }
    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }
    public void setSugarContent(double sugarContent) {
        this.sugarContent = sugarContent;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWithFilling() {
        return isWithFilling;
    }
    public void filled (boolean isWithFilling) {
        this.isWithFilling = isWithFilling;
    }
}