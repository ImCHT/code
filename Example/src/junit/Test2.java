package junit;

import org.junit.Assert;
import org.junit.Test;

public class Test2 {
    @Test
    public void test1(){
        int a = 1,b = 2;
        Assert.assertEquals(3,a+b);
    }
}
