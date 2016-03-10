

public class Passenger 
{
	private String name;
	private String serviceClass;
	private String preference;
	private String groupName;
	
	public Passenger(String aName, String aServiceClass, String aPreference)
	{
		name=aName;
		serviceClass=aServiceClass;
		preference=aPreference;
	}
	public Passenger(String aName, String aServiceClass)
	{
	  name=aName;
	  serviceClass=aServiceClass;
	  
	}
	public void setPreference(String p)
	{
		preference=p;
	}
	public String getPreference()
	{
		return preference;
	}
	public void setName(String userName)
	{
		name=userName;
	}
	public String getName()
	{
		return name;
	}
	public void setGroupName(String gName)
	{
		groupName=gName;
	}
	public String getGroupName()
	{
		return groupName;
	}
	public void setServiceClass(String sClass)
	{
		serviceClass=sClass;
	}
	public String getServiceClass()
	{
		return serviceClass;
	}
	
	
	 
}
