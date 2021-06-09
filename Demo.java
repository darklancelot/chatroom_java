package 聊天室;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import guanggao.Client;

public class Demo extends JFrame{
	private JLabel l1;
	private JLabel l2;
	private JTextField  tfid;
	private JTextField tfusername;
	private JButton btn;
	public Demo() {
		setBounds(0, 0, 400, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		l1 = new JLabel("用户id");
		l1.setBounds(50, 50, 40, 25);
		tfid = new JTextField("127.0.0.1");
		tfid.setBounds(90, 50, 200, 25);
		tfid.enable(false);
		c.add(l1);
		c.add(tfid);
		l2 = new JLabel("用户名");
		l2.setBounds(50, 100, 40, 25);
		c.add(l2);
		tfusername = new JTextField();
		tfusername.setBounds(90, 100, 200, 25);
		c.add(tfusername);
		btn = new JButton("登录");
		btn.setBounds(150, 150, 75, 25);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = send();
				System.out.println(str);// TODO 自动生成的方法存根
				new Clientframe(str, tfid.getText());
			}
		});
		c.add(btn);
		
	}
	private String send() {
		return tfusername.getText();// TODO 自动生成的方法存根

	}

	public static void main(String[] args) {
		new Demo();// TODO 自动生成的方法存根

	}

}
