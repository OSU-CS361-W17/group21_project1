package edu.oregonstate.cs361.battleship;


/**
 * Filename: newModel
 * Project: Battleship
 * Created by ksteinfeldt on 2/3/17.
 */

public class Ship {
    String type;
    int size;
    int x_coord;
    int y_coord;
    int orientation;

    public Ship(int option){
        if(option == 1){
            type = "Submarine";
            size = 2
        }
        else if(option == 2){
            type = "Destroyer";
            size = 2;
        }
        else if(option == 3){
            type = "Cruiser";
            size = 3;
        }
        else if(option == 4){
            type = "Battleship";
            size = 4;
        }
        else if(option == 5){
            type = "AircraftCarrier";
            size = 5;
        }
        else if(option == 11){
            type = "Computer_Submarine";
            size = 2;
        }
        else if(option == 12){
            type = "Computer_Destroyer";
            size = 2;
        }
        else if(option == 13){
            type = "Computer_Cruiser";
            size = 3;
        }
        else if(option == 14){
            type = "Computer_Battleship";
            size = 4;
        }
        else if(option == 15){
            type = "Computer_AircraftCarrier";
            size = 5;
        }
    }

}