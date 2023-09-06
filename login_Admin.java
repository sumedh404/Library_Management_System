
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class login_Admin extends JFrame{

Container c;
JLabel labstu;
JButton btnCreateNew, btnView, btnDelete,btnViewList, btnBack;

login_Admin(){
c = getContentPane();
//c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
c.setLayout(null);

btnCreateNew = new JButton("Create");
//btnLogin = new JButton("login");
btnView = new JButton("Update");
btnDelete = new JButton("Delete");
btnViewList = new JButton("View List"); 
btnBack = new JButton("Back");
labstu = new JLabel("Student's");



ActionListener a1 = (ae) -> {
//btnCreateNew.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
create_student a = new create_student();
dispose();    
};
btnCreateNew.addActionListener(a1);

/*
ActionListener a2 = (ae) -> {
login_Student a = new login_Student();
dispose();

};
btnLogin.addActionListener(a2);
*/
ActionListener a3 = (ae) -> {
view_student a = new view_student();
dispose();
};
btnView.addActionListener(a3);

ActionListener a4 = (ae) -> {
delete_student a = new delete_student();
dispose();

};
btnDelete.addActionListener(a4);

ActionListener a5 = (ae) -> {

main2 a  = new main2();
dispose();
};
btnBack.addActionListener(a5);


ActionListener a6 = (ae) -> {

ViewList a  = new ViewList();
dispose();
};
btnViewList.addActionListener(a6);


Font f1 = new Font("Calibri", Font.BOLD, 50);
Font f = new Font("Calibri", Font.BOLD, 30);

btnCreateNew.setFont(f);
//btnLogin.setFont(f);
btnView.setFont(f);
btnDelete.setFont(f);
btnBack.setFont(f);
btnViewList.setFont(f);
labstu.setFont(f1);

btnCreateNew.setBounds(150,150,150,30);
//btnLogin.setBounds(150,150,150,30);
btnView.setBounds(150,250,150,30);
btnDelete.setBounds(150,300,150,30);
btnBack.setBounds(150,350,150,30);
btnViewList.setBounds(150,200,150,30);
labstu.setBounds(130,50,200,50);

c.add(btnCreateNew);
//c.add(btnLogin);
c.add(btnView);
c.add(btnDelete);
c.add(btnBack);
c.add(btnViewList);
c.add(labstu);

setTitle("Student");
setSize(500,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}




