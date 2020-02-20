package com.epam.Assignment_3_cleancode;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Interest
{
	double pri;
	double rateOfInt;
	double timePer;
	Interest(double pri,double rateOfInt,double timePer)
	{
		 this.pri=pri;
		 this.rateOfInt=rateOfInt;
		 this.timePer=timePer;
	}
	double simpleInt()
	{
		return (pri*rateOfInt*timePer)/100;
	}
	double compInt()
	{
		return principle*Math.pow((1+(rateOfInt/100)),timePer);
	}
}
class HouseConst
{
	String matStandard;
	double totalArea;
	boolean autoHouse;
	HouseConst(String matStandard,double totalArea,boolean autoHouse)
	{
		this.matStandard=matStandard;
		this.totalArea=totalArea;
		this.autoHouse=autoHouse;
	}
	double totalConstCost()
	{
		double totalCost=0.0;
		if(matStandard.equals("standard"))
		{
			totalCost=1200*totalArea;		
		}
		else if(matStandard.equals("above the standard"))
		{
			totalCost=1500*totalArea;
		} 
		else if(matStandard.equals("high than the standard"))
		{
			if(autoHouse==true)
				totalCost=2500*totalArea;
			else
				totalCost=1800*totalArea;
		}
		return totalCost;
			
	}
}
public class Serial 
{
    public static void main( String[] args ) throws IOException
    {
    	Scanner scanner = new Scanner(System.in);
    	OutputStreamWriter op = new OutputStreamWriter(System.out);
    	double pri,rateOfInt,timePer,totalAmount,totalArea,interestCalculated,totalHouseCost;
    	char choiceAtEnd;
    	boolean autoHouse;
    	int ch;
    	String matStandard;
    	do
    	{
    		
    		
    		op.write("\nMenu");
    		op.flush();
    		op.write("\n1.Interest Calculator");
    		op.flush();
    		op.write("\n2.Total Construction Cost");
    		op.flush();
    		op.write("\n Enter your choice .");
    		op.flush();
    		choice=scanner.nextInt();
    		op.flush();
    		switch(ch)
    		{
    			case 1: op.write("Interest Calculator");
    					op.flush();
    					op.write("\n Enter the principle Amount");
    					op.flush();
    					pri = scanner.nextDouble();
    					op.write("\n Enter the Rate of Interest p.a.");
    					op.flush();
    					rateOfInt = scanner.nextDouble();
    					op.write("\n Enter the time period(years)");
    					op.flush();
    					timePer = scanner.nextDouble();
    					Interest interest = new Interest(pri,rateOfInt,timePer);
    					op.write("\n \n Compute");
    					op.flush();
    					op.write("\n 1.Simple Interest");
    					op.flush();
    					op.write("\n 2.Compound Interest");
    					op.flush();
    					op.write("\n Enter your choice");
    					op.flush();
    					ch= scanner.nextInt();
    					switch(ch)
    					{
        	    			case 1: interestCalculated = interest.simpleInt();
        	    					totalAmount=pri+interestCalculated;
        	    					op.write("\n Simple Interest : " + interestCalculated);
        	    					op.flush();
        	    					op.write("\n Total Amount : " + totalAmount);
        	    					op.flush();
        	    					break;
        	    			case 2: interestCalculated = interest.compInt();
        	    					totalAmount=interestCalculated;
        	    					interestCalculated=interestCalculated-pri;
        	    					op.write("\n Compound Interest : " + interestCalculated);
        	    					op.flush();
        	    					op.write("\n Total Amount : " + totalAmount);
        	    					op.flush();
        	    					break;
        	    			default:op.write("\n Wrong Choice");
								 	op.flush();
								 	break;	
    					}
    					break;
    			case 2: output.write("\n Total Construction Cost Calculation");
    					op.flush();
    					scanner.nextLine();
    					op.write("\n Enter the Material Standard(standard/above the standard/high than the standard)");
    					op.flush();
    					matStandard = scanner.nextLine();
    					op.write("\n Enter the total Area of the house");
    					op.flush();
    					totalArea = scanner.nextDouble();
    				    autoHouse=false;
    					if(matStandard.equals("high than the standard"))
    					{
    						op.write("\n Do you want to have auotmated house(true/false)");
    						op.flush();
    						autoHouse=scanner.hasNextBoolean();
    					}
    					HouseConstruction house = new HouseConstruction(matStandard,totalArea,autoHouse);
    					totalHouseCost=house.totalConstructionCost();
    					op.write("\n Total Construction Cost :" + totalHouseCost);
    					op.flush();
    					break;
    			default:op.write("\n Wrong Choice");
						op.flush();
						break;
    		}
    		op.write("\n Do you want to continue");
    		op.flush();
    		scanner.nextLine();
    		choiceAtEnd = scanner.next().charAt(0);
    		}while(choiceAtEnd!='n' && choiceAtEnd!='N');
    		scanner.close();	
    }
}