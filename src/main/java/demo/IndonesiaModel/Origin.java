package demo.IndonesiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import demo.IndonesiaModel.OilProduct;

public class Origin {

    @JsonProperty("crude_oil")
    private OilProduct crudeOil;

    @JsonProperty("condensates")
    private OilProduct condensates;

    @JsonProperty("gasoline")
    private OilProduct gasoline;

    @JsonProperty("naphtha")
    private OilProduct naphtha;

    @JsonProperty("jet_fuel")
    private OilProduct jetFuel;

    @JsonProperty("gasoil_diesel")
    private OilProduct gasoilDiesel;

    @JsonProperty("fuel_oil")
    private OilProduct fuelOil;

    public Origin() {
    }

    public Origin(OilProduct crudeOil, OilProduct condensates,
                  OilProduct gasoline, OilProduct naphtha,
                  OilProduct jetFuel, OilProduct gasoilDiesel,
                  OilProduct fuelOil) {
        this.crudeOil = crudeOil;
        this.condensates = condensates;
        this.gasoline = gasoline;
        this.naphtha = naphtha;
        this.jetFuel = jetFuel;
        this.gasoilDiesel = gasoilDiesel;
        this.fuelOil = fuelOil;
    }

    public OilProduct getCrudeOil() {
        return crudeOil;
    }

    public void setCrudeOil(OilProduct crudeOil) {
        this.crudeOil = crudeOil;
    }

    public OilProduct getCondensates() {
        return condensates;
    }

    public void setCondensates(OilProduct condensates) {
        this.condensates = condensates;
    }

    public OilProduct getGasoline() {
        return gasoline;
    }

    public void setGasoline(OilProduct gasoline) {
        this.gasoline = gasoline;
    }

    public OilProduct getNaphtha() {
        return naphtha;
    }

    public void setNaphtha(OilProduct naphtha) {
        this.naphtha = naphtha;
    }

    public OilProduct getJetFuel() {
        return jetFuel;
    }

    public void setJetFuel(OilProduct jetFuel) {
        this.jetFuel = jetFuel;
    }

    public OilProduct getGasoilDiesel() {
        return gasoilDiesel;
    }

    public void setGasoilDiesel(OilProduct gasoilDiesel) {
        this.gasoilDiesel = gasoilDiesel;
    }

    public OilProduct getFuelOil() {
        return fuelOil;
    }

    public void setFuelOil(OilProduct fuelOil) {
        this.fuelOil = fuelOil;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "crudeOil=" + crudeOil +
                ", condensates=" + condensates +
                ", gasoline=" + gasoline +
                ", naphtha=" + naphtha +
                ", jetFuel=" + jetFuel +
                ", gasoilDiesel=" + gasoilDiesel +
                ", fuelOil=" + fuelOil +
                '}';
    }
}
