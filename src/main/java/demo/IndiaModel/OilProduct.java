package demo.IndiaModel;


import java.util.ArrayList;

public class OilProduct {

    private String productName;
    private ArrayList<Integer> yearsList;

    public OilProduct(String productName, ArrayList<Integer> yearsList) {
        this.productName = productName;
        this.yearsList = yearsList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ArrayList<Integer> getYearsList() {
        return yearsList;
    }

    public void setYearsList(ArrayList<Integer> yearsList) {
        this.yearsList = yearsList;
    }
}
