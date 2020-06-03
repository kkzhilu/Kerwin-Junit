package demo;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/6/3 14:18
 * description:  计算Demo类
 * version:      V1.0
 * ******************************
 */
public class Calculator {

    private int result = 0;

    public void add(int value){
        result += value;
    }

    public void subtract(int value){
        result -= value;
    }

    public int getResult(){
        return result;
    }
}
