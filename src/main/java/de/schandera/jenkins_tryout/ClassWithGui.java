package de.schandera.jenkins_tryout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClassWithGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6490613611562499491L;

	public ClassWithGui() {
		initUI();
	}

	private void initUI() {

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		setTitle("Title");
		JButton changeTitleButton = new JButton("Change Title");
		changeTitleButton.setBounds(50, 60, 80, 30);

		changeTitleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setTitle("Title changed");
			}
		});

		panel.add(changeTitleButton);
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
