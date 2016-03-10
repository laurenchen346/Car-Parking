

import java.util.Scanner;
import java.io.*;

/**
 * @author lauren
 *
 */
public class Membership
{
	private Member member;
	public Member driverSignup()
	{
		  System.out.println("First name: ");
		  Scanner inFN=new Scanner(System.in);
		  String fname=inFN.next();
		  System.out.println("Last name: ");
		  Scanner inLN=new Scanner(System.in);
		  String lname=inLN.next();
		  System.out.println("User name: ");
		  Scanner uN = new Scanner(System.in);
		  String un = uN.next();
		  System.out.println("Email: ");
		  Scanner inEmail=new Scanner(System.in);
		  String email=inEmail.next();
		  System.out.println("Password: ");
		  Scanner pass=new Scanner(System.in);
		  String pw=pass.next();
		  System.out.println("SJSU ID: ");
		  Scanner inID=new Scanner(System.in);
		  String id=inID.next();
		  System.out.println("address: ");
		  Scanner inAddr=new Scanner(System.in);
		  String addr=inID.next();
		  System.out.println("Are you only driver or can be both?\n[D]river\n[B]oth?");
		  Scanner intype = new Scanner(System.in);
		  String ans = intype.next();
		  String membertype;
		  if(ans.equalsIgnoreCase("D")){
		   membertype = "driver";
		  }
		  else membertype = "both"; 	
		  Member driver=new Member(fname,lname,un, email,pw,id,membertype, addr,0);//0 represents driver status;
		  System.out.println("Following info is correct?");
		  System.out.println("First Name: " + fname + "\nLast Name: " + lname + "\nUser Name: " + un
					 + "\nemail: " + email + "\nAddress: " + addr + "\nMember type: " + membertype + "\nPassword: " + pw 
					 + "\nSJSU ID: " + id);
		  member=driver;
		  return driver;
	}
	public Member passengerSignup()
	{
		  System.out.println("First name: ");
		  Scanner inFN=new Scanner(System.in);
		  String fname=inFN.next();
		  System.out.println("Last name: ");
		  Scanner inLN=new Scanner(System.in);
		  String lname=inLN.next();
		  Scanner uN = new Scanner(System.in);
		  System.out.println("User name: ");
		  String un = uN.next();
		  System.out.println("Email: ");
		  Scanner inEmail=new Scanner(System.in);
		  String email=inEmail.next();
		  System.out.println("Password: ");
		  Scanner pass=new Scanner(System.in);
		  String pw=pass.next();
		  System.out.println("SJSU ID: ");
		  Scanner inID=new Scanner(System.in);
		  String id=inID.next();
		  String membertype = "passenger";
		  System.out.println("address: ");
		  Scanner inAddr=new Scanner(System.in);
		  String addr=inID.next();
		  System.out.println("Are you only driver or can be both?\n[P]assenger\n[B]oth?");
		  Scanner intype = new Scanner(System.in);
		  String ans = intype.next();
		  String membertype1;
		  if(ans.equalsIgnoreCase("P")){
		   membertype1 = "passenger";
		  }
		  else membertype1 = "both"; 
		  Member passenger=new Member(fname,lname,un,email,pw,id,addr, membertype1, 1);//1 represents Passenger status;
		  System.out.println("Following info is correct?");
		  System.out.println("First Name: " + fname + "\nLast Name: " + lname + "\nUser Name: " + un
					 + "\nemail: " + email + "\nAddress: " + addr + "\nMember type: " + membertype1 + "\nPassword: " + pw 
					 + "\nSJSU ID: " + id);
		  member=passenger;
		  return passenger;
	}
	public String viewMembership(Member m)
	{
		String fname=m.getFirstName();
		String lname=m.getLastName();
		String email=m.getEmail();
		String address=m.getAddress();
		String id=m.getsjsuID();
		return "name:  "+fname+" "+lname+"\n"+"Email:  "+email+"\n"+"SJSU ID:  "+id+"\n"+"Address:  "+ address;
	}
	public void editMembership(Member m) throws IOException
	{
		boolean finish=false;
     	while(!finish)
     	{
     		System.out.println("Choose one to edit: [E]mail, [A]ddress, [G]o back");
		  	Scanner command=new Scanner(System.in);
		  	String cmd=command.next();
		  	if(cmd.toUpperCase().equals("E")) 
	 		  {
		  		System.out.println("Type in new email: ");
		  		Scanner in=new Scanner(System.in);
				String email=in.next();
				m.setEmailAddress(email);
	 		  }
		  	if(cmd.toUpperCase().equals("A")) 
	 		  {
		  		System.out.println("Type in new Address: ");
		  		Scanner in=new Scanner(System.in);
				String addr=in.next();
				m.setAddress(addr);
	 		  }
		  	if(cmd.toUpperCase().equals("G")) 
	 		  {
		  		 finish=true;
	 		  }
     	}
	}
	public Member login(String un, String password) throws FileNotFoundException
	{
		Scanner txtscan = new Scanner(new File("database.txt"));
		String fn="";
    	String ln="";
    	String email="";
    	String sjsuid="";
    	String address="";
    	String membertype="";
    	String pickuplocation="";
    	String arrivetime="";
    	String departuretime="";
		while(txtscan.hasNextLine()){
		    String str = txtscan.nextLine();
		    if(str.indexOf(un) != -1){
		        String pw=txtscan.nextLine();
		        if(pw.indexOf(password)!= -1)
		        {
		        	fn=txtscan.nextLine();
		        	ln=txtscan.nextLine();
		        	email=txtscan.nextLine();
		        	sjsuid=txtscan.nextLine();
		        	address=txtscan.nextLine();
		        	membertype=txtscan.nextLine();
		        	pickuplocation=txtscan.nextLine();
		        	arrivetime=txtscan.nextLine();
		        	departuretime=txtscan.nextLine();
		        }
		        else
		        {
		        	System.out.println("Password Incorrect!");
		        }
		        
		    }
		}
		Member member=new Member(fn, ln, un,
	            email, password, sjsuid, address, membertype, 1);
		//MemberSchedule memberschedule=new MemberSchedule();
		return member;
	}
	public void quitTheSystemAfterSignUp(String filename) throws FileNotFoundException
	{
		 PrintWriter out=new PrintWriter(filename);
		 String username=member.getusername();
		 out.println(username);
		 String pw=member.getPassword();
		 out.println(pw);
		 String fn=member.getFirstName();
		 out.println(fn);
		 String ln=member.getLastName();
		 out.println(ln);
		 String email=member.getEmail();
		 out.println(email);
		 String ID=member.getsjsuID();
		 out.println(ID);
		 String address=member.getAddress();
		 out.println(address);
		 String pickuplocation=member.getMemberschedule().getPickUpLocation().toString();
		 out.println(pickuplocation);
		 String arrivaltime=member.getMemberschedule().getArrivalTime().toString();
		 out.println(arrivaltime);
		 String departuretime=member.getMemberschedule().getDepartureTime().toString();
		 out.println(departuretime);
		
		 
		 out.close();
		 
	}
}
	


