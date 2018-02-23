package tiktaktoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettingsForm extends JFrame {
	GameSettingsForm gameSettingsForm = this;
	
	public GameSettingsForm()
	{
		setTitle("��������� ����");
		setBounds(450, 450, 240, 190);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		JLabel jLabelMode = new JLabel("�������� ����� ����");
		add(jLabelMode);
		JRadioButton radioButtonModeTwoPlayers = new JRadioButton("����� ������ ������");
		add(radioButtonModeTwoPlayers);
		radioButtonModeTwoPlayers.setSelected(true);
		JRadioButton radioButtonModeAgainstAI = new JRadioButton("����� ������ ����������");
		add(radioButtonModeAgainstAI);
		JLabel jLabelAILevel = new JLabel("�������� ������� AI");
		add(jLabelAILevel);
		JSlider jSlider = new JSlider(0,2,0);
		add(jSlider);
		jSlider.setAlignmentX(LEFT_ALIGNMENT);
		jSlider.setVisible(false);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonModeTwoPlayers);
		buttonGroup.add(radioButtonModeAgainstAI);
		JLabel jLabelLinesCount = new JLabel("������ ����(�� ���������");
		add(jLabelLinesCount);
		JTextField jTextFieldLinesCount = new JTextField();
		jTextFieldLinesCount.setMaximumSize(new Dimension(100, 20));
		add(jTextFieldLinesCount);
		JButton jButtonSetSettings = new JButton("������ ����");
		add(jButtonSetSettings);
		setVisible(true);
		
		
		radioButtonModeAgainstAI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioButtonModeAgainstAI.isSelected()) {
					jSlider.setVisible(true);
				}
			}
		});
		
		radioButtonModeTwoPlayers.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioButtonModeTwoPlayers.isSelected()) {
					jSlider.setVisible(false);
				}
			}
		});
		
		jButtonSetSettings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainGameField gameField = MainGameField.getInstance();
				if (jTextFieldLinesCount.getText().isEmpty()) {
					gameField.linesCount = 3;
				}
				else {
					try {
						gameField.linesCount = Integer.parseInt(jTextFieldLinesCount.getText());
					}
					catch (NumberFormatException ex) {
						// TODO: handle exception
						System.out.println("���������� ������ ����� �����");
					}
				}
				
				gameField.startNewGame();
				if (radioButtonModeAgainstAI.isSelected()) {
					gameField.gameMode = 2;
				}
				gameField.aiLevel = jSlider.getValue();
				gameSettingsForm.setVisible(false);
			}
		});
	}
}
