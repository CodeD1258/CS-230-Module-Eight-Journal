package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 * Edited by Christopher Disla
 */
public class Team extends Entity {
    private List<Player> players = new ArrayList<>();  // List of players in the team

    /**
     * Constructor that initializes a team with a unique ID and a name.
     *
     * @param id The unique identifier of the team
     * @param name The name of the team
     */
    public Team(long id, String name) {
        super(id, name);  // Inherit from Entity class
    }

    /**
     * Adds a player to the team, ensuring the uniqueness of player names using the iterator pattern.
     * If a player with the same name exists, the existing player is returned.
     *
     * @param name The name of the player to be added
     * @return The newly created player or the existing player if a player with the same name exists
     */
    public Player addPlayer(String name) {
        // Iterator pattern to ensure uniqueness of player names
        for (Player existingPlayer : players) {
            if (existingPlayer.getName().equalsIgnoreCase(name)) {
                return existingPlayer;  // Return the existing player if name is taken
            }
        }

        // If no player with the same name exists, create a new player
        Player player = new Player(GameService.getInstance().getNextPlayerId(), name);
        players.add(player);
        return player;
    }

    /**
     * @return A string representation of the team, including its list of players
     */
    @Override
    public String toString() {
        return "Team [id=" + getId() + ", name=" + getName() + ", players=" + players + "]";
    }
}