package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {
    public boolean find(List data1, List data2){
        try {
            data1.size();
            data2.size();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        if (data1.size() > data2.size()) return false;

        int numberMatchesRequired = data1.size();
        for (int i = 0; i < data1.size(); i++) {
            for (int j = 0; j < data2.size(); j++) {
                if(data1.get(i).equals(data2.get(j))){
                    numberMatchesRequired--;
                    break;
                }
            }
        }
        if (numberMatchesRequired == 0){
            return true;
        }
        else {
            return false;
        }
    }
}