class Dice
{
 public int diceRoll ;
 Dice()
 { diceRoll=0;
 }
 
 public int Roll()
	 {
	   diceRoll=(int)(Math.random()*6 )+1 ;
	   return diceRoll;
	 }

}