/** Student Name:Baris Kaplan

 * This is a console program designed to conduct an audition for an architecture
 * competition. Four contestants are competing against each other given their 
 * education, experience and their conciousness about environment. 
 * 
**/

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Architect extends ConsoleProgram {

	public void run() {
		//RUN STARTS
	for(currentArchitectID=1;currentArchitectID<=CONTESTANT_NUM;currentArchitectID++) {
		println("NEW CONTESTANT: ");
	    assignPoint(currentArchitectID);
	    transitions();//This method puts spaces and lines between the contestants.
	}         
	    comparator();//This method compares the Architects' total points and according to these points, this method prints in which place the  Architect's are.
	    battleAndWinNumbers();
	    congratulations();//This method prints out the congratulatory message for the winner of Architect according to the winning point.
	    //RUN ENDS
    }

	////////////GIVEN HELPER METHODS /////////////////////
	// You need to implement the given helper methods ///
	// You ARE NOT ALLOWED to change the signature of the given methods.
	
	/**
	 * This methods asks the number of year of education and number of year of experience. 
	 * It will keep on asking user input until a valid input is read.
	 * @return - returns the knowledge point
	 */
	private double askKnowledge() {
		// your code starts here
				int numberOfEducation= readInt("Enter years of education Architect#"+currentArchitectID+": ");
				while(numberOfEducation<4||numberOfEducation>6) {//If the number of education is not in the suitable range, this method asks another number of education value from the suitable range.
					numberOfEducation= readInt("Enter a valid number of years of education of Architect#"+currentArchitectID+": " );
					if(4<=numberOfEducation&&numberOfEducation<=6) {
						break;
					}
				}
			    int numberOfExperience= readInt("Enter years of experience Architect#"+currentArchitectID+": ");
				while(numberOfExperience<2||numberOfExperience>10) {//If the number of experience is not in the suitable range, this method asks another number of experience value from the suitable range.
					 numberOfExperience= readInt("Enter a valid number of years of experience of Architect#"+currentArchitectID+" : ");	 
					 if(2<=numberOfExperience&&numberOfExperience<=10) {
						 break;
					 }
			    }
				return calculateKnowledge(numberOfEducation,numberOfExperience);
	 }
	/**
	 * This method calculates the knowledge point given the number of year of education 
	 * and the number of year of experience
	 * @param yearsEducation - the number of year of education
	 * @param yearsExperience - the number of year of experience
	 * @return - knowledge point
	 */
	private double calculateKnowledge(int yearsEducation, int yearsExperience) {//This method returns to the knowledge point which is calculated with the below formula.
		// your code starts here
		double knowledgePoint= Math.pow((yearsEducation+yearsExperience)/(5.0),(yearsExperience-2))+fibonacciNum(yearsEducation);
		return knowledgePoint;
		// your code ends here
	}
	/**
	 * This methods asks the number of projects and number of different projects. 
	 * It will keep on asking user input until a valid input is read.
	 * @return - returns the experience point
	 */
	private int askExperience() {
		// your code starts here
			int numOfProjects= readInt("Number of projects completed by Architect#"+currentArchitectID+": ");
			while(numOfProjects<4||numOfProjects>15) {
		    numOfProjects= readInt("Enter a valid number of projects completed by Architect#"+currentArchitectID+": " );
		        if(4<=numOfProjects&&numOfProjects<=15) {
		        	break;
		        }
		    }
		    int numOfDifProjects= readInt("Number of different projects of  Architect#"+currentArchitectID+": ");
			while(numOfDifProjects<2||numOfDifProjects>5) {
				numOfDifProjects= readInt("Enter a valid number of different projects of  Architect#"+currentArchitectID+":");
				if(2<=numOfDifProjects&&numOfDifProjects<=5) {
					break;
		        }
		    }
		    return calculateExperience(numOfProjects,numOfDifProjects);
	 }
	/**
	 * This method calculates the experience point given the number of projects
	 * and the different projects worked on.
	 * @param numProjects - number of projects
	 * @param numDifProjects - number of different projects
	 * @return - experience point
	 */
	private int calculateExperience(int numProjects, int numDifProjects) {//This method returns to the experience point which is calculated with the below formula.
		int y= (numProjects)*(factorial(numDifProjects));//I have defined the experience point as an integer y.
		return y;
	}

	/**
	 * This methods asks the number of awards received.
	 * It will keep on asking user input until a valid input is read.
	 * @return - number of awards
	 */
	
	private int askAwards() {//In this method,I have requested the number of awards from the user.
		//If the user enters a value out of the suitable boundaries for number of awards, I have requested the number of awards from the suitable range again.
			int awards= readInt("Number of awards of Architect#"+currentArchitectID+": ");
			while(awards<1||awards>5) {
				 awards= readInt("Enter a valid number of awards of Architect#"+currentArchitectID+": ");
				 if(1<=awards&&awards<=5) {
					 break;
			     }
			}
            return awards;
    }
	
	/**
	 * This method decides which architect gets the recycled materials.
	 * @return - whether the architect received a recycled material or not.
	 */
	private boolean hasRecycledMaterial() {  //In this method, I have determined if the architect has taken a recycled material.
		boolean g=rgen.nextBoolean();
        return g;
	}
	
	
	
	private int pointCalculator(double knowledge, int experience,  int awards, boolean hasRecycledMaterial) {
        double sum=0.0;
		if(hasRecycledMaterial){
			sum=(Math.sqrt(awards*experience))+(1.3*knowledge);//If the architect receives a recycled material, this method uses this formula for calculating the total point.
		}
		else {
		    sum=(Math.sqrt((awards*experience)))+(0.9*knowledge);//If the architect does not receive a recycled material, this method uses this formula for calculating the total point.
		}
		return round(sum);//By using this method, I have rounded the double value of sum.
	}
	
	/**
	 * This method assigns the total point calculator for a Architects and assigns to the correct Architect
	 * @param p - the total point of any given Architect
	 */
	private void assignPoint(int p) {
        if(currentArchitectID==1) {
        	totalPointOfArchitect1=pointCalculator(askKnowledge(),askExperience(),askAwards(),hasRecycledMaterial());//This part asks the knowledge,experience and awards for Architect1.
        	
        	println("Architect#1 has reached "+totalPointOfArchitect1+" points.");
        }
        else if(currentArchitectID==2) {
        	totalPointOfArchitect2=pointCalculator(askKnowledge(),askExperience(),askAwards(),hasRecycledMaterial());//This part asks the knowledge,experience and awards for Architect2.
        	
        	println("Architect#2 has reached "+totalPointOfArchitect2+" points.");
        }
        else if(currentArchitectID==3) {
        	totalPointOfArchitect3=pointCalculator(askKnowledge(),askExperience(),askAwards(),hasRecycledMaterial());//This part asks the knowledge,experience and awards for Architect3.
        	
        	println("Architect#3 has reached "+totalPointOfArchitect3+" points.");
        }
        else if(currentArchitectID==4) {
        	totalPointOfArchitect4=pointCalculator(askKnowledge(),askExperience(),askAwards(),hasRecycledMaterial());//This part asks the knowledge,experience and awards for Architect4.
        	
        	println("Architect#4 has reached "+totalPointOfArchitect4+" points.");
        }
	}
	
	/**
	 * This method compares the total point of all contestants and prints
	 * the first, second and third order of the Architect according to their total points.
	 */
	private void comparator() { 
		// your code starts here
	  for(int a=1;a<=4;a++) {
		  for(int b=1;b<=4;b++) {
			  for(int c=1;c<=4;c++) {
				  for(int d=1;d<=4;d++) {//By using for loop, I have considered all possible cases for the firstPoint, secondPoint , thirdPoint, firstID, secondID, and thirdID.
					  if(totalPointOfArchitect(a)>totalPointOfArchitect(b)&&totalPointOfArchitect(b)>totalPointOfArchitect(c)&&totalPointOfArchitect(c)>totalPointOfKUArchitect(d)) {
			            firstPoint= totalPointOfArchitect(a);//Because, totalPointOfKUArchitect(a) is the greatest.
						secondPoint=totalPointOfArchitect(b);
						thirdPoint=totalPointOfArchitect(c);
						firstID=a;
						secondID=b;
						thirdID=c;
			             }
					}
				}
			}
		}
	println("Architect#"+firstID+" becomes #1 with "+firstPoint+" points.");
	println("Architect#"+secondID+" becomes #2 with "+secondPoint+" points.");
	println("Architect#"+thirdID+" becomes #3 with "+thirdPoint+" points.");
	println();
	}
	
	////////////ADDITIONAL HELPER METHODS /////////////////////
	// Feel free to add additional helper methods
	// your code starts here
	
	
	private void transitions() {
		println("_________________________________");
		println();
		println();
	}
		
	private boolean winningPossibility(double p) {
		boolean r= rgen.nextBoolean();
		return r;
	}
	
	private int factorial(int u) {//This method calculates the multiplication of the numbers from 1 to u.
		int result=1; //Let u=0
		for(int p=1;p<=u;p++) {//Since u cannot be 0 in this for loop, factorial method does not execute it and returns the result.
			result*=p;
		}
		return result;//Finally, the result is 1. So, factorial(0)=1.
	}
	
	private int fibonacciNum(int a) {//This method prints out the fibonacci number according to the points which are written in this method as  parameters.
		int initialNum=1;
		int secondNum=1;
		for(int i=3;i<=a;i++) {
			int c= initialNum+secondNum;
			initialNum=secondNum;
			secondNum=c;
		}
		return secondNum;
	}
	
	private int round(double z) {//If the z value has a decimal point less than 0.5, this method returns the integer form of z value.
		if(z-(int)z<0.5) {//Let z=12.4. Then, 12.4-12=0.4. Moreover, 0.4<0.5
			return(int)z;//So, the rounded value of 12.4 is 12. 
		}                       //Let z=12.5.Since 12.5-12=0.5, this method gives 12+1=13. 13 is the rounded value of 12.5.
			return(((int)z)+1);//If the z value has a decimal point greater than or equal to 0.5, round method returns the ((integer form of z value)+1).
	}

	private int totalPointOfArchitect(int j) {
		// TODO Auto-generated method stub
		if(j==1) {
			return totalPointOfArchitect1; 
		}
		else if(j==2) {
			return totalPointOfArchitect2;
		}
		else if(j==3) {
			return totalPointOfArchitect3;
		}
		return totalPointOfArchitect4;
	}
	private void battleAndWinNumbers() {//This method creates a battle among the contestants who are first three according to their points. 
		 //Contestants' winning numbers are proportional to their winning probability against each other. 
		 //I have incremented the win numbers according to the  Architects' winning probablities against each other.
		 //This method prints out how many times each architect won in 300 matches.
		    println("The game is completed now and the scores are as below: ");
			println();
			for(int i=1;i<=NTIMES;i++) {
				if(winningPossibility((double)(firstPoint/(firstPoint+secondPoint)))) {
					num1++;
				}
				else if(winningPossibility((double)(secondPoint/(firstPoint+secondPoint)))) {
					num2++;
				}
			}
			for(int i=1;i<=NTIMES;i++) {
				if(winningPossibility((double)(firstPoint/(firstPoint+thirdPoint)))){
					num1++;
				}
				else if(winningPossibility((double)(thirdPoint/(firstPoint+thirdPoint)))) {
					num3++;
				}
			}
			for(int i=1;i<=NTIMES;i++){
				if(winningPossibility((double)(secondPoint/(secondPoint+thirdPoint)))) {
					num2++;
				}
				else if(winningPossibility((double)(thirdPoint/(secondPoint+thirdPoint)))){
					num3++;
				}
			}
			println("Architect#"+firstID+" won "+num1+" times in "+3*NTIMES+" matches.");
			println("Architect#"+secondID+" won "+num2+" times in "+3*NTIMES+" matches.");
			println("Architect#"+thirdID+" won "+num3+" times in "+3*NTIMES+" matches.");
	 }
			
	 private void congratulations() {
			println();
			if(num3>num1&&num1>num2) {
				println("CONGRATULATIONS Architect#"+thirdID+"!! YOU ARE THE WINNER OF Architect.");
			}
			else if(num3>num2&&num2>num1) {
				println("CONGRATULATIONS Architect#"+thirdID+"!! YOU ARE THE WINNER OF Architect.");
			}
			else if(num2>num1&&num1>num3) {
				println("CONGRATULATIONS Architect#"+secondID+"!! YOU ARE THE WINNER OF Architect.");
			}
			else if(num2>num3&&num3>num1) {
				println("CONGRATULATIONS Architect#"+secondID+"!! YOU ARE THE WINNER OF Architect.");
			}
			else if(num1>num2&&num2>num3) {
				println("CONGRATULATIONS Architect#"+firstID+"!! YOU ARE THE WINNER OF Architect.");
			}
			else if(num1>num3&&num3>num2) {
				println("CONGRATULATIONS Architect#"+firstID+"!! YOU ARE THE WINNER OF Architect.");
			}
	  }

	// your code ends here
	
	//////////// GIVEN VARIABLES and CONSTANTS /////////////////////
	int currentArchitectID = 1;
	int totalPointOfArchitect1;
	int totalPointOfArchitect2;
	int totalPointOfArchitect3;
	int totalPointOfArchitect4;
	int firstID;
	int secondID;
	int thirdID;
	int firstPoint;
	int secondPoint;
	int thirdPoint;
	
	private final int CONTESTANT_NUM = 4;
	private final int NTIMES = 100;
	static RandomGenerator rgen = new RandomGenerator();

	////////////ADDITIONAL VARIABLES and CONSTANTS  /////////////////////
	// Feel free to add additional variables and constants 
int num1=0;
int num2=0;
int num3=0;
}
	// your code starts here
	
	// your code ends here

