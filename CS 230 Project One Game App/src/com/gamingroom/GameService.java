package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 * Edit by Christopher Disla
 * 
 * 
 * The Singleton pattern is used to ensure that only one instance of the
 * GameService class exists throughout the application. This design provides
 * a single, globally accessible point of control for managing active games.
 * By restricting instantiation to a single instance, we avoid duplication,
 * reduce memory overhead, and prevent potential conflicts in managing game data.
 * 
 * Characteristics of the Singleton pattern:
 * Single Instance: Guarantees that only one object of this class exists.
 * Global Access Point: Provides a centralized way to access the instance.
 * Lazy Initialization: The instance is created only when it is first needed.
 * 
 * The Iterator pattern is used within certain methods to traverse the list of
 * games efficiently. This design allows systematic and flexible access to
 * elements in the list without exposing its internal structure, improving
 * maintainability and scalability of the application.
 * 
 *
 * 
 */



public class GameService {
    
    private static List<Game> games = new ArrayList<>();  // List holding all the games
    private static long nextGameId = 1;                    // Variable to track the next available game ID
    private static long nextPlayerId = 1;                  // Variable to track the next available player ID
    private static long nextTeamId = 1;                    // Variable to track the next available team ID
    private static GameService instance;                   // Singleton instance of GameService

    // Private constructor to prevent the creation of multiple instances
    private GameService() {}

    /**
     * This method provides access to the single instance of the GameService class.
     * It follows the Singleton design pattern, ensuring only one instance exists at any given time.
     *
     * @return The single instance of GameService
     */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    /**
     * Adds a new game to the system. The game name is checked for uniqueness using the iterator pattern.
     * If a game with the same name already exists, the existing game is returned.
     *
     * @param name The name of the game to be added
     * @return The newly created game or the existing game if a game with the same name exists
     */
    public Game addGame(String name) {
        // Iterator pattern to ensure uniqueness of game names
        for (Game existingGame : games) {
            if (existingGame.getName().equalsIgnoreCase(name)) {
                return existingGame;  // Return the existing game if name conflict occurs
            }
        }

        // If no game with the same name exists, a new game is created
        Game game = new Game(nextGameId++, name);
        games.add(game);
        return game;
    }

    /**
     * Retrieves a game based on its unique ID. The iterator pattern is used to search for the game in the list.
     *
     * @param id The unique ID of the game to retrieve
     * @return The game matching the specified ID, or null if no such game exists
     */
    public Game getGame(long id) {
        // Iterator pattern to search for a game by its unique ID
        for (Game game : games) {
            if (game.getId() == id) {
                return game;  // Return the game if the ID matches
            }
        }
        return null;  // Return null if no game with the given ID is found
    }

    /**
     * Retrieves a game by its name. This method uses the iterator pattern to search the list of games.
     *
     * @param name The name of the game to retrieve
     * @return The game with the specified name, or null if no game matches
     */
    public Game getGame(String name) {
        // Iterator pattern to search for a game by name
        for (Game game : games) {
            if (game.getName().equalsIgnoreCase(name)) {
                return game;  // Return the game if a name match is found
            }
        }
        return null;  // Return null if no game matches the provided name
    }

    /**
     * Returns the total number of active games in the system.
     *
     * @return The number of games currently in the system
     */
    public int getGameCount() {
        return games.size();
    }
    
    public long getNextTeamId() {
        return nextTeamId++;  // Increment after returning the current value
    }

    public long getNextPlayerId() {
        return nextPlayerId++;  // Increment after returning the current value
    }
    
    // Other game, team, and player management methods would be added here
}
