package demo.IndiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ATF extends Product {

    @JsonProperty("ATF")
    private ArrayList<Integer> valuesPerMonthList;

    public ATF(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    public ATF() {
    }

    public void setValuesPerMonthList(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    @Override
    public List<Integer> getValuesPerMonth() {
        return valuesPerMonthList;
    }
}
