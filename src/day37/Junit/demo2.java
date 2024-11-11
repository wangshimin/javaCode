package day37.Junit;

import org.junit.Assert;
import org.junit.Test;

public class demo2 {
    /*
    在实际开发中，如果想要测试一个方法是否正确，并不是直接在当前方法的上面写@Test方法，
    而是自己独立编写一个（没有main方法的）测试类，
    在测试类中，通过@Test注解，来调用被测试的方法，然后通过断言来判断是否正确。

    举例：测试demo1中的add方法
     */

    @Test
    public void addTest()
    {
        // result：方法实际的返回结果
        int result = new demo1().add(2, 10);// 调用被测试的方法
        // 预计结果：测试人员按照公司的业务逻辑去推导，这个方法应该返回什么结果。
        // 如果实际返回的结果和预计返回的结果是一样的，那么就认为测试通过，否则就认为测试不通过。

        // 断言，判断是否正确
        Assert.assertEquals("add方法出错了", 12, result);
    }
}
