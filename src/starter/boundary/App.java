package starter.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import starter.controller.FlipController;
import starter.controller.ResetController;
import starter.model.EmptyTile;
import starter.model.Model;
import starter.model.NumberedTile;
import starter.model.TileSet;

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
	Model model = new Model(new TileSet(new NumberedTile[8], new EmptyTile(null)), 0);

	/**
	 * Create the frame.
	 */
	public App(Model model) {
		setTitle("Double Slided");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 478);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnReset = new JButton("Reset");
		menuBar.add(btnReset);
		btnReset.addActionListener(new ResetController(model, this));
		
		JButton btnQuit = new JButton("Quit");
		menuBar.add(btnQuit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new PuzzlePanel(model);
		panel.addMouseListener(new FlipController(model, this));
		
		JLabel lblNumberOfMoves = new JLabel("Number of Moves: " + model.totalNumMoves);
		lblNumberOfMoves.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNumberOfMoves)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfMoves))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
