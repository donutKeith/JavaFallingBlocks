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
public class CoordVal {
    private Color col;
    private int val;
    
    public CoordVal(){
        this(null, 0);
    }
    
    public CoordVal(int val){
        this.col = null;
        this.val = val;
    }
    
    public CoordVal(Color c, int v){
        this.col = c;
        this.val = v;
    }
    
    public Color getColor(){
        return this.col;
    }
    
    public int getVal(){
        return this.val;
    }
}
