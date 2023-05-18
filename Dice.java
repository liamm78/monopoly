public class Dice
{
   private int sides;
   private boolean isDouble;
   
   public Dice()
   {
      sides = 6;
   }

   public int roll()
   {
   
   //t d1 = 3;
  //nt d2 = 3;
      int total = 0;
      int dice1 = (int)(Math.random()*6+1);
     //ystem.out.println("Dice 1 was "+dice1);
      int dice2 = (int)(Math.random()*6+1);
     //ystem.out.println("Dice 2 was "+dice2);
      if(dice1 == dice2)
      {
         isDouble = true;
         System.out.println("You rolled a double!");
      }
      else
      { isDouble = false; }
     
      
      
      return dice1+dice2;
   }
   
   
   public boolean checkDouble()
   {
      return isDouble;
   }
}