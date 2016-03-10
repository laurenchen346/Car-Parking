


import java.sql.Time;
import java.time.format.TextStyle;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;

public class MemberScheduleOps {
	public MemberSchedule CreateSchedule() {
		System.out.println("Is this one time ride(Y/N): ");
		Scanner oneT = new Scanner(System.in);
		String reply = oneT.next();
		boolean oneTime;
		boolean toSJSU;
		Time arrivalTime;
		Time departureTime;
		ArrayList<String> recurSchedule = new ArrayList<>();
		
		if (reply.toUpperCase().equals("Y")) {
			oneTime = true;
			System.out.println("Please specify direction (SJSU/Other): ");
			Scanner toSJ = new Scanner(System.in);
			String direction = toSJ.next();
			if (direction.toUpperCase().equals("SJSU"))
				toSJSU = true;
			else
				toSJSU = false;
			
			System.out.println("Please enter arrival Time (HH:MM:SS): ");
			Scanner aTime = new Scanner(System.in);
			String arrTime = aTime.next();
			
			arrivalTime = Time.valueOf(arrTime);
			
			System.out.println("Please enter departure Time (HH:MM:SS): ");
			Scanner dTime = new Scanner(System.in);
			String depTime = dTime.next();
			
			departureTime = Time.valueOf(depTime);
		
		} else {
			oneTime = false;
			toSJSU = false;
			arrivalTime = null;
			departureTime = null;
			recurSchedule = CreateRepeatedSchedule();
		}
	
		System.out.println("Please enter your address (Street,City,Zipcode): ");
		Scanner loc = new Scanner(System.in);
		String location = loc.next();
		String params[] = location.split(",");
		int zipCode = Integer.parseInt(params[2]);
		Location pickupLocation = new Location (params[0], params[1], zipCode);
		
		MemberSchedule newSchedule = new MemberSchedule(oneTime, recurSchedule, toSJSU, departureTime, arrivalTime, pickupLocation);
		return newSchedule;
	}
	
	public ArrayList<String> CreateRepeatedSchedule () {
		System.out.println("Enter Scheduled Carpool Time:");		
		ArrayList<String> recurSchedule = new ArrayList<>();
		String test = null;
		String test2 = null;
		for (DayOfWeek dayName : DayOfWeek.values()) {
			System.out.println("Do you want a ride on "+dayName+"?: (YES/NO) ");
			Scanner resp = new Scanner(System.in);
			String respStr = resp.next();
			if(respStr.toUpperCase().equals("YES")) {
				test = dayName.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
				System.out.print("Is this ride to SJSU? (YES/NO)");
				Scanner subresp = new Scanner(System.in);
				String subRespStr = subresp.next();
				
				if (subRespStr.toUpperCase().equals("YES")) {
					test +=	" to SJSU @";
					System.out.print("Enter departure time: (HH:MM)");
					Scanner subsubresp = new Scanner(System.in);
					String subsubrespStr = subsubresp.next();
					test += subsubrespStr;
					
					System.out.print("Do you also want ride From SJSU? (YES/NO)");
					Scanner subresp1 = new Scanner (System.in);
					String subRespStr1 = subresp1.next();
					if (subRespStr1.toUpperCase().equals("YES")) {
						test2 = dayName.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
						test2 += " from SJSU @";
						System.out.print("Enter departure time: (HH:MM)");
						Scanner subsubresp1 = new Scanner(System.in);
						String subsubrespStr1 = subsubresp1.next();
						test2 += subsubrespStr1;
					}			
				} else {
					test += " from SJSU @";
					System.out.print("Enter departure time: (HH:MM)");
					Scanner subsubresp = new Scanner(System.in);
					String subsubrespStr = subsubresp.next();
					test += subsubrespStr;
					
					System.out.print("Do you also want ride to SJSU? (YES/NO)");
					Scanner subresp1 = new Scanner (System.in);
					String subRespStr1 = subresp1.next();
					if (subRespStr1.toUpperCase().equals("YES")) {
						test2 = dayName.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
						test2 += " to SJSU @";
						System.out.print("Enter departure time: (HH:MM)");
						Scanner subsubresp1 = new Scanner(System.in);
						String subsubrespStr1 = subsubresp1.next();
						test2 += subsubrespStr1;
					}
				}
				recurSchedule.add(test);
				if (test2 != null) {
					recurSchedule.add(test2);	
				}
			}
		}
		return recurSchedule;
	}
	
	public String ViewSchedule(MemberSchedule ms) {
		boolean oneTime = ms.getOneTime();
		String[] recur = ms.getRecurSchedule();
		boolean toSJSU = ms.getToSJSU();
		Time arrivalTime = ms.getArrivalTime();
		Time departureTime = ms.getDepartureTime();
		Location pickUpLocation = ms.getPickUpLocation();
		String replyString = null;
		replyString = "Schedule:\n\t";
		if (oneTime) {
			replyString = "One Time \n";
		} else {
			for (String s : recur) {
				if (s != null)
					replyString += s + "\n\t";
			}
			replyString += "\n";
		}
		
		if (oneTime) {
			if (toSJSU) {
				replyString = replyString + "Direction: SJSU \n";
			} else {
				replyString = replyString + "Direction: Other \n";
			}
		}
		String Street = pickUpLocation.getStreet();
		String City = pickUpLocation.getCity();
		int ZipCode = pickUpLocation.getZipCode();
		String Code = Integer.toString(ZipCode);
		
		String Address = "\tStreet: " + Street + "\n\tCity: " + City + "\n\tZip code: " + Code +"\n";
		if (oneTime) {
			String TotalTime = " Arrival Time: " + arrivalTime.toString() + " Departure Time: " + departureTime.toString() + "\n"; 
			replyString += TotalTime; 
		}
		return replyString + "Pickup Address:\n" + Address; 
	}
	
	public void EditSchedule (MemberSchedule ms) {		
		boolean done=false;
		while (!done) {
			System.out.println("Choose one to edit: [S]chedule, [D]irection, [A]rrival Time, [D]eparture Time, [P]ickup Location, [G]o Back");
			Scanner command=new Scanner(System.in);
		  	String cmd=command.next();
		  	ArrayList<String> recurSchedule = new ArrayList<>();
		  	
		  	if(cmd.toUpperCase().equals("S")) {
		  		System.out.println("One Time or Scheduled (Y/N): ");
		  		Scanner oneT=new Scanner(System.in);
		  		String oneTime = oneT.next();
		  		if (oneTime == "Y") {
		  			ms.setOneTime(true);
		  			
		  			if(cmd.toUpperCase().equals("D")) {
				  		System.out.println("Direction SJSU? (Y/N): ");
				  		Scanner toSJ=new Scanner(System.in);
				  		String direction = toSJ.next();
				  		if (direction == "Y") {
				  			ms.setToSJSU(true);
				  		} else {
				  			ms.setToSJSU(false);
				  		}
				  	}
				  	
				  	if(cmd.toUpperCase().equals("A")) {
				  		System.out.println("Please enter new arrival Time (HH:MM:SS): ");
						Scanner aTime = new Scanner(System.in);
						String arrTime = aTime.next();
						java.sql.Time arrivalTime;
						arrivalTime = Time.valueOf(arrTime);
						ms.setArrivalTime(arrivalTime);
						
				  	}
				  	
				  	if(cmd.toUpperCase().equals("D")) {
				  		System.out.println("Please enter new arrival Time (HH:MM:SS): ");
						Scanner dTime = new Scanner(System.in);
						String depTime = dTime.next();
						java.sql.Time departureTime;
						departureTime = Time.valueOf(depTime);
						ms.setDepartureTime(departureTime);
						
				  	}
		  			
		  		} else {
		  			ms.setOneTime(false);
		  			recurSchedule = CreateRepeatedSchedule();
		  			ms.setRecurSchedule(recurSchedule);
		  		}
		  		
		  	}
		  	
		  	if(cmd.toUpperCase().equals("P")) {
		  		System.out.println("Please enter new pickup location(Street, City, Zipcode): ");
				Scanner loc = new Scanner(System.in);
				String location = loc.next();
				String params[] = location.split(",");
				int zipCode = Integer.parseInt(params[2]);
				Location pickupLocation = new Location (params[0], params[1], zipCode);
				ms.setPickUpLocation(pickupLocation);
		  	}				
		  	
		  	if(cmd.toUpperCase().equals("G")) {
		  		done = true;
		  	}
		}
		
	}
}