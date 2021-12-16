package mypack;
import java.io.*;
import java.sql.*;

public class Tester
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static Connection con=null;
	static String ch1;
	static int ch,ch2;
	static 
	{
		try
		{
			
			//Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","123456");
			
		}
		catch(Exception massage)
		{
			
		}
	}
	public static void gotoxy(int x,int y)
	{
		char c = 0x1B;
		int row = y; int column = x;
		System.out.print(String.format("%c[%d;%df",c,row,column));
	}
	// clearscreen function is clear the current screen
	public static void clearScreen()  
	{
		try 
		{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception e)
		{

		}
	}
	public static void color()  
	{
		try 
		{
			new ProcessBuilder("cmd","/c","color F2").inheritIO().start().waitFor();
		}
		catch(Exception e)
		{

		}
	}	
	public static void color3()  
	{
		try 
		{
			new ProcessBuilder("cmd","/c","color F3").inheritIO().start().waitFor();
		}
		catch(Exception e)
		{

		}
	}	
	public static void color1()  
	{
		try 
		{
			new ProcessBuilder("cmd","/c","color F4").inheritIO().start().waitFor();
		}
		catch(Exception e)
		{

		}
	}	
	public static void color2()  
	{
		try 
		{
			new ProcessBuilder("cmd","/c","color F5").inheritIO().start().waitFor();
		}
		catch(Exception e)
		{

		}
	}	
	public static void color4()  
	{
		try 
		{
			new ProcessBuilder("cmd","/c","color FC").inheritIO().start().waitFor();
		}
		catch(Exception e)
		{

		}
	}	
	public static void updateprofile(int id,String name) throws Exception  //Function for Updating Tester's Profile
	{
		int flag1,res;
		
		
		do
		{
			flag1=0;
			try{
			clearScreen();
			color1();
			System.out.println("\n\t\t\t             WELCOME  "+name);
			System.out.println("\t\t\t          ---------------------------\n");
			System.out.println("\t\t\t(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)");
			System.out.println("\t\t\t(~)                                       (~)");
			System.out.println("\t\t\t(~)            UPDATE PROFILE             (~)");
			System.out.println("\t\t\t(~)                                       (~)");
			System.out.println("\t\t\t(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)");
			System.out.println("\t\t\t(~)                                       (~)");
			System.out.println("\t\t\t(~)     1.UPDATE  NAME                    (~)");
			System.out.println("\t\t\t(~)     2.UPDATE  EMAIL                   (~)");
			System.out.println("\t\t\t(~)     3.UPDATE PASSWORD                 (~)");
			System.out.println("\t\t\t(~)     4.UPDATE GENDER                   (~)");
			System.out.println("\t\t\t(~)     5.UPDATE DATE OF BIRTH            (~)");
			System.out.println("\t\t\t(~)     6.UPDATE MOBILE NUMBER            (~)");
			System.out.println("\t\t\t(~)     7.BACK TO TESTER PANEL MENU       (~)");
			System.out.println("\t\t\t(~)                                       (~)");
			System.out.println("\t\t\t(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)(~)");
			System.out.print("\n\t\t\t    Enter your choice :- ");
			
			ch1=br.readLine();
			color2();
			switch(ch1)
			{
				
				case "1": PreparedStatement obj1=con.prepareStatement("update Employee set empName=? where empcode=?");
						obj1.setInt(2,id);
						System.out.print("\t\t\tEnter the  NAME:-");
						obj1.setString(1,br.readLine());
						 res=obj1.executeUpdate();
						 if(res>0)
						 System.out.println("\t\t\t\n NAME UPADTED........");
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
						  break;
				case "2":  PreparedStatement obj2=con.prepareStatement("update Employee set empEmail=? where empcode=?");
						obj2.setInt(2,id);
						System.out.print("\t\t\tEnter the EMAIL :-");
						obj2.setString(1,br.readLine());
						res=obj2.executeUpdate();
						if(res>0)
						 System.out.println("\t\t\t\n EMAIL UPADTED........");
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
						break;
				case "3": PreparedStatement obj3=con.prepareStatement("update Employee set empPassword=? where empcode=?");
						obj3.setInt(2,id);
						System.out.print("\t\t\tEnter the PASSWORD :-");
						obj3.setString(1,br.readLine());
						res=obj3.executeUpdate();
						if(res>0)
						 System.out.println("\t\t\t\n PASSWORD UPADTED........");
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
						 break;
				case "4":  PreparedStatement obj4=con.prepareStatement("update Employee set gender=? where empcode=?");
						obj4.setInt(2,id);
						System.out.print("\t\t\tEnter the GENDER :-");
						obj4.setString(1,br.readLine());
						 res=obj4.executeUpdate();
						 if(res>0)
						 System.out.println("\t\t\t\n GENDER UPADTED........");
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
						break;
				case "5":  PreparedStatement obj5=con.prepareStatement("update Employee set DOB=? where empcode=?");
						obj5.setInt(2,id);
						System.out.print("\t\t\tEnter the DATE OF BIRTH :-");
						obj5.setString(1,br.readLine());
						res=obj5.executeUpdate();
						if(res>0)
						 System.out.println("\t\t\t\n DATE OF BIRTH UPADTED........");
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
						break;
				case "6":  PreparedStatement obj6=con.prepareStatement("update Employee set mobileNo=? where empcode=?");
						obj6.setInt(2,id);
						System.out.print("\t\t\tEnter the MOBILE NUMBER :-");
						obj6.setLong(1,Long.parseLong(br.readLine()));
						res=obj6.executeUpdate();
						if(res>0)
						 System.out.println("\t\t\t\n MOBILE NUMBER UPADTED........");
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
						break;
				case "7": flag1=1;
						break;
				default : System.out.println("\t\t\tINVALID CHOICE......");
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
			}
		}
		catch(Exception e){
			System.out.println("INVALID INPUT FORMAT");
			System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception g){}
		}

		
		
		}while(flag1==0);
	}
	public static void addbug(int id,String name) throws Exception      //Function for Adding Bugs
	{
		color2();
		PreparedStatement obj=con.prepareStatement("select * from BugReport where bugNo=?");
	
		System.out.println("\t\t\t     -------------------------\n");
		System.out.print("\t\t\tEnter the Bug number :- ");
		int p=Integer.parseInt(br.readLine());
		obj.setInt(1,p);
		ResultSet res=obj.executeQuery();
		if(!res.next())
		{
			PreparedStatement obj1=con.prepareStatement("insert into BugReport (bugNo,bugCode,projectID,Ecode,Tcode,Status) values(?,?,?,?,?,?)");
			obj1.setInt(1,p);
			System.out.print("\t\t\tEnter the Bug code :- ");

			obj1.setInt(2,Integer.parseInt(br.readLine()));
			System.out.print("\t\t\tEnter the Bug ProjectID :- ");
			int q=Integer.parseInt(br.readLine());
			PreparedStatement obj2=con.prepareStatement("select * from Project where projectID=?");
			obj2.setInt(1,q);
			ResultSet res2=obj2.executeQuery();
			if(res2.next())
			{
				obj1.setInt(3,q);
				obj1.setInt(5,id);
				System.out.print("\t\t\tEnter the Employee code :- ");
				int d=Integer.parseInt(br.readLine());
				String s="Developer";
				PreparedStatement obj3=con.prepareStatement("select* from Employee where empcode=? and Role=?");
				obj3.setInt(1,d);
				obj3.setString(2,s);
				ResultSet res3=obj3.executeQuery();
				if(res3.next())
				{
				
					
						obj1.setInt(4,d);
						System.out.print("\t\t\tEnter the Status :- ");
						obj1.setString(6,br.readLine());
						
						int res1=obj1.executeUpdate();
						if(res1>0)
							System.out.println("\t\t\t\n\nBugReport Inserted Successfully....");
						else
							System.out.println("\t\t\t\n\nBugReport Not Inserted ............");
					
				}
				else
				{
					System.out.println("\t\t\t\n\nDEVELOPER ID MAY BE DUPLICATE OR MAY BE THE EMPLOYEE IS NOT A DEVELOPER...");
				}
			}
			else
			{
				System.out.println("\t\t\t\n\nPROJECT ID NOT EXITS..........");
			}
		}
		else
		{
			System.out.println("\t\t\t\n\nBUG CODE ALREADY EXITS....");
			
		}

	}
	public static void Viewbug(int id,String name) throws Exception      //Function for displaying Bugs
	{
		PreparedStatement obj=con.prepareStatement("select* from BugReport where Tcode=?");
		obj.setInt(1,id);
		System.out.println("\t\t\t          Welcome    "+name);
		System.out.println("\t\t\t     -------------------------\n");
		ResultSet res1=obj.executeQuery();
		int i=7,flag=0;
		clearScreen();
		color3();
		System.out.println("                                   Bug Table  \n");
		System.out.println("|************|*************|****************|********************|*********************|****************|");
		System.out.println("|  BugNo     |  BugCode    |   ProjectID    |    Employee Code   |  Tester Code        |  Status        |");
		System.out.println("|            |             |                |                    |                     |                |");
		System.out.println("|************|*************|****************|********************|*********************|****************|");
		while(res1.next())
		{
			flag=1;
			gotoxy(1,i);
			System.out.println("|  "+res1.getInt(1));
			gotoxy(14,i);
			System.out.println("|  "+res1.getInt(2));
			gotoxy(28,i);
			System.out.println("| "+res1.getInt(3));
			gotoxy(45,i);
			System.out.println("| "+res1.getInt(4));
			gotoxy(66,i);
			System.out.println("| "+res1.getInt(5));
			gotoxy(88,i);
			System.out.println("| "+res1.getString(6));
			gotoxy(105,i);
			System.out.println("|");
			i++;

		
		}
		gotoxy(1,i);
		if(flag==0)
		{
			System.out.println("|                                          NO RECORD FOUND.............                                 |");
			System.out.println("|                                                                                                       |");
		}
		System.out.println("|************|*************|****************|********************|*********************|****************|");

		
		


	}
	public static void Viewprofile(int id,String name) throws Exception       //Function for Viewing Tester's Profile
	{
		PreparedStatement obj=con.prepareStatement("select* from Employee where empCode=?");
		obj.setInt(1,id);
		System.out.println("\t\t\t          Welcome    "+name);
		System.out.println("\t\t\t     -------------------------\n");
		ResultSet res1=obj.executeQuery();
		clearScreen();
		color4();
		int i=8;
		System.out.println("\t\t\t                                                            PROFILE");
		System.out.println("\t\t\t                                                       ---------------\n");
		System.out.println("|************|*******************|****************************|********************|**************|****************|**************|**************|");
		System.out.println("|  EmpCode   |  EmpName          |        EmpEmail            | Password           |  gender      |  DOB           |  mobileNo    |  Role        |");
		System.out.println("|            |                   |                            |                    |              |                |              |              |");
		System.out.println("|************|*******************|****************************|********************|**************|****************|**************|**************|");
		while(res1.next())
		{
			gotoxy(1,i);
			System.out.println("|  "+res1.getInt(1));
			gotoxy(14,i);
			System.out.println("|  "+res1.getString(2));
			gotoxy(34,i);
			System.out.println("| "+res1.getString(3));
			gotoxy(63,i);
			System.out.println("| "+res1.getString(4));
			gotoxy(84,i);
			System.out.println("| "+res1.getString(5));
			gotoxy(99,i);
			System.out.println("| "+res1.getString(6));
			gotoxy(116,i);
			System.out.println("| "+res1.getLong(7));
			gotoxy(131,i);
			System.out.println("| "+res1.getString(8));
			gotoxy(146,i);

			System.out.println("|");
			i++;
			
		}
		gotoxy(1,i);
		System.out.println("**************************************************************************************************************************************************");
	}

	public static void bugDetails(String name) throws Exception    //Function for displaying all Bug Details
	{
		clearScreen();
		color4();
		System.out.println("\t\t\t          Welcome    "+name);
		System.out.println("\t\t\t     -------------------------\n");
		PreparedStatement pst=con.prepareStatement("select * from bugtype");
		ResultSet res1=pst.executeQuery();
		int flag=0;
			
				System.out.println("                                Bug Codes Table\n");
				System.out.println("|************|*****************************************************|****************|");
				System.out.println("|  bugCode   |            bugCategory                              |   bugSeverty   |");
				System.out.println("|            |                                                     |                |");
				System.out.println("|************|*****************************************************|****************|");
				int i=10;
				while(res1.next())
				{
					flag=1;
					gotoxy(1,i);
					System.out.println("|  "+res1.getInt(1));
					gotoxy(14,i);
					System.out.println("|  "+res1.getString(2));
					gotoxy(68,i);
					System.out.println("| "+res1.getString(3));
					gotoxy(85,i);
					System.out.println("|");
					i++;
				}
				gotoxy(1,i);
				System.out.println("|************|*****************************************************|****************|");
		if(flag==0)
			System.out.println("\t\t\tNO RECORD FOUND.........");	
	}
	public static void Menu(int id,String name)      //Tester Menu
	{
		int flag;
		do
		{
			flag=0;
		//	paush();
			clearScreen();
			color();
			System.out.println("\n\t\t\t              WELCOME  "+name);
			System.out.println("\t\t\t          --------------------------\n");
			System.out.println("\t\t\t><-><-><-><-><-><-><-><-><-><-><-><-><-><-><");
			System.out.println("\t\t\t><                                        ><");
			System.out.println("\t\t\t><             TESTER PANEL               ><");
			System.out.println("\t\t\t><                                        ><");
			System.out.println("\t\t\t><-><-><-><-><-><-><-><-><-><-><-><-><-><-><");
			System.out.println("\t\t\t><                                        ><");
			System.out.println("\t\t\t><     1.UPDATE PROFILE                   ><");
			System.out.println("\t\t\t><     2.Add Bug's Report                 ><");
			System.out.println("\t\t\t><     3.View Bug's                       ><");
			System.out.println("\t\t\t><     4.View Profile                     ><");
			System.out.println("\t\t\t><     5.View BugDetails                  ><");
			System.out.println("\t\t\t><     6.Logout.                          ><");
			System.out.println("\t\t\t><                                        ><");
			System.out.println("\t\t\t><-><-><-><-><-><-><-><-><-><-><-><-><-><-><");
			System.out.print("\n\t\t\t    Enter your choice :- ");
			try
			{
				ch=Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{

			}
			switch(ch)
			{
				case 1: try
						{
					    	updateprofile(id,name);

						}
						catch(Exception e){}	
							
						 break;
			    case 2: try
						{
					    	addbug(id,name);

						}
						catch(Exception e){}	
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}	
						 break;
				case 3: try
						{
					    	Viewbug(id,name);

						}
						catch(Exception e){}
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}	
						 break;
				case 4: try
						{
					    	Viewprofile(id,name);

						}
						catch(Exception e){}	
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
						 break;		 
						
				case 5: try
						{
					    	bugDetails(name);

						}
						catch(Exception e){}	
						System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}
						 break;		 

				case 6: flag=1;break;
				default : System.out.println("\t\t\t\n\nINVALID CHOICE.......");
							System.out.println("\t\t\t\nPress any key to countinue....");
						try
						{
							br.readLine();
						}
						catch(Exception e){}

						break;
			}
		}while(flag==0);
	}
}

