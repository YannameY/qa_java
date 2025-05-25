import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predator;
    @Test
    public void getKittens() throws Exception {

        Mockito.when(predator.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самка", predator);
        Assert.assertEquals(3, lion.getKittens());
    }

    @Test
    public void getFood() throws Exception {

        Mockito.when(predator.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самка", predator);
        Assert.assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        try {
            new Lion("НекорректныйПол", predator);
        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            throw e;
        }
    }
}