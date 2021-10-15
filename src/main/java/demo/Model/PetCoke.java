package demo.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class PetCoke extends Product {

    // using JsonAlias instead of JsonProperty because JsonAlias allows deserialization for multiple names
    // maybe should change all to JsonAlias because JsonProperty is for serialization/deserialization

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
