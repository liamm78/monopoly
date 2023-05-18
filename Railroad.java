public class Railroad extends Space
{
   private int price;
   private String name;
   private boolean bought = false;
   private int count;

   public Railroad(int price, String name)
   {
      this.price = price;
      this.name = name;
      count = 0;
   }

   public int getPrice()
   {
      return price;
   }
   public String getName()
   {
      return name;
   }
   public int getCount()
   {
      return count;
   }
}