import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

class create_student extends JFrame{
Container c;
JLabel labId, labName, labDept, labYear, labEmail, labContact;
JTextField txtId, txtName, txtDept, txtYear, txtEmail, txtContact;
JButton btncreate, btnback;

create_student(){
c = getContentPane();
c.setLayout(null);

labId = new JLabel("Id");
txtId = new JTextField(20);
labName = new JLabel("Name");
txtName = new JTextField(20);
labDept = new JLabel("Dept");
txtDept = new JTextField(30);
labYear = new JLabel("Year");
txtYear = new JTextField(30);
labEmail = new JLabel("Email");
txtEmail = new JTextField(50);
labContact = new JLabel("Contact");
txtContact = new JTextField(10);
btncreate = new JButton("Create");
btnback = new JButton("Back");

ActionListener a1 = (ae) ->{
    int id = Integer.parseInt(txtId.getText());
    String name = txtName.getText();
    String dept = txtDept.getText();
    String year = txtYear.getText();
    String email = txtEmail.getText();
    String contact = txtContact.getText();

    try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        String url = "jdbc:mysql://localHost:3306/projectLib";
        String un = "root";
        String pw = "abc456";
        Connection con = DriverManager.getConnection(url,un,pw);
        String sql = "insert into createS values(?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setString(3,dept);
        pst.setString(4,year);
        pst.setString(5,email);
        pst.setString(6,contact);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(c,"record created");
        con.close();
    }catch(SQLException e){
          
          JOptionPane.showMessageDialog(c,"issue : " + e);
}

};
btncreate.addActionListener(a1);

ActionListener a2 = (ae) ->{
login_Admin a = new login_Admin();
dispose();
};
btnback.addActionListener(a2);

Font f = new Font("Calibri", Font.BOLD, 25);
labId.setFont(f);
txtId.setFont(f);
labName.setFont(f);
txtName.setFont(f);
labDept.setFont(f);
txtDept.setFont(f);
labYear.setFont(f);
txtYear.setFont(f);
labEmail.setFont(f);
txtEmail.setFont(f);
labContact.setFont(f);
txtContact.setFont(f);
btncreate.setFont(f);
btnback.setFont(f);


labId.setBounds(30,50,120,30);
txtId.setBounds(180,50,200,30);
labName.setBounds(30,100,120,30);
txtName.setBounds(180,100,200,30);
labDept.setBounds(30,150,120,30);
txtDept.setBounds(180,150,200,30);
labYear.setBounds(30,200,120,30);
txtYear.setBounds(180,200,200,30);
labEmail.setBounds(30,250,120,30);
txtEmail.setBounds(180,250,200,30);
labContact.setBounds(30,300,120,30);
txtContact.setBounds(180,300,200,30);
btncreate.setBounds(100,380,120,30);
btnback.setBounds(250,380,120,30);


c.add(labId);
c.add(txtId);
c.add(labName);
c.add(txtName);
c.add(labDept);
c.add(txtDept);
c.add(labYear);
c.add(txtYear);
c.add(labEmail);
c.add(txtEmail);
c.add(labContact);
c.add(txtContact);
c.add(btncreate);
c.add(btnback);


setTitle("create student");
setSize(500,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}



