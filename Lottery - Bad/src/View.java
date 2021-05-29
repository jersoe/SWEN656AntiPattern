import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Font;

public class View implements ActionListener {

	public JFrame frmJeroensAwesomeLottery;
	public Controller c;

	public View(Controller c) {
		this.c = c;
		initialize();
		this.frmJeroensAwesomeLottery.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmJeroensAwesomeLottery = new JFrame();
		frmJeroensAwesomeLottery.setResizable(false);
		frmJeroensAwesomeLottery.setTitle("Jeroen's Awesome Lottery");
		frmJeroensAwesomeLottery.setBounds(100, 100, 452, 389);
		frmJeroensAwesomeLottery.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnSell = new JButton("Sell a Ticket");
		btnSell.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSell.setIcon(new ImageIcon(View.class.getResource("/Images/lottery.png")));
		btnSell.addActionListener(this);

		JButton btnDraw = new JButton("Draw a Winner");
		btnDraw.setFont(new Font("Dialog", Font.BOLD, 20));
		btnDraw.setIcon(new ImageIcon(View.class.getResource("/Images/winner.png")));
		btnDraw.addActionListener(this);
		
		JButton btnCheat = new JButton("Cheat!");
		btnCheat.addActionListener(this);
		btnCheat.setFont(new Font("Dialog", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(frmJeroensAwesomeLottery.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSell, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
						.addComponent(btnDraw, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCheat, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnSell, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDraw, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCheat, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmJeroensAwesomeLottery.getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Sell a Ticket")) {
			try {
				String buyer = JOptionPane.showInputDialog("Who is the buyer?");
				int ticketNumber = this.c.SellNewTicket(buyer);
				JOptionPane.showMessageDialog(frmJeroensAwesomeLottery, "Ticket number " + ticketNumber + " was sold to " + buyer + ".");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frmJeroensAwesomeLottery, e1.getMessage());
			}
		} else if (e.getActionCommand().equals("Draw a Winner")) {
			try {
				JOptionPane.showMessageDialog(frmJeroensAwesomeLottery, "The winner is " + this.c.drawWinner().buyer
						+ " with ticket number " + this.c.drawWinner().number + ".");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(frmJeroensAwesomeLottery, e1.getMessage());
			}
		} else if (e.getActionCommand().equals("Cheat!")) {
			String cheatingWinner = JOptionPane.showInputDialog("Who will be the winner?");
			String cheatingTicket = JOptionPane.showInputDialog("What is the winning ticket number?");
			LotteryTicket fakeWinningTicket=new LotteryTicket(cheatingWinner, Integer.parseInt(cheatingTicket));
			this.c.model.winningTicket=fakeWinningTicket;
		}

	}
}
