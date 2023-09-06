
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class main_interface extends JFrame{

Container c;
JLabel labuser, labPassword,labLib;
JTextField txtuser;
JPasswordField txtpassword;
JButton login, signup ;

main_interface(){
c = getContentPane();
//c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
c.setLayout(null);

labLib = new JLabel("Library System");
labuser = new JLabel("Username");
txtuser = new JTextField(20);
labPassword = new JLabel("password");
txtpassword = new JPasswordField(20);
login = new JButton("Login");
signup = new JButton("Signup");




Font f1= new Font("Calibri", Font.BOLD, 50);
Font f = new Font("Calibri", Font.BOLD, 30);
labLib.setFont(f1);
labuser.setFont(f);
txtuser.setFont(f);
labPassword.setFont(f);
txtpassword.setFont(f);
login.setFont(f);
signup.setFont(f);


labLib.setBounds(150,50,500,60);
labuser.setBounds(30,150,250,40);
txtuser.setBounds(220,150,250,40);
labPassword.setBounds(30,200,250,40);
txtpassword.setBounds(220,200,250,40);
login.setBounds(150,300,120,40);
signup.setBounds(300,300,120,40);

c.add(labuser);
c.add(txtuser);
c.add(labPassword);
c.add(txtpassword);
c.add(login);
c.add(signup);
c.add(labLib);


ActionListener a1 = (ae) -> {

      String username= txtuser.getText();
      String password = txtpassword.getText();
    try{
           DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
           String url = "jdbc:mysql://localHost:3306/projectLib";
           String un = "root";
           String pw = "abc456";
           Connection con = DriverManager.getConnection(url,un,pw);
           String sql = "select username, password from signupA where username=? and password=?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,username);
           pst.setString(2,password);
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
              main2 a = new main2();
              //JOptionPane.showMessageDialog(login, "You have successfully logged in");
           }else
             {
                JOptionPane.showMessageDialog(login, "Wrong username & password");
              }
           
        }catch(SQLException e){
           JOptionPane.showMessageDialog(c, "issue" + e);
         }


};
login.addActionListener(a1);


ActionListener a2 = (ae) -> {

Signup_Admin a = new Signup_Admin();
dispose();

};
signup.addActionListener(a2);


setTitle("Library Management System");
setSize(600,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
