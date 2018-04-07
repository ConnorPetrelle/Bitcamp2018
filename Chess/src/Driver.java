import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Driver {
	
	public static void main(String[] args) {
		
				JFrame frame = new JFrame("Chess");
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
		        
		        
		        while(!board.checkmate()) {
		        	//add a timer to slow this down?
		        	frame.repaint();
		        }
		        
		    
	}

}
