class Block
{
    public String s,oth;  // s: player or not , oth : ladder or not 
   public int no;			// no.  : id of the block
    
	
	
	
	Block()
	{   oth=" ";
		s="_ _";
	}
	
	
	Block(int v,String c,String p)
	{
		this.oth = p;
	   this.no = v;
	  this.s=c;
	  
	}
	   
    

	
	void make_move(int old,int ne, String t)  //make move and update block
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(Board.squares[i][j].no == ne)
				{
				
					if(Board.squares[i][j].s.equals("_ _"))
						Board.squares[i][j].s=t;
					else
						Board.squares[i][j].s= Board.squares[i][j].s + " " + t;
				}
				else
 				if(Board.squares[i][j].no == old)
				{
					if(Board.squares[i][j].s.equals("P1 P2"))
						Board.squares[i][j].s="P2";
					else 
					 if(Board.squares[i][j].s.equals("P2 P1"))
						Board.squares[i][j].s="P1";
					else
						Board.squares[i][j].s="_ _";
					}
					
			}
		}
	}
   	   
	   
}