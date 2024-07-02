import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagementSystem extends JFrame {
    JButton addStudent, deleteStudent, updateStudent, searchStudent, displayStudents, clearBtn;
    JTextField rolltxt, nametxt, gradetxt, classtxt, gendertxt, contacttxt, dobtxt, addresstxt;

    JTable table;

    Connection con;

    public StudentManagementSystem() {

        setTitle("Student Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel label1 = new JLabel("Student Management System");
        label1.setFont(new Font("Serif", Font.BOLD, 28));
        label1.setForeground(Color.RED);
        label1.setBounds(300, 10, 400, 32);
        c.add(label1);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.setBounds(10, 60, 400, 580);
        panel1.setLayout(null);
        c.add(panel1);

        JLabel enterdetails = new JLabel("Enter Details");
        enterdetails.setFont(new Font("Serif", Font.BOLD, 20));
        enterdetails.setBounds(140, 5, 200, 20);
        panel1.add(enterdetails);

        JLabel rolllbl = new JLabel("Roll No: ");
        rolllbl.setFont(new Font("Serif", Font.BOLD, 18));
        rolllbl.setBounds(22, 35, 80, 20);
        panel1.add(rolllbl);

        rolltxt = new JTextField(20);
        rolltxt.setFont(new Font("Serif", Font.BOLD, 18));
        rolltxt.setBounds(120, 35, 240, 24);
        panel1.add(rolltxt);

        JLabel namelbl = new JLabel("Name: ");
        namelbl.setFont(new Font("Serif", Font.BOLD, 18));
        namelbl.setBounds(22, 70, 80, 20);
        panel1.add(namelbl);

        nametxt = new JTextField(20);
        nametxt.setFont(new Font("Serif", Font.BOLD, 18));
        nametxt.setBounds(120, 70, 240, 24);
        panel1.add(nametxt);

        JLabel gradelbl = new JLabel("Grade: ");
        gradelbl.setFont(new Font("Serif", Font.BOLD, 18));
        gradelbl.setBounds(22, 105, 80, 20);
        panel1.add(gradelbl);

        gradetxt = new JTextField(20);
        gradetxt.setFont(new Font("Serif", Font.BOLD, 18));
        gradetxt.setBounds(120, 105, 240, 24);
        panel1.add(gradetxt);

        JLabel classlbl = new JLabel("Class: ");
        classlbl.setFont(new Font("Serif", Font.BOLD, 18));
        classlbl.setBounds(22, 140, 80, 20);
        panel1.add(classlbl);

        classtxt = new JTextField(20);
        classtxt.setFont(new Font("Serif", Font.BOLD, 18));
        classtxt.setBounds(120, 140, 240, 24);
        panel1.add(classtxt);

        JLabel genderlbl = new JLabel("Gender: ");
        genderlbl.setFont(new Font("Serif", Font.BOLD, 18));
        genderlbl.setBounds(22, 175, 80, 20);
        panel1.add(genderlbl);

        gendertxt = new JTextField(20);
        gendertxt.setFont(new Font("Serif", Font.BOLD, 18));
        gendertxt.setBounds(120, 175, 240, 24);
        panel1.add(gendertxt);

        JLabel contactlbl = new JLabel("Contact No: ");
        contactlbl.setFont(new Font("Serif", Font.BOLD, 17));
        contactlbl.setBounds(22, 210, 100, 20);
        panel1.add(contactlbl);

        contacttxt = new JTextField(20);
        contacttxt.setFont(new Font("Serif", Font.BOLD, 18));
        contacttxt.setBounds(120, 210, 240, 24);
        panel1.add(contacttxt);

        JLabel doblbl = new JLabel("DOB : ");
        doblbl.setFont(new Font("Serif", Font.BOLD, 18));
        doblbl.setBounds(22, 245, 100, 20);
        panel1.add(doblbl);

        dobtxt = new JTextField(20);
        dobtxt.setFont(new Font("Serif", Font.BOLD, 18));
        dobtxt.setBounds(120, 245, 240, 24);
        panel1.add(dobtxt);

        JLabel addresslbl = new JLabel("Address: ");
        addresslbl.setFont(new Font("Serif", Font.BOLD, 18));
        addresslbl.setBounds(22, 280, 100, 20);
        panel1.add(addresslbl);

        addresstxt = new JTextField(20);
        addresstxt.setFont(new Font("Serif", Font.BOLD, 18));
        addresstxt.setBounds(120, 280, 240, 24);
        panel1.add(addresstxt);

        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.magenta);
        panelButton.setBounds(20, 340, 360, 230);
        panelButton.setLayout(null);
        panel1.add(panelButton);

        addStudent = new JButton("Add");
        addStudent.setFont(new Font("Serif", Font.BOLD, 24));
        addStudent.setBackground(Color.ORANGE);
        addStudent.setBounds(20, 20, 140, 50);
        panelButton.add(addStudent);

        deleteStudent = new JButton("Delete");
        deleteStudent.setFont(new Font("Serif", Font.BOLD, 24));
        deleteStudent.setBackground(Color.ORANGE);
        deleteStudent.setBounds(190, 20, 140, 50);
        panelButton.add(deleteStudent);

        updateStudent = new JButton("Update");
        updateStudent.setFont(new Font("Serif", Font.BOLD, 24));
        updateStudent.setBackground(Color.ORANGE);
        updateStudent.setBounds(20, 90, 140, 50);
        panelButton.add(updateStudent);

        displayStudents = new JButton("Display");
        displayStudents.setFont(new Font("Serif", Font.BOLD, 24));
        displayStudents.setBackground(Color.ORANGE);
        displayStudents.setBounds(190, 90, 140, 50);
        panelButton.add(displayStudents);

        searchStudent = new JButton("Search");
        searchStudent.setFont(new Font("Serif", Font.BOLD, 24));
        searchStudent.setBackground(Color.ORANGE);
        searchStudent.setBounds(20, 160, 140, 50);
        panelButton.add(searchStudent);

        clearBtn = new JButton("Clear");
        clearBtn.setFont(new Font("Serif", Font.BOLD, 24));
        clearBtn.setBackground(Color.ORANGE);
        clearBtn.setBounds(190, 160, 140, 50);
        panelButton.add(clearBtn);

        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(Color.magenta);
        tablePanel.setBounds(420, 60, 555, 580);
        tablePanel.setLayout(null);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                rolltxt.setText(table.getModel().getValueAt(row, 0).toString());
                nametxt.setText(table.getModel().getValueAt(row, 1).toString());
                gradetxt.setText(table.getModel().getValueAt(row, 2).toString());
                classtxt.setText(table.getModel().getValueAt(row, 3).toString());
                gendertxt.setText(table.getModel().getValueAt(row, 4).toString());
                contacttxt.setText(table.getModel().getValueAt(row, 5).toString());
                dobtxt.setText(table.getModel().getValueAt(row, 6).toString());
                addresstxt.setText(table.getModel().getValueAt(row, 7).toString());
            }
        });

        JScrollPane sc = new JScrollPane(table);
        sc.setBounds(10, 10, 535, 560);
        tablePanel.add(sc);

        c.add(tablePanel);

        setVisible(true);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaurav", "root", "Gaurav@1234");

        } catch (Exception e) {
            System.out.println(e);
        }

        addStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {

                    String query = "insert into studentmanagement(rollno,name,grade,class,gender,contactno,dob,address) values(?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, rolltxt.getText());
                    ps.setString(2, nametxt.getText());
                    ps.setString(3, gradetxt.getText());
                    ps.setString(4, classtxt.getText());
                    ps.setString(5, gendertxt.getText());
                    ps.setString(6, contacttxt.getText());
                    ps.setString(7, dobtxt.getText());
                    ps.setString(8, addresstxt.getText());

                    int i = ps.executeUpdate();

                    if (i > 0) {
                        System.out.println("Successfully added");
                        JOptionPane.showMessageDialog(null, "Student added");
                    } else {
                        System.out.println("Fail");
                        JOptionPane.showMessageDialog(null, "Student not added");
                    }

                } catch (Exception e) {
                }

            }
        });

        deleteStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int roll = Integer.parseInt(rolltxt.getText());
                try {
                    String query = "Delete from studentmanagement where rollno=" + roll;
                    PreparedStatement ps = con.prepareStatement(query);
                    int i = ps.executeUpdate();
                    if (i > 0) {
                        System.out.println("Successfully added");
                        JOptionPane.showMessageDialog(null, "Student Deleted");
                    } else {
                        System.out.println("Fail");
                        JOptionPane.showMessageDialog(null, "Student not deleted");
                    }

                } catch (Exception e) {
                }
            }
        });

        displayStudents.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                displayData();
            }
        });

        updateStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int roll = Integer.parseInt(rolltxt.getText());
                String name = nametxt.getText();
                String grade = gradetxt.getText();
                String classs = classtxt.getText();
                String gender = gendertxt.getText();
                String contact = contacttxt.getText();
                String dob = dobtxt.getText();
                String address = addresstxt.getText();

                String query = "Update studentmanagement set rollno='" + roll + "',name='" + name + "',grade='" + grade
                        + "',class='" + classs + "',gender='" + gender + "',contactno='" + contact + "',dob='" + dob
                        + "',address='" + address + "' where rollno='" + roll + "'";

                try {
                    PreparedStatement ps = con.prepareStatement(query);
                    int i = ps.executeUpdate();
                    if (i > 0) {
                        System.out.println("Successfully added");
                        JOptionPane.showMessageDialog(null, "Student updates");
                    } else {
                        System.out.println("Fail");
                        JOptionPane.showMessageDialog(null, "Student not updated");
                    }
                } catch (Exception e) {

                }
            }
        });

        searchStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = "SELECT * FROM studentmanagement WHERE rollno ='" + Integer.parseInt(rolltxt.getText())
                        + "' OR name ='" + nametxt.getText() + "'";

                try {
                    PreparedStatement ps = con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        rolltxt.setText(String.valueOf(rs.getInt(1)));
                        nametxt.setText(rs.getString(2));
                        gradetxt.setText(rs.getString(3));
                        classtxt.setText(rs.getString(4));
                        gendertxt.setText(rs.getString(5));
                        contacttxt.setText(rs.getString(6));
                        dobtxt.setText(rs.getString(7));
                        addresstxt.setText(rs.getString(8));
                    }
                } catch (Exception ee) {

                }
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                rolltxt.setText("");
                nametxt.setText("");
                gradetxt.setText("");
                classtxt.setText("");
                gendertxt.setText("");
                contacttxt.setText("");
                dobtxt.setText("");
                addresstxt.setText("");
            }
        });
    }

    public void displayData() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setRowCount(0);

        if (model.getColumnCount() == 0) {
            model.addColumn("Roll No");
            model.addColumn("Name");
            model.addColumn("Grade");
            model.addColumn("Class");
            model.addColumn("Gender");
            model.addColumn("Contact No");
            model.addColumn("DOB");
            model.addColumn("Address");
        }

        try {
            String query = "SELECT * FROM studentmanagement";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int roll = rs.getInt("rollno");
                String name = rs.getString("name");
                String grade = rs.getString("grade");
                String classs = rs.getString("class");
                String gender = rs.getString("gender");
                String contact = rs.getString("contactno");
                String dob = rs.getString("dob");
                String address = rs.getString("address");

                model.addRow(new Object[] { roll, name, grade, classs, gender, contact, dob, address });
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}
