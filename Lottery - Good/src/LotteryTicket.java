
public class LotteryTicket {
	private int number;
	private String buyer;

	public LotteryTicket(String buyer, int number) {
		this.buyer=buyer;
		this.number=number;
	}

	public int getNumber() {
		return number;
	}

	public String getBuyer() {
		return buyer;
	}
	
	public LotteryTicket clone() {
		return new LotteryTicket(this.buyer, this.number);
	}
}
