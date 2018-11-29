package com.android.rexben.associateexam1;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.addTwoNumbers(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void subtract() {
        double resultAdd = mCalculator.substractTwoNumbers(5, 3);
        assertThat(resultAdd, is(equalTo(2d)));
        int resSub = (int) mCalculator.substractTwoNumbers(100, 99);
        assertThat(resSub, is(equalTo(1)));
    }

    @Test
    public void divide() {
        double resultAdd = mCalculator.divideTwoNumbers(50, 5);
        assertThat(resultAdd, is(equalTo(10d)));
//        double resDivide = mCalculator.divideTwoNumbers(10, 0);
//        assertThat(resDivide, is(equalTo(Infinity)));
    }

    @Test
    public void multiply() {
        double resultAdd = mCalculator.multiplyTwoNumbers(10, 10);
        assertThat(resultAdd, is(equalTo(100d)));

        double resultZero = mCalculator.multiplyTwoNumbers(10, 0);
        assertThat(resultZero, is(equalTo(0d)));
    }


    @Test
    public void raisedTo() {
        double resultAdd = mCalculator.raiseToPower(2, 3);
        assertThat(resultAdd, is(equalTo(8d)));
    }
}
