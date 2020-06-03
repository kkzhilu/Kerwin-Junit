package test;

import core.TestCase;
import demo.Calculator;
import exception.GeneralException;
import validated.Assert;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/6/3 14:24
 * description:  CalculatorTest Test测试类
 * version:      V1.0
 * ******************************
 */
public class CalculatorTest extends TestCase {

    Calculator calculator = null;

    public void testAdd() throws GeneralException {
        calculator.add(5);
        Assert.isTrue(5 == calculator.getResult(), "testAdd is wrong!");
    }

    public  void testSubtract() throws GeneralException {
        calculator.add(10);
        calculator.subtract(5);
        Assert.isTrue(5 == calculator.getResult(), "");
    }

    @Override
    public void setUp() {
        calculator = new Calculator();
    }

    @Override
    public void tearDown() {

    }
}
