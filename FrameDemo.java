package components;

import java.awt.*;
import java.awt.event.*;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

public class FrameDemo {
	static JPanel master = new JPanel();
	static JPanel south = new JPanel();
	static JPanel southWest = new JPanel();

	private static final String key = "ENTER";
	private static KeyStroke keyStroke;

	static JButton sendButton = new JButton("Send");
	static JButton connectButton = new JButton("Connect");
	static JTextArea messageArea = new JTextArea();
	static JTextArea logWindow = new JTextArea();
	static JScrollPane logWindowScroll = new JScrollPane(logWindow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	static JTextArea userWindow = new JTextArea(logWindow.getHeight(), 10);
	static JScrollPane userWindowScroll = new JScrollPane(userWindow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JTextArea messageField = new JTextArea(140, 2);

	private static Action wrapper = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			sendButton.doClick();
		}
	};

	public static void main(String[] args) {
		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		JFrame jframe = new JFrame("@Chat");
		jframe.setSize(600, 400);
		jframe.setResizable(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setResizable(true);

		master.setLayout(new BorderLayout());
		south.setLayout(new BorderLayout());
		southWest.setLayout(new BorderLayout());

		logWindow.setEditable(false);
		logWindow.setLineWrap(true);
		logWindow.setWrapStyleWord(true);
		master.add(logWindowScroll, BorderLayout.CENTER);

		userWindow.setEditable(false);
		userWindow.setLineWrap(false);
		master.add(userWindowScroll, BorderLayout.EAST);

		messageArea.setLineWrap(true);
		messageArea.setWrapStyleWord(true);
		south.add(southWest, BorderLayout.EAST);
		southWest.add(sendButton, BorderLayout.NORTH);
		southWest.add(connectButton, BorderLayout.SOUTH);
		south.add(messageArea, BorderLayout.CENTER);
		master.add(south, BorderLayout.SOUTH);

		keyStroke = KeyStroke.getKeyStroke(key);
		Object actionKey = messageArea.getInputMap(JComponent.WHEN_FOCUSED).get(keyStroke);
		messageArea.getActionMap().put(actionKey, wrapper);

		jframe.add(master);
		//jframe.pack();
		windowActions();
		jframe.setVisible(true);
	}

	public static void windowActions() {

		sendButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendButtonAction();
			}
		});

		connectButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connectButtonAction();
			}

		});

	}

	public static void connectButtonAction() {
		if (!messageArea.getText().equals("")) {
			if (!messageArea.getText().trim().equals("")) {
				// connection method call
				userWindow.append("192.168.255.255\n");
			}
			messageArea.setText("");
		}
	}

	public static void sendButtonAction() {
		if (!messageArea.getText().equals("")) {
			if (!messageArea.getText().trim().equals("")) {
				// message sending method call
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd h:mm:ss.S");
				String formattedDate = sdf.format(date);
				logWindow.append(formattedDate + ": " + messageArea.getText().trim() + "\n");
			}
			messageArea.setText("");
		}
	}
}