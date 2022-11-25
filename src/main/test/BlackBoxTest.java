import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackBoxTest {

    Game game;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    void test1() {
        Trainer t = new Trainer();
        Attack att = new Attack(t, Round.Time.DAY);
        assertTrue(true);

    }

}
