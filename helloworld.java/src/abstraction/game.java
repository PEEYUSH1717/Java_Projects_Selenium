package abstraction;

abstract class Game {
 int score = 0;

 abstract void play();

 void scoreTracking(int points) {
     score += points;
     System.out.println("Score updated: " + score);
 }
}
class CricketGame extends Game {
 void play() {
     System.out.println("Playing Cricket...");
     scoreTracking(50);
 }
}
class ChessGame extends Game {
 void play() {
     System.out.println("Playing Chess...");
     scoreTracking(30);
 }
}
public class game{
 public static void main(String[] args) {
     Game g1 = new CricketGame();
     Game g2 = new ChessGame();

     g1.play();
     g2.play();
 }
}
