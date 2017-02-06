
package edu.oregonstate.cs361.battleship;


/**
 * Filename: newModel
 * Project: Battleship
 * Created by ksteinfeldt on 2/3/17.
 */

public class Ship {
    String type, orient;
    int length;
    int x_coord;
    int y_coord;

    /**************
    Class Functions
    ***************/
    // Getters
    public int getSize(){
        return length;
    }
    public int getX_coord(){
        return x_coord;
    }
    public int getY_coord(){
        return y_coord
    }
    public int getOrientation(){
        return orient
    }
    // Setters
    public void setSize(int in){
        size = in;
    }
    public coords setCoords(int xin, int yin){
        start_coords = new coordSet(xin,yin)
    }


    // Ship Constructor
    public Ship(string id, int size, coord startCoord, coord endCoord,orient){
        type = id;
        length = size;
        startPoint = startCoord;
        endPoint = endCoord;
        orient = orientation;
        }
    }
