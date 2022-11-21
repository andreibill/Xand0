
import java.util.Random;

public class Easy{
    static void move(Character xOrY){
        System.out.println("Making move level \"easy\"");
        Random random = new Random();
        int coordinates;
        do{
           coordinates = random.nextInt(9);
        }while(!checkMove(coordinates, xOrY));
    }

    private static boolean checkMove (int coordinates, Character xOrY){
        if (Table.table[coordinates / 3][coordinates % 3] != ' ') return false;
         if (Game.winningMove(coordinates, xOrY) && Table.turnOf < 8) {
             Table.deleteMove(coordinates);
             return false;
         }
        return true;
    }

}
