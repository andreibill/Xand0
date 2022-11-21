import java.util.Scanner;

public class User{
    static void move(Character xOrY){
        String coordinates;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter the coordinates: ");
            coordinates = scanner.nextLine();
        }while (!checkUserMove(coordinates));
        Table.insertMove(coordinates , xOrY);
    }

    private static boolean checkUserMove(String command){
        if(command.length() != 3){
            System.out.println("You should enter numbers");
            return false;
        } else if (command.charAt(0) > '3' || command.charAt(0) < '1' || command.charAt(2) > '3' || command.charAt(2) < '1') {
            System.out.println("The numbers should be between 1 and 3");
            return false;
        } else if (Table.table[(int)command.charAt(0)-49][(int)command.charAt(2)-49] != ' ') {
            System.out.println("Space already occupied");
            return false;
        }

        return true;
    }
}
