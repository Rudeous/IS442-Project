package demo.IndonesiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OilProduct {

    @JsonProperty("2017")
    private Year year2017;

    @JsonProperty("2018")
    private Year year2018;

    @JsonProperty("2019")
    private Year year2019;

    @JsonProperty("2020")
    private Year year2020;

    @JsonProperty("2021")
    private Year year2021;

    public OilProduct() {
    }

    public OilProduct(Year year2017, Year year2018,
                      Year year2019, Year year2020,
                      Year year2021) {
        this.year2017 = year2017;
        this.year2018 = year2018;
        this.year2019 = year2019;
        this.year2020 = year2020;
        this.year2021 = year2021;
    }

    public Year getYear2017() {
        return year2017;
    }

    public void setYear2017(Year year2017) {
        this.year2017 = year2017;
    }

    public Year getYear2018() {
        return year2018;
    }

    public void setYear2018(Year year2018) {
        this.year2018 = year2018;
    }

    public Year getYear2019() {
        return year2019;
    }

    public void setYear2019(Year year2019) {
        this.year2019 = year2019;
    }

    public Year getYear2020() {
        return year2020;
    }

    public void setYear2020(Year year2020) {
        this.year2020 = year2020;
    }

    public Year getYear2021() {
        return year2021;
    }

    public void setYear2021(Year year2021) {
        this.year2021 = year2021;
    }

    @Override
    public String toString() {
        return "OilProduct{" +
                "year2017=" + year2017 +
                ", year2018=" + year2018 +
                ", year2019=" + year2019 +
                ", year2020=" + year2020 +
                ", year2021=" + year2021 +
                '}';
    }
}
