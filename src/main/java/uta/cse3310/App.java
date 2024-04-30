// This is example code provided to CSE3310 Fall 2022
// You are free to use as is, or changed, any of the code provided

package uta.cse3310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.ArrayList;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class App extends WebSocketServer {
  // All games currently underway on this server are stored in
  // the vector ActiveGames
  Vector<Game> ActiveGames = new Vector<Game>();
  Stats stats = new Stats();
  public ArrayList<User> nickNames = new ArrayList<User>();

  int GameId = 1;

  public App(int port) {
    super(new InetSocketAddress(port));
  }

  public App(InetSocketAddress address) {
    super(address);
  }

  public App(int port, Draft_6455 draft) {
    super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {

    System.out.println(conn.getRemoteSocketAddress().getAddress().getHostAddress() + " connected");

    ServerEvent E = new ServerEvent();

    // search for a game needing a player
    Game G = null;
    for (Game i : ActiveGames) {
      if (i.Players == uta.cse3310.PlayerType.NOPLAYER) {
        G = i;
        System.out.println("found a match");
      }
    }

    // No matches ? Create a new Game.
    if (G == null) {
      G = new Game(stats);
      stats.concurentGames++;

      G.GameId = GameId;
      GameId++;
      // Add the first player
      G.Players = uta.cse3310.PlayerType.Red;
      ActiveGames.add(G);
      System.out.println(" creating a new Game");
    } else {
      // join an existing game
      System.out.println(" not a new game");
      G.Players = uta.cse3310.PlayerType.Pink;
      G.StartGame();
    }
    System.out.println("G.players is " + G.Players);
    // create an event to go to only the new player
    E.YouAre = G.Players;
    E.GameId = G.GameId;
    // allows the websocket to give us the Game when a message arrives
    conn.setAttachment(G);

    Gson gson = new Gson();
    // Note only send to the single connection
    conn.send(gson.toJson(E));
    System.out.println(gson.toJson(E));

    // The state of the game has changed, so lets send it to everyone
    String jsonString;
    jsonString = gson.toJson(G);

    System.out.println(jsonString);
    broadcast(jsonString);

  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    System.out.println(conn + " has closed");
    // Retrieve the game tied to the websocket connection
    Game G = conn.getAttachment();
    if(ActiveGames.contains(G)){
      ActiveGames.remove(G); 
        if(stats.concurentGames > 0) { 
            stats.concurentGames--; 
        }
    }
    G = null;
  }

  @Override
  public void onMessage(WebSocket conn, String message) {
    System.out.println("message from front: " + message);
    JsonObject jsonMessage = JsonParser.parseString(message).getAsJsonObject();
    try {
        if (jsonMessage.has("nickname")) {
            
        }
    } catch (JsonSyntaxException e) {
        System.out.println("Error parsing JSON: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("General error: " + e.getMessage());
    }
    // Additional handling for UserEvent and game updates
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    UserEvent U = gson.fromJson(message, UserEvent.class);
    System.out.println(U.Button);

    // Get our Game Object
    Game G = conn.getAttachment();
    G.Update(U);

    // send out the game state every time
    // to everyone
    String jsonString;
    jsonString = gson.toJson(G);

    System.out.println(jsonString);
    broadcast(jsonString);
  }

  @Override
  public void onMessage(WebSocket conn, ByteBuffer message) {
    System.out.println(conn + ": " + message);
  }

  @Override
  public void onError(WebSocket conn, Exception ex) {
    ex.printStackTrace();
    if (conn != null) {
      // some errors like port binding failed may not be assignable to a specific
      // websocket
    }
  }

  @Override
  public void onStart() {
    System.out.println("Server started!");
    setConnectionLostTimeout(0);
  }

  public static void main(String[] args) {

    // Set up the http server
    //9003
    //9080
    int port = 9003;
    HttpServer H = new HttpServer(port, "./html");
    H.start();
    System.out.println("http Server started on port:" + port);

    // create and start the websocket server
    //9880
    //9103
    port = 9103;
    App A = new App(port);
    A.start();
    System.out.println("websocket Server started on port: " + port);

  }
}
