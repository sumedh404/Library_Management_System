

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class main2 extends JFrame{
Container c;
JLabel labstu;
JButton btnStudent, btnBook;

main2(){
c = getContentPane();
//c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
c.setLayout(null);

labstu = new JLabel("");
btnStudent = new JButton("Student");
btnBook = new JButton("Book");

ActionListener a1 = (ae) ->{
login_Admin a = new login_Admin();
dispose();

};
btnStudent.addActionListener(a1);


ActionListener a2 = (ae) ->{
student_book a = new student_book();
dispose();
};
btnBook.addActionListener(a2);

Font f = new Font("Calibri", Font.BOLD, 30);

btnStudent.setFont(f);
btnBook.setFont(f);

btnStudent.setBounds(150,150,200,40);
btnBook.setBounds(150,230,200,40);

c.add(btnStudent);
c.add(btnBook);

setTitle("Library System");
setSize(500,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}