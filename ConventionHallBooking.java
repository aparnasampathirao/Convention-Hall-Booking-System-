import Expenses.Veg;
import Expenses.NonVeg;
import Expenses.VegBill;
import Expenses.NonVegBill;
import Expenses.Decoration;
import java.io.*;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.lang.*;
import java.io.PrintWriter;
import java.util.*;
class Options
{
	Scanner sc=new Scanner(System.in);
	public String Name;
	public String EventDate;
	public int HallNo;
	public String Event;
	public String currentdate;
	public int ch;
	public String slot;
	public boolean b;
	Options(String Name,String EventDate,String currentdate,int ch,String slot)
	{
		this.Name=Name;
		this.currentdate=currentdate;
		this.EventDate=EventDate;
		this.ch=ch;
		this.slot=slot;
	}
    	public String getEvent(int ch)
	{
		Event="";
		switch(ch)
		{
			case 1:Event+="Birthday";
					break;
			case 2:Event+="Marriage";
					break;
			case 3:Event+="Engagement";
					break;
			case 4:Event+="Others";
					break;
			default:Event+="Invalid Choice";
					break;
		}
		return Event;
	}
	 public static String generateBookingID(String eventDate, String event, String slot) 
	{
        	String formattedDate = eventDate.replace("-", "");
        	return formattedDate + "_" + event + "_" + slot;
    	}
    	public static boolean bookingIDExists(String bookingID) 
	{
        	try (Scanner fileSc = new Scanner(new File("conventionhall.txt"))) 
		{
            		while (fileSc.hasNextLine()) 
			{
                		String line = fileSc.nextLine().trim();
                		if (line.startsWith("Booking ID: " + bookingID)) 
				{
                    			return true; 
                		}
           		}
        	}
		catch (IOException e) 
		{
            		System.out.println("Error reading from file: " + e.getMessage());
        	}
        	return false; 
    	}
}

class Birthday extends Options
{
	Scanner sc=new Scanner(System.in);
	public String slot1,Id;
	public double HallPrice=0,dPrice=0,price5=0;
	Birthday(Options op)
	{
		super(op.Name,op.EventDate,op.currentdate,op.ch,op.slot);
		slot1=op.slot;
	}
	public void Details()
	{
		Id=generateBookingID(EventDate, getEvent(ch), slot1);
		if (bookingIDExists(Id)) 
		{
            		System.out.println("Hall already booked");
			System.exit(0);
        	}
	}
	public double calculateHallPrice() 
	{
       		System.out.println("Name: " + Name);
       		System.out.println("Date: " + EventDate);
		System.out.print("Do you want AC Hall: ");
		String p=sc.nextLine();
		HallPrice += p.equalsIgnoreCase("yes") ? 30000 : 15000;
		return HallPrice;
	} 
	public String getId()
	{
		return Id;
	}
}
class Engagement extends Options
{
	Scanner sc=new Scanner(System.in);
	public String slot,Id;
	public double HallPrice=0,dPrice=0,price5=0;
	Engagement(Options op)
	{
		super(op.Name,op.EventDate,op.currentdate,op.ch,op.slot);

	}
	public void Details()
	{
		Id=generateBookingID(EventDate, getEvent(ch), slot);
		if (bookingIDExists(Id)) 
		{
            		System.out.println("Hall already booked");
			System.exit(0);
        	}
	}

	public double calculateHallPrice()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Name: " + Name);
       		System.out.println("Date: " + EventDate);
		System.out.print("Do you want AC Hall: ");
		String p=sc.nextLine();
		HallPrice += p.equalsIgnoreCase("yes") ? 30000 : 15000;
		return HallPrice;
	}
	public String getId()
	{
		return Id;
	}
}
class Marriage extends Options
{
	Scanner sc=new Scanner(System.in);
	public String slot,Id;
	public double HallPrice=0,dPrice=0,price5=0;
	Marriage(Options op)
	{
		super(op.Name,op.EventDate,op.currentdate,op.ch,op.slot);
	}
	public void Details()
	{
		Id=generateBookingID(EventDate, getEvent(ch), slot);
		if (bookingIDExists(Id)) 
		{
            		System.out.println("Hall already booked");
			System.exit(0);
        	}
	}
	public double calculateHallPrice()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Name: " + Name);
       		System.out.println("Date: " + EventDate);
		System.out.print("Do you want AC Hall: ");
		String p=sc.nextLine();
		HallPrice += p.equalsIgnoreCase("yes") ? 30000 : 15000;
		return HallPrice;
	}
	public String getId()
	{
		return Id;
	}
}
class Others extends Options
{
	Scanner sc=new Scanner(System.in);
	public String slot,Id;
	public double HallPrice=0,dPrice=0,price5=0;
	Others(Options op)
	{
		super(op.Name,op.EventDate,op.currentdate,op.ch,op.slot);
	}
	public void Details()
	{
		Id=generateBookingID(EventDate,getEvent(ch), slot);
		if (bookingIDExists(Id)) 
		{
            		System.out.println("Hall already booked");
			System.exit(0);
        	}
	}
	public double calculateHallPrice()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Name: " + Name);
       		System.out.println("Date: " + EventDate);
		System.out.print("Do you want AC Hall: ");
		String p=sc.nextLine();
		HallPrice += p.equalsIgnoreCase("yes") ? 30000 : 15000;
		return HallPrice;
	}
	public String getId()
	{
		return Id;
	}
}
public class ConventionHallBooking
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		Veg v=new Veg();
		NonVeg nv=new NonVeg();
		VegBill vb=new VegBill();
		NonVegBill vnb=new NonVegBill();
		Decoration d=new Decoration();
		double dPrice=0,price5=0,TPrice=0,price6=0,price7=0,Hp=0;			
        		int HallNo = 0;
			String bookingId="",Event="",Menu="",slot="";
        		double HallPrice = 0;
        		int FoodPrice = 0,TotalFoodPrice=0;
		LocalDate Date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        	String currentdate = Date.format(formatter);
		System.out.print("Enter Name: ");
		String Name=sc.nextLine();
		System.out.print("Enter Event Date: ");
		String EventDate=sc.nextLine();	
        	StringTokenizer tokenizer1 = new StringTokenizer(currentdate, "-");
        	StringTokenizer tokenizer2 = new StringTokenizer(EventDate, "-");
        	Calendar calendar1 = Calendar.getInstance();
        	calendar1.set(Integer.parseInt(tokenizer1.nextToken()),Integer.parseInt(tokenizer1.nextToken()) - 1,Integer.parseInt(tokenizer1.nextToken()));
        	Calendar calendar2 = Calendar.getInstance();
        	calendar2.set(Integer.parseInt(tokenizer2.nextToken()), Integer.parseInt(tokenizer2.nextToken()) - 1, Integer.parseInt(tokenizer2.nextToken()));
			if(calendar2.after(calendar1)) 
			{
            			System.out.println("The date you entered is past date so please enter the correct date ");
				System.exit(0);
        		}
			System.out.println("Events in the Convention Hall");
			System.out.println("1.Birthday Parties");
			System.out.println("2.Marriage");
			System.out.println("3.Engagement");
			System.out.println("4.Others");
			System.out.print("Enter the event: ");
			int ch=sc.nextInt();
			System.out.println("Available slots: ");
		System.out.println("1.Morning(8:00Am - 3:00Pm)");
		System.out.println("2.Evening(8:00Pm-12:00Am)");
		System.out.print("Enter the slot: ");
		int ccc=sc.nextInt();
		switch(ccc)
		{
			case 1:slot="Morning";
				break;
			case 2:slot="Evening";
				break;
		}
		System.out.print("Enter Number of guests: ");
		int G=sc.nextInt();
			Options op=new Options(Name,EventDate,currentdate,ch,slot);
			switch(ch)
			{
				case 1:System.out.println("Birthday Party:");
				        Birthday b=new Birthday(op);
					b.Details();
					bookingId=b.getId();
      					Event=b.getEvent(ch);
					HallNo=101;
					HallPrice=b.calculateHallPrice();
						dPrice=d.displayItems(slot);
						price5=d.cakeDetails();
						price6=d.photographerDetails();
						price7=d.musicDetails();
					TPrice=dPrice+price5+price6+price7;
					break;
				case 2:System.out.println("Marriage:");
					Marriage m=new Marriage(op);
					m.Details();
					bookingId=m.getId();
					Event=m.getEvent(ch);
      					HallNo=102;
					HallPrice=m.calculateHallPrice();
					dPrice=d.displayItems(slot);
					price6=d.photographerDetails();
					price7=d.musicDetails();
					TPrice=dPrice+price5+price6+price7;
					break;
				case 3:System.out.println("Engagement:");
					Engagement e=new Engagement(op);
					e.Details();
					bookingId=e.getId();
					Event=e.getEvent(ch);
					HallNo=103;
					HallPrice=e.calculateHallPrice();
					dPrice=d.displayItems(slot);
					price5=d.cakeDetails();
					price6=d.photographerDetails();
					price7=d.musicDetails();
					TPrice=dPrice+price5+price6+price7;
					break;
				case 4:System.out.println("Other Parties:");
					Others o=new Others(op);
					o.Details();
					bookingId=o.getId();
					Event=o.getEvent(ch);
       			                HallNo=104;
					HallPrice=o.calculateHallPrice();
					dPrice=d.displayItems(slot);
					price5=d.cakeDetails();
					price6=d.photographerDetails();
					price7=d.musicDetails();
					TPrice=dPrice+price5+price6+price7;
					break;
				default:System.out.println("Invalid Choice");
					break;

			}
			System.out.print("Do you want Food: ");
			sc.nextLine();
			String p=sc.nextLine();
			if(p.equalsIgnoreCase("yes"))
			{
			System.out.println("Select your Menu");
			System.out.println("1.Veg");
			System.out.println("2.NonVeg");
			System.out.println("3.Both Veg and NonVeg");
			System.out.println("Enter your choice:");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:v.displayVegMenu();
					FoodPrice=vb.calculateBill();
					Menu=vb.getString();
					System.out.println("Food Price:"+FoodPrice);
					break;
				case 2:nv.displayNonVegMenu();
					FoodPrice=vnb.calculateBill();
					Menu=vnb.getString();
					System.out.println("Food Price: "+FoodPrice);
					break;
				case 3:System.out.println("Firstly Order the veg dishes:");
					v.displayVegMenu();
					int price2=vb.calculateBill();
					String Menu1=vb.getString();
					System.out.println("Order NonVeg dishes:");
					nv.displayNonVegMenu();
					int price3=vnb.calculateBill();
					String Menu2=vnb.getString();
					Menu=Menu1+Menu2;
					FoodPrice=price2+price3;
					System.out.println("Food Price: "+FoodPrice);
					break;
				default:System.out.println("Invalid option");
					break;	
			}
			TotalFoodPrice=FoodPrice*G;
		}
	    try (PrintWriter pw = new PrintWriter(new FileWriter("conventionhall.txt",true))) 
	   {
            pw.println("Convention Hall Booking Details:");
            pw.println("-------------------------------");
            pw.println("Name: " + Name);
            pw.println("Date: " + EventDate);
	    pw.println("Booking ID: " + bookingId);
	    pw.println("Event: "+Event);
	    pw.println("Number of Guests: "+G);
            pw.println("Hall Number: " + HallNo);
	    pw.println("Slot: "+slot);
            pw.println("Hall Price: " + HallPrice);
	    if(dPrice>0)
	   {
		pw.println("Decoration Price: "+dPrice);
	    }
	    if(price5>0)
	    {
		pw.println("cake Price: "+price5);
	    }
            if(price6>0)
	    {
		pw.println("Photographer Price: "+price6);
            }
	    if(price7>0)
	    {
		pw.println("Music Price: "+price7);
            }
	    if(TotalFoodPrice>0)
	    {
              pw.println("TotalFood Price: " + TotalFoodPrice);
	      pw.println("Selected Menu: "+Menu);
	    }
            pw.println("Total Price: " + (HallPrice + TotalFoodPrice+TPrice));
            pw.println("-------------------------------");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
	 System.out.println("Convention Hall Booking Details:");
           System.out.println("-------------------------------");
            System.out.println("Name: " + Name);
            System.out.println("Date: " + EventDate);
	   System.out.println("Event: "+Event);
	  System.out.println("Number of Guests: "+G);
         System.out.println("Hall Number: " + HallNo);
	   System.out.println("Slot: "+slot);
           System.out.println("Hall Price: " + HallPrice);
		if(dPrice>0)
	   {
		 System.out.println("Decoration Price: "+dPrice);
	    }
	    if(price5>0)
	    {
		 System.out.println("cake Price: "+price5);
	    }
            if(price6>0)
	    {
		 System.out.println("Photographer Price: "+price6);
            }
	    if(price7>0)
	    {
		 System.out.println("Music Price: "+price7);
            }
	    if(TotalFoodPrice>0)
	    {
               System.out.println("TotalFood Price: " + TotalFoodPrice);
	       System.out.println("Selected Menu: "+Menu);
	    }
             System.out.println("Total Price: " + (HallPrice + TotalFoodPrice+TPrice));
             System.out.println("-------------------------------");

        }
}		