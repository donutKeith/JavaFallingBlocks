/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fallingblocks;
import java.awt.Graphics;
/**
 *
 * @author home
 */
public class CoordSysDrawer {
    private int screenXAnchor, screenYAnchor;

    public CoordSysDrawer(int screenX, int screenY){
        this.screenXAnchor = screenX;
        this.screenYAnchor = screenY;
    }
    
    public void setAnchor(int x, int y){
        this.screenXAnchor = x;
        this.screenYAnchor = y;
    }
    
    public void draw(Graphics g, CoordSystem cs){
        
    }
}
