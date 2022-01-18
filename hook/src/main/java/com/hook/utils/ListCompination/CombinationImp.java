package com.hook.utils.ListCompination;

import com.hook.message.ErrorCodeAndMessage;
import com.hook.message.GlobalException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @auth A-8626
 * @date 2022年01月11日  20:38
 **/
public class CombinationImp implements Combination {

    @Override
    public LinkedList<Object> oneDimensionSelf(List<Object> list) {

        if(list.size() == 0){
            throw new GlobalException(ErrorCodeAndMessage.LIST_NOT_NULL);
        }

        LinkedList<Object> linkedList = new LinkedList<>();

        for (int i=0;i<list.size();i++){
            linkedList.add(list.get(i));

            for (Object o : list) {
                linkedList.add(list.get(i)+"@@"+o);
            }
        }
        return linkedList;
    }

    /**
     * 对一维集合做自身排列组合(自身笛卡尔乘积).去重重复项
     *
     * @param list
     */
    @Override
    public LinkedList<Object> oneDimensionSelfUnique(List<Object> list) {

        if(list.size() == 0){
            throw new GlobalException(ErrorCodeAndMessage.LIST_NOT_NULL);
        }

        LinkedList<Object> linkedList = new LinkedList<>();

        for(int i = 0;i<list.size();i++){
            linkedList.add(list.get(i));
                for (int j = i+1;j<list.size();j++){
                    linkedList.add(list.get(i)+"@@"+list.get(j));
                }
        }
        return linkedList;
    }

    /**
     * 将一个二维集合行列转换
     * 如:[[1,2,3],[4,5,6],[7,8,9]]行列转换后结果为:[[1,4,7],[2,5,8],[3,6,9]]
     *
     * @param list
     */
    @Override
    public LinkedList<ArrayList<Object>> twoDimensionProcessionConvert(List<List<Object>> list) {

        LinkedList<ArrayList<Object>> linkedList = new LinkedList<ArrayList<Object>>();
            if(list.size() ==0){
                throw  new GlobalException(ErrorCodeAndMessage.LIST_NOT_NULL);
            }

            //将list分割开
        LinkedHashMap<String,ArrayList> listLinkedHashMap = new LinkedHashMap<>();

            for(int i =0;i<list.size();i++){
                listLinkedHashMap.put("linkedHash_"+i, (ArrayList) list.get(i));
                System.out.println(listLinkedHashMap);
            }

            for (int j=0;j<list.get(0).size();j++){
                ArrayList<Object> arrayList = new ArrayList<>();
                for (int k=0;k<listLinkedHashMap.size();k++){
                    arrayList.add(listLinkedHashMap.get("linkedHash_"+k).get(j));
                }
                linkedList.add(arrayList);
            }
        return linkedList;
    }


}
