package com.stackroute;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import regexdemo.BasicMathUtil;

import java.util.stream.Stream;

public class BasicMathUtilTest {

    private BasicMathUtil basicMathUtil;
    private int testInput;
    private int expectedOutput;
    private int actual;


    @BeforeEach
    public void setup(){
        basicMathUtil = new BasicMathUtil();
    }

    @AfterEach
    public void tearDown(){

        testInput = 0;
        expectedOutput =0;
        actual = 0;
    }

    public static Stream<Arguments> testDataProviderForSquare(){

        return Stream.of(
                Arguments.arguments(30,900),
                Arguments.arguments(-40,1600)
        );

    }



    @Tag("smoke")
    @Test
    public void testIfBasicMathUtilIsInstantiable(){
        Assertions.assertNotNull(new BasicMathUtil());
    }

    @Tag("regression")
    @Tag("sanity")
    @ParameterizedTest(name = "Test Invocation {index} with test data {0} and {1}") //means the test will take arguments
//    @CsvSource({"2,4","3,9","20,400","200,40000"}) //means test will take a string
//    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip=1)
    @MethodSource("testDataProviderForSquare")
    public void givenValidInputsSquareShouldReturnCorrectSquareValue_001(int input, int expected){

        actual = basicMathUtil.square(input);

        Assertions.assertEquals(expected, actual, "square should return correct square value for valid integer inputs");

    }


}

//    @Test
//    public void  testSquare_001(){
//
//        /**
//         *  AAA method
//         * Arrange --- prepare the objects, inputs and expected output required for testing the functional unit
//         * Act --- execute the functional unit that is under test
//         * Assert --- verify the result by comparing the actual outcome with the expected outcome
//         */
//
//
//    }
