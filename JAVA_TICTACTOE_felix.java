package ch.felixmachts.tictactoespiel;

import java.util.Scanner;   //imports function scanner=user input
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classname: TicTacToeSpiel
 * Version: 15.4
 * Date: 22.05.2023
 * programmer: Felix
 * purpose of the program: A 2 Player Video Game
 */
public class TicTacToeSpiel {
	/**
	 * This is the Main Method
	 *most of the game is in here
	 */
	public static void main(String[] args) {
		
	//declaration Variables
	boolean rightFromTheStart = true ;
	String SPLIT_LINE = "------------------------";        //this is a CONSTANT_VARIABLE
	String ERROR_TEXT = "Feld Besetzt !! Wähle erneut";
	char[] list = new char [9] ;              //defines field
	char currentPlayer = '✕';
	int winCountPlayerOne = 0;   // adds up after win condition is met for given player, printet out at the start
	int winCountPlayerTwo = 0;
	boolean isGameDone = false;
	//End declaration Variables
	
	while (rightFromTheStart == true) {
		rightFromTheStart = false ;


	/*the menu
	 *it has 2 options y: yes play
	 *and n: end program now 
	 *the player will return here after every match
	 */
	System.out.println("TicTacToe regeln: 3x3 felder, ziel 3 in einer Reihe");
	System.out.println("Spieler 1 ist ✕ , Spieler 2 ist ◯");
	System.out.println("Gewonnen Bisher: P1= " + winCountPlayerOne + " P2= " + winCountPlayerTwo );
	System.out.println(SPLIT_LINE);

	System.out.println("neues Spiel starten (oder Programm beenden)");             
	
	
	//ask if newgame as var : newGame
	//	String newGame = inputScanner.nextLine();

	 Scanner yayNay = new Scanner(System.in);
     String newGame = "";
        ////////////////////////////////////////////////////////////////TEST ////////////////while (!(newGame.equals("y") ||  !(newGame.equals("n") {
        
        while (!newGame.equals("y") && !newGame.equals("n")) {     //while ((nG != y) and (nG != n) repeat: nG =yayNay.nextLine(), else
            System.out.println("y/n?");
            newGame = yayNay.nextLine();
        }
        	     //   System.out.println( "Valid answer Only:" + newGame );

		if ( newGame.equals("n") ) {
		/*  System.out.println("NAY");  */
			  System.out.println("Credits");
			  System.out.println("Felix");
			  System.exit(0) ;                                                                            // Program ends here expected: exit(0)
		}
						
		list[0] = '-';      //set all individual fields to neutral, happens after every new start.
		list[1] = '-';
		list[2] = '-';
		list[3] = '-';
		list[4] = '-';
		list[5] = '-';
		list[6] = '-';
		list[7] = '-';
		list[8] = '-';

		/*Variable currentPlayer defines the current in Row player, starts always with ✕ (needs to be set here to reset after every new game. )    */
		currentPlayer = '✕';
		isGameDone = false;
		
		 overviewField ();                      //prints overview field
		
		while (isGameDone == false) {   //start Main Game Loop (every round)
				
			/* 	newGame = "idk"	;  , resets the game  ,is not necessary for some reason, */
			/* winconditions here (first ✕ then elif ◯ )   */
	
			if (list[0] == '✕' && list[1] == '✕' && list[2] == '✕' || 
				list[3] == '✕' && list[4] == '✕' && list[5] == '✕' || 
				list[6] == '✕' && list[7] == '✕' && list[8] == '✕' || 
				list[0] == '✕' && list[3] == '✕' && list[6] == '✕' || 
				list[1] == '✕' && list[4] == '✕' && list[7] == '✕' || 
				list[2] == '✕' && list[5] == '✕' && list[8] == '✕' || 
				list[0] == '✕' && list[4] == '✕' && list[8] == '✕' || 
				list[6] == '✕' && list[4] == '✕' && list[2] == '✕') {
				System.out.println(" ✕, Spieler 1 hat Gewonnen");
				System.out.println(SPLIT_LINE);
				winCountPlayerOne = winCountPlayerOne + 1 ;
				isGameDone = true;
			}
			
			else if (list[0] == '◯' && list[1] == '◯' && list[2] == '◯' || 
						list[3] == '◯' && list[4] == '◯' && list[5] == '◯' || 
						list[6] == '◯' && list[7] == '◯' && list[8] == '◯' || 
						list[0] == '◯' && list[3] == '◯' && list[6] == '◯' || 
						list[1] == '◯' && list[4] == '◯' && list[7] == '◯' || 
						list[2] == '◯' && list[5] == '◯' && list[8] == '◯' || 
						list[0] == '◯' && list[4] == '◯' && list[8] == '◯' || 
						list[6] == '◯' && list[4] == '◯' && list[2] == '◯') {
				System.out.println(" ◯, Spieler 2 hat Gewonnen");
				System.out.println(SPLIT_LINE);
				winCountPlayerTwo = winCountPlayerTwo + 1 ;
				isGameDone = true;
			}
			
			
			
			/* draw [ all fields are either  ✕ || ◯] //  ((1=✕||1=◯)&&(2=✕||2=◯)etc...)           */
			else if ((list[0] == '✕' || list[0] == '◯') && (list[1] == '✕' || list[1] == '◯') && 
					(list[2] == '✕' || list[2] == '◯') && (list[3] == '✕' || list[3] == '◯') && 
					(list[4] == '✕' || list[4] == '◯') && (list[5] == '✕' || list[5] == '◯') && 
					(list[6] == '✕' || list[6] == '◯') && (list[7] == '✕' || list[7] == '◯') && 
					(list[8] == '✕' || list[8] == '◯')) {
				System.out.println("unentschieden , kein Spieler hat Gewonnen");
				System.out.println(SPLIT_LINE);
				isGameDone = true;
			}
			else {
				System.out.println("Spiel läuft " + currentPlayer + " bitte");
				System.out.println("nur nummern von 1-9 bitte");
				System.out.println("Eingabe feld");
			
				//Scanner inputScanner2 = new Scanner(System.in);
				//byte inputInString = inputScanner2.nextByte();       
			
				Scanner inputScanner2 = new Scanner(System.in);
			
				String inputInString = inputScanner2.nextLine();//changed from string to byte, because its always 1-9 / v12: changed to string again 
				/*	inputScanner2.close();    do not immediate close this again, will give error, as long as the Variable is in use keep it open  */
			
				Pattern pattern = Pattern.compile("^[1-9]$", Pattern.CASE_INSENSITIVE);   //REGEX PART
				Matcher matcher = pattern.matcher(inputInString);
				boolean validInput = matcher.find();
				if(validInput) {   // if this value = true
					//    System.out.println("Input is Good");
					System.out.print("sie haben das feld ausgewählt nummer:");
					System.out.println(inputInString);
			
					/* check if input is [1-9] // todo-done  exception handling  via  REGEX ^[0-9]$
					 *	while ( inputInString == 1) && inputInString == 2) && inputInString == 3) && inputInString == 4) && inputInString == 5) && inputInString == 6) && inputInString == 7) && inputInString == 8) && inputInString == 9) ) {
					 */
				
					if ( inputInString.equals("1")) {                             // condition if field 1 full 
						if(list[0] == '✕' || list[0] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();
						}
						else {
							list[0] = currentPlayer;
						}
					}
					/////////////////////////////////////////////////////////////////////////////////
					if ( inputInString.equals("2")) {                             // condition if field 2 full
						if (list[1] == '✕' || list[1] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();
						}
						else {
							list[1] = currentPlayer;
						}
					}
					/////////////////////////////////////////////////////////////////////////////////
					if ( inputInString.equals("3")) {                             // condition if field 3 full
						if(list[2] == '✕' || list[2] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();				
						}
						else {
							list[2] = currentPlayer;
						}
					}
						////////////////////////////////////////////////////////////////////////////////////
					if ( inputInString.equals("4")) {                             // condition if field 4 full
						if(list[3] == '✕' || list[3] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();				
						}
						else {
							list[3] = currentPlayer;
						}
					}
					////////////////////////////////////////////////////////////////////////////////////
					if ( inputInString.equals("5")) {                             // condition if field 5 full
						if(list[4] == '✕' || list[4] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();				
						}
						else {
							list[4] = currentPlayer;
						}
					}
					////////////////////////////////////////////////////////////////////////////////////
					if ( inputInString.equals("6")) {                             // condition if field 6 full
						if(list[5] == '✕' || list[5] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();				
						}
						else {
							list[5] = currentPlayer;
						}
					}
					////////////////////////////////////////////////////////////////////////////////////
					if ( inputInString.equals("7")) {                             // condition if field 7 full
						if(list[6] == '✕' || list[6] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();				
						}
						else {
							list[6] = currentPlayer;
						}
					}
					////////////////////////////////////////////////////////////////////////////////////
					if ( inputInString.equals("8")) {                             // condition if field 8 full
						if(list[7] == '✕' || list[7] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();				
						}
						else {
							list[7] = currentPlayer;
						}
					}
					////////////////////////////////////////////////////////////////////////////////////
					if ( inputInString.equals("9")) {                             // condition if field 9 full
						if(list[8] == '✕' || list[8] == '◯' ) {
							System.out.println(ERROR_TEXT);
							inputInString = inputScanner2.nextLine();				
						}
						else {
							list[8] = currentPlayer;
						}
					}
				
					////////////////////////////////////////////////////////////////////////////////////
		
					overviewField ();    
					System.out.println(SPLIT_LINE);
					
					System.out.println("Aktueller Stand=");
					System.out.println(list[0] + " | " + list[1] + " | " + list[2]);                // print actual Field
					System.out.println("- + - + -");
					System.out.println(list[3] + " | " + list[4] + " | " + list[5]);
					System.out.println("- + - + -");
					System.out.println(list[6] + " | " + list[7] + " | " + list[8]);
			
					
					if ( currentPlayer == '✕') {     //at End of the Game Loop Switch from ◯ to ✕ and reverse  
						currentPlayer = '◯';
					}
					else {
						currentPlayer = '✕';
					}
			    }   //from if (validinput == true)
				else {
					System.out.println("");                ///ends loop if input is invalid, skips "change current player"
			      
			    }
			}
		} //Main Game loop end
					/*System.out.println(isGameDone); */
					rightFromTheStart = true;
				
	}
	}
			
	/**
	 * method to print out the overview field
	 * all it does is print out the same lines
	*/	
	static void overviewField () {
			System.out.println("Feldnummern=");
			System.out.println("1" + " | " + "2" + " | " + "3"); 
			System.out.println("- + - + -");
			System.out.println("4" + " | " + "5" + " | " + "6"); 
			System.out.println("- + - + -");
			System.out.println("7" + " | " + "8" + " | " + "9"); 
	}
}

