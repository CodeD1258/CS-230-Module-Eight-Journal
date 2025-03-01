package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 * Edited by Christopher Disla
 */
public class Game extends Entity {
    private List<Team> teams; // List to hold the teams in the game

    // Constructor to initialize the teams list
    public Game(long id, String name) {
        super(id, name);  // Calling the constructor of the Entity class
        teams = new ArrayList<>(); // Initialize the list of teams
    }

    // Add team method
    public Team addTeam(String name) {
        // Use iterator pattern to ensure unique team names
        for (Team existingTeam : teams) {
            if (existingTeam.getName().equalsIgnoreCase(name)) {
                return existingTeam;  // Return the existing team if name matches
            }
        }

        // If no team with the same name exists, create a new team
        Team team = new Team(GameService.getInstance().getNextTeamId(), name);
        teams.add(team); // Add the new team to the list
        return team;
    }

    // Getter for teams
    public List<Team> getTeams() {
        return teams;
    }
}
