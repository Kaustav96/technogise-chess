package com.chess.chess;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import java.util.List;

public class KingTest {

    @Autowired
    private PieceFactory pieceFactory;
    @Autowired
    private Piece piece;

    @Before
    public void init(){
        pieceFactory = new PieceFactory();
    }
    @Test
    public void testKingMove8Directions(){

        piece = pieceFactory.getPiece("king");
        final List<String> validMoves = piece.outputPossibleStates("D5");
        assertThat(validMoves,hasSize(8));
        assertThat(validMoves, hasItems("C6", "D6", "E6", "E5", "E4", "D4", "C4", "C5"));
    }

    @Test
    public void testKingMoveFromCorner(){
        piece = pieceFactory.getPiece("king");
        final List<String> validMoves = piece.outputPossibleStates("A8");
        assertThat(validMoves,hasSize(3));
        assertThat(validMoves, hasItems("B8", "B7", "A7"));
    }
    @Test
    public void testKingMoveFromCloseToCorner(){
        piece = pieceFactory.getPiece("king");
        final List<String> validMoves = piece.outputPossibleStates("H4");
        assertThat(validMoves,hasSize(5));
        assertThat(validMoves, hasItems("H5", "G5", "G4", "G3", "H3"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidKingPosition(){
        piece = pieceFactory.getPiece("king");
        piece.outputPossibleStates("A2A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongValueKingRow(){
        piece = pieceFactory.getPiece("king");
        piece.outputPossibleStates("A@");
    }

    @Test
    public void testWrongPiece(){
        piece = pieceFactory.getPiece("bishop");
        assertNull(piece);
    }
}
