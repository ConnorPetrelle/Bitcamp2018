import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Driver extends TimerTask{
	
	private static JFrame frame;
	private static Timer timer;
	private static TimerTask task;
	
	public static void main(String[] args) {
		
				frame = new JFrame("Chess");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		        frame.setSize(500, 2000);
		        
		        frame.pack();
		        frame.setSize(Board.SCREEN_WIDTH, Board.SCREEN_HEIGHT);
		        frame.setLocation((screenSize.width - Board.SCREEN_WIDTH) / 2, (screenSize.height - Board.SCREEN_HEIGHT) / 2);

		        Board board = new Board();
		        frame.addMouseListener(new MoveListener(board));
		        frame.add(board);
		        frame.setVisible(true);
		        
		        task = new Driver();
		        timer = new Timer();
		        timer.scheduleAtFixedRate(task, 0, 15);
		    
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		frame.repaint();
	}

}
