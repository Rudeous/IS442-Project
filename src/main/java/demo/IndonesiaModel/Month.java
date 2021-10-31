package demo.IndonesiaModel;

public class Month {

    private double value;

    public Month() {
    }

    public Month(double value) {
        this.value = value;
    }

    // convert from int to double
    public Month(int value) {
        this.value = (double)value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Month{" +
                "value=" + value +
                '}';
    }
}
