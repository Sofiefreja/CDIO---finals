package board;

import entities.Cup;

/**
 * 
 * @author Mathias Tvaermose Gleerup, s153120
 *
 */
public class Brewery extends Ownable {
	
	private int rent_1=100;
	private int rent_2=200;
	private Cup gameCup;
	/**
	 * Constructor which takes a name, ID and the cup used by the game as parameters
	 * @param name
	 * @param id
	 * @param gameCup
	 */
	public Brewery(String name, int id, Cup gameCup) {
		super(name, id, 3000, 1500, 'I');
		this.gameCup = gameCup;
	}
	
	@Override
	public int getRent(){
		int typeCounter=0;
		//the for loop evaluates the number of breweries the owner has
		for(int i = 0; i<=owner.getOwned().size();i++){
			if(owner.getOwned().get(i).getType()==this.getType()){
				typeCounter++;
			}
		}
		if(typeCounter==2){//Condition for doubling the rent.
			return gameCup.getSum()*rent_2;
		}else{
			return gameCup.getSum()*rent_1;
		}
	}

}
