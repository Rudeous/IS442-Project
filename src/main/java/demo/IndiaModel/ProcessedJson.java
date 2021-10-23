package demo.IndiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessedJson {

    @JsonProperty("PT_IMPORT_2019-20")
    private Sheet sheet19_20;

    @JsonProperty("PT_IMPORT_2017-18")
    private Sheet sheet17_18;

    @JsonProperty("PT_IMPORT_2018-19")
    private Sheet sheet18_19;

    @JsonProperty("PT_import")
    private Sheet sheet21_22;

    @JsonProperty("PT_IMPORT_2020-21")
    private Sheet sheet20_21;

    public ProcessedJson(Sheet sheet19_20, Sheet sheet17_18,
                         Sheet sheet18_19, Sheet sheet21_22,
                         Sheet sheet20_21) {
        this.sheet19_20 = sheet19_20;
        this.sheet17_18 = sheet17_18;
        this.sheet18_19 = sheet18_19;
        this.sheet21_22 = sheet21_22;
        this.sheet20_21 = sheet20_21;
    }

    public ProcessedJson(Sheet sheet19_20) {
        this.sheet19_20 = sheet19_20;
    }

    public ProcessedJson() {
    }

    public Sheet getSheet19_20() {
        return sheet19_20;
    }

    public void setSheet19_20(Sheet sheet19_20) {
        this.sheet19_20 = sheet19_20;
    }

    public Sheet getSheet17_18() {
        return sheet17_18;
    }

    public void setSheet17_18(Sheet sheet17_18) {
        this.sheet17_18 = sheet17_18;
    }

    public Sheet getSheet18_19() {
        return sheet18_19;
    }

    public void setSheet18_19(Sheet sheet18_19) {
        this.sheet18_19 = sheet18_19;
    }

    public Sheet getSheet21_22() {
        return sheet21_22;
    }

    public void setSheet21_22(Sheet sheet21_22) {
        this.sheet21_22 = sheet21_22;
    }

    public Sheet getSheet20_21() {
        return sheet20_21;
    }

    public void setSheet20_21(Sheet sheet20_21) {
        this.sheet20_21 = sheet20_21;
    }

    @Override
    public String toString() {
        return "ProcessedJson{" +
                "sheet19_20=" + sheet19_20 +
                ", sheet17_18=" + sheet17_18 +
                ", sheet18_19=" + sheet18_19 +
                ", sheet21_22=" + sheet21_22 +
                ", sheet20_21=" + sheet20_21 +
                '}';
    }
}
