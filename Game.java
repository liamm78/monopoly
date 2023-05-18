import java.util.*;
public class Game
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      final String COMMUNITY = "COMMUNUTY";
      final String RAILROAD = "RAILROAD";
      final boolean b = false;
      Space[] board = new Space[39];
      board[0] = new Space("Start");
      board[1] = new Property(60, "Mediterrean Avenue", "Brown",b);
      board[2] = new Chance();
      board[3] = new Property(60, "Baltic Avenue", "Brown",b);
      board[4] = new Tax(100, "Income Tax");
      board[5] = new Railroad(200, "Reading Railroad");
      board[6] = new Property(100, "Orential Avenue", "Light Blue",b);
      board[7] = new Chance();
      board[8] = new Property(100, "Vermont Avenue", "Light Blue",b);
      board[9] = new Property(120, "Connecicut Avenue", "Light Blue",b);
      board[10] = new Space("JUST VISITING");
      board[11] = new Property(140, "St Charles Place", "Pink",b);
      board[12] = new Property(150, "Electric Company", "UTILITY",b);
      board[13] = new Property(140, "States Avenue", "Pink",b);
      board[14] = new Property(160, "Virginia Avenue", "Pink",b);
      
      board[15] = new Railroad(200, "Pennslyvania Railroad");
      board[16] = new Property(180, "St James Place", "Orange",b);
      board[17] = new Property(180, "Tennessee Avenue", "Orange",b);
      board[18] = new Property(200, "New York Avenue", "Orange",b);
      board[19] = new Space("FREE PARKING");
      board[20] = new Property(220, "Kentucky Avenue", "Red",b); 
      board[21] = new Chance();
      board[22] = new Property(220, "Indiana Avenue", "Red",b);
      board[23] = new Property(240, "Illiniois Avenue", "Red",b);
      board[24] = new Railroad(200, "B & O Railroad");
      board[25] = new Property(260, "Atlantic Avenue", "Yellow",b);
      board[26] = new Property(260, "Ventor Avenue", "Yellow",b);
      board[27] = new Property(150, "Waterworks", "UTILITY",b);
      board[28] = new Property(280, "Marvin Gardens", "Yellow",b);
      board[29] = new Space("JAIL");
      board[30] = new Property(300, "Pacific Avenue", "Green",b);
      board[31] = new Property(300, "North Carolina Avenue", "Green",b);
      board[32] = new Chance();
      board[33] = new Property(320, "Pennslyvania Avenue", "Green",b);
      board[34] = new Railroad(200, "Shortline Railroad");
      board[35] = new Chance();
      board[36] = new Property(350, "Park Place", "Blue",b);
      board[37] = new Tax(200, "Luxury Tax");
      board[38] = new Property(400, "Boardwalk", "Blue" ,b);
          
     
      Dice d1 = new Dice();       
      Player[]player = new Player[3];
      player[0] = new Player(1500, "Car", false);  //new player
      player[1] = new Computer(5000, "C1", true);  //new computer
      player[2] = new Computer(5000, "C2", true);  //new computer
      for(int turn = 1; turn<=20; turn++) //turns
      {    
         System.out.println("Turn "+turn+"/10\n**********"); 
         for(int playerNum = 0; playerNum<player.length; playerNum++){ //players per turn
            System.out.println("\n"+player[playerNum].getName()+"'s TURN "+"\n-------------");
         
            do{   //repeats until doubles run out
               int total = 0;
               total+=d1.roll(); 
               player[playerNum].move(total);
               if(player[playerNum].getPosition()<=38)  
               { 
                  ///*** CHECKS IF SPACE IS A PROPERTY ***///Y
                  
                  if(board[player[playerNum].getPosition()] instanceof Property)
                  {
                     int index = 0;
                     boolean owned = false;
                     
                     Property property = (Property) board[player[playerNum].getPosition()];
                     int count = player[playerNum].getColorProperties(property);   //gets number of color properties of property. 
                     for(int i=0; i<player.length; i++)
                     { 
                        if(player[i].hasProperty(property))
                        { 
                           index = i; 
                           owned = true;
                           System.out.println(player[i].getName()+" has "+property.getName()+": "+player[playerNum].getName()+" OWES RENT");
                        }
                     }
                         
                     if(!owned)  //if NO PLAYER owns property yet . FIX THIS
                     {
                           player[playerNum].buyProperty(property);
                     }
                  }
                  
                  else if(board[player[playerNum].getPosition()] instanceof Railroad)
                  {
                     Railroad railroad = (Railroad) board[player[playerNum].getPosition()];
                     
                     int index = 0;
                     boolean owned = false;
                     for(int i=0; i<player.length; i++)
                     { 
                        if(player[i].hasRailroad(railroad))
                        { 
                           index = i; 
                           owned = true;
                           System.out.println(player[i].getName()+" has "+railroad.getName()+": "+player[playerNum].getName()+" OWES RENT");
                        }
                     }
                     
                     if(!owned)  //if NO PLAYER owns property yet . FIX THIS
                     {
                           player[playerNum].buyRailroad(railroad);
                     }
                  }
                  
                  else if(board[player[playerNum].getPosition()] instanceof Chance)
                  {
                     Chance chance = (Chance) board[player[playerNum].getPosition()];
                     String result = chance.choose(player[playerNum]);
                     System.out.println(result);
                     System.out.println(player[playerNum].getName()+" has $"+player[playerNum].getBalance());
                  }
                  
                  else if(board[player[playerNum].getPosition()] instanceof Tax)
                  {
                     Tax t = (Tax) board[player[playerNum].getPosition()];
                     t.tax(player[playerNum]);
                     System.out.println(player[playerNum].getName()+" have landed on "+t.getName()+": lose "+t.getPrice());
                     System.out.println(player[playerNum].getName()+" has $"+player[playerNum].getBalance());
                  } 
                  else
                  { 
                     Space space = board[player[playerNum].getPosition()];
                     space.decideSpace(player[playerNum]);
                  }        
               } 
               else
               { System.out.println(player[playerNum].getName()+" passed GO and received $200");
                  player[playerNum].deposit(200);
                  player[playerNum].teleport(0);
                  total = 0;
                  break;
               }
            
            } while(d1.checkDouble());          //if double is true repeat
         }  //end of forloop
         
      }  
      
      for(int p = 0; p<player.length; p++)
      {
         player[p].displayProperties();
      }
   
   }
}
    
