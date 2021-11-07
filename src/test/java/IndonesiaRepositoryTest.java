import com.example.servingwebcontent.repository.IndonesiaRepository;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class IndonesiaRepositoryTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void main(){
        try{
            IndonesiaRepository.getAll();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}

