import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;

class ViewList extends JFrame
{
Container c;
//JLabel lblstu ;
JButton btnBack;

boolean status;

ViewList()
{
c=getContentPane();
c.setLayout(new FlowLayout());

 
//lblstu=new JLabel("Student List :");          
btnBack=new JButton("Back");

//Font f=new Font("Courier", Font.BOLD, 20);
//Font g=new Font("Courier", Font.BOLD, 20);
//lblstu.setFont(f);


//lblstu.setBounds(30, 50, 200, 40);
btnBack.setBounds(100, 700, 100, 40);

//c.add(lblstu);
c.add(btnBack);


ActionListener a1=(ae) -> {
login_Admin a= new login_Admin();
dispose();
};
btnBack.addActionListener(a1);


setTitle("View Student");
setSize(500, 600);
add(getTablePanel());
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

private JPanel getTablePanel() {
JPanel tableJPanel = new JPanel();
tableJPanel.setLayout(new BorderLayout());
// Column Header
String[] columns = {"ID", "Name", "dept", "year", "Email", "Contact" };
// Getting Data for Table from Database
Object[][] data = getStudentDetails();
// Creating JTable object passing data and header
JTable studentTable = new JTable(data, columns);
tableJPanel.add(studentTable.getTableHeader(), BorderLayout.NORTH);
tableJPanel.add(studentTable, BorderLayout.CENTER);
return tableJPanel;
}
private Object[][] getStudentDetails() {
Object[][] data = null;
final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
final String CONNECTION_URL = "jdbc:mysql://localhost:3306/projectLib";
final String USERNAME = "root";
final String PASSWORD = "abc456";
final String QUERY = "Select id , name , dept, year, email, contact from creates order by id asc";
try {
// Loading the Driver
Class.forName(DRIVER_NAME);
// Getting Database Connection Object by Passing URL, Username and Password
Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs = statement.executeQuery(QUERY);
int rowCount = getRowCount(rs); // Row Count
int columnCount = getColumnCount(rs); // Column Count
data = new Object[rowCount][columnCount];
// Starting from First Row for Iteration
rs.beforeFirst();


int i = 0;
while (rs.next()) {
int j = 0;
data[i][j++] = rs.getInt("id");
data[i][j++] = rs.getString("name");
data[i][j++] = rs.getString("dept");
data[i][j++] = rs.getString("year");
data[i][j++] = rs.getString("email");
data[i][j++] = rs.getString("contact");
i++;
}
status = true;
// Closing the Resources;
statement.close();
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
return data;
}
// Method to get Row Count from ResultSet Object
private int getRowCount(ResultSet rs) {
try {
if(rs != null) {
rs.last();
return rs.getRow(); 
}
} catch (SQLException e) {
System.out.println(e.getMessage());
e.printStackTrace();
}
return 0;
}
// Method to get Column Count from ResultSet Object
private int getColumnCount(ResultSet rs) {
try {
if(rs != null)
return rs.getMetaData().getColumnCount();
} catch (SQLException e) {
System.out.println(e.getMessage());
e.printStackTrace();
}
return 0;
}
@Override
public String toString() {
return (status) ? "Data Listed Successfully" : "Application Error Occured";
}
}