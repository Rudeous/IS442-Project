package demo.IndiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Sheet {

    @JsonProperty("Periods")
    private List<String> period;

    @JsonProperty("Imports")
    private List<Product> imports;

    @JsonProperty("Exports")
    private List<Product> exports;

    public Sheet(List<String> period, List<Product> imports, List<Product> exports) {
        this.period = period;
        this.imports = imports;
        this.exports = exports;
    }

    public Sheet() {
    }

    public List<String> getPeriod() {
        return period;
    }

    public void setPeriod(List<String> period) {
        this.period = period;
    }

    public List<Product> getImports() {
        return imports;
    }

    public void setImports(List<Product> imports) {
        this.imports = imports;
    }

    public List<Product> getExports() {
        return exports;
    }

    public void setExports(List<Product> exports) {
        this.exports = exports;
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "period=" + period +
                ", imports=" + imports +
                ", exports=" + exports +
                '}';
    }
}
