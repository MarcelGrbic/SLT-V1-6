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
    @Test
    public void testSwitchCurrentPlayerChangesPlayer(){
        TicTacToe game = new TicTacToe();
        Player first = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        assertNotEquals(first, game.getCurrentPlayer(),"Der aktuelle Spieler sollte gewchselt worden sein.");
    }
    @Test
    public void tetSwitchCurrentPlayerTwiceReturnsOriginalPlayer(){
        TicTacToe game = new TicTacToe();
        Player first = game.getCurrentPlayer();
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals(first, game.getCurrentPlayer(), "Nach zwei Wechsel sollte der urspruengliche Spieler wieder dran sein.");
    }
    @Test
    public void testGetBoardNotNull(){
        TicTacToe game = new TicTacToe();
        assertNotNull(game.getBoard(), "Das Spielfeld sollte nicht null sein.");
    }
    @Test
    public void testGetBoardConsistency(){
        TicTacToe game = new TicTacToe();
        Board board = game.getBoard();
        board.place(1,1,'O');
        assertEquals('O',game.getBoard().getCell(1,1),"Aenderung am Board sollte erhalen bleiben.");
    }
    @Test
    public void testCurrentPlayerInitialIsPlayer1(){
        TicTacToe game = new TicTacToe();
        assertEquals('X',game.getCurrentPlayer().getMarker(),"Der erste Spieler sollte X sein");
    }
    @Test
    public void testCurrentPlayerNotNull(){
        TicTacToe game = new TicTacToe();
        assertNotNull(game.getCurrentPlayer(),"Der aktuelle Spieler sollte nciht null sein.");
    }

}