/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;
import java.awt.Color;
/**
 * @author home
 */
public class PieceFactory {
    static final CoordVal E = new CoordVal(0);
    static final CoordVal F = new CoordVal(Color.RED, 0);
    static final CoordVal[][] z_piece = {
        {E, E, E, E, E},
        {E, F, F, E, E},
        {E, E, F, F, E},
        {E, E, E, E, E},
        {E, E, E, E, E}
    };
    static final CoordVal[][] s_piece = {
        {E, E, E, E, E},
        {E, E, F, F, E},
        {E, F, F, E, E},
        {E, E, E, E, E},
        {E, E, E, E, E}
    };
    static final CoordVal[][] l_piece = {
        {E, E, F, E, E},
        {E, E, F, E, E},
        {E, E, F, F, E},
        {E, E, E, E, E},
        {E, E, E, E, E}
    };
    static final CoordVal[][] r_piece = {
        {E, E, F, E, E},
        {E, E, F, E, E},
        {E, F, F, E, E},
        {E, E, E, E, E},
        {E, E, E, E, E}
    };
    static final CoordVal[][] t_piece = {
        {E, E, E, E, E},
        {E, E, E, E, E},
        {E, F, F, F, E},
        {E, E, F, E, E},
        {E, E, E, E, E}
    };
    static final CoordVal[][] o_piece = {
        {E, E, E, E, E},
        {E, E, F, F, E},
        {E, E, F, F, E},
        {E, E, E, E, E},
        {E, E, E, E, E}
    };
    static final CoordVal[][] i_piece = {
        {E, E, F, E, E},
        {E, E, F, E, E},
        {E, E, F, E, E},
        {E, E, F, E, E},
        {E, E, E, E, E}
    };
    
    private static final CoordVal[][][] pieceList = {
        z_piece, 
        s_piece, 
        t_piece,
        l_piece,
        r_piece,
        t_piece,
        o_piece,
        i_piece
    };
    
    private int randomNumBetween(int min, int max){
        return randomNumBetween(min, max, true, true);
    }
    
    private int randomNumBetween(int min, int max, boolean lowerInc, boolean upperInc){
        // Swap min and max if needed (fix user error)
        if (min > max){
            max = max + min;
            min = max - min;
            max = max - min;
        }
        
        if (!lowerInc){
            min++;
        }
        if (!upperInc){
            max--;
        }
        // Math.random() = Random number between 0 and 1
        // random number can be thought of as % between min and max 0 = min 1 = max
        return (int) ( min + (( max - min ) * Math.random()) );
    }
    
    public GamePiece genrate(int id){
        if (id < 0 || id >= pieceList.length){
            id = randomNumBetween(0, pieceList.length - 1);
        } 
        return new GamePiece(new CoordSystem(pieceList[id], 2, 2));
    }
}
