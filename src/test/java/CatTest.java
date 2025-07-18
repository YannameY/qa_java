import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline mockFeline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        Assert.assertEquals("Звук должен быть 'Мяу'", "Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Пища должна быть 'Животные', 'Птицы', 'Рыба'", expectedFood, cat.getFood());

    }
}
