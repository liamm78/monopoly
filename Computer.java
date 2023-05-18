import java.util.*;
public class Computer extends Player
{
   private int balance;
   private int position;
   private ArrayList<Property> properties;
   private ArrayList<Railroad> railroads;
   private final int railPrice = 200;
   
   private String name = null;
   private boolean computer = true;

   public Computer(int balance, String name, boolean isComputer)
   {
      super(balance, name, isComputer);
      this.name = name;
      this.balance = balance;
      this.computer = isComputer;
      properties = new ArrayList<Property>();
      railroads = new ArrayList<Railroad>();
   }
   
   public void buyRailroad(Railroad rail)
   {
      int count = getRailCount();
      if(balance<railPrice)  //usually 200
      { System.out.println(name+" does not have enough money to buy this railroad!"); }
      else
      {
         railroads.add(rail);
         withdraw(railPrice);
         System.out.println(name+" has bought "+rail.getName()+" for "+railPrice);
      }
   }

   public void buyProperty(Property property)
   {
      if(balance<property.getPrice())
      { System.out.println( name+" does not have enough money to buy this property!"); }
      else
      {
         properties.add(property);
         withdraw(property.getPrice());
         System.out.println(name+" has bought "+property.getName()+"("+property.getColor().toUpperCase()+") for "+property.getPrice());
      }
      if(getColorProperties(property)==3)
      { System.out.println(name+" has a set of "+property.getColor()); }
   }
   public int getColorProperties(Property property)
   {
      int count = 0;
      for(Property prop: properties)   //checks if player has other colored properties  //-THIS CAN BE ANOTHER METHOD! -//
      {
         if(prop.getColor().equals(property.getColor()))
         {
            count++;
            //System.out.println(count);
         }
                     
      }
      return count;
   }
   public boolean hasProperty(Property p)
   {
      return properties.contains(p);
   }
   public boolean hasRailroad(Railroad r)
   { 
      return railroads.contains(r); }
   
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