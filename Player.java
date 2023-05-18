import java.util.*;
public class Player
{
   private int balance;
   private int position;
   private ArrayList<Property> properties;
   private ArrayList<Railroad> railroads;
   private final int railPrice = 200;
   
   private String name = null;
   private boolean isComputer = false;
   public Player(int balance, String name, boolean isComputer)
   {
      this.balance = balance;
      position = 0;
      this.name = name;
      properties = new ArrayList<Property>();
      railroads = new ArrayList<Railroad>();
   }
   
   public int getRailCount()
   { return railroads.size(); }
   
   public void buyRailroad(Railroad rail)
   {
   int count = getRailCount();
   System.out.println("Would you like to buy "+rail.getName()+"for $"+rail.getPrice()+"? - YOU HAVE $"+balance);
   System.out.println(" -.- You have "+count+" railroads");
   
      Scanner scan = new Scanner(System.in);
      if(!scan.nextLine().equals("Y"))
      {
      }
      else
      {
         if(balance<railPrice)  //usually 200
         { System.out.println("You do not have enough money to buy this railroad!"); }
         else
         {
            railroads.add(rail);
            withdraw(railPrice);
            System.out.println(name+" has bought "+rail.getName()+" for "+railPrice);
         }
      }
   }
   
   
   
   
   public boolean isComputer()
   { 
      return isComputer; }
  
   public void buyProperty(Property property)
   {
   int count = getColorProperties(property);
   System.out.println("Would you like to buy "+property.getName()+"("+property.getColor().toUpperCase()+") for $"+property.getPrice()+"? - YOU HAVE $"+balance);
   System.out.println(" -.- You have "+count+" "+property.getColor()+" properties");
   
      Scanner scan = new Scanner(System.in);
      if(!scan.nextLine().equals("Y"))
      {
      }
      else
      {
         if(balance<property.getPrice())
         { System.out.println("You do not have enough money to buy this property!"); }
         else
         {
            properties.add(property);
            withdraw(property.getPrice());
            System.out.println(name+" has bought "+property.getName()+"("+property.getColor().toUpperCase()+") for "+property.getPrice());
         }
         if(getColorProperties(property)==2)
         { System.out.println("You have a set of "+property.getColor()); }
      }
   }
   public int getColorProperties(Property property)
   {
      int count = 0;
      for(Property prop: properties)   //checks if player has other colored properties  //-THIS CAN BE ANOTHER METHOD! -//
      {
         if(prop.getColor().equals(property.getColor()))
         {
            count++;
         }
                     
      }
      return count;
   }
   
   public boolean hasProperty(Property p)
   { return properties.contains(p); }
   
   public boolean hasRailroad(Railroad r)
   { return railroads.contains(r); }
   
   public void displayProperties()
   {
      System.out.println("\n\n"+name+" owns...\n");
      for(Property p: properties)
      {
         System.out.println(p.getName()+" - "+p.getPrice()+": "+p.getColor().toUpperCase());
      }
      
      for(Railroad r: railroads)
      {
      System.out.println(r.getName()+" - "+railPrice);
      }
   }
   
  
 
   

   public void withdraw(int bal)
   {
      balance -= bal;
   }
   
   public void deposit(int bal)
   {
      balance+=bal;
   }
   public int getBalance()
   {
      return balance;
   }
   
   public String getName()
   {
      return name;
   }
   
   public void move(int dice)
   {
      position+=dice;
      System.out.println(name +" has moved "+dice+" spaces!");
   }
   
   public void teleport(int t)
   {
      position = t;
      //System.out.println(name+" has moved to GO");
   }
   
   public int getPosition()
   {
      return position;
   }
}