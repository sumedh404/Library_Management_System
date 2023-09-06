
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class Signup_Admin extends JFrame{

Container c;
JLabel labId, labName,labContactNo,labUserName, labPassword;
JPasswordField txtPassword;
JTextField txtId, txtName,  txtContactNo,txtUserName;
JButton btncreate , btnback;

Signup_Admin(){
c = getContentPane();
//c.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
c.setLayout(null);


labId = new JLabel("Id");
txtId = new JTextField(20);
labName = new JLabel("Name");
txtName = new JTextField(20);
labContactNo = new JLabel("contact");
txtContactNo = new JTextField(10);
labUserName = new JLabel("Username");
txtUserName = new JTextField(20);
labPassword = new JLabel("Password");
txtPassword = new JPasswordField(20);
btncreate  = new JButton("Create");
btnback  = new JButton("Back");


ActionListener a1 = (ae) -> {
   
     int id =Integer.parseInt(txtId.getText());
     String name = txtName.getText();
     String contact =txtContactNo.getText();
     String username = txtUserName.getText();
     String password = txtPassword.getText();


     try{
           DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
           String url = "jdbc:mysql://localHost:3306/projectLib";
           String un = "root";
           String pw = "abc456";
           Connection con = DriverManager.getConnection(url,un,pw);
           String sql = "insert into signupA values(?,?,?,?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,id);
           pst.setString(2,name);
           pst.setString(3,contact);
           pst.setString(4,username);
           pst.setString(5,password);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(c, "record created");
           con.close();
   }catch(SQLException e){
      
        JOptionPane.showMessageDialog(c,"issue : " + e);
 }

    
};
btncreate.addActionListener(a1);

ActionListener a2 = (ae) -> {

main_interface a = new main_interface();
dispose();
};
btnback.addActionListener(a2);


Font f = new Font("Calibri", Font.BOLD, 25);
labId.setFont(f);
txtId.setFont(f);
labName.setFont(f);
txtName.setFont(f);
labContactNo.setFont(f);
txtContactNo.setFont(f);
labUserName.setFont(f);
txtUserName.setFont(f);
labPassword.setFont(f);
txtPassword.setFont(f);
btncreate.setFont(f);
btnback.setFont(f);

labId.setBounds(50,50,100,30);
txtId.setBounds(180,50,200,30);
labName.setBounds(30,100,100,30);
txtName.setBounds(180,100,200,30);
labContactNo.setBounds(20,150,100,30);
txtContactNo.setBounds(180,150,200,30);
labUserName.setBounds(20,200,120,30);
txtUserName.setBounds(180,200,200,30);
labPassword.setBounds(20,250,100,30);
txtPassword.setBounds(180,250,200,30);
btncreate.setBounds(100,325,120,30);
btnback.setBounds(250,325,100,30);


c.add(labId);
c.add(txtId);
c.add(labName);
c.add(txtName);
c.add(labContactNo);
c.add(txtContactNo);
c.add(labUserName);
c.add(txtUserName);
c.add(labPassword);
c.add(txtPassword );
c.add(btncreate);
c.add(btnback);




setTitle("Admin Signup");
setSize(500,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

