import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;

import java.io.FileWriter;

import java.sql.DriverManager;
import java.sql.*;

class MyApplication2 
{

	static JFrame f = new JFrame();

	static String Department[] = { "Comp", "Mech","IT","Electrical" };
	static String temp[] = {"a","b"};

	//Student tab Variables
	static JTextField tfPRN,tfName,tfAddress,tfPhone,tfMail;
	static JButton btSubmit,btDelete;
	static JTabbedPane tabbedPane =  new JTabbedPane();
    static JComboBox cbStudentDepartment = new JComboBox(Department);
    static JRadioButton rbStudentMale, rbStudentFemale;
    static ButtonGroup groupGender;
	static DefaultTableModel model = new DefaultTableModel();
	static JTable table = new JTable(model);

	//Parent tab Variables
	static JTextField tfPName,tfPAddress,tfPPhone,tfPMail,tfPOccupation,tfPStudentName;
	static JButton btPSubmit,btPDelete;
	static JComboBox cbParentPRN = new JComboBox();

	
	//Constructor
	public MyApplication2(){
		//Gender
		rbStudentMale = new JRadioButton();
   		 rbStudentFemale = new JRadioButton();
    	rbStudentMale.setText("Male");
		rbStudentFemale.setText("Female");
		groupGender = new ButtonGroup();
		groupGender.add(rbStudentFemale);
		groupGender.add(rbStudentMale);

		//set title of jframe
		f.setTitle("MyApplication2");
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Table
		
		model.addColumn("PRN");
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Phone");
		model.addColumn("Mail");
		model.addColumn("Gender");
		model.addColumn("Department");

		/*String[] column = {"ID","NAME","ADDRESS"};
		Object[][] data = {};
		JTable STable = new JTable(data, column);
		STable.setBounds(10,10,50,50);
		*/
		JScrollPane sp = new JScrollPane(table);

		//Creating object of jpanel class
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		tabbedPane.add("Student",p1);
		tabbedPane.add("Parent",p2);
		tabbedPane.add("Faculty",p3);

		//set the layout
		p1.setLayout(new GridBagLayout());
		p2.setLayout(new GridBagLayout());
		p3.setLayout(new GridBagLayout());

		//create constraints
		GridBagConstraints gbc = new GridBagConstraints();

		//insets for all conponents
		gbc.insets = new Insets(2,2,2,2);


	//Student Details
		//Name
		gbc.gridx = 0;
		gbc.gridy = 0;
		p1.add(new JLabel("Name"),gbc);

		gbc.gridx++;
		tfName = new JTextField("",20);
		p1.add(tfName,gbc);


		//PRN
		gbc.gridx=0;
		gbc.gridy++;
		p1.add(new JLabel("PRN"),gbc);


		gbc.gridx++;
		tfPRN = new JTextField("",20);
		p1.add(tfPRN,gbc);

		//Address
		gbc.gridx=0;
		gbc.gridy++;
		p1.add(new JLabel("Address"),gbc);

		gbc.gridx++;
		tfAddress = new JTextField("",20);
		p1.add(tfAddress,gbc);

		//Phone
		gbc.gridx=0;
		gbc.gridy++;
		p1.add(new JLabel("Phone"),gbc);
		gbc.gridx++;
		tfPhone = new JTextField(20);
		p1.add(tfPhone,gbc);

		//mail
		gbc.gridx=0;
		gbc.gridy++;
		p1.add(new JLabel("Mail"),gbc);
		gbc.gridx++;
		tfMail = new JTextField(20);
		p1.add(tfMail,gbc);

		//Department
		gbc.gridx=0;
		gbc.gridy++;
		p1.add(new JLabel("Department"),gbc);
		gbc.gridx++;
		p1.add(cbStudentDepartment,gbc);

		gbc.gridx=0;
		gbc.gridy++;
		p1.add(new JLabel("Gender"),gbc);
		gbc.gridx++;
		p1.add(rbStudentMale,gbc);	
		gbc.gridx++;	
		p1.add(rbStudentFemale,gbc);
		
		//Submit button
		gbc.gridx=0;
		gbc.gridy++;
		btSubmit = new JButton("SUBMIT");
		btSubmit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				addToDatabase(e);
			}
		});
		p1.add(btSubmit,gbc);

		//Delete button
		gbc.gridx++;
		btDelete = new JButton("DELETE");
		btDelete.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				DeleteRow(e);
			}
		});
		p1.add(btDelete,gbc);

	// Parent Details
		//Name
		gbc.gridx = 0;
		gbc.gridy = 0;
		p2.add(new JLabel("Name"),gbc);

		gbc.gridx++;
		tfPName = new JTextField("",20);
		p2.add(tfPName,gbc);


		//Student's PRN
		gbc.gridx=0;
		gbc.gridy++;
		p2.add(new JLabel("Student's PRN"),gbc);
		gbc.gridx++;
		p2.add(cbParentPRN,gbc);

		//Student name as per PRN
		gbc.gridx++;
		tfPStudentName = new JTextField("",5);
		p2.add(tfPStudentName,gbc);

		//Address
		gbc.gridx=0;
		gbc.gridy++;
		p2.add(new JLabel("Address"),gbc);

		gbc.gridx++;
		tfPAddress = new JTextField("",20);
		p2.add(tfPAddress,gbc);

		//Phone
		gbc.gridx=0;
		gbc.gridy++;
		p2.add(new JLabel("Phone"),gbc);

		gbc.gridx++;
		tfPPhone = new JTextField("",20);
		p2.add(tfPPhone,gbc);

		//Mail
		gbc.gridx=0;
		gbc.gridy++;
		p2.add(new JLabel("Mail"),gbc);

		gbc.gridx++;
		tfPMail = new JTextField("",20);
		p2.add(tfPMail,gbc);		

		//Occupation
		gbc.gridx=0;
		gbc.gridy++;
		p2.add(new JLabel("Occupation"),gbc);

		gbc.gridx++;
		tfPOccupation = new JTextField("",20);
		p2.add(tfPOccupation,gbc);		



		//Submit button
		gbc.gridx=0;
		gbc.gridy++;
		btPSubmit = new JButton("SUBMIT");
		/*btPSubmit.addActionListener((new ActionListener()
			{  
   				 public void actionPerformed(ActionEvent e)
				{  
           			 addToDatabase(e); 
   				}  
   			}
		));*/
		p2.add(btPSubmit,gbc);

		//Delete button
		gbc.gridx++;
		btPDelete = new JButton("DELETE");
		//btPDelete.addActionListener(this);
		p2.add(btPDelete,gbc);	

		//add the content
		f.getContentPane().add(tabbedPane);
		f.add(sp);


		f.setSize(600,400);
		f.setVisible(true);

		// Fill Table from Database
		DisplayTable();
		
		// Edit Student Table details ( Update/ Delete )
		table.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent evt)
			{
				StudentTableMouseClicked(evt);
			}
		}
		);

	}

	static void DisplayTable()
	{



		String rPRN= "";
		String rName= "";
		String rPhone = "";
		String rMail = "";
		String rAddress = "";
		String rGender = "";
		String rDepartment = "";
		String rStudentPRN = "";
		try
		{

			String sql = "SELECT * FROM STUDENT";
		//	String sqlGetPRN = "Select PRN FROM STUDENT WHERE NAME = '"+rName"';";
			DefaultTableModel MyTable = (DefaultTableModel) table.getModel();
			MyTable.setRowCount(0);

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaForm","root","vu123");
			PreparedStatement ps = myconn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i =0;
			while(rs.next())
			{	
				rPRN = rs.getString("PRN");
				rName = rs.getString("name");
				cbParentPRN.addItem(rPRN+": "+rName);
				rAddress = rs.getString("address");
				rPhone = rs.getString("phone"); 
				rMail = rs.getString("mail");
				rGender = rs.getString("gender"); 
				rDepartment = rs.getString("department");
			//	rStudentPRN= cbStudentDepartment.getSelectedItem().toString();

				MyTable.addRow(new Object[]{rPRN,rName,rAddress,rPhone,rMail,rGender,rDepartment});
				i++; 
			}
			myconn.close();
		}
		catch(Exception abc)
		{
			System.out.println("Error:In Exception");
			abc.printStackTrace();
		}
		
	}

	/*public void actionPerformed(ActionEvent e)
	{
		try{
			FileWriter f = new FileWriter("student.txt", true);
			f.write(tfName.getText()+"\r\n");
			f.close();
			String Name = tfName.getText();
			String Address = tfAddress.getText();
			String ID = tfPRN.getText();
			Object[] a = {Name,Address,ID};

			DefaultTableModel MyTable = (DefaultTableModel) table.getModel();
			
			MyTable.addRow(a);

			tfName.setText("");
		}
		catch(Exception xyz)
		{

		}
	}*/

	static void StudentTableMouseClicked(MouseEvent evt)
	{
			tfPRN.setEditable(false);

			DefaultTableModel t = (DefaultTableModel) table.getModel();
			JTable source = (JTable) evt.getSource();
			int row = source.rowAtPoint(evt.getPoint());
			String cgender = "Female";

			// Fill Text Fields with Selected Attributes
			tfPRN.setText(t.getValueAt(row,0).toString());
			tfName.setText(t.getValueAt(row,1).toString());
			tfAddress.setText(t.getValueAt(row,2).toString());
			tfPhone.setText(t.getValueAt(row,3).toString());
			tfMail.setText(t.getValueAt(row,4).toString());
			cgender = t.getValueAt(row,5).toString();
			if(cgender.equals("Male"))
			{
				rbStudentMale.setSelected(true);
				rbStudentFemale.setSelected(false);
			}	
			if(cgender.equals("Female"))	
			{
				rbStudentMale.setSelected(false);
				rbStudentFemale.setSelected(true);
			}
			cbStudentDepartment.setSelectedItem(t.getValueAt(row,6));

			// Update instead of Submit
			btSubmit.setText("UPDATE");
			btSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateRecord(e);
			}
			});
	
	}


	static void UpdateRecord(ActionEvent e)
	{
		String prn,name,address,phone,mail,gender="Male",department;

		prn = tfPRN.getText();
		name = tfName.getText();
		address = tfAddress.getText();
		phone = tfPhone.getText();
		mail = tfMail.getText();
		department = cbStudentDepartment.getSelectedItem().toString();
		if(rbStudentMale.isSelected())
			gender = "Male";
		if(rbStudentFemale.isSelected())
			gender = "Female";
	

		String sql = "UPDATE STUDENT SET PRN = '"+prn+"', NAME =  '"+name+"',ADDRESS = '"+address+"', PHONE = '"+phone+"',MAIL = '"+mail+"',GENDER = '"+gender+"',DEPARTMENT = '"+department+"' WHERE PRN = "+prn+";";
		System.out.println(sql);

		tfPRN.setText("");
		tfName.setText("");
		tfMail.setText("");
		tfPhone.setText("");
		tfAddress.setText("");

		//Write here the code to enter into database
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaForm","root","vu123");
			Statement st = myconn.createStatement();
			st.executeUpdate(sql);
			myconn.close();

			Object[] a = {prn,name,address,phone,mail,gender,department};
			DefaultTableModel MyTable = (DefaultTableModel) table.getModel();
			MyTable.addRow(a);
		}
		catch(Exception abc)
		{
			System.out.println("Error:In Exception");
			abc.printStackTrace();
		}

		// Update JTable
		DisplayTable();
		tfPRN.setEditable(true);
		
		// Revert back SubmitButton to Submit instead of Update
		btSubmit.setText("SUBMIT");
		btSubmit.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				addToDatabase(e);
			}
		});
	}

	static void DeleteRow(ActionEvent e)
	{
   		DefaultTableModel model = (DefaultTableModel) table.getModel();
  		int[] rows = table.getSelectedRows();
		String key = tfPRN.getText();

		// Delete from Database
		String sql = "DELETE FROM STUDENT WHERE PRN = "+key+";";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaForm","root","vu123");
			Statement st = myconn.createStatement();
			st.executeUpdate(sql);
			myconn.close();
		}	
		catch(Exception abc)
		{
			System.out.println("Error:In Exception");
			abc.printStackTrace();
		}		

		// Delete from table  
   		for(int i=0;i<rows.length;i++)	
		{
     		model.removeRow(rows[i]-i);
  	    }	
		System.out.println(rows[0]);
		JOptionPane.showMessageDialog(f,"Record Deleted.");	

		tfPRN.setEditable(true);
	}

	static void addToDatabase(ActionEvent e)
	{
		String prn,name,address,phone,mail,gender="Male",department;

		prn = tfPRN.getText();
		name = tfName.getText();
		address = tfAddress.getText();
		phone = tfPhone.getText();
		mail = tfMail.getText();
		department = cbStudentDepartment.getSelectedItem().toString();
		if(rbStudentMale.isSelected())
			gender = "Male";
		if(rbStudentFemale.isSelected())
			gender = "Female";
		System.out.println(prn+name+address+phone+department+mail);

		String sql = "INSERT INTO STUDENT VALUES ("+prn+",'"+name+"','"+address+"','"+phone+"','"+mail+"','"+gender+"','"+department+"');";
		System.out.println(sql);
		
		//Write here the code to enter into database
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaForm","root","vu123");
			Statement st = myconn.createStatement();
			st.executeUpdate(sql);
			myconn.close();

			Object[] a = {prn,name,address,phone,mail,gender,department};
			DefaultTableModel MyTable = (DefaultTableModel) table.getModel();
			MyTable.addRow(a);
		}
		catch(SQLIntegrityConstraintViolationException e1)
		{
			JOptionPane.showMessageDialog(f,"PRN Already Exists...");
		}
		catch(Exception abc)
		{
			System.out.println("Error:In Exception");
			abc.printStackTrace();
		}

	}


    public static void main(String[] args)
	{
			MyApplication2 object = new MyApplication2();
	}
}