package demo.IndiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class CrudeOil extends Product {

    @JsonProperty(" CRUDE OIL")
    private ArrayList<Integer> valuesPerMonthList;

    public CrudeOil(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    public CrudeOil() {
    }

    public void setValuesPerMonthList(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    @Override
    public List<Integer> getValuesPerMonth() {
        return valuesPerMonthList;
    }
}
