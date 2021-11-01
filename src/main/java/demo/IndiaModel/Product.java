package demo.IndiaModel;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @Type(value = CrudeOil.class, name = "crudeOil"),
        @Type(value = MS.class, name = "MS"),
        @Type(value = LPG.class, name = "LPG"),
        @Type(value = Naphtha.class, name = "naphtha"),
        @Type(value = ATF.class, name = "ATF"),
        @Type(value = SKO.class, name = "SKO"),
        @Type(value = HSD.class, name = "HSD"),
        @Type(value = LOBS.class, name = "LOBS"),
        @Type(value = FuelOil.class, name = "fuelOil"),
        @Type(value = Bitumen.class, name = "bitumen"),
        @Type(value = PetCoke.class, name= "petcoke"),
        @Type(value = LDO.class, name= "LDO"),
        @Type(value = Others.class, name = "others"),
        @Type(value = ProductImport.class, name = "productImport"),
        @Type(value = TotalImport.class, name = "totalImport"),
        @Type(value = TotalProductExport.class, name = "totalProductExport")
})
public class Product {

    List<Integer> valuesPerMonth;

    public List<Integer> getValuesPerMonth() {
        return valuesPerMonth;
    }


}
