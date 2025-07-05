package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void testIsCellEmptyReturnsTrueForEmptyCell(){
        Board board = new Board();
        board.clear();
        assertTrue(board.isCellEmpty(1,1),"Die Zelle (1,1) sollte leer sein.");
    }
    @Test
    public void testPlaceThrowsExceptionWhenCellOccupied(){
        Board board = new Board();
        board.place(0,0,'O');

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.place(0,0,'O');
        });
        assertEquals("Cell is already occupied!", exception.getMessage());
    }
    @Test
    public void testClearSetsAllCellIsEmtpy(){
        Board board = new Board();
        board.clear();
        board.place(1,1,'O');
        assertFalse(board.isCellEmpty(1,1));
    }
    @Test
    public void testIsFullReturnsFalseIfAnyCellEmpty(){
        Board board = new Board();
        board.clear();
        board.place(0,0,'X');
        assertFalse(board.isFull());
    }

}