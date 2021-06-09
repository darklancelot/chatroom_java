package ¡ƒÃÏ “;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jdk.nashorn.internal.scripts.JS;

public class Clientframe extends JFrame{
	String name;
	String id;
	private JTextArea talk;
	private JLabel l;
	private JTextField t;
	private JButton btn;
	Client client;
	
	public Clientframe(String name,String id) {
		this.name = name ;
		setBounds(50, 50, 517, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		talk = new JTextArea();
		client = new Client(id, 1100);
	
		JScrollPane js1 = new JScrollPane(talk);
		js1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		js1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		js1.setBounds(0, 0, 500, 390);
		c.add(js1);
		l = new JLabel(this.name);
		l.setFont(new Font("ø¨ÃÂ", Font.BOLD, 20));
		l.setBounds(0, 400, 70, 20);
		c.add(l);
		t = new JTextField();
		t.setBounds(80, 400, 350, 20);
		c.add(t);
		btn = new JButton("∑¢ÀÕ");
		btn.setBounds(230, 430, 70, 30);
		c.add(btn);
		addlistener();
		ReadmessageThread t = new ReadmessageThread();
		t.start();
		setVisible(true);
	}
	private class ReadmessageThread extends Thread {
	
		public void run() {
			while(true) {
				String str = client.receivemessage();
				talk.append(str+"\n");
			}
		}
	}
	private void addlistener(){
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				client.sendmessage(name+":\n"+t.getText());
				t.setText("");
			}
		});
		
	}
}
