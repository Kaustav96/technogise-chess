package com.chess.chess;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PawnTest {
    @Autowired
    private PieceFactory pieceFactory;
    @Autowired
    private Piece piece;

    @Before
    public void init(){
        pieceFactory = new PieceFactory();
    }
    @Test
    public void testPawnMoveInVerticalDirection(){

        piece = pieceFactory.getPiece("pawn");
        final List<String> validMoves = piece.outputPossibleStates("D5");
        assertThat(validMoves,hasSize(1));
        assertThat(validMoves, hasItems("D6"));
    }

    @Test
    public void testPawnNotMoveVerticalUpWhenAtEnd(){
        piece = pieceFactory.getPiece("pawn");
        final List<String> validMoves = piece.outputPossibleStates("A8");
        assertTrue(validMoves.size()==0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPawnPosition(){
        piece = pieceFactory.getPiece("pawn");
        piece.outputPossibleStates("A2A");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongValuePawnRow(){
        piece = pieceFactory.getPiece("pawn");
        piece.outputPossibleStates("A@");
    }

    @Test
    public void testWrongPiece(){
        piece = pieceFactory.getPiece("bishop");
        assertNull(piece);
    }
}
