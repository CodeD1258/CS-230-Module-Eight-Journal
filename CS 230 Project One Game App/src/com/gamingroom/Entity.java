package com.gamingroom;
/**
 * The Entity class is the foundational class for all entities within the system.
 * It contains the common attributes and behaviors shared across all entities 
 * (such as Game, Team, and Player) in the game. Each entity will have an id 
 * and a name to ensure its unique identification.
 *  @author Christopher Disla
 */
public class Entity {
    long id;      // Unique identifier for each entity (Game, Team, or Player)
    String name;  // Name of the entity (e.g., game name, team name, or player name)

    /**
     * Private constructor to prevent instantiation without providing necessary parameters.
     */
    private Entity() {}

    /**
     * Constructor that initializes the entity with a unique id and a name.
     *
     * @param id Unique identifier for the entity
     * @param name Name of the entity
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retrieves the unique identifier of the entity.
     *
     * @return the id of the entity
     */
    public long getId() {
        return id;
    }

    /**
     * Retrieves the name of the entity.
     *
     * @return the name of the entity
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the entity, including its id and name.
     *
     * @return a string representation of the entity
     */
    @Override
    public String toString() {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}
