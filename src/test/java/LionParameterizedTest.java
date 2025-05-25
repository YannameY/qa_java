import com.example.Lion;
import com.example.Predator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    String sex;
    boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Mock
    Predator predator;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самка", false},
                {"Самец", true}
        });
    }

    @Test
    public void testDoesHaveMane() throws Exception {

        Lion lion = new Lion(sex, predator);

        Lion mockedLion = Mockito.mock(Lion.class);
        if ("Самец".equals(sex)) {
            Mockito.when(mockedLion.doesHaveMane()).thenReturn(true);
        } else if ("Самка".equals(sex)) {
            Mockito.when(mockedLion.doesHaveMane()).thenReturn(false);
        }

        Assert.assertEquals(lion.doesHaveMane(), mockedLion.doesHaveMane());
    }

}