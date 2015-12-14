import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

public class FrameDemo {
	static String ip;

	static JPanel master = new JPanel();
	static JPanel south = new JPanel();
	static JPanel southWest = new JPanel();

	private static final String key = "ENTER";
	private static KeyStroke keyStroke;

	static JButton sendButton = new JButton("Send");
	static JButton connectButton = new JButton("Connect");
	static JTextArea messageArea = new JTextArea();
	public static JTextArea logWindow = new JTextArea();
	static JScrollPane logWindowScroll = new JScrollPane(logWindow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	static JTextArea userWindow = new JTextArea(logWindow.getHeight(), 10);
	static JScrollPane userWindowScroll = new JScrollPane(userWindow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	JTextArea messageField = new JTextArea(140, 2);

	public FrameDemo() {
		createAndShowGUI();
	}

	private static Action wrapper = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent ae) {
			sendButton.doClick();
		}
	};

	// public static void main(String[] args) {
	// createAndShowGUI();
	// }

	public static void createAndShowGUI() {
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
		// jframe.pack();
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
				ip = (messageArea.getText().trim());
				//
				System.out.println("är detta en loop?1");

				// socket.socketConnect(ip);
				main.cThread = new ClientSocket(ip, 6066);
				System.out.println("är detta en loop?1.5");
				main.cThread.start();
				System.out.println("är detta en loop?2");
				try {
					main.sOutputStream = new ObjectOutputStream(main.cSocket.getOutputStream());
					main.sOutputStream.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			messageArea.setText("");
			System.out.println(
					"är detta en loop?3 = on port: " + main.cSocket.getPort() + " ::" + main.sOutputStream.hashCode());
		}
	}

	public static void sendButtonAction() {
		String message = messageArea.getText();
		if (!message.equals("")) {
			if (!message.trim().equals("")) {
				// message sending method call
				Date date = new Date();

				MessagePacket msg = new MessagePacket(message, date, main.cSocket.getLocalSocketAddress().toString());
				sendMsg(msg);

			}
			messageArea.setText("");
		}
	}

	public static void sendMsg(MessagePacket msg) {
		try {
			System.out.println(msg.getMessage() + " == the message111111!");// +
																			// main.sOutputStream.hashCode());
			main.sOutputStream.writeObject(msg);
			System.out.println(msg.getMessage() + " == the message22222222!");
			main.sOutputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		main.log.insertMessage(msg);
	}

}
