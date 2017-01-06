package board;

import entities.Cup;


public class Brewery extends Ownable {
	
	private int rent_1=100;
	private int rent_2=200;
	private Cup gameCup;
	
	public Brewery(String name, int id, Cup gameCup) {
		super(name, id, 3000, 1500, 'I');
		this.gameCup = gameCup;
	}
	
	@Override
	public int getRent(){
		int typeCounter=0;
		for(int i = 0; i<=owner.getOwned().size();i++){
			if(owner.getOwned().get(i).getType()==this.getType()){
				typeCounter++;
			}
		}
		if(typeCounter==2){
			return gameCup.getSum()*rent_2;
		}else{
			return gameCup.getSum()*rent_1;
		}
	}

}
