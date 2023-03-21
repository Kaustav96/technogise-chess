package com.chess.chess;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class QueenTest {
    @Autowired
    private PieceFactory pieceFactory;
    @Autowired
    private Piece piece;

    @Before
    public void init(){
        pieceFactory = new PieceFactory();
    }

    @Test
    public void queenCanMoveInAllDirections(){
        piece = pieceFactory.getPiece("queen");
        final List<String> validMoves = piece.outputPossibleStates("E4");
        assertTrue(validMoves.size()==27);
        assertThat(validMoves, hasItems("E5","E6","E7","E8","E3","E2","E1","F4","G4",
                "H4","D4","C4","B4","A4","D3","C2","B1","F5","G6","H7","D5","C6","B7","A8","F3","G2","H1"));
    }

    @Test
    public void queenCanMoveInAllDirectionsIfPossible(){
        piece = pieceFactory.getPiece("queen");
        final List<String> validMoves = piece.outputPossibleStates("A2");

        assertTrue(validMoves.size()==21);
        assertThat(validMoves, hasItems("A3", "A4", "A5", "A6", "A7", "A8", "A1",
                "B2", "C2", "D2", "E2", "F2", "G2", "H2", "B3", "C4", "D5", "E6", "F7", "G8", "B1"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidQueenPosition(){
        piece = pieceFactory.getPiece("queen");
        piece.outputPossibleStates("A2A");
    }
    @Test
    public void testWrongPiece(){
        piece = pieceFactory.getPiece("bishop");
        assertNull(piece);
    }
}
