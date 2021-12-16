import java.io.*;
import java.sql.*;
import mypack.*;

class login
{
	static Connection con=null;
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
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","123456");
		}
		catch(Exception e){}
	}
	public static void main(String[] args)   //Login Menu
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			try
			{
				Admin.clearScreen();
				System.out.println("\n\n\t\t\t           ******WELCOME TO BUG TRACKING SYSTEM*******\n\n");
				System.out.println("\t\t\t\t************************************************");
				System.out.println("\t\t\t\t|                      LOGIN                   |");
				System.out.println("\t\t\t\t*                   -----------                *");
				System.out.println("\t\t\t\t|                                              |");
				System.out.println("\t\t\t\t*    Enter UserName:                           *");		
				System.out.println("\t\t\t\t|                                              |");
				System.out.println("\t\t\t\t*    Enter Password:                           *");
				System.out.println("\t\t\t\t|                                              |");
				System.out.println("\t\t\t\t************************************************");
				gotoxy(55,10);
				int UserName=Integer.parseInt(br.readLine());
				gotoxy(55,12);
				char[] ch=System.console().readPassword();
				String Password=new String(ch);
				PreparedStatement pst=con.prepareStatement("select * from Employee where empCode=? and empPassword=?");
				pst.setInt(1,UserName);
				pst.setString(2,Password);
				ResultSet res=pst.executeQuery();
				int flag=0;
				if(res.next())
				{
					String Role=res.getString(8);
					String name=res.getString(2);
					int id=res.getInt(1);
					if(Role.equals("Admin"))
						Admin.Menu(name);
					else if(Role.equals("Developer"))
						Developer.DevMenu(id,name);
					else if(Role.equals("Tester"))
						Tester.Menu(id,name);
					else if(Role.equals("Manager"))
						Manager.Menu(id,name);
					flag=1;
				}
				if(flag==0)
				{
					gotoxy(33,16);
					System.out.println("Invalid UserName/Password");
					gotoxy(33,17);
					System.out.print("Press any key to continue........");
		 			br.readLine();
		 		}
			}
			catch(Exception e)
			{
				gotoxy(33,16);
				System.out.println("Invalid UserName");
				try{
					gotoxy(33,17);
					System.out.print("Press any key to continue........");
		 			br.readLine();
				   }
				catch(Exception f){}
			}
		}
		
	}
}