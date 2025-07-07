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
    @Test
    public void testPlaceInsertsMarkerCorrectly(){
        Board board = new Board();
        board.place(1,1,'X');
        assertEquals('X',board.getCell(1,1),"Marker sollte korrekt gesetzt werden.");
    }
    @Test
    public void testClearResetsBoard(){
        Board board = new Board();
        board.place(0,0,'O');
        board.clear();
        assertTrue(board.isCellEmpty(0,0),"Nach dem loeschen sollte die Zelle leer sein.");
    }
    @Test
    public void testIsFullReturnsTrueIfBoardIsFull(){
        Board board = new Board();
        char mark = 'X';
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            board.place(i,j,mark);
               assertTrue(board.isFull(),"Das Board sollte voll sein.");

    }
    @Test
    public void testGetCellReturnsCorrectMarker(){
        Board board = new Board();
        board.place(2,1,'O');
        assertEquals('O',board.getCell(2,1),"Marker sollte gesezt sein.");
    }
    @Test
    public void testGetCellReturnsEmptyIfUnoccupied(){
        Board board = new Board();
        assertEquals(' ',board.getCell(0,0),"Leere Zelle sollte ' ' zurueckgeben.");
    }

}