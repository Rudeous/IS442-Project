package demo.IndiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class SKO extends Product {

    @JsonProperty("SKO")
    private ArrayList<Integer> valuesPerMonthList;

    public SKO(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    public SKO() {
    }

    public void setValuesPerMonthList(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    @Override
    public List<Integer> getValuesPerMonth() {
        return valuesPerMonthList;
    }
}
