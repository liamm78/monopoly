public class Property extends Space
{
   private int price = 0;
   private String name = null;
   private boolean bought = false;
   private String color = null;
   private int level = 0;

   public Property(int price, String name, String color, boolean bought)
   {
      this.price = price;
      this.name = name;
      this.bought = bought;
      this.color = color;
   }
   
   public int getPrice()
   {
      return price;
   }
   
   public String getName()
   {
      return name;
   }
   public String getColor()
   {
      return color;
   }

   public void rent()
   {
      if(level==0)
      {
      }
   }
   
   
}

