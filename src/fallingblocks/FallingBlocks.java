/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

import java.awt.Color;

/**
 *
 * @author home
 */
public class FallingBlocks {

    /**
     * @param args the command line arguments
     */

 
    public static void main(String[] args) {
        // TODO code application logic here
        CoordSystem board = new CoordSystem(10, 20, new CoordVal(Color.BLACK, 0));
        board.DisplayMap();
    }
    
}
