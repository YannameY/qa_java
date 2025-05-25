import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline mockFeline;


    @Test
    public void testGetSound() {

        Feline mockFeline = mock(Feline.class);
        Cat cat = new Cat(mockFeline);
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {

        Cat cat = new Cat(mockFeline);
        Mockito.when(mockFeline.eatMeat()).thenReturn(List.of("Хищник"));
        Assert.assertEquals(List.of("Хищник"), cat.getFood());
        Mockito.verify(mockFeline, Mockito.times(1)).eatMeat();
    }
}