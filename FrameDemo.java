package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameDemo {
  static JPanel master = new JPanel();
  static JPanel south = new JPanel();
  JPanel west = new JPanel();

  static JButton sendButton = new JButton("Send");
  static JTextArea messageArea = new JTextArea();

  static JTextArea logWindow = new JTextArea();
  static JScrollPane logWindowScroll = new JScrollPane(logWindow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
  JTextArea messageField = new JTextArea(140, 2);

  private static void createAndShowGUI() {
    JFrame jframe = new JFrame("@Chat");
    jframe.setSize(600, 400);
    jframe.setResizable(true);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setResizable(true);

    master.setLayout(new BorderLayout());

    logWindow.setEditable(false);
    logWindow.setLineWrap(true);
    logWindow.setWrapStyleWord(true);
    master.add(logWindowScroll, BorderLayout.CENTER);

    messageArea.setLineWrap(true);
    messageArea.setWrapStyleWord(true);
    south.add(sendButton);
    south.add(messageArea);
    master.add(south, BorderLayout.SOUTH);

    jframe.add(master);

    jframe.pack();
    jframe.setVisible(true);
  }

  public static void main(String[] args) {
    createAndShowGUI();
  }
}