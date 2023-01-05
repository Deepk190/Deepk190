import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class student_add extends JFrame implements ActionListener
{
int roll=0;
JFrame frm;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,title;
JTextField t1,t2,t3,t4;
JButton b1,b2,b3,b4,b5;
JRadioButton r1,r2;
JCheckBox ch1,ch2,ch3;
JComboBox list;
JTextArea tr;
Font f;
JPanel p1,p2,p3,p4,p5;
ButtonGroup btg;
public student_add()
{
frm=new JFrame("Login Here");
frm.setSize(600,350);
frm.setVisible(true);
f=new Font("Monotype Corsiva",Font.BOLD,34);

title=new JLabel("Student Registration Form");
title.setFont(f);
title.setForeground(Color.RED);

p1=new JPanel(new FlowLayout());
p2=new JPanel(new GridLayout(8,2));
p3=new JPanel(new FlowLayout());
p4=new JPanel(new FlowLayout());
p5=new JPanel(new FlowLayout());


tr=new JTextArea(5,10);

r1=new JRadioButton("Male");
r2=new JRadioButton("Female");

ch1=new JCheckBox("10th");
ch2=new JCheckBox("12th");
ch3=new JCheckBox("Grad.");

btg=new ButtonGroup();//allow single selection

btg.add(r1);btg.add(r2);


l1=new JLabel("Enter Name:");
l2=new JLabel("Enter Father:");
l3=new JLabel("Select Gender:");
l4=new JLabel("Enter Address:");
l5=new JLabel("Enter Phone:");
l6=new JLabel("Select Course:");
l7=new JLabel("Enter DOB:");
l8=new JLabel("Select Qualification:");

t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
t4=new JTextField(20);


b1=new JButton("Save");
b2=new JButton("Delete");
b3=new JButton("Update");
b4=new JButton("Search");
b5=new JButton("Clear");

list=new JComboBox();
list.addItem("Plz Select");
list.addItem("Bca");
list.addItem("Mca");
list.addItem("Pgdca");

p1.add(title);

p4.add(r1);p4.add(r2);

p5.add(ch1);p5.add(ch2);p5.add(ch3);

p2.add(l1);p2.add(t1);p2.add(l2);p2.add(t2);
p2.add(l3);p2.add(p4);p2.add(l4);p2.add(tr);
p2.add(l5);p2.add(t3);p2.add(l6);p2.add(list);
p2.add(l7);p2.add(t4);p2.add(l8);p2.add(p5);

p3.add(b1);p3.add(b2);p3.add(b3);p3.add(b4);p3.add(b5);

p1.setBackground(Color.PINK);
p3.setBackground(Color.ORANGE);

b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);

frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frm.add(p1,BorderLayout.NORTH);
frm.add(p2,BorderLayout.CENTER);
frm.add(p3,BorderLayout.SOUTH);
}
public void actionPerformed(ActionEvent ev)
{
String gen="",qual="",n,f,c,a,p,d;
if(r1.isSelected())
gen="Male";
if(r2.isSelected())
gen="Female";

if(ch1.isSelected())
qual=qual+"10th ,";
if(ch2.isSelected())
qual=qual+"12 ,";
if(ch3.isSelected())
qual=qual+"Graduation";

n=t1.getText();
f=t2.getText();
p=t3.getText();
d=t4.getText();
a=tr.getText();

c=String.valueOf(list.getSelectedItem());

System.out.println("Name:"+n+"\tFather:"+f+"\tPhone"+p+"\tDOB"+d+"\tAddress:"+a+"\tCourse:"+c+"\tGender:"+gen+"\tQualification:"+qual);

if(ev.getSource()==b1)
{
JOptionPane.showMessageDialog(frm,"Record Has been Saved!!","Information",JOptionPane.INFORMATION_MESSAGE);
}

if(ev.getSource()==b2)
{
roll=Integer.parseInt(JOptionPane.showInputDialog("Enter Roll No To Delete:"));
JOptionPane.showMessageDialog(frm,"Record Has been Deleted!!","Information",JOptionPane.INFORMATION_MESSAGE);
}

if(ev.getSource()==b4)
{
}
if(ev.getSource()==b3)
{
}
if(ev.getSource()==b5)
{
t1.setText("");
t2.setText("");
r1.setSelected(false);
r2.setSelected(false);
list.setSelectedItem("Plz Select");
t3.setText("");
t4.setText("");
tr.setText("");
ch1.setSelected(false);
ch2.setSelected(false);
ch3.setSelected(false);
}

}

public static void main(String args[])
{
student_add st_add=new student_add();
}
}

