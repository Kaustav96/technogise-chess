package com.chess.chess;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece{

    @Override
    public List<String> outputPossibleStates(String currentPosition) {

        if(!isValid(currentPosition)){
            throw new IllegalArgumentException("Incorrect Position " + currentPosition);
        }else{
            // pawn only moves one direction up
            List<String> newPosition = getNewPosition(currentPosition);
            return newPosition;
        }
    }

    @Override
    public List<String> getNewPosition(String currentPosition) {
        char currentRow = currentPosition.charAt(0);
        int rowNum = currentPosition.charAt(1)-'0';
        int newRowNum = (rowNum+1);
        String newPosition = currentRow+""+newRowNum;
        List<String> validMoves = new ArrayList<>();
        if(!isValid(newPosition)) {
                return validMoves;
        }
        validMoves.add(newPosition);
        return validMoves;
    }
}
