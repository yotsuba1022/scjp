package idv.carl.scjp.generics.basics;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author Carl Lu
 */
public class GenericMethodClass {

    public static <T> void staticGenericMethod(T input) {
        System.out.println("Input type: " + input.getClass().getName());
    }

    public static <T> T parseObject(String input, Class<T> clazz) {
        return JSON.parseObject(input, clazz);
    }

    public static <T> List<T> parseArray(String response, Class<T> object) {
        List<T> modelList = JSON.parseArray(response, object);
        return modelList;
    }

    public static <T> T[] parseGenericArray(T... input) {
        return input;
    }

    public <T> void instanceGenericMethod(T input) {
        System.out.println("Input type: " + input.getClass().getName());
    }

}
