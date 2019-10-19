package com.atguigu.gmall0513.mock.util;

/**
 * Created by LuFei on 2019/10/18
 * Author: LuFei
 */
public class RanOpt<T>{
    T value ;
    int weight;

    public RanOpt ( T value, int weight ){
        this.value=value ;
        this.weight=weight;
    }

    public T getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}
