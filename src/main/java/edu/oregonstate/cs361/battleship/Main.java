
package edu.oregonstate.cs361.battleship;

import spark.Request;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

public class Main {

    public static void main(String[] args) {
        //This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");

        //This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());
        //This will listen to POST requests and expects to receive a game model, as well as location to fire to
        post("/fire/:row/:col", (req, res) -> fireAt(req));
        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:id/:row/:col/:orientation", (req, res) -> placeShip(req));
    }
    //This function is just for random numbers
    private static int randNum(){
        int x = 0 + (int)(Math.random() * ((10 - 0) + 1));
        return x;
    }
    //This function should return a new model
    private static BattleshipModel newModel() {
        BattleshipModel model = new BattleshipModel();
        Gson gson = new Gson();


        return null;
    }

    //This function should accept an HTTP request and deseralize it into an actual Java object.
    private static BattleshipModel getModelFromReq(Request req){
        Gson gson = new Gson();
        String json = req.body();
        BattleshipModel gameInfo = gson.fromJson(json, BattleshipModel.class);
        return gameInfo;
    }

    //This controller should take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req) {
        Gson gson = new Gson();
        GameModel model = getModelFromReq(req);
        int x_start, y_start;
        string orientation, type;
        x_start = Integer.parseInt(req.params(":col"));
        y_start = Integer.parseInt(req.params(":row"));
        orientation = req.params("orientation");
        type = req.params(":id");
        if (type == 'aircraftCarrier'){
            model.player_aircraftCarrier.startPoint = new coord(x_start,y_start);
            model.player_aircraftCarrier.orient = orientation;
            if (orientation == 'horizontal'){
                model.player_aircraftCarrier.endpoint = new coord((x_start+5),y_start)
            }
            else {
                model.player_aircraftCarrier.endpoint = new coord(x_start,(y_start+5))
            }
        }
        else if (type == 'battleship'){
            model.player_battleship.startPoint = new coord(x_start,y_start);
            model.player_battleship.orient = orientation;
            if (orientation == 'horizontal'){
                model.player_battleship.endpoint = new coord((x_start+4),y_start)
            }
            else {
                model.player_battleship.endpoint = new coord(x_start,(y_start+4))
            }
        }
        else if (type == 'cruiser'){
            model.player_cruiser.startPoint = new coord(x_start,y_start);
            model.player_cruiser.orient = orientation;
            if (orientation == 'horizontal'){
                model.player_cruiser.endpoint = new coord((x_start+3),y_start)
            }
            else {
                model.player_cruiser.endpoint = new coord(x_start,(y_start+3))
            }
        }
        else if (type == 'destroyer'){
            model.player_destroyer.startPoint = new coord(x_start,y_start);
            model.player_destroyer.orient = orientation;
            if (orientation == 'horizontal'){
                model.player_destroyer.endpoint = new coord((x_start+2),y_start)
            }
            else {
                model.player_destroyer.endpoint = new coord(x_start,(y_start+2))
            }
        }
        else if (type == 'submarine'){
            model.player_submarine.startPoint = new coord(x_start,y_start);
            model.player_submarine.orient = orientation;
            if (orientation == 'horizontal'){
                model.player_submarine.endpoint = new coord((x_start+2),y_start)
            }
            else {
                model.player_submarine.endpoint = new coord(x_start,(y_start+2))
            }
        }
        return null;
    }

    //Similar to placeShip, but with firing.
    private static String fireAt(Response res, Request req) {
        Gson gson = new Gson();

        // get battleship model  from request
        GameModel model = getModelFromReq(req);

        Coord fire = new Coord(Integer.parseInt(req.params(":col")), Integer.parseInt(req.params(":row")));

        int x_start, y_start;
        string orientation, type;
        x_start = Integer.parseInt(req.params(":col"));
        y_start = Integer.parseInt(req.params(":row"));

//      shootrow = Integer.parseInt(req.params(":row"));
//      shootcol = Integer.parseInt(req.params(":col"));
//
//      Point shootpoint = new Point(shootrow, shootcol);


        orientation = req.params("orientation");
        type = req.paras(":id");

        Random num = new Random();

//        BattleshipModel.Ship[] user_ships = { model.player_aircraftCarrier, model.player_battleship,
//                                                model.player_cruiser, model.player_destroyer, model.player_submarine};
//
//        BattleshipModel.Ship[] AI_ships = { model.player_aircraftCarrier, model.player_battleship,
//                model.player_cruiser, model.player_destroyer, model.player_submarine};


        if (! checkRepeatFire(fire, model.playerHits, model.playerMisses)) {
            if (checkCollision(fire,model.player_aircraftCarrier, model.player_battleship,
                    model.player_cruiser, model.player_destroyer, model.player_submarine)) {
                model.playerHits.add(fire);
            } else {
                model.playerMisses.add(fire);
            }
        }

            Coordinate fireAI = new Coordinate(rand.nextInt(10) + 1, rand.nextInt(10) +1);

        if (checkCollision(fireAI,model.player_aircraftCarrier, model.player_battleship,
                model.player_cruiser, model.player_destroyer, model.player_submarine )) {
            model.computerHits.add(fireAI);
        } else {
            model.computerMisses.add(fireAI);
        }

        if (checkWin(model.playerHits, model.computerHits)) {
            model.ResetGame();
        }

        System.out.println(gson.toJson(model));
        return gson.toJson(model);
    }


    static boolean checkRepeatFire(Coordinate cord, List<Coordinate> hit, List<Coordinate> miss) {

        for (Coordinate aHit : hit) {
            if (cord.Across == aHit.Across && cord.Down == aHit.Down)
                return true;
        }
        for (Coordinate aMiss : miss) {
            if (cord.Across == aMiss.Across && cord.Down == aMiss.Down)
                return true;
        }
        return false;
    }

        //win?
        private static boolean checkWin(List<Coordinate> phits, List<Coordinate> chits){
            boolean playerWin=false;
            boolean computerWin=false;

            if(phits.size()==16)
                playerWin=true;

            if(chits.size()==16)
                computerWin=true;

            if(playerWin || (playerWin && computerWin)) {
                System.out.println("Game won by player");
                return true;
            }

    }

    }

}
