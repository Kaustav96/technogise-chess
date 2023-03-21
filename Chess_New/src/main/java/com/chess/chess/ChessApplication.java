package com.chess.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ChessApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(ChessApplication.class, args);
		PieceFactory pieceFactory = new PieceFactory();
		int ch = 1;

		while(ch!=0){
			System.out.print("Enter the name of piece for which moves will be generated: ");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String pieceName=br.readLine();

			Piece piece = pieceFactory.getPiece(pieceName);
			if(piece!=null) {
				System.out.print("Enter the current position ");
				String currentPosition = br.readLine();
				List<String> validMoves =
						piece.outputPossibleStates(currentPosition);
				System.out.println(validMoves.size() == 0
						? "No moves possible"
						: "Valid Moves are - " + validMoves);
			}
			System.out.println("Do you want to continue - ");
			ch = Integer.parseInt(br.readLine());
		}
		System.out.println("Thanks for playing..");
		System.exit(0);
	}

}
