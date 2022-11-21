public class Player {
     static void move(String command , Character xOrY){
         if (command.equals("user")) User.move(xOrY);
         else if (command.equals("easy")) Easy.move(xOrY);
         else if (command.equals("medium")) Medium.move(xOrY);
         else if (command.equals("hard")) Hard.move(xOrY);
     }
}
