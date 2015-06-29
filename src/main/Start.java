package main;
import java.util.*;

public class Start {

	public static void main(String[] args){
		// TODO Auto-generated method stub

		Deck wordsDeck = new Deck();
		String dataFile = "data\\test_vocab.txt";
		wordsDeck.initDeck(dataFile);
		
		ArrayList<Card> cards = wordsDeck.getCards();
		
		Scanner scan = new Scanner(System.in);
		String user_input = "";
	
	
		while (!user_input.toUpperCase().equals("QUIT")){ 
			for(int i = 0; i < cards.size(); i++){
				System.out.println("Press any key to see a word ('quit' for exit)!");
				user_input = scan.nextLine();
				if(user_input.toUpperCase().equals("QUIT")){
					wordsDeck.saveDeckToFile(dataFile);
					break;
				}
				System.out.println(cards.get(i).getWord());
				System.out.println();
				System.out.println("Press any key to see a translation ('quit' for exit)!");
				user_input = scan.nextLine();
				if(user_input.toUpperCase().equals("QUIT")){
					wordsDeck.saveDeckToFile(dataFile);
					break;
				}
				System.out.println(cards.get(i).getTranslation());
				System.out.println();
				wordsDeck.putCardToBottom(cards.get(i));				
			}
		}
		
		System.out.println("Bye!");
		
		scan.close();

	}

}