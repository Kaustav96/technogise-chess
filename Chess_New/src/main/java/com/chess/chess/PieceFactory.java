package com.chess.chess;

public class PieceFactory {

    public Piece getPiece(String pieceType){
        if(pieceType == null) return null;

        if (pieceType.equalsIgnoreCase("pawn")){
            return new Pawn();
        }
        if (pieceType.equalsIgnoreCase("king")){
            return new King();
        }
        if (pieceType.equalsIgnoreCase("queen")){
            return new Queen();
        }
        return  null;
    }
}
