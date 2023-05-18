public class Space
{
   private String name;



   public Space()
   {
      this("Start");
   }
   public Space(String name)
   {
      this.name = name;
   
   }

   public void decideSpace(Player p)
   {
      if(name.equals("JAIL"))
      { System.out.println("Go to Jail!"); }
      if(name.equals("JUST VISITING"))
      { System.out.println("Just Visiting"); }
      if(name.equals("FREE PARKING"))
      { System.out.println("Free Parking"); }
   }

}