package demo.IndonesiaModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import demo.IndonesiaModel.Origin;

public class ProcessedJson {

    @JsonProperty("IMPORT")
    private Origin imports;

    @JsonProperty("EXPORT")
    private Origin exports;

    public ProcessedJson() {
    }

    public ProcessedJson(Origin imports, Origin exports) {
        this.imports = imports;
        this.exports = exports;
    }

    public Origin getImports() {
        return imports;
    }

    public void setImports(Origin imports) {
        this.imports = imports;
    }

    public Origin getExports() {
        return exports;
    }

    public void setExports(Origin exports) {
        this.exports = exports;
    }

    @Override
    public String toString() {
        return "ProcessedJson{" +
                "imports=" + imports +
                ", exports=" + exports +
                '}';
    }

}
