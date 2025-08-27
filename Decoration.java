package Expenses;
import java.util.*;
public class Decoration
{
	Scanner sc=new Scanner(System.in);
	double price=0;
	double price5=0;
	double q=0;
	double pq=0;
	double xy=0;
	public double displayItems(String slot)
	{
		System.out.print("Do we need to decorate: ");
		String p4=sc.nextLine();
		if(p4.equalsIgnoreCase("yes"))
		{
		String s=slot;
		System.out.println("Decoration preferences: ");
		System.out.println("1.Lighting");
		System.out.println("2.Baloons");
		System.out.println("3.Flowers");
		while(true)
		{
			System.out.println("Enter Decoration Preferences: ");
			int ch=sc.nextInt();
			switch(ch)
			{
				case 1:System.out.print("Lighting: ");
					System.out.print("Do you want simple Lighting: ");
					sc.nextLine();
					String p=sc.nextLine();
					if(p.equalsIgnoreCase("yes"))
					{
						if(s.equals("Morning"))
						{
							price+=2000;
						}
						price+=3000;
					}
					else
					{
						if(s.equals("Morning"))
						{
							price+=3000;
						}
						price+=4000;
					}
					break;
				case 2:System.out.print("Baloons: ");
					sc.nextLine();
					price+=5000;
					break;
				case 3:System.out.print("Flowers: ");
					sc.nextLine();
					price+=20000;
			}
			System.out.print("Do you have any other decoration Reference(yes/no): ");
			String 	q=sc.nextLine();
			if(q.equalsIgnoreCase("no"))
			{
				break;
			}
		}
		}
		return price;
	}
	public double cakeDetails()
	{
		System.out.print("Do you want cake: ");
		String p1=sc.nextLine();
		if(p1.equalsIgnoreCase("yes"))
		{		
		System.out.println("Select your cake flavour: ");
		System.out.println("1.Chocolate - 250/kg");
		System.out.println("2.Strawberry 200/kg");
		System.out.println("3.BlackForest - 300/kg");
		System.out.println("4.Vanilla - 150/kg");
		int ch1=sc.nextInt();
		switch(ch1)
		{
			case 1:System.out.println("Chocolate");
				System.out.print("Enter Quantity of cake: ");
				q=sc.nextDouble();
				price5+=250*q;
				break;
			case 2:System.out.println("Strawberry");
				System.out.print("Enter Quantity of cake: ");
				q=sc.nextDouble();
				price5+=200*q;
				break;	
			case 3:System.out.println("BlackForest");
				System.out.print("Enter Quantity of cake: ");
				q=sc.nextDouble();
				price5+=300*q;
				break;
			case 4:System.out.println("Vanilla");
				System.out.print("Enter Quantity of cake: ");
				q=sc.nextDouble();
				price5+=150*q;
				break;
			default:System.out.println("Invalid Choice");
				break;
		}
		}
		return price5;
	}
	public double photographerDetails()
	{
		System.out.print("Do you want photographer: ");
		sc.nextLine();
		String p2=sc.nextLine();
		if(p2.equalsIgnoreCase("yes"))
		{
		System.out.println("one hour-2000");
		System.out.print("Enter number of hours: ");
		int l=sc.nextInt();
		pq=2000*l;
		}
		return pq;
	}
	public double musicDetails()
	{
		System.out.print("Do you want music: ");
		sc.nextLine();
		String p3=sc.nextLine();
		if(p3.equalsIgnoreCase("yes"))
		{
		System.out.println("1.Pleasant Music");
		System.out.println("2.Dj");
		int q;
		System.out.println("Enter your preference: ");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:System.out.println("one hour-2000");
				System.out.print("Enter number of hours: ");
				q=sc.nextInt();
				xy=2000*q;
				break;
			case 2:System.out.println("one hour-3000");
				System.out.print("Enter number of hours: ");
				q=sc.nextInt();
				xy=2000*q;
				break;
			default:System.out.println("Invalid Choice");
				break;
		}
		}
		return xy;
	}
}					