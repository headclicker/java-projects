/*
 * Programmer: Ben Russell
 * Date: 11/9/2022
 * Purpose: Create the square class for the penny pitch game
 */
public class Square{
   private int value=0;
   private boolean penny=false;
   public Square(int v){
      value=v;
   }
   public void reset(){
      penny=false;
   }
   public int hit(){
      if(penny==false){
         penny=true;
         return value;
      }else{
         return 0;
      }
   }
   public int getValue(){
      if(penny==false){
         return value;
      }else{
         return 0;
      }
   }
   public String toString(){
      return "Value: " + value + "\nPenny: " + penny;
   }
}