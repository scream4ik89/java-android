import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRegEx extends Assert{
    Main main;
    @Before
    public void before(){
    main = new Main();
    }
    @After
    public void after(){
    main = null;
    }
    @Test
    public void testCarNumber(){
    boolean result = Main.checkCarNumber("2020 MP-7");
    assertTrue(result);
    }
    @Test
    public void testCarNumber2(){
    boolean result = Main.checkCarNumber("2020 AP-7");
    assertTrue(result);
    }
    @Test
    public void testCarNumber3(){
    boolean result = Main.checkCarNumber("20200 MP-7");
    assertFalse(result);
    }
    @Test
    public void testPhoneNumber1(){
    boolean result = Main.checkPhoneNumber("+375 (25) 942-67-44");
    assertTrue(result);
    }
    @Test
    public void testPhoneNumber2(){
    boolean result = Main.checkPhoneNumber("+375 (33) 942-67-44");
    assertTrue(result);
    }
    @Test
    public void testPhoneNumber3(){
    boolean result = Main.checkPhoneNumber("+375 (22) 942-67-44");
    assertFalse(result);
    }
}
