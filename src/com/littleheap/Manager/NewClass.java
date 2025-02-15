package com.littleheap.Manager;

import javax.swing.*;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

//import org.eclipse.swt.internal.win32.TF_DA_COLOR;

import com.littleheap.MainInterface;
import com.littleheap.DataBase.TableOperate;

public class NewClass extends JPanel implements ActionListener {
	private JLabel label;
	private JTextField tf_classnumber;
	private JTextField tf_classname;
	private JLabel lb_classnumber;
	private JLabel lb_classname;
	private JButton btn_submit;
	private JButton back;

	/**
	 * Create the panel.
	 */
	public NewClass() {
		setBackground(new Color(175, 238, 238));
		setLayout(null);
		
		label = new JLabel("\u65B0\u5EFA\u56FE\u4E66\u5E93");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("宋体", Font.BOLD, 40));
		label.setBounds(542, 20, 294, 105);
		add(label);
		
		lb_classnumber = new JLabel("\u5206\u7C7B\u7F16\u53F7\uFF1A");
		lb_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classnumber.setBounds(361, 260, 194, 55);
		add(lb_classnumber);
		
		tf_classnumber = new JTextField();
		tf_classnumber.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classnumber.setColumns(10);
		tf_classnumber.setBounds(555, 250, 399, 75);
		add(tf_classnumber);
		
		tf_classname = new JTextField();
		tf_classname.setFont(new Font("宋体", Font.BOLD, 35));
		tf_classname.setColumns(10);
		tf_classname.setBounds(555, 431, 399, 75);
		add(tf_classname);
		
		lb_classname = new JLabel("\u5206\u7C7B\u540D\u79F0\uFF1A");
		lb_classname.setFont(new Font("宋体", Font.BOLD, 35));
		lb_classname.setBounds(361, 441, 194, 55);
		add(lb_classname);
		
		btn_submit = new JButton("\u63D0\u4EA4");
		btn_submit.setFont(new Font("宋体", Font.BOLD, 35));
		btn_submit.setBounds(585, 637, 251, 80);
		add(btn_submit);
		btn_submit.addActionListener(this);
		
		back = new JButton("\u8FD4\u56DE");
		back.setFont(new Font("宋体", Font.PLAIN, 26));
		back.setBounds(0, 0, 115, 82);
		add(back);
		back.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back) {
			//点击返回按钮
			MainInterface.NewClasstoManager();
		}else if(e.getSource() == btn_submit){
			//点击提交按钮
			if(!TableOperate.isExist_Table(tf_classname.getText().toLowerCase()+"book")) {
				TableOperate.newClass(tf_classnumber.getText(), tf_classname.getText());
				tf_classnumber.setText("");
				tf_classname.setText("");
				JOptionPane.showMessageDialog(null, "恭喜", "添加新类别成功", JOptionPane.OK_CANCEL_OPTION);
			}else {
				JOptionPane.showMessageDialog(null, "该类别已存在", "添加新类别失败", JOptionPane.ERROR_MESSAGE);
			}

		}
	}
}
