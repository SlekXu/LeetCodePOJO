package Temp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Slek
 * @Date 2022/12/12 23:06
 * @Description
 */
public class JUCTest {


    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
    }
}
