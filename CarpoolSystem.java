



import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class CarpoolSystem 
{
	public static void main(String[] arg) throws IOException
	{
		Scanner in=new Scanner(System.in);
		  System.out.println("[S]ign up, [L]ogin");
		  String command=in.next();
		  boolean done=false;
		  if(command.toUpperCase().equals("S"))
		  {
			  Membership membership=new Membership();
			  System.out.println("[D]river or [P]assenger? ");
			  Scanner letter=new Scanner(System.in);
			  String p=letter.next();
			  if(p.toUpperCase().equals("D"))
			  {
				  Member driverMember=membership.driverSignup();
				String sjsuID = driverMember.getsjsuID();
	  			HashMap<String, MemberSchedule> map = new HashMap<String, MemberSchedule>();
				     while(!done)
					   {
						  System.out.println("[A]ccount, [M]ember schedule, [R]ide schedule, [Q]uit");
						  String operation=in.next();
						  boolean finish1=false;
				    	while(!finish1)
						    {
						  if(operation.toUpperCase().equals("A")) 
						  {
							  System.out.println("[V]iew account info, [E]dit account info, [G]o back");
							  String operation1=in.next();
							  if(operation1.toUpperCase().equals("V")) 
							  {
								 System.out.println(membership.viewMembership(driverMember));
							  }
							  if(operation1.toUpperCase().equals("E")) 
							  {
								  membership.editMembership(driverMember);
							  }
							  if(operation1.toUpperCase().equals("G")) 
							  {
								  finish1=true;
							  }
						  	} else {
							finish1 = true;
						} 
						   }
				    	 boolean finish2=false;
				     	while(!finish2) 
					{
						if(operation.toUpperCase().equals("M")) 
						{
							MemberScheduleOps memberscheduleops = new MemberScheduleOps();
							if (!map.containsKey(sjsuID)) {
								System.out.println("Schedule does not exist for the user, want to create a schedule now? (Y/N): ");
								Scanner sample=new Scanner(System.in);
								String reply = sample.next();
								if (reply.toUpperCase().equals("Y")) {
									System.out.println("start");
									MemberSchedule schedule = memberscheduleops.CreateSchedule();
									map.put(sjsuID, schedule);
									driverMember.setMemberschedule(schedule);
									System.out.println("end");
								} else {
									finish2 = true;
								}
							} else {
								MemberSchedule schedule = map.get(sjsuID);								
								System.out.println("[V]iew member schedule, [E]dit member schedule, [G]o back");
								String operation2=in.next();
								if(operation2.toUpperCase().equals("V")) 
								{
									System.out.println(memberscheduleops.ViewSchedule(schedule));
								}
								if(operation2.toUpperCase().equals("E"))
								{
									memberscheduleops.EditSchedule(schedule);
								}
								if(operation2.toUpperCase().equals("G"))
								{
									finish2=true;
								}
							}
						} else {
							finish2 = true;
						}
					}
				     	boolean finish3=false;
				     	while(!finish3)
				 		    {
				 		  if(operation.toUpperCase().equals("R")) 
				 		  {

					 			 CarpoolSchedule carpoolschedule = new CarpoolSchedule();
						 			if(!map.containsKey(sjsuID))
						 		{
						 			System.out.println(" Would you like to create a Carpool Schedule? (Y/N)");
						 			Scanner ride = new Scanner(System.in);
						 			String rideY = ride.next();
						 			if (rideY.toUpperCase().equals("Y")){
						 			Carpool cschedule = carpoolschedule.CreateCarpool();
						 			System.out.println("end");
	
				 					}
				 					else
				 					{ finish3 = true;}}
				 				
				 					else {
				 						MemberSchedule schedule = map.get(sjsuID);
				 	

				 			  System.out.println("[V]iew ride schedule, [E]dit ride schedule, [G]o back");
				 			  String operation3=in.next();
				 			  if(operation3.toUpperCase().equals("V")) 
				 			  { 
				 				
				 				//System.out.println(memberscheduleops.ViewSchedule(schedule)); 
				 				//System.out.println("No stops due to lack of passengers...");
				 			  }
				 			  if(operation3.toUpperCase().equals("E")) 
				 			  {
				 				//System.out.println(ridescheduleops.EditSchedule(schedule));  
				 			  }
				 			  if(operation3.toUpperCase().equals("G")) 
				 			  {
				 				  finish3=true;
				 			  }}
				 		  } else {
							finish3 = true;
						}
				 		    }
						  if(operation.toUpperCase().equals("Q")) 
						  {
							  String fileName="database.txt";
							  membership.quitTheSystemAfterSignUp(fileName);
							  done=true;
						  }
				     
						  
				    	}  
				  
			  }
			  else if(p.toUpperCase().equals("P"))
			  {
				  Member passengerMember=membership.passengerSignup();
				  
					String sjsuID = passengerMember.getsjsuID();
		  			HashMap<String, MemberSchedule> map = new HashMap<String, MemberSchedule>();
					     while(!done)
						   {
							  System.out.println("[A]ccount, [M]ember schedule, [R]ide schedule, [Q]uit");
							  String operation=in.next();
							  boolean finish1=false;
					    	while(!finish1)
							    {
							  if(operation.toUpperCase().equals("A")) 
							  {
								  System.out.println("[V]iew account info, [E]dit account info, [G]o back");
								  String operation1=in.next();
								  if(operation1.toUpperCase().equals("V")) 
								  {
									 System.out.println(membership.viewMembership(passengerMember));
								  }
								  if(operation1.toUpperCase().equals("E")) 
								  {
									  membership.editMembership(passengerMember);
								  }
								  if(operation1.toUpperCase().equals("G")) 
								  {
									  finish1=true;
								  }
							  	} else {
								finish1 = true;
							} 
							   }
					    	 boolean finish2=false;
					     	while(!finish2) 
						{
							if(operation.toUpperCase().equals("M")) 
							{
								MemberScheduleOps memberscheduleops = new MemberScheduleOps();
								if (!map.containsKey(sjsuID)) {
									System.out.println("Schedule does not exist for the user, want to create a schedule now? (Y/N): ");
									Scanner sample=new Scanner(System.in);
									String reply = sample.next();
									if (reply.toUpperCase().equals("Y")) {
										System.out.println("start");
										MemberSchedule schedule = memberscheduleops.CreateSchedule();
										map.put(sjsuID, schedule);
										System.out.println("end");
									} else {
										finish2 = true;
									}
								} else {
									MemberSchedule schedule = map.get(sjsuID);								
									System.out.println("[V]iew member schedule, [E]dit member schedule, [G]o back");
									String operation2=in.next();
									if(operation2.toUpperCase().equals("V")) 
									{
										System.out.println(memberscheduleops.ViewSchedule(schedule));
									}
									if(operation2.toUpperCase().equals("E"))
									{
										memberscheduleops.EditSchedule(schedule);
									}
									if(operation2.toUpperCase().equals("G"))
									{
										finish2=true;
									}
								}
							} else {
								finish2 = true;
							}
						}
					     	boolean finish3=false;
					     	while(!finish3)
					 		    {
					 		  if(operation.toUpperCase().equals("R")) 
					 		  {
					 			 CarpoolSchedule carpoolschedule = new CarpoolSchedule();
						 			if(!map.containsKey(sjsuID))
						 		{
						 			System.out.println(" Would you like to create a Carpool Schedule? (Y/N)");
						 			Scanner ride = new Scanner(System.in);
						 			String rideY = ride.next();
						 			if (rideY.toUpperCase().equals("Y")){
						 			Carpool cschedule = carpoolschedule.CreateCarpool();
						 			System.out.println("end");
	
					 					}
					 					else
					 					{ finish3 = true;}}
					 				
					 					else {
					 						MemberSchedule schedule = map.get(sjsuID);
					 	

					 			  System.out.println("[V]iew ride schedule, [E]dit ride schedule, [G]o back");
					 			  String operation3=in.next();
					 			  if(operation3.toUpperCase().equals("V")) 
					 			  { 
					 				
					 				//System.out.println(memberscheduleops.ViewSchedule(schedule)); 
					 				//System.out.println("No stops due to lack of passengers...");
					 			  }
					 			  if(operation3.toUpperCase().equals("E")) 
					 			  {
					 				//System.out.println(ridescheduleops.EditSchedule(schedule));  
					 			  }
					 			  if(operation3.toUpperCase().equals("G")) 
					 			  {
					 				  finish3=true;
					 			  }}
					 		  } else {
								finish3 = true;
							}
					 		    }
							  if(operation.toUpperCase().equals("Q")) 
							  {
								  done=true;
							  }
					     
							  
					    	}  
					  
				  }
			  }
		  
		  if(command.toUpperCase().equals("L")) //not sure how to write it yet~(no database yet)
		  {
			  Scanner login=new Scanner(System.in);
			  System.out.println("Username: ");
			  String username=login.next();
			  Scanner loginpw=new Scanner(System.in);
			  System.out.println("Password: ");
			  String password=loginpw.next();
			  
			  Membership membership=new Membership();
			  Member member=membership.login(username, password);
			  while(!done)
			   {
				  System.out.println("[A]ccount, [M]ember schedule, [R]ide schedule, [Q]uit");
				  String operation=in.next();
				  boolean finish1=false;
		    	while(!finish1)
				    {
				  if(operation.toUpperCase().equals("A")) 
				  {
					  System.out.println("[V]iew account info, [E]dit account info, [G]o back");
					  String operation1=in.next();
					  if(operation1.toUpperCase().equals("V")) 
					  {
						 System.out.println(membership.viewMembership(member));
					  }
					  if(operation1.toUpperCase().equals("E")) 
					  {
						  membership.editMembership(member);
					  }
					  if(operation1.toUpperCase().equals("G")) 
					  {
						  finish1=true;
					  }
				  	} else {
					finish1 = true;
				} 
				   }
		    	/*
		    	 boolean finish2=false;
		     	while(!finish2) 
			{
				if(operation.toUpperCase().equals("M")) 
				{
					MemberScheduleOps memberscheduleops = new MemberScheduleOps();
					
					if (!map.containsKey(sjsuID)) {
						System.out.println("Schedule does not exist for the user, want to create a schedule now? (Y/N): ");
						Scanner sample=new Scanner(System.in);
						String reply = sample.next();
						if (reply.toUpperCase().equals("Y")) {
							System.out.println("start");
							MemberSchedule schedule = memberscheduleops.CreateSchedule();
							map.put(sjsuID, schedule);
							member.setMemberschedule(schedule);
							System.out.println("end");
						} else {
							finish2 = true;
						}
					} else {
						MemberSchedule schedule = map.get(sjsuID);								
						System.out.println("[V]iew member schedule, [E]dit member schedule, [G]o back");
						String operation2=in.next();
						if(operation2.toUpperCase().equals("V")) 
						{
							System.out.println(memberscheduleops.ViewSchedule(schedule));
						}
						if(operation2.toUpperCase().equals("E"))
						{
							memberscheduleops.EditSchedule(schedule);
						}
						if(operation2.toUpperCase().equals("G"))
						{
							finish2=true;
						}
					}
				} else {
					finish2 = true;
				}
				
			}
			*/
		    	/*
		     	boolean finish3=false;
		     	while(!finish3)
		 		    {
		 		  if(operation.toUpperCase().equals("R")) 
		 		  {
MemberScheduleOps memberscheduleops = new MemberScheduleOps(); 
						
		 				RideScheduleOps ridescheduleops = new RideScheduleOps();
		 				if(!map.containsKey(sjsuID)){
		 					System.out.println("Nothing displayed. Member schedule needed.Create now? (Y/N) ");
		 					Scanner sample=new Scanner(System.in);
		 					String reply = sample.next();
		 					if(reply.toUpperCase().equals("Y")) {
		 						System.out.println("start");
		 						MemberSchedule schedule = memberscheduleops.CreateSchedule();
		 						map.put(sjsuID, schedule);
		 						System.out.println("end");
		 					}
		 					else
		 					{ finish3 = true;}}
		 				
		 					else {
		 						MemberSchedule schedule = map.get(sjsuID);
		 	

		 			  System.out.println("[V]iew ride schedule, [E]dit ride schedule, [G]o back");
		 			  String operation3=in.next();
		 			  if(operation3.toUpperCase().equals("V")) 
		 			  { 
		 				
		 				System.out.println(memberscheduleops.ViewSchedule(schedule)); 
		 				//System.out.println("No stops due to lack of passengers...");
		 			  }
		 			  if(operation3.toUpperCase().equals("E")) 
		 			  {
		 				System.out.println(ridescheduleops.EditSchedule(schedule));  
		 			  }
		 			  if(operation3.toUpperCase().equals("G")) 
		 			  {
		 				  finish3=true;
		 			  }}
		 		  } else {
					finish3 = true;
				}
		 		    }
				  if(operation.toUpperCase().equals("Q")) 
				  {
					  String fileName="database.txt";
					  membership.quitTheSystem(fileName);
					  done=true;
				  }
		     	
				  */
		    	}  
		    	
		  
			  
		  }
		  

		 		  
	}
}
