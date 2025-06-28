import com.example.Lion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;


import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Parameterized.Parameters(name = "Тестовые данные: пол={0}, ожидается мане={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самка", false},
                {"Самец", true}
        });
    }

    private String sex;
    private boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Mock
    private Feline feline;

    @Test
    public void testDoesHaveMane() throws Exception {

        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
