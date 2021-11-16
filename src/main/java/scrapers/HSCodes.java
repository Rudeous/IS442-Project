package scrapers;
import java.util.*;

public class HSCodes {
    public static ArrayList<ArrayList<Integer>> getList(){ //returns 2d list of hscodes according to product group
        ArrayList<ArrayList<Integer>> hello = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(27090010);
        temp.add(27090090);
        hello.add(temp);
        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.add(27090020);
        hello.add(temp2);
        ArrayList<Integer> temp3 = new ArrayList<>();
        temp3.add(27101211);
        temp3.add(27101212);
        temp3.add(27101213);
        temp3.add(27101221);
        temp3.add(27101222);
        temp3.add(27101223);
        temp3.add(27101224);
        temp3.add(27101225);
        temp3.add(27101226);
        temp3.add(27101227);
        temp3.add(27101228);
        temp3.add(27101229);
        hello.add(temp3);
        ArrayList<Integer> temp4 = new ArrayList<>();
        temp4.add(27101270);
        temp4.add(27101280);
        hello.add(temp4);
        ArrayList<Integer> temp5 = new ArrayList<>();
        temp5.add(27101981);
        temp5.add(27101982);
        temp5.add(27101983);
        hello.add(temp5);
        ArrayList<Integer> temp6 = new ArrayList<>();
        temp6.add(27101971);
        temp6.add(27101972);
        hello.add(temp6);
        ArrayList<Integer> temp7 = new ArrayList<>();
        temp7.add(27101979);
        hello.add(temp7);
        //System.out.println(hello);
        return hello;
    }

    public static ArrayList<String> getProductNames(){
        ArrayList<String> hello = new ArrayList<>();
        hello.add("crude_oil");
        hello.add("condensates");
        hello.add("gasoline");
        hello.add("naphtha");
        hello.add("jet_fuel");
        hello.add("gasoil_diesel");
        hello.add("fuel_oil");
        return hello;
    }

    public static ArrayList<String> getExcelFileNames(){
        ArrayList<String> hello = new ArrayList<>();
        hello.add("IMPORT_crude_oil");
        hello.add("IMPORT_condensates");
        hello.add("IMPORT_gasoline");
        hello.add("IMPORT_naphtha");
        hello.add("IMPORT_jet_fuel");
        hello.add("IMPORT_gasoil_diesel");
        hello.add("IMPORT_fuel_oil");
        hello.add("EXPORT_crude_oil");
        hello.add("EXPORT_condensates");
        hello.add("EXPORT_gasoline");
        hello.add("EXPORT_naphtha");
        hello.add("EXPORT_jet_fuel");
        hello.add("EXPORT_gasoil_diesel");
        hello.add("EXPORT_fuel_oil");
        return hello;
    }

    public static ArrayList<String> getMonthNames(){
        ArrayList<String> hello = new ArrayList<>();
        hello.add("");
        hello.add("JANUARY");
        hello.add("FEBRUARY");
        hello.add("MARCH");
        hello.add("APRIL");
        hello.add("MAY");
        hello.add("JUNE");
        hello.add("JULY");
        hello.add("AUGUST");
        hello.add("SEPTEMBER");
        hello.add("OCTOBER");
        hello.add("NOVEMBER");
        hello.add("DECEMBER");
        return hello;
    }
}
