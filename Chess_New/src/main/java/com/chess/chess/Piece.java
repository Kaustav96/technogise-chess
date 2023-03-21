package com.chess.chess;

import java.util.List;

public abstract class Piece {

    public static int A_ASCII = 'A';
    public static int H_ASCII = 'H';
    public boolean isValid(String stringPosition){
        if (stringPosition == null || stringPosition.length() != 2) {
            return false;
        }

        final char column = stringPosition.charAt(0);
        final char row = stringPosition.charAt(1);
        try {
            final int rowNumber = Integer.parseInt(String.valueOf(row));

            if (column < A_ASCII || column > H_ASCII || rowNumber < 1 || rowNumber > 8) {
                return false;
            }

            return true;
        } catch (IllegalArgumentException nfe) {
            throw new IllegalArgumentException("Incorrect Position " + stringPosition, nfe);
        }
    }

    public abstract List<String> outputPossibleStates(String currentPosition);
    public abstract List<String> getNewPosition(String currentPosition);

}
