import java.util.ArrayList;

public class Model {
	public Controller controller;
	public ArrayList<LotteryTicket> tickets = new ArrayList<LotteryTicket>();
	public LotteryTicket winningTicket=null;

	public Model(Controller controller) {
		this.controller = controller;
	}
	
	public int sellNewTicket(String buyer) throws Exception {
		if (winningTicket!=null) {
			throw new Exception("The lottery has ended!");
		}
		LotteryTicket newTicket = new LotteryTicket(buyer, this.getNextTicketNumber());
		this.tickets.add(newTicket);
		return newTicket.number;
	}
	
	public int getNextTicketNumber() {
		int nextTicketNumber=0;
		for (LotteryTicket ticket: this.tickets) {
			if (ticket.number>=nextTicketNumber) {
				nextTicketNumber=ticket.number+1;
			}
		}
		return nextTicketNumber;
	}

	public LotteryTicket drawWinner() throws Exception {
		if (this.tickets.size()==0) {
			throw new Exception("No ticket were sold!");
		}
		if (this.winningTicket==null) {
			int index = (int)(Math.random() * tickets.size());
			this.winningTicket=tickets.get(index);
		}
		return this.winningTicket;
	}
}
