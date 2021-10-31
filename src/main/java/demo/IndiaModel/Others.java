package demo.IndiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Others extends Product {

    @JsonProperty("Others")
    private ArrayList<Integer> valuesPerMonthList;

    public Others(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    public Others() {
    }

    public void setValuesPerMonthList(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    @Override
    public List<Integer> getValuesPerMonth() {
        return valuesPerMonthList;
    }
}
