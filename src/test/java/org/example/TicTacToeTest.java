package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    @Test
    public void testHasWinnerReturnsTrueWhenPlayerWins(){
        TicTacToe game = new TicTacToe();

        game.getBoard().place(0,0,'X');
        game.getBoard().place(0,1,'X');
        game.getBoard().place(0,2,'X');

        assertEquals('X', game.getCurrentPlayer().getMarker());
        assertTrue(game.hasWinner(),"hasWinner sollte true zurueckgeben, wenn der Spieler X gewonnen hat.");
    }

    @Test
    public void testHasWinnerReturnsFalseWhenNoWin(){
        TicTacToe game = new TicTacToe();

        game.getBoard().place(0,0,'X');
        game.getBoard().place(0,1,'O');
        game.getBoard().place(0,2,'X');

        assertEquals('X',game.getCurrentPlayer().getMarker());
        assertFalse(game.hasWinner(),"hasWinner sollte false zurueckgeben, wenn kein Spieler gewonne hat.");
    }

}