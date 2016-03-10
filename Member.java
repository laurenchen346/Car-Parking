


//import java.io.Serializable;
import java.util.ArrayList;





public class Member //implements Serializable
{
	 private String firstName;
	 
	    private String lastName;
	  
	    private String username;
	   private String address;
	    private String email;
	  
	    private String password;
	    private String sjsuID;
	    private int status;
	    // the user's user type (driver/passenger/both) */
	    private String memberType;
	    private MemberSchedule memberschedule;
	    // the carpools in which this user is participating */
	    private ArrayList<Carpool> carpools;

public Member() 
{
   
    //this.memberType = MemberType.Passenger;
    carpools = new ArrayList<Carpool>();
   
}



public Member(String firstName, String lastName, String username,
        String email, String password, String sjsuID, String address,
        String memberType, int s )
{
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.password = password;
    this.address = address;
    this.sjsuID = sjsuID;
    this.status=s;
    this.memberType = memberType;
    carpools = new ArrayList<Carpool>();
   
}


public MemberSchedule getMemberschedule()
	{
		return memberschedule;
	}
	public void setMemberschedule(MemberSchedule ms)
	{
		memberschedule=ms;
	}


public void setFirstName(String firstName) { this.firstName = firstName; }



public void setLastName(String lastName) { this.lastName = lastName; }



public void setEmailAddress(String email) { this.email = email; }

public void setAddress(String address) { this.address = address; }

public void setPassword(String password) { this.password = password; }


public void setUserType(String MemberType)
{ this.memberType = memberType; }

public int checkStatus()
	 {
		 return status;
	 }
	 public void changeStatus(int n)
	 {
		 this.status=n;
	 }


// ------[MEMBER FUNCTIONS]------ //

//Add a carpool to this user.
    //param c the new carpool to which this student is participating
    

public void addCarpool(Carpool c)
{
    if (c != null)
        carpools.add(c);
}







public void clear()
{
    firstName = "";
    lastName = "";
    username = "";
    email = "";
    password = "";
    sjsuID= "";
    memberType = "";
    carpools.clear();
    
}



public void clearCarpools() { carpools.clear(); }




// Remove a carpool from this user.
   // @param c the carpool in which this user is no longer participating
    

public void removeCarpool(Carpool c)
{
    if (c != null)
        carpools.remove(c);
}










public String getFirstName() { return firstName; }


public String getLastName() { return lastName; }


public String getusername() { return username; }


public String getEmail() { return email; }



public String getsjsuID() { return sjsuID; }

public String getAddress(){ return address;}


public String getPassword() { return password; }



// Returns the user's user type (driver/passenger/both).
    //return the user's user type
    

//public MemberType getUserType() { return memberType; }


// Returns the user's carpools.
   // @return the user's carpools
   

public ArrayList<Carpool> getCarpools() { return carpools; }







}

