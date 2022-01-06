package main;
import java.util.Scanner;
import player.*;
import render.*;
// ******* Mrs.Clever does not programmed for board size that bigger than 3 !!!!! and she doesn't have a counter losing system yet.***********************
public class Tournament {
    private Renderer render;
    private Player [] player;
    private int rounds;
    public static void main(String[] args){
        final String separator = "======================";
        Scanner scanner = new Scanner(System.in);
        int [] score_tournament = new int[3];
        PlayerFactory factory_player = new PlayerFactory();
        RendererFactory factory_render = new RendererFactory();
        System.out.println(String.format("\nWelcome to Tic Tac Toe Game!\n%s", separator));
        System.out.println("\nThere 3 Player mode:\nHuman - The user play.\nMr.Whatever - The CPU Make random chooses.\nMrs.Clever - Ai is a big word for it so basically it's CPU with a lame strategy.");
        // Here i making two players, and as i make the object they need to choose their mark as part of constructor initial.
        System.out.println("\fChoose Player mode player X:");
        Player playerX = factory_player.build(scanner.nextLine(), Board.Mark.X);
        System.out.println(String.format("\nPlayer 1 created.\n%s", separator));
        System.out.println("\fChoose Player mode(CPU or Human) for player O:");
        Player playerO = factory_player.build(scanner.nextLine(), Board.Mark.O);
        System.out.println(String.format("\nPlayer 2 created.\n%s", separator));
        Player [] player = {playerX, playerO}; // Here i created a array of player objects.
        // Here i making a object of render.
        System.out.println("\nWhich render object you want to create?:");
        Renderer render = factory_render.build(scanner.nextLine());
        System.out.println(String.format("\nRender object created.\n%s", separator));
        // Creating a tournament with number of rounds that the user choose.
        System.out.println("\fPlease choose the number of rounds for the tournament:");
        Tournament tournament = new Tournament(scanner.nextInt(), player, render);
        System.out.println(String.format("\nTournament Created\n%s\n", separator));
        score_tournament = tournament.playTournament();
        System.out.println(String.format("%s\nScore List:\nPlayer X: %s\nPlayer O: %s\nDraw: %s",separator ,score_tournament[0], score_tournament[1], score_tournament[2]));
    }
    public Tournament(int rounds, Player [] player, Renderer render){
        this.render = render;
        this.player = player;
        this.rounds = rounds;
    }
    public int[] playTournament(){
        int [] game_rounds = new int[3];
        for(int i = 0; i < rounds; i++){
            System.out.println(String.format("\nRound %s\n======================", i));
            Game game = new Game(player, render);
            switch(game.run()){
                case "X":
                    game_rounds[0] += 1;
                    break;
                case "O":
                    game_rounds[1] += 1;
                    break;
                case "DRAW":
                    game_rounds[2] += 1;
                    break;
                default:
                    System.err.println("Something went wrong with the program in following round..\n");
                    break;
            }
        }
        return game_rounds;
    }
}