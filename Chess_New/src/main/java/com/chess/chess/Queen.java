package com.chess.chess;

import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    @Override
    public List<String> outputPossibleStates(String currentPosition) {
        if(!isValid(currentPosition)){
            throw new IllegalArgumentException("Incorrect Position " + currentPosition);
        }else{
            // Queen moves in all directions
            List<String> moves = getNewPosition(currentPosition);
            return moves;
        }
    }

    @Override
    public List<String> getNewPosition(String currentPosition) {
        int row = currentPosition.charAt(1) - '1';
        int col = currentPosition.charAt(0) - 'A';
        return getQueenMoves(row,col);
    }
    private List<String> getQueenMoves(int row, int col) {
        List<String> moves = new ArrayList<>();
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                if (dr != 0 || dc != 0) {
                    int r = row + dr;
                    int c = col + dc;
                    // queen can move all across the board
                    // checking for all other values of queen
                    while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                        moves.add((char)(c+'A')+""+(r+1));
                        if (r == row && c == col) {
                            break;
                        }
                        r += dr;
                        c += dc;
                    }
                }
            }
        }
        return moves;
    }


}
