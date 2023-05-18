import java.util.*;
public class Chance extends Space
{
private HashMap<String,String> chance;
//private String key;

public Chance()
{
chance = new HashMap<>();
chance.put("c1","Advance to GO");
    chance.put("c2","Advance to St Charles");
    chance.put("c3","Get 50");
    chance.put("c4","Go back 3 spaces");
  //  System.out.println(chance);
}


public String choose(Player p)
{
String result = null;
Set<String> keySet = chance.keySet(); //makes a new set (array with unique values) of keys)
String[] keyArray = keySet.toArray(new String[keySet.size()]); //makes new array from keySet of correct size
int random = (int)(Math.random()*keyArray.length); //gets random index from key array
String key = keyArray[random];
//System.out.println(random);
//System.out.println(key);
String value = chance.get(key);
//System.out.println(value);
if(chance.containsKey(key))
{
if(key.equals("c1"))
{
p.withdraw(50);
result = "LOSE $50";
}
if(key.equals("c2"))
{
p.withdraw(200);
result = "LOSE $200";
}
if(key.equals("c3"))
{
p.deposit(50);
result = "BANK PAYS YOU A DIVIDEND OF $50";
}
if(key.equals("c4"))
{
p.deposit(200);
result = "BANK PAYS YOU $200";
}
}
else
{ result = "Cannot find"; }
return result;
//System.out.println("Player has landed on Chance!");
}



}