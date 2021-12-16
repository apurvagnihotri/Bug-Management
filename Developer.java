package mypack;
import java.io.*;
import java.sql.*;
public class Developer
{
	static Connection con=null;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void clearScreen()
	{
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}
		catch(Exception e){}
	}
	public static void gotoxy(int x,int y)
	{
		char c = 0x1B;
		int row = y; int column = x;
		System.out.print(String.format("%c[%d;%df",c,row,column));
	}
	static
	{
		
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","123456");
		}
		catch(Exception e){}
	}
	public static void ViewProfile(int id) throws Exception           //This function is for Viewing Developer's Profile
	{
		PreparedStatement pst=con.prepareStatement("select * from Employee where empCode=?");
		pst.setInt(1,id);
		ResultSet res=pst.executeQuery();
		clearScreen();
		System.out.println("\n                                                ******My Profile******\n");
		System.out.println("+------------+------------------+-----------------------------+--------------------+--------------+----------------+--------------+--------------+");
		System.out.println("|  EmpCode   |  EmpName         |         EmpEmail            |  Password          |  gender      |  DOB           |  mobiliNo    |  Role        |");
		System.out.println("+------------+------------------+-----------------------------+--------------------+--------------+----------------+--------------+--------------+");
		int i=7;
		while(res.next())
		{
			gotoxy(1,i);
			System.out.println("|  "+res.getInt(1));
			gotoxy(14,i);
			System.out.println("|  "+res.getString(2));
			gotoxy(33,i);
			System.out.println("| "+res.getString(3));
			gotoxy(63,i);
			System.out.println("| "+res.getString(4));
			gotoxy(84,i);
			System.out.println("| "+res.getString(5));
			gotoxy(99,i);
			System.out.println("| "+res.getString(6));
			gotoxy(116,i);
			System.out.println("| "+res.getLong(7));
			gotoxy(131,i);
			System.out.println("| "+res.getString(8));
			gotoxy(146,i);

			System.out.println("|");
			i++;
			
		}
		gotoxy(1,i);
		System.out.println("+------------+------------------+-----------------------------+--------------------+--------------+----------------+--------------+--------------+");

	}
	public static void update(String temp,int n,int ID)          //This function updates the records using column name,id and n which denotes string or integer on the basis of its value
	{
		try{
		System.out.print("\t\t\tEnter new "+temp+": ");
		String S=br.readLine();
		if(n==1)
			S="update Employee set "+temp+"='"+S+"'"+" where empCode="+ID;
		else
			S="update Employee set "+temp+"="+S+" where empCode="+ID;
		PreparedStatement pst=con.prepareStatement(S);
		if(pst.executeUpdate()>0)
			System.out.println("\t\t\tRecord Updated");
		else
			System.out.println("\t\t\tRecord not Updated");
		System.out.print("\t\t\tPress any key to continue........");
		br.readLine();
		}
		catch(Exception e){
			System.out.println("INVALID Input FORMAT");
			System.out.println("\t\t\t\nPress any key to continue....");
			try{br.readLine();}
			catch(Exception f){}
			

		}
		
	
	}
	public static void UpdateProfile(int id,String Name) throws Exception       //Update Menu
	{
				boolean i=true;
				int res=0;
				do
				{
					try{
					clearScreen();
					System.out.println("\t\t\t *********Welcome    "+Name+" ***********");
					System.out.println("\n\n");
					System.out.println("\t\t\t************************************************");
					System.out.println("\t\t\t|                                              |");
					System.out.println("\t\t\t|                UPDATE MENU                   |");
					System.out.println("\t\t\t|                                              |");
					System.out.println("\t\t\t************************************************");
					System.out.println("\t\t\t|                1.Name                        |");
					System.out.println("\t\t\t|                2.Email                       |");
					System.out.println("\t\t\t|                3.Password                    |");
					System.out.println("\t\t\t|                4.Gender                      |");
					System.out.println("\t\t\t|                5.DOB                         |");
					System.out.println("\t\t\t|                6.mobileNo                    |");
					System.out.println("\t\t\t|                7.Go Back                     |");
					System.out.println("\t\t\t************************************************");
					System.out.print("\t\t\tEnter your Choice: ");

					String ch=br.readLine();

					switch(ch)
					{
						case "1": update("empName",1,id);
				
								break;
						case "2":update("empEmail",1,id);
				
								break;

						case "3": update("empPassword",1,id);
								
				
								break;

						case "4": update("gender",1,id);
								break;

						case "5": update("DOB",1,id);
				
								break;

						case "6": update("mobileNo",2,id);
				
								break;

						case "7": i=false;
								break;

						default: System.out.println("\t\t\tInvalid Input");
								 System.out.println("Enter any key to continue...");
								 br.readLine();
								 break;
					}

					}
					catch(Exception e)
					{
						
					}
					

				}while(i);
	}

	public static void ViewBug(int id,String Name) throws Exception    //Function for Displaying Bugs
	{
		clearScreen();
		System.out.println("\t\t\t *********Welcome    "+Name+" ***********\n\n");
		PreparedStatement pst=con.prepareStatement("select bugNo,bugCode,projectID,TCode,status,bugDes from bugreport where ECode=?");
		pst.setInt(1,id);
		ResultSet res=pst.executeQuery();
		int flag=0;
		clearScreen();
		System.out.println("\n                                                   *********Bug Report Table*********\n");
		System.out.println("+------------+-------------+-------------+-------------+--------------+--------------------------------------------------------------------------------+");
		System.out.println("|  bugNo     |  bugCode    |  projectID  |     TCode   |   Status     |                            bugDes                                              |");
		System.out.println("+------------+-------------+-------------+-------------+--------------+--------------------------------------------------------------------------------+");
		int i=7;
		while(res.next())
		{
			gotoxy(1,i);
			System.out.println("|  "+res.getInt(1));
			gotoxy(14,i);
			System.out.println("|  "+res.getInt(2));
			gotoxy(28,i);
			System.out.println("| "+res.getInt(3));
			gotoxy(42,i);
			System.out.println("| "+res.getInt(4));
			gotoxy(56,i);
			System.out.println("| "+res.getString(5));
			gotoxy(71,i);
			System.out.println("| "+res.getString(6));
			gotoxy(152,i);
			System.out.println("|");
			i++;
			flag=1;
			
		}
		gotoxy(1,i);
		if(flag==0)
		System.out.println("|                                                                 Record not Found...                                                                  |");
		System.out.println("+------------+-------------+-------------+-------------+--------------+--------------------------------------------------------------------------------+");
		
	}

	public static void UpdateBugStatus(int id,String Name) throws Exception   //Function for Updating Bug Status
	{
		clearScreen();
		System.out.println("\t\t\t *********Welcome    "+Name+" ***********\n\n");
		PreparedStatement pst=con.prepareStatement("update bugreport set bugDes=? where ECode=? and bugCode=?");
		System.out.print("Enter BugCode: ");
		pst.setInt(3,Integer.parseInt(br.readLine()));
		System.out.print("Enter Bug Description: ");
		pst.setString(1,br.readLine());
		pst.setInt(2,id);
		int res=pst.executeUpdate();
		if(res>0)
			System.out.println("Record Updated...");
		else
			System.out.println("Record Not Updated...");

	}
	public static void BugDetails(String Name) throws Exception    //Function for Displaying Bug Details
	{
		clearScreen();
		System.out.println("\t\t\t *********Welcome    "+Name+" ***********\n\n");
		PreparedStatement pst=con.prepareStatement("select * from bugtype");
		ResultSet res=pst.executeQuery();
		System.out.print("\t\t\tEnter BugCode: ");
		int bcode=Integer.parseInt(br.readLine());
		int flag=0;
		while(res.next())
		{
			if(bcode==res.getInt(1))
			{
				
				PreparedStatement pst1=con.prepareStatement("select * from bugtype where bugCode=?");
				pst1.setInt(1,bcode);
				ResultSet res1=pst1.executeQuery();
				clearScreen();
				System.out.println("\n                      *********Bug Codes Table*********\n");
				System.out.println("+------------+-----------------------------------------------------+----------------+");
				System.out.println("|  bugCode   |            bugCategory                              |   bugSeverty   |");
				System.out.println("+------------+-----------------------------------------------------+----------------+");
				int i=7;
				while(res1.next())
				{
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
				System.out.println("+------------+----------------------------------------+-----------------------------+");

				flag=1;
			}				
			
		}
		if(flag==0)
			System.out.println("\t\t\tNo Details Related to this Bug were Found...");	
	}

		
		
	
	public static void DevMenu(int id,String Name) throws Exception     //Developer Menu
	{
		boolean i=true;
		do
		{
			clearScreen();

			System.out.println("\t\t\t *********Welcome    "+Name+" ***********\n\n");

			System.out.println("\t\t\t******************************************");
			System.out.println("\t\t\t|                                        |");
			System.out.println("\t\t\t|            DEVELOPER MENU              |");
			System.out.println("\t\t\t|                                        |");
			System.out.println("\t\t\t******************************************");
			System.out.println("\t\t\t|           1.View Profile               |");
			System.out.println("\t\t\t|           2.Update Profile             |");
			System.out.println("\t\t\t|           3.View Bug Status            |");
			System.out.println("\t\t\t|           4.Update Bug Status          |");
			System.out.println("\t\t\t|           5.Bug Details                |");
			System.out.println("\t\t\t|           6.Logout                     |");
			System.out.println("\t\t\t******************************************");
			System.out.print("  \t\t\tEnter your Choice: ");
		
			String choice=br.readLine();
			switch(choice)
			{
				case "1": try
						{
							ViewProfile(id);
						}
						catch(Exception e){}
						System.out.print("\t\t\tPress any key to continue...");
						br.readLine();
						break;

				case "2": try
						{
							UpdateProfile(id,Name);
						}
						catch(Exception e){System.out.println("Shiva");}
						break; 

				case "3": try
						{
							ViewBug(id,Name);
						}
						catch(Exception e){};
						System.out.print("\t\t\tPress any key to continue...");
						br.readLine();
						break;

				case "4": try
						 {
						 	UpdateBugStatus(id,Name);
						 }
						 catch(Exception e){};
						System.out.print("\t\t\tPress any key to continue...");
						br.readLine();
						break;

				case "5": try
						{
							BugDetails(Name);
						}
						catch(Exception e){}
						System.out.print("\t\t\tPress any key to continue...");
						br.readLine();
						break;

				case "6": i=false;
						break;

				default: System.out.println("\t\t\tInvalid Input!!!");
						 System.out.print("\t\t\tPress any key to continue...");
						br.readLine();
						break;	
			}
		}
		while(i);

	}
	
}


