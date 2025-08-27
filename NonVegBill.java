package Expenses;
import java.util.Scanner;
public class NonVegBill
{
	String Food="";
	public int calculateBill()
	{
		Scanner sc=new Scanner(System.in);
		int price=0;
		while(true)
		{
			System.out.println("Enter the dish you want to order: ");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 11:Food=Food+"Manchuria\n";
					price+=80;
					break;
				case 12:Food=Food+"Chicken 65\n";
					price+=100;
					break;
				case 13:Food=Food+"Chicken lollipops\n";
					price+=100;
					break;
				case 21:Food=Food+"Dum Biryani\n";
					price+=150;
					break;
				case 22:Food=Food+"Chicken Fry Biryani\n";
					price+=150;
					break;
				case 23:Food=Food+"Mutton Biryani\n";
					price+=200;
					break;
				case 31:Food=Food+"Apricot Delight\n";
					price+=100;
					break;
				case 32:Food=Food+"Icecream\n";
					price+=80;
					break;
				case 33:Food=Food+"Gulab Jamun\n";
					price+=50;
					break;
				default:Food=Food+"Manchuria\n";
					break;
			}
			 System.out.println("Do you want to order more? (yes/no)");
			 sc.nextLine();
            		String p=sc.nextLine();
 	               if (p.equalsIgnoreCase("no")) 
            		{
                		    break;
            		}

		}
	       return price;
         }
	public String getString()
	{
		return Food;
	}


}
