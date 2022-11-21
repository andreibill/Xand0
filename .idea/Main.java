import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] commands;
        Game game;
        Table.resetTable();
        game = new Game();
        commands = game.input().split(" ");
        while(!commands[0].equals("exit")){
            Table.showTable();
            while(Table.gameState == '0' && commands.length > 1){
                if(Table.turnOf++ % 2 == 1) {
                    Player.move(commands[1] , 'X');
                }
                else {
                    Player.move(commands[2], 'O');
                }
                Table.showTable();
                Table.GameState();
            }
            Table.resetTable();
            game = new Game();
            commands = game.input().split(" ");
        }
    }
}