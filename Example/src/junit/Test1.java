package junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Test1 {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(timeout=4000)
    public void test1(){
        TestExample testExample = new TestExample();
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("amount must be greater than zero");
        testExample.test();
    }
}
