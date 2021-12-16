package mypack;
import java.io.*;
import java.sql.*;
class Menu
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static String choice;
	public static String ManSubMenu(String name) throws Exception 					/* This function Display the Menu for the Manager and returns the User choice*/
	{
			Admin.clearScreen();
			System.out.println("\t\t\t *********Welcome    "+name+" ***********\n\n");
			System.out.println("\t\t\t+---------------------------------------+");
			System.out.println("\t\t\t|\t         Manager\t\t|");
			System.out.println("\t\t\t+---------------------------------------+");
			System.out.println("\t\t\t|                                       |");
			System.out.println("\t\t\t|\t  1. Add Manager Account\t|");
			System.out.println("\t\t\t|\t  2. View Manager Account\t|");
			System.out.println("\t\t\t|\t  3. Delete Manager\t\t|");
			System.out.println("\t\t\t|\t  4. Update Manager Detail's\t|");
			System.out.println("\t\t\t|\t  5. Back to prev Menu\t\t|");
			System.out.println("\t\t\t+---------------------------------------+");
			System.out.print("\t\t\tEnter Your Choice......");
			choice=br.readLine();
			return choice;
	}
	public static String DevSubMenu(String name) throws Exception               /* This function Display the Menu for the Developer and returns the User choice*/
	{
		Admin.clearScreen();
		System.out.println("\t\t\t *********Welcome    "+name+" ***********\n\n");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|\t     Developer\t\t\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|                                       |");
		System.out.println("\t\t\t|       1. Add Developer Account\t|");
		System.out.println("\t\t\t|       2. View Developer Account\t|");
		System.out.println("\t\t\t|       3. Delete Developer Account\t|");
		System.out.println("\t\t\t|       4. Update Developer Detail's\t|");
		System.out.println("\t\t\t|       5. Back to main Menu\t\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.print("\t\t\tEnter Your Choice......");
		choice=br.readLine();
		return choice;
	}
	public static String TestSubMenu(String name) throws Exception   			/* This function Display the Menu for the Tester and returns the User choice*/
	{
		Admin.clearScreen();
		System.out.println("\t\t\t *********Welcome    "+name+" ***********\n\n");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|\t\t  Tester\t\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|                                       |");
		System.out.println("\t\t\t|\t 1. Add Tester Account\t\t|");
		System.out.println("\t\t\t|\t 2. View Tester Account\t\t|");
		System.out.println("\t\t\t|\t 3. Delete Tester Account\t|");
		System.out.println("\t\t\t|\t 4. Update Tester Detail's\t|");
		System.out.println("\t\t\t|\t 5. Back to Prev Menu\t\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.print("\t\t\tEnter Your Choice......");
		choice=br.readLine();
		return choice;
	}
	public static String AdminMainMenu(String name) throws Exception  				/* This function Display the Menu f Admin and returns the User choice*/
	{
		Admin.clearScreen();
		System.out.println("\t\t\t *********Welcome    "+name+" ***********\n\n");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|\t          Admin Menu\t\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|                                       |");
		System.out.println("\t\t\t|\t    1. Employeee\t\t|");
		System.out.println("\t\t\t|\t    2. View All Project\t\t|");
		System.out.println("\t\t\t|\t    3. View Bug's Reports\t|");
		System.out.println("\t\t\t|\t    4. Logout\t\t\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.print("\t\t\tEnter Your Choice......");
		choice=br.readLine();
		return choice;
	} 
	public static String UpdateMenu(String name) throws Exception 							//Update Menu of Employees
	{
		Admin.clearScreen();
		System.out.println("\t\t\t *********Welcome    "+name+" ***********\n\n");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|\t         Update Menu\t\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|                                       |");
		System.out.println("\t\t\t|\t    1. Employee Name\t\t|");
		System.out.println("\t\t\t|\t    2. Employeee Email\t\t|");
		System.out.println("\t\t\t|\t    3. Employee Password\t|");
		System.out.println("\t\t\t|\t    4. Gender\t\t\t|");
		System.out.println("\t\t\t|\t    5. BOD\t\t\t|");
		System.out.println("\t\t\t|\t    6. mobileNo\t\t\t|");
		System.out.println("\t\t\t|\t    7. Back to Prev Menu\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.print("\t\t\tEnter Your Choice......");
		choice=br.readLine();
		return choice;
	} 
	public static String EmployeeSubMenu(String name) throws Exception   	/* This function Display the Menu for the Employee and returns the User choice*/
	{
		Admin.clearScreen();
		System.out.println("\t\t\t *********Welcome    "+name+" ***********\n\n");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|\t       Employee Menu\t\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.println("\t\t\t|                                       |");
		System.out.println("\t\t\t|\t    1. Manager\t\t\t|");
		System.out.println("\t\t\t|\t    2. Developer\t\t|");
		System.out.println("\t\t\t|\t    3. Tester\t\t\t|");
		System.out.println("\t\t\t|\t    4. Back to Prev Menu\t|");
		System.out.println("\t\t\t+---------------------------------------+");
		System.out.print("\t\t\tEnter Your Choice......");
		choice=br.readLine();
		return choice;
	}

}
class Functions
{
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static Connection con=null;
	static
	{
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","123456");
		}
		catch(Exception e){}
	}
	public static void insert(String Role) throws Exception                     // this function insert the values according to the Role
	{
		try
		{	System.out.print("Enter the Employee Code: ");
			int id=Integer.parseInt(br.readLine());
			PreparedStatement pst=con.prepareStatement("select * from Employee where empCode=? and Role=?");
			pst.setInt(1,id);
			pst.setString(2,Role);
			ResultSet res=pst.executeQuery();
			if(!res.next())
				{
					pst=con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?)");
					pst.setInt(1,id);
					System.out.print("Enter Employee Name: ");
					pst.setString(2,br.readLine());
					System.out.print("Enter Employee Email: ");
					pst.setString(3,br.readLine());
					System.out.print("Enter Employee Password: ");
					pst.setString(4,br.readLine());
					System.out.print("Enter Employee Gender: ");
					pst.setString(5,br.readLine());
					System.out.print("Enter Employee DOB: ");
					pst.setString(6,br.readLine());
					System.out.print("Enter Employee Mobile: ");
					pst.setLong(7,Long.parseLong(br.readLine()));
					pst.setString(8,Role);
					if(pst.executeUpdate()>0)
						System.out.println("Record Inserted");
					else
						System.out.println("Record not inserted");
				}
			else
				System.out.println("Employee Code Already Exist.......");
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input Format......");
		}
		finally{
			System.out.println("Press any key to continue........");
			br.readLine();
		}
	}

	public static void select(String Role) throws Exception                            // Display the values according to the Role
	{
		PreparedStatement pst=con.prepareStatement("select * from Employee where Role=?");
		pst.setString(1,Role);
		ResultSet res=pst.executeQuery();
		int flag=0;
		Admin.clearScreen();
		System.out.println("\n                                              ********"+Role+" Table*******\n");
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
			flag=1;
		}
		gotoxy(1,i);
		if(flag==0)
		System.out.println("|                                                     No Record Found                                                            |");
		System.out.println("+------------+------------------+-----------------------------+--------------------+--------------+----------------+--------------+--------------+");
		System.out.println("Press any key to continue........");
		br.readLine();
		//con.close();
	}
	public static void selectProject() throws Exception   						//this function Display the Employee table
	{
		PreparedStatement pst=con.prepareStatement("select * from Project");
		ResultSet res=pst.executeQuery();
		int flag=0;
		Admin.clearScreen();
		System.out.println("\n                                        ********Project Details Table*********\n");
		System.out.println("+------------+-----------------------------+----------------+-----------------+--------------------------------------------------------------------------------+");
		System.out.println("|  projectID |  projectName                |  Start Date    |   End Date      |                     Project Description                                        |");
		System.out.println("+------------+-----------------------------+----------------+-----------------+--------------------------------------------------------------------------------+");
		int i=7;
		while(res.next())
		{
			gotoxy(1,i);
			System.out.println("|  "+res.getInt(1));
			gotoxy(14,i);
			System.out.println("|  "+res.getString(2));
			gotoxy(44,i);
			System.out.println("| "+res.getDate(3));
			gotoxy(61,i);
			System.out.println("| "+res.getDate(4));
			gotoxy(79,i);
			System.out.println("| "+res.getString(5));
			gotoxy(160,i);
			System.out.println("|");
			i++;
			flag=1;
			
		}
		gotoxy(1,i);
		if(flag==0)
			System.out.println("|                                                              No Record Found                                                                                 |");
		System.out.println("+------------+-----------------------------+----------------+-----------------+--------------------------------------------------------------------------------+");
		System.out.println("Press any key to continue........");
		br.readLine();
	}
	public static void selectBugReport() throws Exception  						//this function Display the Bug Report table
	{
		PreparedStatement pst=con.prepareStatement("select * from BugReport");
		ResultSet res=pst.executeQuery();
		int flag=0;
		Admin.clearScreen();
		System.out.println("\n                                                   *********Bug Report Table*********\n");
		System.out.println("+------------+-------------+-------------+-------------+-----------+--------------+--------------------------------------------------------------------------------+");
		System.out.println("|  bugNo     |  bugCode    |  projectID  |   ECode     |   TCode   |   Status     |                            bugDes                                              |");
		System.out.println("+------------+-------------+-------------+-------------+-----------+--------------+--------------------------------------------------------------------------------+");
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
			System.out.println("| "+res.getInt(5));
			gotoxy(68,i);
			System.out.println("| "+res.getString(6));
			gotoxy(83,i);
			System.out.println("| "+res.getString(7));
			gotoxy(164,i);
			System.out.println("|");
			i++;
			flag=1;
			
		}
		gotoxy(1,i);
		if(flag==0)
		System.out.println("|                                                                 No Record Found                                                                                  |");
		System.out.println("+------------+-------------+-------------+-------------+-----------+--------------+--------------------------------------------------------------------------------+");
		System.out.println("Press any key to continue........");
		br.readLine();
	}
	public static void delete(String Role) throws Exception  							//this function Delete the values according to the EmplyeeID and Role
	{
		try
		{
			System.out.print("Enter the Employee Code: ");
			int id=Integer.parseInt(br.readLine());
			PreparedStatement pst=con.prepareStatement("select * from Employee where empCode=? and Role=?");
			pst.setInt(1,id);
			pst.setString(2,Role);
			ResultSet res=pst.executeQuery();
			if(res.next())
			{
				pst=con.prepareStatement("delete from Employee where empCode=? and Role=?");
				pst.setInt(1,id);
				pst.setString(2,Role);
				if(pst.executeUpdate()>0)
					System.out.println("Record Deleted");
				else
					System.out.println("Record not Deleted");
			}
			else
				System.out.println("Employee Code Not Found");
		}
		catch(Exception e)
		{
			System.out.println("Invalid Employee Code");
		}
		finally{
			System.out.println("Press any key to continue........");
			br.readLine();
		}
	}
	public static void update(String temp,int n,String Role) throws Exception   	//This function updates the values using the column name,Role and n denotes String or integer on the basis of its value
	{
		try
		{
			System.out.print("Enter the Employee Code: ");
			int id=Integer.parseInt(br.readLine());
			PreparedStatement pst=con.prepareStatement("select * from Employee where empCode=? and Role=?");
			pst.setInt(1,id);
			pst.setString(2,Role);
			ResultSet res=pst.executeQuery();
			if(res.next())
			{
				System.out.println("Enter new "+temp);
				String S=br.readLine();
				if(n==1)
					S="update Employee set "+temp+"='"+S+"'"+" where empCode="+id;
				else
					S="update Employee set "+temp+"="+S+" where empCode="+id;
				pst=con.prepareStatement(S);
				if(pst.executeUpdate()>0)
					System.out.println("Record Updated");
				else
					System.out.println("Record not Updated");
			}
			else
				System.out.println("Employee Code Not Found");
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input Format........");
		}
		finally{
			System.out.println("Press any key to continue........");
			br.readLine();
		}
	}
	public static void gotoxy(int x,int y)
	{
		char c = 0x1B;
		int row = y; int column = x;
		System.out.print(String.format("%c[%d;%df",c,row,column));
	}
}

public class Admin
{
	static int flag,flagl;
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void Menu(String name)
	{
		do
		{
			flagl=0;
			try
			{
				switch(Menu.AdminMainMenu(name)) //Admin Main Menu
				{
					case "1":
					int flag1=0;
					do
					{
						switch(Menu.EmployeeSubMenu(name)) //Employee Sub Menu
						{
							case "1":
							flag=0;
								do
								{
									switch(Menu.ManSubMenu(name))    //Manager Menu
									{
										case "1":Functions.insert("Manager"); break;
										case "2":Functions.select("Manager"); break;
										case "3":Functions.delete("Manager");break;
										case "4":
										do
										{
											flag=1;
											switch(Menu.UpdateMenu(name))
											{
												case "1":Functions.update("empName",1,"Manager");break;
												case "2":Functions.update("empEmail",1,"Manager");break;
												case "3":Functions.update("empPassword",1,"Manager");break;
												case "4":Functions.update("gender",1,"Manager");break;
												case "5":Functions.update("DOB",1,"Manager");break;
												case "6":Functions.update("mobileNo",2,"Manager");break;
												case "7":flag=0;break;
												default:
												System.out.println("Invalid Input");
												System.out.println("Press any key to continue........");
 												br.readLine();
											}
										}while(flag==1);
										break;
										case "5":flag=1;break;
										default:
										System.out.println("Invalid Input");
										System.out.println("Press any key to continue........");
 										br.readLine();
									}
								}while(flag==0);
							break;
							case "2":
							flag=0;
								do
								{
									switch(Menu.DevSubMenu(name))    //Developer Menu
									{
										case "1":Functions.insert("Developer");break;
										case "2":Functions.select("Developer");break;
										case "3":Functions.delete("Developer");break;
										case "4":
										do
										{
											flag=1;
											switch(Menu.UpdateMenu(name))
											{
												case "1":Functions.update("empName",1,"Developer");break;
												case "2":Functions.update("empEmail",1,"Developer");break;
												case "3":Functions.update("empPassword",1,"Developer");break;
												case "4":Functions.update("gender",1,"Developer");break;
												case "5":Functions.update("DOB",1,"Developer");break;
												case "6":Functions.update("mobileNo",2,"Developer");break;
												case "7":flag=0;break;
												default:
												System.out.println("Invalid Input");
												System.out.println("Press any key to continue........");
 												br.readLine();
											}
										}while(flag==1);
										break;
										case "5":flag=1;break;
										default:
										System.out.println("Invalid Input");
										System.out.println("Press any key to continue........");
 										br.readLine();
									}
								}while(flag==0);
							break;
							case "3":
							flag=0;
								do
								{
									switch(Menu.TestSubMenu(name))      //Tester Menu
									{
										case "1":Functions.insert("Tester");break;
										case "2":Functions.select("Tester");break;
										case "3":Functions.delete("Tester");break;
										case "4":
										do
										{
											flag=1;
											switch(Menu.UpdateMenu(name))
											{
												case "1":Functions.update("empName",1,"Tester");break;
												case "2":Functions.update("empEmail",1,"Tester");break;
												case "3":Functions.update("empPassword",1,"Tester");break;
												case "4":Functions.update("gender",1,"Tester");break;
												case "5":Functions.update("DOB",1,"Tester");break;
												case "6":Functions.update("mobileNo",2,"Tester");break;
												case "7":flag=0;break;
												default:
												System.out.println("Invalid Input");
												System.out.println("Press any key to continue........");
 												br.readLine();
											}
										}while(flag==1);
										break;
										case "5":flag=1;break;
										default:
										System.out.println("Invalid Input");
										System.out.println("Press any key to continue........");
 										br.readLine();
									}
								}while(flag==0);
							break;
							case "4":flag1=1;break;
							default:System.out.println("Invalid Input");
							System.out.println("Press any key to continue........");
 							br.readLine();
						}
					}while(flag1==0);
					break;
					case "2":Functions.selectProject();
					break;
					case "3":Functions.selectBugReport();
					break;
					case "4":
					flagl=1;
					break;
					default:
					System.out.println("Invalid Input");
					System.out.println("Press any key to continue........");
 					br.readLine();
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception Caught");
			}
		}while(flagl==0);
	}
	public static void clearScreen()   //Function for Clearing Screen
	{
		try{
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		}
		catch(Exception e){}
	}
}
