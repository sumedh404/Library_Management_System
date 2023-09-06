
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class view_student extends JFrame{
Container c;
JLabel labBookId;
JTextField txtBookId;
JButton btnSearch, btnBack, btnUpdate;
JLabel lb1, lb2, lb3, lb4, lb5, lb6;
JTextField txt1, txt2, txt3, txt4, txt5,txt6;

view_student(){
c= getContentPane();
c.setLayout(null);

labBookId = new JLabel("Student Id");
txtBookId = new JTextField(30);
lb1 = new JLabel("ID");
txt1 = new JTextField(30);
lb2 = new JLabel("Name");
txt2 = new JTextField(30);
lb3 = new JLabel("Dept");
txt3 = new JTextField(30);
lb4= new JLabel("Year");
txt4 = new JTextField(30);
lb5 = new JLabel("Email");
txt5 = new JTextField(20);
lb6= new JLabel("Contact");
txt6 = new JTextField(30);
btnSearch = new JButton("Search");
btnBack = new JButton("Back");
btnUpdate = new JButton("Update");

ActionListener a1 = (ae) -> {
   String bid = txtBookId.getText();
   try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String url = "jdbc:mysql://localhost:3306/projectLib";
        String un = "root";
        String pw = "abc456";
        Connection con = DriverManager.getConnection(url,un,pw);
        String sql = "select * from creates where id=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,bid);
        ResultSet rs = pst.executeQuery();
         if(rs.next()){
              String s1 = rs.getString(1);
              String s2 = rs.getString(2);
              String s3 = rs.getString(3);
              String s4 = rs.getString(4);
              String s5 = rs.getString(5);        
                String s6 = rs.getString(6); 

              txt1.setText(s1);
              txt2.setText(s2);
              txt3.setText(s3);
              txt4.setText(s4);
              txt5.setText(s5);
              txt6.setText(s6);
      
           }else
             {
                JOptionPane.showMessageDialog(c,"Data Not Found");
              }
    }catch(SQLException e){
       JOptionPane.showMessageDialog(c,"issue" + e);
    }
}; 
btnSearch.addActionListener(a1);


ActionListener a2 = (ae) -> {
login_Admin a = new login_Admin();
dispose();
}; 
btnBack.addActionListener(a2);

ActionListener a3 = (ae) -> {
      String pid = txtBookId.getText();
    try{
    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    String url = "jdbc:mysql://localhost:3306/projectLib";
    String un = "root";
    String pw = "abc456";
    Connection con = DriverManager.getConnection(url,un,pw);
    String sql = "UPDATE creates SET id=?, name=?, dept=?, year=?, email=?, contact=? WHERE id=?";
    PreparedStatement pst = con.prepareStatement(sql);
    
 
    pst.setString(1,txt1.getText());
    pst.setString(2,txt2.getText());
    pst.setString(3,txt3.getText());
    pst.setString(4,txt4.getText());
    pst.setString(5,txt5.getText());
    pst.setString(6,txt6.getText());
   

    pst.setString(7,pid);

    if(txt1.getText().equals("") || txt2.getText().equals("") || txt3.getText().equals("") || txt4.getText().equals("") || txt5.getText().equals("")  || txt6.getText().equals("")  ){
         JOptionPane.showMessageDialog(c,"Fill all the details :( ");
     }else{
        pst.executeUpdate();
        JOptionPane.showMessageDialog(c,"Updated Successfully :) " );
     }

    }catch(SQLException e){
         JOptionPane.showMessageDialog(c,"issue" + e);
    }

}; 
btnUpdate.addActionListener(a3);

Font f = new Font("Calibri", Font.BOLD, 25);
Font f1 = new Font("Calibri",Font.PLAIN,  20);
labBookId.setFont(f);
txtBookId.setFont(f);
btnSearch.setFont(f);
btnBack.setFont(f);
btnUpdate.setFont(f);

lb1.setFont(f);
txt1.setFont(f1);
lb2.setFont(f);
txt2.setFont(f1);
lb3.setFont(f);
txt3.setFont(f1);
lb4.setFont(f);
txt4.setFont(f1);
lb5.setFont(f);
txt5.setFont(f1);
lb6.setFont(f);
txt6.setFont(f1);


labBookId.setBounds(190,20,150,30);
txtBookId.setBounds(170,50,120,30);
btnSearch.setBounds(120,100,110,30);
btnBack.setBounds(250,100,100,30);
btnUpdate.setBounds(170,500,120,30);

lb1.setBounds(30,170,150,30);
txt1.setBounds(170,170,180,30);
lb2.setBounds(30,220,150,30);
txt2.setBounds(170,220,180,30);
lb3.setBounds(30,270,150,30);
txt3.setBounds(170,270,180,30);
lb4.setBounds(30,320,150,30);
txt4.setBounds(170,320,180,30);
lb5.setBounds(30,370,150,30);
txt5.setBounds(170,370,180,30);
lb6.setBounds(30,420,150,30);
txt6.setBounds(170,420,180,30);


c.add(labBookId);
c.add(txtBookId);
c.add(btnSearch);
c.add(btnBack);
c.add(btnUpdate);

c.add(lb1);
c.add(lb2);
c.add(lb3);
c.add(lb4);
c.add(lb5);
c.add(lb6);
c.add(txt1);
c.add(txt2);
c.add(txt3);
c.add(txt4);
c.add(txt5);
c.add(txt6);




setTitle("Update Student");
setSize(500,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


}
}


