package mypack;
import java.util.*;
import java.io.*;
import java.sql.*;

public class Manager
{
    
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  

        public static void clearScreen()
          {
              try{
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
              }
              catch(Exception e){}

          }
          public static void Menu(int id,String name) throws Exception     //Manager Menu
          { 
            String choice;
            int x=1;
            do
            {
              clearScreen();
              System.out.println("\t\t\t********WELCOME "+name+" ********");
              System.out.println("\t\t\t*-------------------------------*");
              System.out.println("\t\t\t|          Manager              |");
              System.out.println("\t\t\t*-------------------------------*");
              System.out.println("\t\t\t|                               |");
              System.out.println("\t\t\t|   1. View Profile\t\t|");
              System.out.println("\t\t\t|   2. Update Profile\t\t|");
              System.out.println("\t\t\t|   3. Manage project\t\t|");
              System.out.println("\t\t\t|   4. Bug's\t\t\t|");
              System.out.println("\t\t\t|   5. Logout\t\t\t|");
              System.out.println("\t\t\t|                               |");
            System.out.println("\t\t\t*-------------------------------*");
              System.out.print("\t\t\t Enter the choice you want to opt:");
              choice=br.readLine();
              switch(choice)
              {
                case "1":FunctionDetails.ViewProfile(id);
                        break;
                case "2":FunctionDetails.UpdateProfile(id);
                       break;
                case "3":FunctionDetails.ManageProject();
                       break;
                case "4":FunctionDetails.Bugs();
                       break;
                case "5":x=0;
                       break;
                default:System.out.println("Invalid option choosen");
                        System.out.println("Press any key to continue...");
                        br.readLine();
                       break;
          }
            }while(x==1);
          }

}
class FunctionDetails   //This Class includes all Functions 
{
  static Connection con=null;
  static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  static
  {
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BMS","root","123456");
    }
    catch(Exception e)
    {
      System.out.println("cannot load Driver");
    }
  }
  public static void ViewProfile(int id) throws Exception  //Function for Viewing Manager's Profile
  {
        PreparedStatement pst=con.prepareStatement("select * from Employee where empCode=?");
        pst.setInt(1,id);
        ResultSet res=pst.executeQuery();
        Manager.clearScreen();
        System.out.println("\n                                                ******My Profile******\n");
        System.out.println("+------------+------------------+-----------------------------+--------------------+--------------+----------------+--------------+--------------+");
        System.out.println("|  EmpCode   |  EmpName         |         EmpEmail            |  Password          |  gender      |  DOB           |  mobileNo    |  Role        |");
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
        System.out.println();
        System.out.println("Press any key to continue...");
        br.readLine();
  }
    
  public static void UpdateProfile(int id) throws Exception   //Function for Updating Profile
  {
    String choice;
    int x=1,res;
    do{
      try{
          res=0;
          Manager.clearScreen();
          System.out.println("\t\t\t*-------------------------------*");
          System.out.println("\t\t\t|  Manager profile Update       |");
          System.out.println("\t\t\t*-------------------------------*");
          System.out.println("\t\t\t|  1. update Employee Name\t|");
          System.out.println("\t\t\t|  2. update Employee Email\t|");
          System.out.println("\t\t\t|  3. update Employee Password\t|");
          System.out.println("\t\t\t|  4. update Employee Gender\t|");
          System.out.println("\t\t\t|  5. update Employee DOB\t|");
          System.out.println("\t\t\t|  6. update Employee MobileNo\t|");
          System.out.println("\t\t\t|  7. Back\t\t\t|");
          System.out.println("\t\t\t*-------------------------------*");
          System.out.print("\t\t\t  Enter the choice you want to opt:");
          choice=br.readLine();
          switch(choice)
          {
            case "1": PreparedStatement pst1=con.prepareStatement("update Employee set empName=? where empCode=?");
                    pst1.setInt(2,id);
                    System.out.println("Enter the new name");
                    pst1.setString(1,br.readLine());
                    res=pst1.executeUpdate();
                    break;
            case "2": PreparedStatement pst2=con.prepareStatement("update Employee set empEmail=? where empCode=?");
                    pst2.setInt(2,id);
                    System.out.println("Enter the new Email");
                    pst2.setString(1,br.readLine());
                    res=pst2.executeUpdate();
                    break;
            case "3": PreparedStatement pst3=con.prepareStatement("update Employee set empPassword=? where empCode=?");
                    pst3.setInt(2,id);
                    System.out.println("Enter the new Password");
                    pst3.setString(1,br.readLine());
                    res=pst3.executeUpdate();
                    break;
            case "4": PreparedStatement pst4=con.prepareStatement("update Employee set gender=? where empCode=?");
                    pst4.setInt(2,id);
                    System.out.println("Enter the new gender");
                    pst4.setString(1,br.readLine());
                    res=pst4.executeUpdate();
                    break;
            case "5": PreparedStatement pst5=con.prepareStatement("update Employee set DOB=? where empCode=?");
                    pst5.setInt(2,id);
                    System.out.println("Enter the new DOB");
                    pst5.setString(1,br.readLine());
                    res=pst5.executeUpdate();
                    break;
            case "6":
                    PreparedStatement pst6=con.prepareStatement("update Employee set mobileNo=? where empCode=?");
                    pst6.setInt(2,id);
                    System.out.println("Enter the new MobileNo");
                    pst6.setLong(1,Long.parseLong(br.readLine()));
                    res=pst6.executeUpdate();
                    break;
            case "7":x=0;
                 break;
            default:
                System.out.println("Invalid choice:");
                System.out.println("Press any key to continue...");
                br.readLine();
          }
          
          if(res>0)
         {
         System.out.println("Record Updated...");
         System.out.println("Press any key to continue...");
          br.readLine();
         }
       }
         catch(Exception e)
                  {
                    System.out.println("Invalid Input Format");
                    System.out.println("Press Any key to continue");
                    br.readLine();
                  }
  
    }while(x==1);
    
    
  }
  public static void ManageProject() throws Exception   //Project Menu
  {
    
    String choice;
    int x=1,res=0;
    do
    {
           Manager.clearScreen();
           System.out.println("\t\t\t*-------------------------------*");
           System.out.println("\t\t\t|       Project Details         |");
           System.out.println("\t\t\t*-------------------------------*");
          System.out.println("\t\t\t|   1. Add Projects\t\t|");
          System.out.println("\t\t\t|   2. View All Projects\t|");
          System.out.println("\t\t\t|   3. Delete Project\t\t|");
          System.out.println("\t\t\t|   4. Update Project\t\t|");
          System.out.println("\t\t\t|   5. Assign Project\t\t|");
          System.out.println("\t\t\t|   6. View All Assigned Project|");
          System.out.println("\t\t\t|   7. Back\t\t\t|");
          System.out.println("\t\t\t*-------------------------------*");
          System.out.print("\t\t\t   Enter the option you want to invoke on Project:");
          choice=br.readLine();
          switch(choice)
          {
            case "1": AddProject();
                break;
            case "2": ViewAllProject();
                break;  
            case "3": DeleteProject();
                break;
            case "4": UpdateProject();
                break;
            case "5": AssignProject();
                break;
            case "6": ViewAllAssignProject();
                break;
            case "7": x=0;
                break;  
            default:
                System.out.println("Invalid choice ");
                System.out.println("Press any key to continue...");
                br.readLine();
                  break;        
          }
        }while(x==1);
  }


  public static void AddProject() throws Exception  //Function for Adding Projects
    {
      try
        { System.out.print("Enter the ProjectID: ");
          int id=Integer.parseInt(br.readLine());
          PreparedStatement pst=con.prepareStatement("select * from project where projectID=?");
          pst.setInt(1,id);
          ResultSet res=pst.executeQuery();
          if(!res.next())
            {
              pst=con.prepareStatement("insert into Project values(?,?,?,?,?)");
              pst.setInt(1,id);
              System.out.println("Enter Project Name:");
              pst.setString(2,br.readLine());
              System.out.println("Enter Project Start Date:");
              pst.setString(3,br.readLine());
              System.out.println("Enter Project End Date:");
              pst.setString(4,br.readLine());
              System.out.println("Enter Project Description:");
              pst.setString(5,br.readLine());
              int res1=pst.executeUpdate();
              if(res1>0)
                System.out.println("Record Inserted...");
            }
          else
            System.out.println("ProjectID Already Exist.......");
        }
    catch(Exception e)
    {
      System.out.println("Invalid Input......");
    }
    finally{
      System.out.println("Press any key to continue........");
      br.readLine();
    }

  }


  public static void ViewAllProject() throws Exception //Function for Displaying All Projects
    { 
        PreparedStatement pst=con.prepareStatement("select * from Project");
        ResultSet res=pst.executeQuery();
        int flag=0;
        Manager.clearScreen();
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
        System.out.println();
        System.out.println("Press any kry to continue.......");
        br.readLine();

    }
   public static void DeleteProject()  throws Exception   //Function for Deleting a Project
    {
      try
        {
          PreparedStatement pst=con.prepareStatement("delete from Project where projectID=?");
          System.out.println("Enter the ProjectID to be delete");
          pst.setInt(1,Integer.parseInt(br.readLine()));
          int res=pst.executeUpdate();
          if(res>0)
          {
          System.out.println("Record deleted..");
          }
          else
          System.out.println("Invalid ID...");
        }
        catch(Exception e)
        {
          System.out.println("Project Is on Process");
        }
        finally
          {
            System.out.println("Press any key to continue...");
              br.readLine();
          }
    }
    public static void update(String temp,int n) throws Exception //Function for Updating Project Details
    {
      
      try
          {
            System.out.print("Enter ProjectID: ");
            int id=Integer.parseInt(br.readLine());
            PreparedStatement pst=con.prepareStatement("select * from Project where ProjectID=?");
            pst.setInt(1,id);
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
              System.out.println("Enter new "+temp);
              String S=br.readLine();
              if(n==1)
                S="update project set "+temp+"='"+S+"'"+" where ProjectID="+id;
              else
                S="update Porject set "+temp+"="+S+" where projectID="+id;
              pst=con.prepareStatement(S);
              if(pst.executeUpdate()>0)
                System.out.println("Record Updated");
              else
                System.out.println("Record not Updated");
            }
            else
              System.out.println("ProjectID Not Found");
          }
          catch(Exception e)
          {
            System.out.println("Invalid Input");
          }
          finally{
            System.out.println("Press any key to continue........");
            br.readLine();
                }
    }
    public static void UpdateProject()  throws Exception  //Update Project Menu
    {
      char choice;
      int x=1,res=0;
      do{
           Manager.clearScreen();
           System.out.println("\t\t\t*----------------------------------*");
           System.out.println("\t\t\t|       Project Update Screen      |");
           System.out.println("\t\t\t*----------------------------------*");
           System.out.println("\t\t\t|   1. update Project Name\t   |");
          System.out.println("\t\t\t|   2. update Project Start Date   |");
          System.out.println("\t\t\t|   3. update Porject End date\t   |");
          System.out.println("\t\t\t|   4. update Project Description  |");
          System.out.println("\t\t\t|   5. Back\t\t\t   |");
          System.out.println("\t\t\t*----------------------------------*");
          System.out.print("\t\t\t  Enter the choice you want to opt:");
          choice=br.readLine().charAt(0);
          switch(choice)
          {
            case '1':update("projectName",1); 
                  break;
            case '2':update("SDate",1);
                  break;
            case '3':update("EDate",1); 
                  break;
            case '4':update("projectDec",1);
                  break;
            
            case '5':x=0;
                 break;
            default:
                System.out.println("Invalid choice:");
                System.out.println("Press any key to continue...");
                br.readLine();
          }
      }while(x==1); 
    }
    public static void AssignProject() throws Exception     //Function for Assigning Project
    {
      try{
      System.out.println("Enter EmployeeID to be assigned:");
      int b=Integer.parseInt(br.readLine());
      PreparedStatement pst=con.prepareStatement("select * from employee where Role='Developer' and empCode=?");
      pst.setInt(1,b);
      ResultSet res1=pst.executeQuery();
    
      if(res1.next())
      {
        pst=con.prepareStatement("insert into AssignProject values (?,?)");
        System.out.println("Enter ProjectID to be assigned:");
        int a=Integer.parseInt(br.readLine());
        pst.setInt(1,a);
        pst.setInt(2,b);
        int res=pst.executeUpdate();
        if(res>0)
          System.out.println("Project Assigned");
      }
      else
          System.out.println("EmployeeID is Not Found");
    }
    catch(Exception e)
    {
      System.out.println("Invalid ID");
    }
    finally{
      System.out.println("Press any key to continue...");
      br.readLine();
    }

    }
    public static void ViewAllAssignProject() throws Exception  //Function for Viewing All Assigned Projects
    { 
        PreparedStatement pst=con.prepareStatement("select * from AssignProject");
        ResultSet res=pst.executeQuery();
        int flag=0;
        Manager.clearScreen();
        System.out.println("\n***Assigned Project Table***\n");
        System.out.println("+------------+-------------+");
        System.out.println("| projectID  |  empCode    |");
        System.out.println("+------------+-------------+");
        int i=7;
        while(res.next())
        {
          gotoxy(1,i);
          System.out.println("|  "+res.getInt(1));
          gotoxy(14,i);
          System.out.println("|  "+res.getInt(2));
          gotoxy(28,i);
          System.out.println("|");
          flag=1;
          i++;
        }
        if(flag==0)
        System.out.println("|     Project Not Found..  |");
        System.out.println("+------------+-------------+");
        System.out.println();
        System.out.println("Press any key to continue.......");
        br.readLine();

    }
  public static void Bugs() throws Exception  //Bug Menu
  {
    
       String choice;
       int x=1,res=0;
      do
      {
          Manager.clearScreen();
          System.out.println("\t\t\t*-------------------------------*");
          System.out.println("\t\t\t|         Bug Details            |");
          System.out.println("\t\t\t*-------------------------------*");
          System.out.println("\t\t\t|   1. Add New Bug\t\t|");
          System.out.println("\t\t\t|   2. View Bug Type\t\t|");
          System.out.println("\t\t\t|   3. View All Bugs\t\t|");
          System.out.println("\t\t\t|   4. Update Bug\t\t|");
          System.out.println("\t\t\t|   5. Delete Bug\t\t|");
          System.out.println("\t\t\t|   6. Back\t\t\t|");
          System.out.println("\t\t\t*-------------------------------*");
          System.out.print("\t\t\t Enter the option you want to invoke on bug:");
          choice=br.readLine();
          switch(choice)
          {
            case "1": AddNewBug();
                break;
            case "2":ViewBugType();
                break;
            case "3": ViewAllBug();
                break;  
            case "4": UpdateBug();
                break;
            case "5": DeleteBug();
                break;
            case "6": x=0;
                break;  
            default:
                System.out.println("Invalid choice ");
                System.out.println("Press any key to continue...");
                br.readLine();       
          }

        }while(x==1); 
     } 
  public static   void AddNewBug()  throws Exception    //Function for Adding New Bugs in BugTpye Table
  {
    try
          {
            System.out.print("Enter bugCode: ");
            int id=Integer.parseInt(br.readLine());
            PreparedStatement pst=con.prepareStatement("select * from bugtype where bugCode=?");
            pst.setInt(1,id);
            ResultSet res=pst.executeQuery();
            if(!res.next())
            {
              pst=con.prepareStatement("insert into BugType values (?,?,?)");
              pst.setInt(1,id);
              System.out.println("Enter Bug Category:");
              pst.setString(2,br.readLine());
              System.out.println("Enter Bug Severty:");
              pst.setString(3,br.readLine());
              int res1=pst.executeUpdate();
              if(res1>0)
                System.out.println("Bug Details added...");
            }
            else
              System.out.println("Bug code Already Exist.....");
          }
          catch(Exception e)
          {
            System.out.println("Invalid Input");
          }
          finally{
            System.out.println("Press any key to continue........");
            br.readLine();
                }
  }

  public static void ViewBugType() throws Exception   //Function for Viewing Bug Types
  {

    Manager.clearScreen();
    PreparedStatement pst=con.prepareStatement("select * from bugtype");
    ResultSet res1=pst.executeQuery();
    int flag=0;
     
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
      flag=1;   
     
    }
    gotoxy(1,i);
    if(flag==0)
      System.out.println("\t\t\tNo Details Related to this Bug were Found..."); 
    System.out.println("+------------+----------------------------------------+-----------------------------+");
    System.out.println();
    System.out.println("Press any key to continue...");
    br.readLine();
     
  }
 
  public static   void ViewAllBug()  throws Exception        //Function for Viewing All Bugs available in BugReport
  {
        PreparedStatement pst=con.prepareStatement("select * from BugReport");
        ResultSet res=pst.executeQuery();
        int flag=0;
        Manager.clearScreen();
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
        System.out.println("|                                                                            No Bug Available.                                                                     |");
        System.out.println("+------------+-------------+-------------+-------------+-----------+--------------+--------------------------------------------------------------------------------+");
        System.out.println();
        System.out.println("Press any key to continue...");
        br.readLine();
  }
  public static void Update1(String temp) throws Exception   //Function for Updating Bug Report
    {
      
      try
          {
            System.out.print("Enter bugNo: ");
            int id=Integer.parseInt(br.readLine());
            PreparedStatement pst=con.prepareStatement("select * from BugReport where bugNo=?");
            pst.setInt(1,id);
            ResultSet res=pst.executeQuery();
            if(res.next())
            {
              System.out.println("Enter new "+temp);
              String S=br.readLine();
              S="update BugReport set "+temp+"='"+S+"'"+" where bugNo="+id;
              pst=con.prepareStatement(S);
              if(pst.executeUpdate()>0)
                System.out.println("Record Updated");
              else
                System.out.println("Record not Updated");
            }
            else
              System.out.println("Bug code Not Found");
          }
          catch(Exception e)
          {
            System.out.println("Invalid Input");
          }
          finally{
            System.out.println("Press any key to continue........");
            br.readLine();
                }
    }
  public static void UpdateBug() throws Exception  //Updating Bug Report
  {
       String choice;
       int x=1,res=0;
      do{
           Manager.clearScreen();
           System.out.println("\t\t\t*----------------------------------*");
           System.out.println("\t\t\t|       Bug Update Screen          |");
           System.out.println("\t\t\t*----------------------------------*");
           System.out.println("\t\t\t|   1. Update Bug Status\t   |");
          System.out.println("\t\t\t|   2. update Bug Description\t  |");
          System.out.println("\t\t\t|   3. Back\t\t\t   |");
          System.out.println("\t\t\t*----------------------------------*");
          System.out.print("\t\t\t  Enter the choice you want to opt:");
          choice=br.readLine();
          switch(choice)
          {
            case "1":Update1("status"); 
                  break;
            case "2":Update1("bugDes");
                  break;
            case "3":x=0;
                 break;
            default:
                System.out.println("Invalid choice:");
                System.out.println("Press any key to continue...");
                br.readLine();
          }
      }while(x==1); 
  }

  public static void DeleteBug()  throws Exception  //Function for Deleting Bugs
  {
    try{
      PreparedStatement pst=con.prepareStatement("delete from BugReport where bugNo=?");
      System.out.println("Enter the Bug No to be delete");
      pst.setInt(1,Integer.parseInt(br.readLine()));
      int res=pst.executeUpdate();
      if(res>0)
      {
      System.out.println("Record deleted..");
      }
      }
      catch(Exception e){
      System.out.println("Invalid ID...");
    }
    finally{
      System.out.println("Press any key to continue...");
      br.readLine();}
  }
  public static void gotoxy(int x,int y)
  {
    char c = 0x1B;
    int row = y; int column = x;
    System.out.print(String.format("%c[%d;%df",c,row,column));
  }
}

