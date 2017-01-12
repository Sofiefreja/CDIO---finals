package board;

import entities.Cup;

/**
 * Class Brewery extends Ownable
 * @author Mathias Tvaermose Gleerup, s153120
 *
 */
public class Brewery extends Ownable {
	
	private int multiplier_1=100;
	private int multiplier_2=200;
	private Cup gameCup;
	/**
	 * Constructor
	 * @param name of this instance
	 * @param id [1:40]
	 * @param gameCup of the game
	 */
	public Brewery(String name, int id, Cup gameCup) {
		super(name, id, 3000, 1500, 'I');	// the price, pawn-price and type for a Shipping field
											// is always the same.
		this.gameCup = gameCup;
	}
	
	@Override
	public int getRent(){
		int typeCounter=0;
		//the for loop evaluates the number of breweries the owner has
		for(int i = 0; i<owner.getOwned().size();i++){
			if(owner.getOwned().get(i).getType()==this.getType()){
				typeCounter++;
			}
		}
		if(typeCounter==2){//Condition for doubling the rent.
			return gameCup.getSum()*multiplier_2;
		}else{
			return gameCup.getSum()*multiplier_1;
		}
	}

}
