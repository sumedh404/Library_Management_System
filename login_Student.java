
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class login_Student extends JFrame{
Container c;
JLabel labId;
JTextField txtId;
JButton btnLogin, btnBack;

login_Student(){
  c= getContentPane();
  c.setLayout(null);

labId = new JLabel("Student Id");
txtId = new JTextField(10);
btnLogin = new JButton("Login");
btnBack = new JButton("Back");

ActionListener a1 = (ae) -> {
    
     String Id = txtId.getText();
     try{
           DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
           String url = "jdbc:mysql://localHost:3306/projectLib";
           String un = "root";
           String pw = "abc456";
           Connection con = DriverManager.getConnection(url,un,pw);
           String sql = "select Id from creates where Id=?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,Id);
           ResultSet rs = pst.executeQuery();
           if(rs.next()){
              student_book a = new student_book();
              //JOptionPane.showMessageDialog("Successfully login");
           }else
             {
                JOptionPane.showMessageDialog(btnLogin,"Data Not Found");
              }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(c, "issue" + e);
      }
}; 
btnLogin.addActionListener(a1);


ActionListener a2 = (ae) -> {
login_Admin a = new login_Admin();
dispose();
}; 
btnBack.addActionListener(a2);

Font f = new Font("Calibri", Font.BOLD, 25);
labId.setFont(f);
txtId.setFont(f);
btnLogin.setFont(f);
btnBack.setFont(f);

labId.setBounds(130,50,150,30);
txtId.setBounds(130,80,120,30);
btnLogin.setBounds(90,150,100,30);
btnBack.setBounds(200,150,100,30);

c.add(labId);
c.add(txtId);
c.add(btnLogin);
c.add(btnBack);

setTitle("Login Student");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
