package hw08;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SwingTest extends JFrame {
	JList<String> list;
	JTextField tf;
	DefaultListModel<String> model;
	public SwingTest() throws IOException, ParseException {
		setTitle("Swing Test");
		setSize(300,400);
		//setLayout(new);
		
		JButton button = new JButton("입력");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.addElement(tf.getText());
			}
			
		});
		
		tf = new JTextField();
		tf.setColumns(20);
		JPanel p = new JPanel();
		p.add(tf);
		p.add(button);
		this.add(p,BorderLayout.SOUTH);
		list = new JList<>();
		this.add(list, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(1500, 500);
		
		model = new DefaultListModel<>();
		model.addElement("Hello");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("object.json")));
		JSONParser parser = new JSONParser();
		JSONObject parse = (JSONObject)parser.parse(br);
		JSONArray objs = (JSONArray)parse.get("주소록");
		Person person = null;
		for (int i = 0; i < objs.size(); i++) {
			person = new Person();
			JSONObject obj = (JSONObject)objs.get(i);
			person.setMobile(obj.get("휴대전화").toString());
			person.setName(obj.get("이름").toString());
			person.setAddr(obj.get("주소").toString());
			person.setEmail(obj.get("email").toString());
			model.addElement(person.toString());
		}
		
		list.setModel(model);
		
		JMenuBar bar = new JMenuBar();
		JMenu menu1 = new JMenu("file");
		JMenuItem item = new JMenuItem("Hello");		
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int idx = list.getSelectedIndex();
				model.removeElementAt(idx);
				JDialog dlg = new JDialog(SwingTest.this, "this is a dialog");
				dlg.add(new Label("Dialog"));
				dlg.setSize(300, 300);
				dlg.setLocation(500, 500);
				dlg.setVisible(true);
			}
			
		});
		menu1.add(item);
		bar.add(menu1);
		this.setJMenuBar(bar);
		
		setVisible(true);
	}
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		//JFrame f = new JFrame("��ܿ� ǥ�õǴ� ����");
		new SwingTest();
	}

}