package com.hook.utils.ListCompination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @date 2021-01-11
 * @author shajianbin
 * @version 1.0
 * @description  主要是对集合做排列组合操作
 */
public interface Combination {

    /*
     *对一维集合做自身的排列组合,自身做笛卡尔乘积。
     *      如:["1","2","3"]排列组合后结果为["1","2","3","11"，"12","13","21","22","23","31","32","33"]
     */
    LinkedList<Object> oneDimensionSelf(List<Object> list);

    /**
     * 对一维集合做自身排列组合(自身笛卡尔乘积).去重重复项
     *      如:["1","2","3"]排列组合后结果为["1","2","3","12","13","23"]
     */
    LinkedList<Object> oneDimensionSelfUnique(List<Object> list);

    /**
     * 将一个二维集合行列转换
     *      如:[[1,2,3],[4,5,6],[7,8,9]]行列转换后结果为:[[1,4,7],[2,5,8],[3,6,9]]
     */
    LinkedList<ArrayList<Object>> twoDimensionProcessionConvert(List<List<Object>> list);
}
