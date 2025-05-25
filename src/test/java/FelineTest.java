import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline felineMock;

    @InjectMocks
    private Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(feline.eatMeat(), felineMock.eatMeat());
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals(expectedFamily, result);
    }


    @Test
    public void testGetKittens() {
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int result = felineMock.getKittens();
        Assert.assertEquals(1, result);

    }

    @Test
    public void getKittensTest() {
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        Assert.assertEquals(feline.getKittens(), felineMock.getKittens());
    }
}