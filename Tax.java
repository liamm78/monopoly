public class Tax extends Space
{
   private int price;
   private String name;

   public Tax(int price, String name)
   {
      this.price = price;
      this.name = name;
   }

   public void tax(Player p)
   {
      if(name.equals("Income Tax"))
      {
         p.withdraw(100);
      }
   }
   public String getName()
   {
   return name;
   }
   
   public int getPrice()
   {
   return price;
   }
}
