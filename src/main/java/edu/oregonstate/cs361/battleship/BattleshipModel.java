package edu.oregonstate.cs361.battleship;

/**
 * Created by michaelhilton on 1/26/17.
 */
public class BattleshipModel {
  //class ship names
  public Ship player_aircraftCarrier;
  public Ship player_battleship;
  public Ship player_cruiser;
  public Ship player_destroyer;
  public Ship player_submarine;
  public Ship computer_aircraftCarrier;
  public Ship computer_battleship;
  public Ship computer_cruiser;
  public Ship computer_destroyer;
  public Ship computer_submarine;

  //class
  public ArrayList<coord> player_hits;
  public ArrayList<coord> player_misses;
  public ArrayList<coord> computer_hits;
  public ArrayList<coord> computer_misses;

  public BattleshipModel() {
    //initialize game info
    this.player_aircraftCarrier = new Ship("aircraftCarrier", 5, new coord(0, 0), new coord(0, 0),'horizontal');
    this.player_battleship = new Ship("battleship", 4, new coord(0, 0), new coord(0, 0), 'horizontal');
    this.player_cruiser = new Ship("cruiser", 3, new coord(0, 0), new coord(0, 0), 'horizontal');
    this.player_destroyer = new Ship("destroyer", 2, new coord(0, 0), new coord(0, 0), 'horizontal');
    this.player_submarine = new Ship("submarine", 2, new coord(0, 0), new coord(0, 0), 'horizontal');

    this.computer_aircraftCarrier = new Ship("aircraftCarrier", 5, new coord(2, 2), new coord(2, 7), 'vertical');
    this.computer_battleship = new Ship("battleship", 4, new coord(2, 8), new coord(6, 8), 'horizontal');
    this.computer_cruiser = new Ship("cruiser", 3, new coord(4, 1), new coord(4, 4), 'vertical');
    this.computer_destroyer = new Ship("destroyer", 2, new coord(7, 3), new coord(7, 5), 'vertical');
    this.computer_submarine = new Ship("submarine", 2, new coord(9, 6), new coord(9, 8), 'vertical');

    this.player_hits = new ArrayList<coord>();
    this.player_misses = new ArrayList<coord>();
    this.computer_hits = new ArrayList<coord>();
    this.computer_misses = new ArrayList<coord>();

  }
}
