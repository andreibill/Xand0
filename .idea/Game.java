
import java.util.Scanner;

public class Game {
    static boolean winningMove(int  coordinates, Character xOrY){
        Table.insertMove(coordinates, xOrY);
        boolean win = Table.checkWin(coordinates);
        return win;
    }
    String input(){
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.println("Input command: ");
            command = scanner.nextLine();
        }while (!checkInput(command));
        return command;
    }

    private boolean checkInput(String command){
        if(command.equals("exit")){
            return true;
        } else if (command.matches("start\\s+(user|easy|medium|hard)\\s+(user|easy|medium|hard)")) {
            return true;
        }
        System.out.println("Bad Parameters!");
        return false;
    }


}
