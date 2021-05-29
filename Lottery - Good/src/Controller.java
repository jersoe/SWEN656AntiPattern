import java.awt.EventQueue;

public class Controller {
	private Model model;
	
	public Controller() {
		this.model=new Model(this);
		Controller c = this;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new View(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	protected int SellNewTicket(String buyer) throws Exception {
		return this.model.sellNewTicket(buyer);
	}
	
	protected LotteryTicket drawWinner() throws Exception {
		return this.model.drawWinner();
	}	

	public static void main(String[] args) {
		new Controller();
	}
}
