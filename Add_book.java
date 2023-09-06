package pa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Add_book extends JFrame{
Container c;
JLabel  labBookId, labBookName, labAuthor, labPublication, labDate;
JTextField txtBookName, txtBookId, txtAuthor, txtPublication, txtDate;
JButton btnAdd, btnBack;

Add_book(){
c = getContentPane();
c.setLayout(null);

labBookId = new JLabel("Id");
txtBookId = new JTextField(30);
labBookName = new JLabel("Book Name");
txtBookName = new JTextField(30);
labAuthor = new JLabel("Author");
txtAuthor = new JTextField(30);
labPublication = new JLabel("Publication");
txtPublication = new JTextField(30);
labDate = new JLabel("Date");
txtDate = new JTextField(30);
btnAdd = new JButton("Add Book");
btnBack = new JButton("Back");

ActionListener a1 = (ae) ->{
       int id = Integer.parseInt(txtBookId.getText());
       String name = txtBookName.getText();
       String author = txtAuthor.getText();
       String publication = txtPublication.getText();
       String date = txtDate.getText();

try{
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      String url = "jdbc:mysql://localHost:3306/projectLib";
      String un = "root";
      String pw = "abc456";
      Connection con = DriverManager.getConnection(url,un,pw);
      String sql = "insert into bookdata values(?,?,?,?,?)";
      PreparedStatement pst = con.prepareStatement(sql);
      pst.setInt(1,id);
      pst.setString(2,name);
      pst.setString(3,author);
      pst.setString(4,publication);
      pst.setString(5,date);
      pst.executeUpdate();
      JOptionPane.showMessageDialog(c, "record created");
      con.close();

}
catch(SQLException e){
       JOptionPane.showMessageDialog(c,"issue : " + e);
}
       
};
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) ->{
student_book a = new student_book();
dispose();
};
btnBack.addActionListener(a2);

Font f = new Font("Calibri", Font.BOLD, 25);

labBookName.setFont(f);
txtBookName.setFont(f);
labBookId.setFont(f);
txtBookId.setFont(f);
labAuthor.setFont(f);
txtAuthor.setFont(f);
labPublication.setFont(f);
txtPublication.setFont(f);
labDate.setFont(f);
txtDate.setFont(f);
btnAdd.setFont(f);
btnBack.setFont(f);


labBookId.setBounds(50,50,100,30);
txtBookId.setBounds(180,50,100,30);
labBookName.setBounds(30,100,200,30);
txtBookName.setBounds(180,100,200,30);
labAuthor.setBounds(30,150,100,30);
txtAuthor.setBounds(180,150,200,30);
labPublication.setBounds(30,200,120,30);
txtPublication.setBounds(180,200,200,30);
labDate.setBounds(30,250,100,30);
txtDate.setBounds(180,250,200,30);
btnAdd.setBounds(100,325,150,30);
btnBack.setBounds(270,325,100,30);


c.add(labBookName);
c.add(txtBookName);
c.add(labBookId);
c.add(txtBookId);
c.add(labAuthor);
c.add(txtAuthor);
c.add(labPublication);
c.add(txtPublication);
c.add(labDate);
c.add(txtDate);
c.add(btnAdd);
c.add(btnBack);



setTitle("Add book");
setSize(500,500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}


