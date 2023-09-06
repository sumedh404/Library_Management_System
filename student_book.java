
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class student_book extends JFrame{
Container c;
JLabel labbook;
JButton btnAddBook, btnDeleteBook, btnViewBook, btnRenewBook, btnViewList, btnBack;

student_book(){
c = getContentPane();
c.setLayout(null);

labbook = new JLabel("Book's");
btnAddBook = new JButton("Add Book");
btnDeleteBook = new JButton("Delete Book");
btnViewBook = new JButton("View Book");
btnRenewBook = new JButton("Renew Book");
btnViewList = new JButton("Renew Boo");
btnBack = new JButton("Back");

ActionListener a1 = (ae) ->{
Add_book a = new Add_book();
dispose();
};
btnAddBook.addActionListener(a1);

ActionListener a2 = (ae) ->{
delete_book a = new delete_book();
dispose();
};
btnDeleteBook.addActionListener(a2);

ActionListener a3 = (ae) ->{
view_book a = new view_book();
dispose();
};
btnViewBook.addActionListener(a3);

ActionListener a4 = (ae) ->{
renew_book a = new renew_book();
dispose();
};
btnRenewBook.addActionListener(a4);

ActionListener a5 = (ae) ->{
 main2 a = new main2();
dispose();
};
btnBack.addActionListener(a5);

ActionListener a6 = (ae) ->{
ViewList a = new ViewList();
dispose();
};
btnViewList.addActionListener(a6);

Font f1 = new Font("Calibri", Font.BOLD, 50);
Font f = new Font("Calibri", Font.BOLD, 30);

labbook.setFont(f1);
btnAddBook.setFont(f);
btnDeleteBook.setFont(f);
btnViewBook.setFont(f);
btnRenewBook.setFont(f);
btnBack.setFont(f);


labbook.setBounds(170,50,200,50);
btnAddBook.setBounds(150,150,200,30);
btnDeleteBook.setBounds(150,210,200,30);
btnViewBook.setBounds(150,270,200,30);
btnRenewBook.setBounds(150,330,200,30);
btnBack.setBounds(150,390,200,30);

c.add(btnAddBook);
c.add(btnDeleteBook);
c.add(btnViewBook);
c.add(btnRenewBook);
c.add(btnBack);
c.add(labbook);


setTitle("Student book");
setSize(500,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}




