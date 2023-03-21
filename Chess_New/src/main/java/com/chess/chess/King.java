package com.chess.chess;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class King extends Piece {
    private static int[] dx = {-1,1,0,0,-1,-1,1,1};
    private static int[] dy = {0,0,1,-1,1,-1,1,-1};
    @Override
    public List<String> outputPossibleStates(String currentPosition) {
        if(!isValid(currentPosition)){
            throw new IllegalArgumentException("Incorrect Position " + currentPosition);
        }else{
            // king moves in 8 directions
            List<String> newPosition = getNewPosition(currentPosition); //getKingMoves(row,col);
            Collections.sort(newPosition);
            return newPosition;
        }
    }

    @Override
    public List<String> getNewPosition(String currentPosition) {
        // king moves in 8 directions
        char currentRow = currentPosition.charAt(0);
        int currentRowNum = currentPosition.charAt(1)-'0';
        List<String> validMoves = new ArrayList<>();
        for(int i=0;i<8;i++){
            char newRowVal = (char) (currentRow+dx[i]);
            int newRowNum = currentRowNum + dy[i];
            String newRow = newRowVal+""+newRowNum;
            if(isValid(newRow)){
                validMoves.add(newRow);
            }
        }
        return validMoves;
    }
}
