package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void testMarkerX(){
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }
    public void testMarkerO(){
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }


}