
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class delete_book extends JFrame{
Container c;
JLabel labBookId;
JTextField txtBookId;
JButton btnDelete, btnBack;

delete_book(){
c= getContentPane();
c.setLayout(null);

labBookId = new JLabel("Book Id");
txtBookId = new JTextField(30);
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");


ActionListener a1 = (ae) -> {
     int bid = Integer.parseInt(txtBookId.getText());
     try{
         DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
         String url ="jdbc:mysql://localHost:3306/projectLib";
         String un ="root";
         String pw = "abc456";
         Connection con = DriverManager.getConnection(url,un,pw);
         String sql = "DELETE FROM bookdata WHERE id=?";
         PreparedStatement pst = con.prepareStatement(sql);
         pst.setInt(1,bid);
         int y = pst.executeUpdate();

         if(y==1){
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
student_book a = new student_book();
dispose();
}; 
btnBack.addActionListener(a2);

Font f = new Font("Calibri", Font.BOLD, 25);
labBookId.setFont(f);
txtBookId.setFont(f);
btnDelete.setFont(f);
btnBack.setFont(f);

labBookId.setBounds(150,50,150,30);
txtBookId.setBounds(130,80,120,30);
btnDelete.setBounds(90,150,110,30);
btnBack.setBounds(210,150,100,30);

c.add(labBookId);
c.add(txtBookId);
c.add(btnDelete);
c.add(btnBack);

setTitle("Delete Book");
setSize(400,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


}
}
