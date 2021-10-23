package demo.IndiaModel;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PetCoke extends Product {

    // using JsonAlias instead of JsonProperty because JsonAlias allows deserialization for multiple names

    @JsonProperty("PetCoke")
    @JsonAlias({"Petcoke", "Petcoke / CBFS"})
    private ArrayList<Integer> valuesPerMonthList;

    public PetCoke(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
}

    public PetCoke() {
    }

    public void setValuesPerMonthList(ArrayList<Integer> valuesPerMonthList) {
        this.valuesPerMonthList = valuesPerMonthList;
    }

    @Override
    public List<Integer> getValuesPerMonth() {
        return valuesPerMonthList;
    }
}
