package starter.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import starter.controller.FlipController;
import starter.model.EmptyTile;
import starter.model.Model;
import starter.model.NumberedTile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class App extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;
	NumberedTile[] pieces = new NumberedTile[8];
	EmptyTile space;
	Model model = new Model(pieces, space);

	/**
	 * Create the frame.
	 */
	public App() {
		setTitle("Double Slided");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 478);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnReset = new JButton("Reset");
		menuBar.add(btnReset);
		
		JButton btnQuit = new JButton("Quit");
		menuBar.add(btnQuit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(model);
		// panel.addMouseListener(new FlipController(model, this));
		
		JLabel lblNumberOfMoves = new JLabel("Number of Moves:");
		lblNumberOfMoves.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel numberMovesLabel = new JLabel("New label");
		numberMovesLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNumberOfMoves)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numberMovesLabel)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfMoves)
						.addComponent(numberMovesLabel))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}