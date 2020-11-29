package com.tsystems.javaschool.tasks.pyramid;

import java.util.Collections;
import java.util.List;

public class PyramidBuilder {
    public int[][] buildPyramid(List<Integer> integerList){
        for (Integer i: integerList
             ) {
            if (i == null) throw new CannotBuildPyramidException();
        }

        Collections.sort(integerList);
        int numberOfLines = numberLines(integerList);
        int numberOfColumns = 2 * numberOfLines - 1;
        int pos = 0;
        
        int[][]pyramid = new int[numberOfLines][numberOfColumns];
        for (int i = 0; i < numberOfLines; i++) {
            int columnPosition = (numberOfColumns + 1) / 2 - (i + 1);
            for (int j = 1; j <= i + 1; j++) {
                pyramid[i][columnPosition] = integerList.get(pos);
                columnPosition += 2;
                pos++;
            }
        }
        return pyramid;
    }

    private int numberLines(List<Integer> integerList) {
        int n = 0;
        int lines = 0;
        int sizeList = integerList.size();
        while (sizeList > 0){
            sizeList = sizeList - (n + 1);
            lines++;
            n++;
        }
        if (sizeList != 0) throw new CannotBuildPyramidException();
        return lines;
    }
}