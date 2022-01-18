package com.hook.utils.ListCompination;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CombinationImpTest {


    @Test
    void oneDimensionSelf() {
        List<Object> arrayList1 = new ArrayList<>();
        arrayList1.add("A");
        arrayList1.add("B");
        arrayList1.add("C");
        arrayList1.add("D");
        arrayList1.add("E");

        List<Object> arrayList2 = new ArrayList<>();
        arrayList2.add("F");
        arrayList2.add("G");
        arrayList2.add("H");
        arrayList2.add("I");
        arrayList2.add("J");

        List<Object> arrayList3 = new ArrayList<>();
        arrayList3.add("K");
        arrayList3.add("L");
        arrayList3.add("M");
        arrayList3.add("N");
        arrayList3.add("O");

        List<Object> arrayList4 = new ArrayList<>();
        arrayList4.add("P");
        arrayList4.add("Q");
        arrayList4.add("R");
        arrayList4.add("S");
        arrayList4.add("T");

        List<List<Object>> arrayList = new ArrayList<>();
            arrayList.add(arrayList1);
            arrayList.add(arrayList2);
            arrayList.add(arrayList3);
            arrayList.add(arrayList4);

        CombinationImp combinationImp = new CombinationImp();
        LinkedList<ArrayList<Object>> linkedList = combinationImp.twoDimensionProcessionConvert(arrayList);
        for (Object o : linkedList) {
            System.out.println(o);
        }
    }
}