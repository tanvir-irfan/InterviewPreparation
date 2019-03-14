import java.util.Scanner;

public class PokemonEvaluation {
	static int CANDY_NEEDED_FOR_EVALUATION = 12;
	static int CANDY_INDEX = 0;
	static int POKEMON_INDEX = 1;
	static int [] data = new int[2];
	
	public static void main(String [] st) {
		
		Scanner sc = new Scanner(System.in);			
		
		data[CANDY_INDEX] = sc.nextInt();
		data[POKEMON_INDEX] = sc.nextInt();
		sc.close();
		
		int []returnData = findNumberOfEvaluatedPokemon(data);
		
		System.out.println(returnData[0] + " ; " + returnData[1]);
	}
	
	public static int[] findNumberOfEvaluatedPokemon(int []data) {
		int []returnData = new int[2];
		
		int tempCandy = data[CANDY_INDEX];
		int tempPokemon = data[POKEMON_INDEX];
		
		while( tempCandy >=  CANDY_NEEDED_FOR_EVALUATION) {
			int tempEval = tempCandy / CANDY_NEEDED_FOR_EVALUATION;
			if(tempEval > tempPokemon) {				
				returnData[POKEMON_INDEX] += tempPokemon;
				returnData[CANDY_INDEX] = tempCandy - (tempPokemon * CANDY_NEEDED_FOR_EVALUATION) + tempPokemon;
				break;
			}
			
			returnData[POKEMON_INDEX] += tempEval;
			tempPokemon -= tempEval;
			tempCandy = tempCandy % CANDY_NEEDED_FOR_EVALUATION + tempEval;
			returnData[CANDY_INDEX] = tempCandy;
		}
		
		// handle the extra pokemon
		if(tempPokemon > 0 && (tempPokemon + returnData[CANDY_INDEX]) > CANDY_NEEDED_FOR_EVALUATION) {
			// first time you need 13 PIDGEY to evaluate to PIDGITO
			returnData[POKEMON_INDEX]++;
			tempPokemon -= (CANDY_NEEDED_FOR_EVALUATION + 1);
			
			returnData[POKEMON_INDEX] += tempPokemon / CANDY_NEEDED_FOR_EVALUATION;
			returnData[CANDY_INDEX] = tempPokemon % CANDY_NEEDED_FOR_EVALUATION;
		}
		
		return returnData;
	}
}
