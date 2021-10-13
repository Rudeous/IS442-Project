package demo.Model;

import java.util.List;

public class Product {

    private List<Integer> valuesPerMonth;

    public Product(List<Integer> valuesPerMonth) {
        this.valuesPerMonth = valuesPerMonth;
    }

    public Product() {
    }

    public List<Integer> getValuesPerMonth() {
        return valuesPerMonth;
    }

    public void setValuesPerMonth(List<Integer> valuesPerMonth) {
        this.valuesPerMonth = valuesPerMonth;
    }

    @Override
    public String toString() {
        return "Product{" +
                "valuesPerMonth=" + valuesPerMonth +
                '}';
    }

//    TODO: create Product class for each Oil Product
//     or change the json to be a ["Crude Oil", [values]]
//     instead of {"Crude Oil": [values]}

}
