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
public class CoordSystem {
    private CoordVal[][] coordSys;
    private int width, height;
    private int[] origin;
    private static final int X = 0;
    private static final int Y = 1;
    private static final int rot_degree = 90;
    
    public CoordSystem(int width, int height, CoordVal fill){
        this(width, height, fill, 0, height - 1);
    }
    
    public CoordSystem(CoordVal[][] map){
        this(map, 0, map.length-1);
    }
    
    public CoordSystem(CoordVal[][] map, int originX, int originY){
        this.coordSys = map;
        this.height = map.length;
        this.width = map[0].length;
        this.origin = new int[2];
        this.origin[X] = originX;
        this.origin[Y] = originY;
    }
    
    public CoordSystem(int width, int height, CoordVal fill, int originX, int originY){
        this.width=width;
        this.height=height;
        this.origin = new int[2];
        this.origin[X] = originX;
        this.origin[Y] = originY;
        this.coordSys = new CoordVal[this.height][this.width];
        for(int i = 0; i < this.height; i++){
            for(int j = 0; j < this.width; j++){
                this.coordSys[i][j] = fill;
            }
        }
    }
    
    public CoordVal[][] copy(CoordVal[][] a){
        CoordVal[][] ret = new CoordVal[a.length][];
        for(int row = 0; row < a.length; ++row){
            ret[row] = new CoordVal[a[row].length];
            System.arraycopy(a[row], 0, ret[row], 0, a[row].length);
        }
        return ret;
    }
    
    private int[] ConvertCoordToIndex(int coordX, int coordY){
        int[] ret = new int[2];
        ret[X] = coordX + this.origin[X];
        ret[Y] = -coordY + this.origin[Y];
        return ret;
    }
    
    private int[] ConvertIndexToCoord(int indexX, int indexY){
        int[] ret = new int[2];
        ret[X] = indexX - this.origin[X];
        ret[Y] = -indexY + this.origin[Y];
        return ret;
    }
    
    public CoordVal[][] putMap(CoordSystem map, int xCoord, int yCoord){
        CoordVal[][] unionMap = copy(this.coordSys);
        int[] localStart;
        localStart = ConvertCoordToIndex(xCoord, yCoord);
        localStart[X] = localStart[X] - map.origin[X];
        localStart[Y] = localStart[Y] - map.origin[Y];
        for (int y = 0, curLocalY = localStart[Y]; y < map.getHeight(); y++, curLocalY++){
            for (int x = 0, curLocalX = localStart[X]; x < map.getWidth(); x++, curLocalX++){
                if (curLocalY < this.getHeight() && curLocalY >= 0 && curLocalX < this.getWidth() && curLocalX >= 0 ){
                    unionMap[curLocalY][curLocalX] = map.coordSys[y][x];
                }
            }
        }
        return unionMap;
    }
    
    public boolean checkCollision(CoordSystem map, int xdir, int ydir){
        for(int y = 0; y < map.getHeight(); ++y){
            for(int x = 0; x < map.getWidth(); ++x){
                if (map.coordSys[y][x] == PieceFactory.F){
                    if(){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void DisplayMap(){
        DisplayMap(this.coordSys);
    }
    
    public void DisplayMap(CoordVal[][] map){
        for(CoordVal[] row: map){
            for(CoordVal cell: row){
                System.out.print(cell.getVal());
            }
            System.out.println();
        }
    }
    
    public CoordVal get(int x, int y){
        return get(x, y, true);
    }
    
    public CoordVal get(int x, int y, boolean isCoord){
        if (isCoord){
            int[] temp = ConvertCoordToIndex(x, y);
            return this.coordSys[temp[Y]][temp[X]];
        }
        else{
            return this.coordSys[y][x];
        }
    }
    
    public void set(int x, int y, CoordVal val){
        int[] coords = ConvertCoordToIndex(x, y);
        this.coordSys[y][x] = val;
    }
    
    public int getWidth(){
        return this.width;
    }
    
    public int getHeight(){
        return this.height;
    }
    
    public void rotate(){
        rotate(true);
    }
    
    public void rotate(boolean clockwise){
        int degree;
        if (clockwise){
            degree = -rot_degree;
        }
        else{
            degree = rot_degree;
        }
        int sin_degree = (int) Math.sin(Math.toRadians(degree));
        int cos_degree = (int) Math.cos(Math.toRadians(degree));
        int[] coords = new int[2];
        int rotX, rotY;
        CoordVal[][] rot_version = copy(this.coordSys);
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                coords = ConvertIndexToCoord(x, y);
                rotX = (coords[X] * cos_degree) - (coords[Y] * sin_degree);
                rotY = (coords[X] * sin_degree) + (coords[Y] * cos_degree);
                coords = ConvertCoordToIndex(rotX, rotY);
                rot_version[coords[Y]][coords[X]] = this.coordSys[y][x];
            }
        }
        this.coordSys = rot_version;
    }
}
