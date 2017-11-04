import java.util.*;
class Board
{
	public static Block squares[][] = new Block[10][10];
	public Snake s[]=new Snake[3];
	public Ladder l[]= new Ladder[3];
	public Player p1= new Player("P1");
	public Player p2= new Player("P2");
	public Dice D=new Dice();
	
	Board() //constructor
	{  
        s[0] = new Snake(34,11);
		s[1] = new Snake(72,43);
		s[2] = new Snake(98,50);
		
		l[0]= new Ladder(6,62);
		l[1]=new Ladder(18,56);
		l[2]=new Ladder(76,95);

		int c=100;
		for (int i=0;i<10;i++)
		{    if(i%2==0)
			{
				for(int j=0;j<10;j++)
				{   
					if(c== 34 || c==11)
						squares[i][j] = new Block(c,"_ _", "Snake 1");
					else
					if(c==72 || c==43)
						squares[i][j] = new Block(c,"_ _","Snake 2");
					else
					 if(c== 98 || c==50)
						squares[i][j] = new Block(c,"_ _", "Snake 3");
					else
					if(c== 6 || c==62)
						squares[i][j] = new Block(c,"_ _", "Ladder 1");
					else
					if(c==18 || c==56)
						squares[i][j] = new Block(c,"_ _","Ladder 2");
					else if(c== 76 || c==95)
						squares[i][j] = new Block(c,"_ _", "Ladder 3");
					else
						squares[i][j] = new Block(c,"_ _", "       ");
					c--;
				}
			}
			
			else
			{   int k=c-9;
				for(int j=0;j<10;j++)
				{     
				  	 if(k== 34 || k==11)
						squares[i][j] = new Block(k,"_ _", "Snake 1");
					else if(k==72 || k==43)
						squares[i][j] = new Block(k,"_ _","Snake 2");
					 else if(k== 98 || k==50)
						squares[i][j] = new Block(k,"_ _", "Snake 3");
					else if(k== 6 || k==62)
						squares[i][j] = new Block(k,"_ _", "Ladder 1");
					else if(k==18 || k==56)
						squares[i][j] = new Block(k,"_ _","Ladder 2");
					else if(k== 76 || k==95)
						squares[i][j] = new Block(k,"_ _", "Ladder 3");
					else
						squares[i][j] = new Block(k,"_ _", "       ");
					 k++;
					 c--;
				}
			}
			
			
		}
		
		
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
		for(int i=0;i<10;i++)
		{
			for(int j =0;j<10;j++)
				System.out.print("    "+squares[i][j].no+"    \t");
			System.out.print("\n");
			for(int j=0;j<10;j++)
				System.out.print("    "+squares[i][j].s+"     \t");
			System.out.print("\n");
			for(int j=0;j<10;j++)
				System.out.print("  "+squares[i][j].oth+" \t");
			System.out.print("\n\n");	
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
		
	}
	
	
	int ifLadder(int x) //if ladder is present
   
   {
	    if(x==6)
			x=62;
		else 
		 if(x==18)
			x=56;
		else
			if(x==76)
			 x=95;
		
return x;		
			
	   
	   
   }
	
	
	
	  int ifSnake(int x) //if snake is present
   
   {
	    if(x==34)
			x=11;
		else 
		 if(x==72)
			x=43;
		else
			if(x==98)
			 x=50;
		
return x;		
			
	   
	   
   }
	
	void display()
	{
		System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
		for(int i=0;i<10;i++)
		{
			for(int j =0;j<10;j++)
				System.out.print("    "+squares[i][j].no+"    \t");
			System.out.print("\n");
			for(int j=0;j<10;j++)
				System.out.print("    "+squares[i][j].s+"     \t");
			System.out.print("\n");
			for(int j=0;j<10;j++)
				System.out.print("  "+squares[i][j].oth+" \t");
			System.out.print("\n\n");
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
	
		
	}
	
	
	//------------------------------------------------   GAME -------------------------------------------------------
	void StrtGame()
	{
	
	 int tot1=0,tot2=0,turn=1; // 
	 int d;
	 char roll;
	 do 
	 {
		 if(turn==1)
		 {
			 d=D.Roll();
			 
	 
			 int ol = tot1;
			 tot1=tot1+d;
			
			 if(tot1 >100)  // if more than 100 ...chance given again
			 { 
				tot1=tot1-d;
				turn = 1 ;
			 }
			  
				for(int i=0;i<10;i++)
			 {
				 for(int j=0;j<10;j++)
				 {
					 if(squares[i][j].no==tot1)
					 {  
						tot1=ifLadder(tot1); // change pos if ladder
						tot1=ifSnake(tot1);  // change pos if snake
						
						p1.pos = tot1;
			System.out.println("\n--------P1's TURN----------\n\nDice : "+d+"\n P1 : "+p1.pos+"\n P2 : "+p2.pos+"\n\n");
		
						squares[i][j].make_move(ol,tot1,"P1");
						display();
						if(d==6)    // chance given if 6 comes
							turn=1;
						else
				        turn=2;
						break;
					}
				 }
			 }
			
	     }
		 else
			 if(turn==2)
		 {
			 d=D.Roll();
			 
			 int ol = tot2;
			 tot2=tot2+d;
			 
			 if(tot2 >100)
			 { 
				tot2=tot2-d;
				turn =2 ;
			 }
			 
 //System.out.println("\nP2 : "+d+"\nnew position : "+p2.pos+"\n\n");
			
			 for(int i=0;i<10;i++)
			 {
				 for(int j=0;j<10;j++)
				 {
					 if(squares[i][j].no==tot2)
					 {   
				        tot2=ifLadder(tot2);
						tot2=ifSnake(tot2);
						p2.pos=tot2;
						System.out.println("\n--------P2's TURN----------\n\nDice : "+d+"\n P2 : "+p2.pos+"\n P1 : "+p1.pos+"\n\n");
		
				 		squares[i][j].make_move(ol,tot2,"P2");
				        if(d==6)
							turn=2;
						else
				           turn=1;
						display();
						break;
					}
				 }
			 }
			
	     
	 }
	 if(p1.pos ==100 || p2.pos ==100 )  // exit if game is finished
		 break;
	 Scanner sn= new Scanner(System.in);
	 System.out.println("\nroll?\n");
	 roll=sn.next().charAt(0);
	 } while(roll=='r' || roll=='R' );
	
	if(p1.pos==100)
		System.out.println("-------------------------------------------------- PLAYER 1 WON !! -------------------------------------------------------------------------------------\n\n");
	
	else
      if(p2.pos==100)
		System.out.println("-------------------------------------------------- PLAYER 2 WON !! -------------------------------------------------------------------------------------\n\n");
			
     
	}
	
	
	
	
	
}