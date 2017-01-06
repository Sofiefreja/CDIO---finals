package cards;
import entities.Board;
import entities.Player;

/**
 * abstract. amount
 * @author Sofie Freja Christensen s153932
 *
 */
public abstract class Transaction extends Card{
	int money;
	public Transaction(String description,Board board ,int money) {
		super(description,board);
		this.money = money;
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void useCard(Player player);
	
}
