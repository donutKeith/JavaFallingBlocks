/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;

/**
 *
 * @author home
 */
public class GamePiece {
    private CoordSystem pieceMap;
    private int[] bounds;
    private static final int NUM_BOUNDS = 4;
    public enum DIRECTION{
        LEFT, TOP, RIGHT, BOTTOM;
    }
    public GamePiece(CoordSystem cs){
        this.pieceMap = cs;
        this.bounds = new int[NUM_BOUNDS];
        
        //calcBounds();
    }
    
    public void rotate(boolean clockWise){
        this.pieceMap.rotate(clockWise);
    }
    
    public void calcBounds(){
        int[] lefts, tops, rights, bottoms;
        for(int y = 0; y < this.pieceMap.getHeight(); ++y){
            for (int x = 0; x < this.pieceMap.getWidth(); ++x){
                
            }
        }
    }
}
