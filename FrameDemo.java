package components;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.xml.bind.Marshaller.Listener;

public class FrameDemo {
  static JPanel master = new JPanel();
  static JPanel south = new JPanel();
  JPanel west = new JPanel();

  private static final String key = "ENTER";
  private static KeyStroke keyStroke;

  static JButton sendButton = new JButton("Send");
  static JTextArea messageArea = new JTextArea();
  static JTextArea logWindow = new JTextArea();
  static JScrollPane logWindowScroll = new JScrollPane(logWindow, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
      JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
  /*
   * private static ArrayList<String> logCreator(int x) { ArrayList<String> log
   * = new ArrayList<String>(); Date date = new Date(); SimpleDateFormat sdf =
   * new SimpleDateFormat("MM/dd h:mm:ss"); String formattedDate =
   * sdf.format(date); for (int i = 0; i <= x; i++) { log.add(formattedDate +
   * ": This is chat message " + i); } return log; }
   */

  private static void createAndShowGUI() {
    JFrame jframe = new JFrame("@Chat");
    jframe.setSize(600, 400);
    jframe.setResizable(true);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setResizable(true);

    master.setLayout(new BorderLayout());
    south.setLayout(new BorderLayout());

    logWindow.setEditable(false);
    logWindow.setLineWrap(true);
    logWindow.setWrapStyleWord(true);
    master.add(logWindowScroll, BorderLayout.CENTER);

    messageArea.setLineWrap(true);
    messageArea.setWrapStyleWord(true);
    south.add(sendButton, BorderLayout.WEST);
    south.add(messageArea, BorderLayout.CENTER);
    master.add(south, BorderLayout.SOUTH);

    keyStroke = KeyStroke.getKeyStroke(key);
    Object actionKey = messageArea.getInputMap(JComponent.WHEN_FOCUSED).get(keyStroke);
    messageArea.getActionMap().put(actionKey, wrapper);

    /*
     * ArrayList<String> lofg = logCreator(50); for (String a : lofg) {
     * logWindow.append(a + "\n"); }
     */

    jframe.add(master);
    // jframe.pack();
    windowActions();
    jframe.setVisible(true);
  }

  /*
   * text1.setOnKeyListener(new OnKeyListener() { public boolean onKey(View v,
   * int keyCode, KeyEvent event){ // If the event is a key-down event on the
   * "enter" button if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode
   * == KeyEvent.KEYCODE_ENTER)) { // Perform action on key press
   * sendButtonAction(); return true; } return false; } });
   */

  public static void windowActions() {

    sendButton.addActionListener(new java.awt.event.ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        sendButtonAction();
      }
    });

  }

  public static void sendButtonAction() {
    if (!messageArea.getText().equals("")) {
      if (!messageArea.getText().trim().equals("")) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd h:mm:ss");
        String formattedDate = sdf.format(date);
        logWindow.append(formattedDate + ": " + messageArea.getText().trim() + "\n");
      }
      messageArea.setText("");
    }
  }
}