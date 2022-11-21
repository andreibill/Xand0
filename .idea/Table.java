public class Table {
    static Character[][] table = new Character[][]{
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
    };
    static int turnOf = 1; // if turnOf is odd is turn of X otherwise is turn of O
    static Character gameState = '0'; // 0 = not finished, 1 = draw, X = X wins, O = O wins
    static void showTable(){
        System.out.println("---------");
        for(int i = 0; i < 3; i++){
            System.out.print("| ");
            for(int j = 0; j < 3; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    static void insertMove(String coordinates , Character xOrY){
        table[(int)coordinates.charAt(0)-49][(int)coordinates.charAt(2)-49] = xOrY;
    }
    static void insertMove(int coordinates , Character xOrY){
        table[coordinates/3][coordinates%3] = xOrY;
    }
    static boolean checkWin(int coordinates){
        int x = coordinates/3;
        int y = coordinates%3;
        if((table[0][y] == table[1][y] && table[0][y] == table[2][y]) ||
                (table[x][0] == table[x][1] && table[x][0] == table[x][2]))return true;
        else if(x == y){
            if(table[0][0] == table[1][1] && table[0][0] == table[2][2]) return true;
        } else if (x + y == 2)
            if(table[0][2] == table[1][1] && table[0][2] == table[2][0] ) return true;
        return false;
    }


    static void deleteMove(String coordinates){
        table[(int)coordinates.charAt(0)-49][(int)coordinates.charAt(2)-49] = ' ';
    }
    static void deleteMove(int coordinates){
        table[coordinates/3][coordinates%3] = ' ';
    }

    static void GameState(){
        gameState = setGameState();
        if(gameState == 'X') System.out.println("X wins");
        if(gameState == 'O') System.out.println("O wins");
        if(gameState == '1') System.out.println("Draw");
    }

    private static Character setGameState(){
        if(table[0][0] == table[0][1] && table[0][0] == table[0][2] && table[0][0] != ' ') return table[0][0];
        if(table[1][0] == table[1][1] && table[1][0] == table[1][2] && table[1][0] != ' ') return table[1][0];
        if(table[2][0] == table[2][1] && table[2][0] == table[2][2] && table[2][0] != ' ') return table[2][0];
        if(table[0][0] == table[1][0] && table[0][0] == table[2][0] && table[0][0] != ' ') return table[0][0];
        if(table[0][1] == table[1][1] && table[0][1] == table[2][1] && table[0][1] != ' ') return table[0][1];
        if(table[0][2] == table[1][2] && table[0][2] == table[2][2] && table[0][2] != ' ') return table[0][2];
        if(table[0][0] == table[1][1] && table[0][0] == table[2][2] && table[0][0] != ' ') return table[0][0];
        if(table[0][2] == table[1][1] && table[0][2] == table[2][0] && table[0][2] != ' ') return table[0][2];
        if(turnOf > 9) return '1';
        return '0';
    }

    static void resetTable(){
        table = new Character[][]{
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };
        turnOf = 1;
        gameState = '0';
    }
}
