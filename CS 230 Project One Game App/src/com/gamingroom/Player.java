package com.gamingroom;

/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 * @author coce@snhu.edu
 *Edited by Christopher Disla
 *
 */
public class Player extends Entity {

    /**
     * Constructor that initializes a player with a unique ID and a name.
     *
     * @param id The unique identifier of the player
     * @param name The name of the player
     */
    public Player(long id, String name) {
        super(id, name);  // Inherit from Entity class
    }

    /**
     * @return A string representation of the player with its ID and name
     */
    @Override
    public String toString() {
        return "Player [id=" + getId() + ", name=" + getName() + "]";
    }
}