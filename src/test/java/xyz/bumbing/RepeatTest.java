package xyz.bumbing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import java.io.Serializable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//./mv
class RepeatTest {

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10,name = "{displayName}, {currentRepetition}/{totalRepetitions}")// placeholder 이름 지정 가능
    void repeatedTest(RepetitionInfo repetitionInfo){// RepetitionInfo 인자 받기 가능
        System.out.println(repetitionInfo.getCurrentRepetition()+"/"+repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("파라메터 테스트")
    @ParameterizedTest(name = "{displayName}, {index}, message1 = {0}")
    @ValueSource(strings = {"날씨가","많이","추워지고","있네요."})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void parameterizedTest(String message1){
        System.out.println(message1);
    }


    @DisplayName("파라메터 테스트")
    @ParameterizedTest(name = "{displayName}, {index}, message1 = {0}")
    @ValueSource(ints = {1,2,3})
    void convertTest(@ConvertWith(CustomConverter.class) String i){
        assertEquals(String.class,i.getClass(),"숫자를 문자열로 변환");
        System.out.println(i);
    }
    static class CustomConverter extends SimpleArgumentConverter{

        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            assertEquals(String.class, aClass,"can Only convert to String");
            return o!=null?o.toString():null;
        }
    }

    @DisplayName("파라메터 테스트")
    @ParameterizedTest(name = "{displayName}, {index}, message1 = {0}")
    @CsvSource("10,'test',20,'test2'")
    void convertTest(Integer i, String name){
        System.out.println(i);
    }


    @DisplayName("파라메터 테스트")
    @ParameterizedTest(name = "{displayName}, {index}, message = {0}")
    @CsvSource({"10,'test'","20,'test2'"})
    void convertTest(@AggregateWith(CustomAggregator.class) List<Object> list){
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
    static class CustomAggregator implements ArgumentsAggregator{

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return List.<Object>of(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }
}