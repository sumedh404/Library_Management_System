
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class delete_student extends JFrame{
Container c;
JLabel labStudentId;
JTextField txtStudentId;
JButton btnDelete, btnBack;

delete_student(){
c= getContentPane();
c.setLayout(null);

labStudentId = new JLabel("Student Id");
txtStudentId= new JTextField(30);
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");


ActionListener a1 = (ae) -> {

         int stuid =Integer.parseInt(txtStudentId.getText());
      try{
          DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
          String url = "jdbc:mysql://localHost:3306/projectLib";
          String un = "root";
          String pw = "abc456";
          Connection con = DriverManager.getConnection(url,un,pw);
          String sql = "DELETE FROM creates WHERE id=?";
          PreparedStatement pst = con.prepareStatement(sql);
          pst.setInt(1,stuid);
          int x = pst.executeUpdate();

          if(x==1){
                 JOptionPane.showMessageDialog(c, "Delete Sucessfully");
          }
          else{
              JOptionPane.showMessageDialog(c, "NO Data Found");
          }  
       }catch(SQLException e){
            JOptionPane.showMessageDialog(c, "issue " + e);
       }
}; 
btnDelete.addActionListener(a1);


ActionListener a2 = (ae) -> {
login_Admin a = new login_Admin();
dispose();
}; 
btnBack.addActionListener(a2);

Font f = new Font("Calibri", Font.BOLD, 25);
labStudentId.setFont(f);
txtStudentId.setFont(f);
btnDelete.setFont(f);
btnBack.setFont(f);

labStudentId.setBounds(130,50,150,30);
txtStudentId.setBounds(130,80,120,30);
btnDelete.setBounds(90,150,110,30);
btnBack.setBounds(210,150,100,30);

c.add(labStudentId);
c.add(txtStudentId);
c.add(btnDelete);
c.add(btnBack);

setTitle("Delete Student");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


}
}
