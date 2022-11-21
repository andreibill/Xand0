
import java.util.Random;
import java.util.Scanner;

public class Medium{
    static void move(Character xOrY){
        System.out.println("Making move level \"medium\"");
        Random random = new Random();
        Character opositeOfXOrY;
        if(xOrY == 'X')
            opositeOfXOrY = 'O';
        else
            opositeOfXOrY = 'X';

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Table.table[i][j] == ' ') {
                    if (Game.winningMove(i * 3 + j, xOrY)) {
                        return;
                    } else {
                        Table.deleteMove(i * 3 + j);
                    }
                }
            }
        }
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if(Table.table[i][j] == ' ')
                    if(Game.winningMove(i*3+j , opositeOfXOrY )){
                        Table.table[i][j] = xOrY;
                        return;
                    }else {
                        Table.table[i][j] = ' ';
                    }
        int coordinates;
        do{
            coordinates = random.nextInt(9);
        }while(!checkMove(coordinates, xOrY));
        Table.insertMove(coordinates, xOrY);
    }
    private static boolean checkMove (int coordinates, Character xOrY){
        if (Table.table[coordinates / 3][coordinates % 3] != ' ') return false;
        return true;
    }
}
