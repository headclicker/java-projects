/*
 * Programmer: Ben Russell
 * Date: 11/9/2022
 * Purpose: create a program that simulates the penny pitch game described in the lab
 */
 import java.util.Scanner;
 public class pennyPitchGame{
   public static void main(String[] args){
      boolean isPlaying=true;
      while(isPlaying==true){
         int boardSize=5;
         int score=0;
         int mid;
         int maxPennies;
         
         Scanner scanner = new Scanner (System.in);
         System.out.println("Welcome to the penny pitch game\nHow large do you want the square to be?(1-18)");
         boardSize = scanner.nextInt();
         while((boardSize>18)||(boardSize<1)){
            System.out.println("Please enter a value between 1 and 18");
            boardSize = scanner.nextInt();
         }
         
         mid=boardSize/2;
         maxPennies=boardSize*boardSize;
         int squareVal;
         int colNum;
         int mid2=0;
         if(boardSize%2==0){
            squareVal=mid;
            colNum=mid;
            mid2=mid-1;
         }else{
            squareVal=mid+1;
            colNum=mid+1;
         }
         
         Square[][] board = new Square[boardSize] [boardSize]; //create board
         /*for(int row = 0; row<boardSize; row++){
            for(int col = 0; col<boardSize; col++){
               board[row][col]= new Square(0);
            }
         }*/
         int centerDist=0;
         for(int i=0; i<colNum; i++){// fill board
            
            for(int row = 0; row<boardSize; row++){
               for(int col = 0; col<boardSize; col++){
                  if(boardSize%2!=0){
                     if((row==mid+centerDist)||(row==mid-centerDist)||(col==mid+centerDist)||(col==mid-centerDist)){
                        board[row][col]= new Square(squareVal);
                     }
                  }else{
                     if((row==mid+centerDist)||(row==mid2-centerDist)||(col==mid+centerDist)||(col==mid2-centerDist)){
                        board[row][col]= new Square(squareVal);
                     }
                  }
               }
            }
            squareVal--;
            centerDist++;
         }
         

 
         /*for(int row = 0; row<boardSize; row++){
            for(int col = 0; col<boardSize; col++){
               int squareValue=0;
               if((row==0)||(col==0)||(row==boardSize-1)||(col==boardSize-1)){
                  squareValue=1;
               }else if((row==3)&&(col==3)){
                  squareValue=2;
               }else if((row==col)){
                  squareValue=row+1;
               }else if((row!=col)){
                  squareValue=2;
               }
               board[row][col]= new Square(squareValue);
            }
         }*/
         System.out.println("");
         for(int row = 0; row<boardSize; row++){ //display board
            for(int col = 0; col<boardSize; col++){
               System.out.print((board[row][col]).getValue() + " ");
            }
            System.out.println("");
         }
   
         Scanner kbReader = new Scanner(System.in); //number of pennies
         System.out.println("How many pennies would you like to throw?(1-" + maxPennies + ")");
         int numPennies = kbReader.nextInt();
         while((numPennies>maxPennies)||(numPennies<1)){
            System.out.println("Please enter a value between 1 and " + maxPennies);
            numPennies = kbReader.nextInt();
         }
   
         for(int i=1; i<=numPennies; i++){ //throw pennies
            int randRow = (int)(Math.random()*(boardSize));
            int randCol = (int)(Math.random()*(boardSize));
            while((board[randRow][randCol]).getValue()==0){
               randRow = (int)(Math.random()*(boardSize));
               randCol = (int)(Math.random()*(boardSize));
            }
            score+=(board[randRow][randCol]).getValue();
            (board[randRow][randCol]).hit(); 
            System.out.println("");
            for(int row = 0; row<boardSize; row++){ //display board
               for(int col = 0; col<boardSize; col++){
                  if((board[row][col]).getValue()!=0){
                     System.out.print((board[row][col]).getValue() + " ");
                  }else{
                     System.out.print("P ");
                  }
               }
               System.out.println("");
            }
            System.out.println("Score: " + score);
         }
         Scanner kbReader2 = new Scanner(System.in); //play aagain?
         System.out.println("Would you like to play again?");
         String playAgain = kbReader2.nextLine();
         if(playAgain.equalsIgnoreCase("no")){
            isPlaying=false;
         }
      }
      System.out.println("Thank you for playing!");
   }
}
