package test;

import core.TestCase;
import demo.Calculator;
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

    public void testAdd() {
        calculator.add(5);
        Assert.isTrue(5 == calculator.getResult(), "testAdd is wrong!");
    }

    public void testSubtract() {
        calculator.add(10);
        calculator.subtract(5);
        Assert.isTrue(5 == calculator.getResult(), "testSubtract is wrong!");
    }

    public void testSub() {
        calculator.add(10);
        calculator.subtract(5);
        calculator.add(5);
        Assert.isTrue(5 == calculator.getResult(), "testSub is wrong!");
    }

    @Override
    public void setUp() {
        calculator = new Calculator();
    }

    @Override
    public void tearDown() {

    }
}
