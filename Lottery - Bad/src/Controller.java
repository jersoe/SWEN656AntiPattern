import java.awt.EventQueue;

public class Controller {
	public Model model;
	
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
		
	public int SellNewTicket(String buyer) throws Exception {
		return this.model.sellNewTicket(buyer);
	}
	
	public LotteryTicket drawWinner() throws Exception {
		return this.model.drawWinner();
	}	

	public static void main(String[] args) {
		new Controller();
	}
}
