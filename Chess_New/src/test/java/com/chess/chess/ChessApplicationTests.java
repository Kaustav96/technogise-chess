package com.chess.chess;

import jdk.jfr.internal.tool.Main;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class ChessApplicationTests {


	@Test
	void contextLoads() {
		PieceFactory pieceFactory = new PieceFactory();
		Piece piece = pieceFactory.getPiece("bishop");
		Assert.assertNull(piece);
	}
}
