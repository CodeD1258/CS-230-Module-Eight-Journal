package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 * Edit by Christopher Disla
 */
import java.util.Scanner;

public class ProgramDriver {

    public static void main(String[] args) {
        // Obtain the singleton instance of GameService
        GameService service = GameService.getInstance();

        // Initialize game data
        System.out.println("\nInitializing game data...");

        // Create and add some games to the service
        Game game1 = service.addGame("Game #1");
        System.out.println(game1);
        Game game2 = service.addGame("Game #2");
        System.out.println(game2);

        // Add teams to the game
        System.out.println("\nAdding teams to the game...");

        Team team1 = game1.addTeam("Team Alpha");
        Team team2 = game1.addTeam("Team Beta");
        Team team3 = game1.addTeam("Team Gamma");

        // Add players to teams
        team1.addPlayer("Player1");
        team1.addPlayer("Player2");
        team2.addPlayer("Player3");
        team2.addPlayer("Player4");
        team3.addPlayer("Player5");
        team3.addPlayer("Player6");

        // Display the teams and players
        System.out.println("\nGame Setup: Teams and Players");
        System.out.println(game1);

        // Simulate the game rounds
        simulateGameRounds(game1);

        // Test singleton pattern to prove only one instance of GameService exists
        SingletonTester tester = new SingletonTester();
        tester.testSingleton();
    }

    /**
     * Simulates the rounds of the game.
     * For simplicity, it only prints messages to simulate rounds.
     */
    public static void simulateGameRounds(Game game) {
        System.out.println("\nStarting game rounds for " + game.getName() + "...");
        Scanner scanner = new Scanner(System.in);
        
        // Loop for four rounds
        for (int round = 1; round <= 4; round++) {
        	System.out.println("\nRound " + round + " has started!");
            System.out.println("Drawing clues... (This could be a simulated drawing here)");

            // Simulate players guessing
            System.out.println("Players, guess the drawing!");
            System.out.println("Type 'guess' to make a guess (simulated input): ");
            String guess = scanner.nextLine();
            System.out.println("Guessing completed. If no team guessed correctly, others have the chance...");

            // Simulate the round end
            System.out.println("Round " + round + " is over!");

            // Optional: Implement timing (e.g., 1 minute countdown), but it's skipped for this simulation
        }

        System.out.println("\nGame rounds completed for " + game.getName());
    }
}