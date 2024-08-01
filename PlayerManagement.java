package com.palyerManagement.prathm;
import java.util.Scanner;

import com.palyer.prathm.Player;
public class PlayerManagement {

		static Scanner scan = new Scanner(System.in);
		static int count = -1;
		public static void main(String[] args) {
		int choice;
		{
			Player[] player = new Player[30];
			do
			{
				System.out.println("\n********W-E-L-C-O-M-E**********\n\n1.Add Players \n2.Display Players \n3.Search by JerseyNo\n4.Search by Name\n5.Update player \n6.Remove Plyaer\n7.Sort Players\n8.EXIT \n");
				System.out.println("Enter your choice: ");
				choice = scan.nextInt();
				switch(choice)
				{
					case 1:
					{
						addPlayer(player);
						break;
					}
					case 2:
					{
						displayPlayer(player);
						break;
					}
					case 3:
					{
						int result = searchById(player);
						if(result>=0)
						{
							player[result].display();
						}
						if(result==-1)
						{
							System.out.println("Player details not Found");
						}
						break;
					}
					case 4:
					{	
						int res = searchByName(player);
						if(res>=0)
						{
							player[res].display();
						}
						if(res==-1)
						{
							System.out.println("Player details not Found");
						}
						break;
					}
					case 5:
					{	
						update(player);
						break;
					}
					case 6:
					{
						removePlayer(player);
						break;
					}
					case 7:
					{
						sortPlaye(player);
						break;
					}
					case 8:
					{
						System.out.println("__________THANK  YOU  FOR  VISIT________\n");
						break;
					}
					default:
						System.out.println("Enter valid choice\n");
				}
			}while(choice!=8);
		}
	}	
		public static void addPlayer(Player[] player) 
		{
			System.out.println("Enter the JerseyNo of Player: \n");
			int jerseyNo = scan.nextInt();
			scan.nextLine();
			System.out.println("Enter the Name of Player: \n");
			String name = scan.nextLine();
			System.out.println("Enter the Matches: \n");
			int matches = scan.nextInt();
			System.out.println("Enter the Runs: ");
			int runs = scan.nextInt();
			System.out.println("Enter the Wickets: ");
			int wickets = scan.nextInt();
			player[++count] = new Player(jerseyNo,name,matches,runs,wickets);
			System.out.println("______<Player-Added-Succesefully>_____");
		}
		public static void displayPlayer(Player[] player) 
		{
			for(int i=0 ; i<=count ; i++)
			{
				player[i].display();
			}		
		}
		public static int searchById(Player[] player) 
		{
			System.out.println("Enter the JerseyNo to Search: ");
			int jer = scan.nextInt();
			for(int i=0; i<=count; i++)
			{
				if(jer==(player[i].getJerseyNo()))
				{
					return i;
				}
				if(i==count+1)
				{
					return -1;
				}
			}
			return -1;
		}
		public static int searchByName(Player[] player) 
		{
			System.out.println("Enter the Name to Search: ");
			scan.nextLine();
			String nm = scan.nextLine();
			for(int i=0; i<=count; i++)
			{
				if(nm.equalsIgnoreCase(player[i].getName()))
				{
					return i;
				}
				if(i==count+1)
				{
					return -1;
				}
			}
			return -1;
		}
		private static void update(Player[] player) 
		{
			int results = searchById(player);
			if(results >= 0)
			{
				System.out.println("Enter the Matches to Update: ");
				int match = scan.nextInt();
				player[results].setMatches(match+(player[results].getMatches()));		
				System.out.println("Enter the Runs to Update: ");
				int runs = scan.nextInt();
				player[results].setRuns(runs+(player[results].getRuns()));
				System.out.println("Enter the Wickets to Update: ");
				int wickets = scan.nextInt();
				player[results].setWickets(wickets+(player[results].getWickets()));
				System.out.println("_____Player-Details-Updated-Succesfully____");
			}
			if(results==-1)
			{
				System.out.println("Player Not Found");
			}
		}
		public static void removePlayer(Player[] player)
		{
			int res = searchById(player);
			if(res>=0)
			{
				player[res] = player[res+1];
				System.out.println("_____Player-Details-Removed_____");
				count--;
			}
			else
			{
				System.out.println("Player Not Found");
			}
		}
		
		private static void sortPlaye(Player[] player)
		{
			int i;
			Player[] p = new Player[30];
			for(i=0 ; i<=count; i++)
			{
				p[i] = player[i];
			}
				System.out.println("1.Sort by Runs\n2.Sort by Wickets");
				int choice = scan.nextInt();
				if(choice == 1)
				{
					int j;
					Player temp;
					for(i=0;i<=count-1;i++)
					{
						for(j=0;j<=count-i-1;j++)
						{
							if(p[j].getRuns()<p[j+1].getRuns())
							{
								temp=p[j];
								p[j]=p[j+1];
								p[j+1]=temp;
							}
						}
					}
					for(i=0;i<=count;i++)
					{
						p[i].display();
					}
				}
				if(choice == 2)
				{
					int j;
					Player temp;
					for(i=0;i<=count-1;i++)
					{
						for(j=0;j<=count-i-1;j++)
						{
							if(p[j].getWickets()<p[j+1].getWickets())
							{
								temp=p[j];
								p[j]=p[j+1];
								p[j+1]=temp;
							}
						}
					}
					for(i=0;i<=count;i++)
					{
						p[i].display();
					}
				}		
		}
	}


