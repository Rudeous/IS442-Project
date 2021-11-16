import org.apache.commons.io.comparator.LastModifiedFileComparator;

import java.io.File;
import java.sql.Timestamp;
import java.util.Arrays;

public class testing {
    public static void main(String[] args){
        java.io.File dir =
                new java.io.File(System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\");
        java.io.File[] files = dir.listFiles();

        //Sort files in ascending order base on last modification date
        assert files != null;
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
        System.out.println(files[files.length-1].getAbsolutePath());
    }
}
