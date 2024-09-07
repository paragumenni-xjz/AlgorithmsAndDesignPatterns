package com.xjz.leetcode;

import com.xjz.leetcode.pojo.Student;
import com.xjz.leetcode.pojo.User;
import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        int comparable = comparable(new Student("qqq", 13), new User("www", 15), Student::getName, User::getName);
        System.out.println(comparable);
    }

    public static <T,R,U extends Comparable<? super U>> int comparable(T t, R r, Function<T,U> obj1, Function<R,U> obj2){
        return ObjectUtils.compare(obj1.apply(t), obj2.apply(r));
    }
}
