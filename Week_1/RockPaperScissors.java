import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        
        boolean playerWins = (playerMove.equalsIgnoreCase("Rock") && computerMove.equals("Scissors")) ||
                             (playerMove.equalsIgnoreCase("Paper") && computerMove.equals("Rock")) ||
                             (playerMove.equalsIgnoreCase("Scissors") && computerMove.equals("Paper"));
                             
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] options = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        int rounds = 5;
        int wins = 0, losses = 0, draws = 0;
        
        String[] roundHistory = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            System.out.print("Enter move (Rock/Paper/Scissors): ");
            String playerMove = scanner.nextLine();
            String computerMove = options[random.nextInt(3)];
            
            String result = playRound(playerMove, computerMove);
            roundHistory[i] = "Round " + (i + 1) + " | Player: " + playerMove + " | Computer: " + computerMove + " | " + result;
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        
        System.out.println("\n--- Final Summary ---");
        for (String record : roundHistory) {
            System.out.println(record);
        }
        
        double winPercentage = ((double) wins / rounds) * 100;
        System.out.printf("\nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
        scanner.close();
    }
}