
public class Hard {
    static void move(Character xOrY){
        System.out.println("Making move level \"hard\"");
        int maxValue = Integer.MIN_VALUE;
        int indexOfMaxValue = 0;
        Character enemyXOrY = xOrY == 'O'? 'X' : 'O';

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
                    if(Game.winningMove(i*3+j , enemyXOrY )){
                        Table.table[i][j] = xOrY;
                        return;
                    }else {
                        Table.table[i][j] = ' ';
                    }

        Character[] array = buildArray(Table.table);
        int[] freeSpots = checkFreeSpots(array);
        for(int i = 0; i < 9; i++){
            if (freeSpots[i] != -1){
                Table.insertMove(freeSpots[i],xOrY);
                array[freeSpots[i]] = xOrY;
                int value = moveMethod(array, xOrY, 0);
                array[freeSpots[i]] = ' ';
                Table.deleteMove(freeSpots[i]);
                if(value > maxValue){
                    maxValue = value;
                    indexOfMaxValue = i;
                }
                }
            }
        Table.insertMove(freeSpots[indexOfMaxValue] , xOrY);
    }

    static private int moveMethod(Character[]array, Character xOrY, int turnOf){
        int maxValue = Integer.MIN_VALUE;
        int indexOfMaxValue = 0;
        array = buildArray(array);
        int[] freeSpots = checkFreeSpots(array);
        int value = 0;
        turnOf = turnOf == 0? 1:0;// 0 = Ai, 1 = theEnemy
        Character enemyXOrY = xOrY == 'O'? 'X' : 'O';
        if(freeSpots == null){
            return 0;
        }else{
            for(int i = 0; i < 9; i++){
                if (freeSpots[i] != -1) {
                    if (turnOf == 0) {
                        if(Game.winningMove(freeSpots[i], xOrY)) {
                            Table.deleteMove(freeSpots[i]);
                            return 10;
                        }
                    } else if (turnOf == 1) {
                        if(Game.winningMove(freeSpots[i], enemyXOrY)) {
                            Table.deleteMove(freeSpots[i]);
                            return -10;
                        }
                    }
                    array[freeSpots[i]] = turnOf == 0? xOrY : enemyXOrY;
                    value += moveMethod(array, xOrY, turnOf);
                    array[freeSpots[i]] = ' ';
                    Table.deleteMove(freeSpots[i]);
                    if(value > maxValue){
                        maxValue = value;
                        indexOfMaxValue = i;
                    }
                }
            }
        }
        return maxValue;
    }

    static private Character[] buildArray(Character[][] table){
        Character[] array = new Character[9];
        for(int i = 0; i < 9; i++){
            if(table[i/3][i%3] != ' ')
                array[i] = (table[i/3][i%3]);
            else
                array[i] = ' ';
        }
        return array;
    }
    static private Character[] buildArray(Character[] array){
        Character[] arr = new Character[9];
        for(int i = 0; i < array.length; i++){
            if(array[i] != ' ')
                arr[i] = (array[i]);
            else
                arr[i] = ' ';
        }
        return arr;
    }

    static private int[] checkFreeSpots(Character[] array){
        int[] availSpots = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
        int count = 0;
        for(int i = 0; i < 9; i++){
            if(array[i] == ' ')
                availSpots[count++] = i;
        }
        if(count == 0)
            return null;
        return availSpots;
    }

    static private int firstFreeSpots(Character[] array){
        int[] availSpots = new int[9];
        for(int i = 0; i < 9; i++){
            if(array[i] == ' ')
                return i;
        }
        return -1;
    }
}
