import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/*import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;*/



class UsingDatabase 
{
	static String department[] = {"Aerospace","Computer","Electrical","Electronics","Civil"};
	
	static JFrame f = new JFrame();
	static JTextField tfStudentPRN,tfStudentName,tfStudentAddress,tfStudentPhone,tfStudentMail;
	static JTextField tfParentPRN,tfParentName,tfParentAddress,tfParentPhone,tfParentMail,tfParentOccupation;		
	static JTextField tfStaffID,tfStaffName,tfStaffAddress,tfStaffPhone,tfStaffMail,tfStaffJoinYear;
	static JButton btStudentSubmit,btStudentDelete;
	static JButton btParentSubmit,btParentDelete;
	static JButton btStaffSubmit,btStaffDelete;
	static JLabel lbPRN,lbName,lbAddress,lbPhone,lbMail,lbGender,lbDepartment;
	static JLabel lbParentPRN,lbParentName,lbParentAddress,lbParentPhone,lbParentMail,lbParentOccupation;
	static JLabel lbStaffID,lbStaffName,lbStaffAddress,lbStaffPhone,lbStaffMail,lbStaffJoinYear;
	static JRadioButton rtbStudentMale,rbtStudentFemale;
	static ButtonGroup groupGender;
	static JComboBox cbStudentDepartment = new JComboBox(department);
	static JComboBox cbParentPRN = new JComboBox();
	static DefaultTableModel m = new DefaultTableModel();
	static DefaultTableModel m1 = new DefaultTableModel();
	static DefaultTableModel m2 = new DefaultTableModel();
	static DefaultTableModel m3 = new DefaultTableModel();

	static JTable StudentTable = new JTable(m);
	static JTable ParentTable = new JTable(m1);
	static JTable StaffTable = new JTable(m2);
	static JTable PendingTable = new JTable(m3);
	//static JTable StudentTable;
	static JScrollPane sp = new JScrollPane(StudentTable);
	static JScrollPane sp1 = new JScrollPane(ParentTable);
	static JScrollPane sp2 = new JScrollPane(StaffTable);
	static JScrollPane sp3 = new JScrollPane(PendingTable);
	//static JScrollPane sp;



	@SuppressWarnings("unchecked")
	private static void init()
	{
		//Radio Button
		rtbStudentMale = new JRadioButton();
		rbtStudentFemale = new JRadioButton();
		rtbStudentMale.setText("MALE");
		rbtStudentFemale.setText("FEMALE");
		groupGender = new ButtonGroup();
		groupGender.add(rtbStudentMale);
		groupGender.add(rbtStudentFemale);

		 //JFrame f = new JFrame();
		f.setLayout(new FlowLayout());

		//String[] column = {"PRN","Name","Address","Phone","Mail","Gender","Department"};
		//Object[][] data = {};
		
		//StudentTable.setBounds(100,100,100,200);
		//Student Table
		m.addColumn("PRN");
		m.addColumn("Name");
		m.addColumn("Address");
		m.addColumn("Phone");
		m.addColumn("Mail");
		m.addColumn("Gender");
		m.addColumn("Department");

		m1.addColumn("PRN");
		m1.addColumn("Name");
		m1.addColumn("Address");
		m1.addColumn("Phone");
		m1.addColumn("Mail");
		m1.addColumn("Occupation");

		m2.addColumn("Staff ID");
		m2.addColumn("Name");
		m2.addColumn("Address");
		m2.addColumn("Phone");
		m2.addColumn("Mail");
		m2.addColumn("Join Year");	

		//Pending Table
		m3.addColumn("PRN");
		m3.addColumn("Name");
		m3.addColumn("Address");
		m3.addColumn("Phone");
		m3.addColumn("Mail");
		m3.addColumn("Gender");
		m3.addColumn("Department");
				
		
		f.setTitle("Student Management");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		JTabbedPane tabbedpane = new JTabbedPane();

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();

		tabbedpane.addTab("Student", p1);
		tabbedpane.addTab("Parent", p2);
		tabbedpane.addTab("Faculty", p3);

		tabbedpane.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent ce){
				int index = tabbedpane.getSelectedIndex();
				System.out.print("index = "+index);
				if(index==0)
				{
					sp.setVisible(true);
					sp1.setVisible(false);
					sp2.setVisible(false);
					sp3.setVisible(false);
				}
				if(index==1)
				{
					sp.setVisible(false);
					//sp1.setVisible(true);
					sp2.setVisible(false);
					sp3.setVisible(true);
					sp1.setVisible(true);
				}
				if(index==2)
				{
					sp.setVisible(false);
					sp1.setVisible(false);
					sp2.setVisible(true);
					sp3.setVisible(false);
				}
			}
		});

		//For Student Tab
		p1.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5,5,5,5);

		gbc.gridx = 0;
		gbc.gridy = 0;
		lbPRN = new JLabel("PRN");
		p1.add(lbPRN, gbc);
		gbc.gridx++;
		tfStudentPRN = new JTextField(20);
		p1.add(tfStudentPRN, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbName = new JLabel("Name");
		p1.add(lbName, gbc);
		gbc.gridx++;
		tfStudentName = new JTextField(20);
		p1.add(tfStudentName, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbAddress = new JLabel("Address");
		p1.add(lbAddress, gbc);
		gbc.gridx++;
		tfStudentAddress = new JTextField(20);
		p1.add(tfStudentAddress, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbPhone = new JLabel("Phone");
		p1.add(lbPhone, gbc);
		gbc.gridx++;
		tfStudentPhone = new JTextField(20);
		p1.add(tfStudentPhone, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbMail = new JLabel("Mail");
		p1.add(lbMail, gbc);
		gbc.gridx++;
		tfStudentMail = new JTextField(20);
		p1.add(tfStudentMail, gbc);

		gbc.gridx=0;
		gbc.gridy++;
		lbGender = new JLabel("Gender");
		p1.add(lbGender,gbc);
		gbc.gridx++;
		p1.add(rtbStudentMale,gbc);
		gbc.gridx++;
		p1.add(rbtStudentFemale,gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbDepartment = new JLabel("Department");
		p1.add(lbDepartment, gbc);
		gbc.gridx++;
		p1.add(cbStudentDepartment, gbc);


		gbc.gridx = 0;
		gbc.gridy++;
		btStudentSubmit = new JButton("Submit");
		p1.add(btStudentSubmit, gbc);
		gbc.gridx++;
		btStudentDelete = new JButton("DELETE");
		p1.add(btStudentDelete, gbc);
		btStudentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddDataToDatabase(e);
			}
		});
		btStudentDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeleteRecord(e);
			}
		});

		//For Parent Tab
		p2.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		lbParentPRN = new JLabel("PRN");
		p2.add(lbParentPRN, gbc);
		gbc.gridx++;
		tfParentPRN = new JTextField(20);
		tfParentPRN.setEditable(false);
		p2.add(tfParentPRN, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbParentName = new JLabel("Name");
		p2.add(lbParentName, gbc);
		gbc.gridx++;
		tfParentName = new JTextField(20);
		p2.add(tfParentName, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbParentAddress = new JLabel("Address");
		p2.add(lbParentAddress, gbc);
		gbc.gridx++;
		tfParentAddress = new JTextField(20);
		p2.add(tfParentAddress, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbParentPhone = new JLabel("Phone");
		p2.add(lbParentPhone, gbc);
		gbc.gridx++;
		tfParentPhone = new JTextField(20);
		p2.add(tfParentPhone, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbParentMail = new JLabel("Mail");
		p2.add(lbParentMail, gbc);
		gbc.gridx++;
		tfParentMail = new JTextField(20);
		p2.add(tfParentMail, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbParentOccupation = new JLabel("Occupation");
		p2.add(lbParentOccupation, gbc);
		gbc.gridx++;
		tfParentOccupation = new JTextField(20);
		p2.add(tfParentOccupation, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		btParentSubmit = new JButton("Submit");
		p2.add(btParentSubmit, gbc);
		gbc.gridx++;
		btParentDelete = new JButton("DELETE");
		p2.add(btParentDelete, gbc);

		btParentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddToParentDatabase(e);
			}
		});
		btParentDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					DeleteParentRecord(e);
			}
		});


		//For Faculty Tab
		p3.setLayout(new GridBagLayout());

		gbc.gridx = 0;
		gbc.gridy = 0;
		lbStaffID = new JLabel("Staff ID");
		p3.add(lbStaffID, gbc);
		gbc.gridx++;
		tfStaffID = new JTextField(20);
		p3.add(tfStaffID, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbStaffName = new JLabel("Name");
		p3.add(lbStaffName, gbc);
		gbc.gridx++;
		tfStaffName = new JTextField(20);
		p3.add(tfStaffName, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbStaffAddress = new JLabel("Address");
		p3.add(lbStaffAddress, gbc);
		gbc.gridx++;
		tfStaffAddress = new JTextField(20);
		p3.add(tfStaffAddress, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbStaffPhone = new JLabel("Phone");
		p3.add(lbStaffPhone, gbc);
		gbc.gridx++;
		tfStaffPhone = new JTextField(20);
		p3.add(tfStaffPhone, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbStaffMail = new JLabel("E-Mail");
		p3.add(lbStaffMail, gbc);
		gbc.gridx++;
		tfStaffMail = new JTextField(20);
		p3.add(tfStaffMail, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		lbStaffJoinYear = new JLabel("Join Year");
		p3.add(lbStaffJoinYear, gbc);
		gbc.gridx++;
		tfStaffJoinYear = new JTextField(20);
		p3.add(tfStaffJoinYear, gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		btStaffSubmit = new JButton("Submit");
		p3.add(btStaffSubmit, gbc);
		gbc.gridx++;
		btStaffDelete = new JButton("DELETE");
		p3.add(btStaffDelete, gbc);

		btStaffSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddToStaffDatabase(e);
			}
		});
		btStaffDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					DeleteStaffRecord(e);
					tfStaffID.setEditable(true);
			}
		});


		//Add mouse listener to table
		StudentTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				StudentTableMouseclicked(evt);
			}
		});

		StaffTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				StaffTableMouseclicked(evt);
			}
		});

		ParentTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				ParentTableMouseclicked(evt);
			}
		});

		PendingTable.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				PendingTableMouseclicked(evt);
			}
		});


		f.getContentPane().add(tabbedpane, BorderLayout.CENTER);
		f.add(sp);

		f.add(sp3);
		sp3.setVisible(false);

		f.add(sp1);
		sp1.setVisible(false);

		f.add(sp2);
		sp2.setVisible(false);

		f.setSize(800,800);
		f.setVisible(true);

		tfStudentPRN.requestFocusInWindow();

		/*tabbedpane.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent ce){
				int index = tabbedpane.getSelectedIndex();
				System.out.print("index = "+index);
				//table = new JTable(m);
				//sp = new JScrollPane(table);
				if(index==0)
				{
					m.addColumn("PRN");
					m.addColumn("Name");
					m.addColumn("Address");
					m.addColumn("Phone");
					m.addColumn("Mail");
					m.addColumn("Gender");
					m.addColumn("Department");

					//f.add(sp);
				}
				if(index==1)
				{
					m.addColumn("Parent");
				}
				if(index==2)
				{
					m.addColumn("Staff");
				}
				StudentTable = new JTable(m);
				sp = new JScrollPane(Studentable);
				f.add(sp);
			}
		});*/
	}

	public UsingDatabase()
	{
		init();
		tfStudentPRN.setCaretPosition(0);
		String sql = "SELECT * FROM STUDENT";
		String sql1 = "SELECT * FROM PARENT";
		String sql2 = "SELECT * FROM STAFF";
		String sql3 = "SELECT * FROM PENDING";

		String prn,name,address,phone,mail,gender,department,occupation;
		String staffid,join_year;
		Object[] record = new Object[7];
		DefaultTableModel t = (DefaultTableModel) StudentTable.getModel();
		DefaultTableModel t1 = (DefaultTableModel) PendingTable.getModel();

		//Fill student table
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement stmt = myconn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next())
			{
				prn = rs.getString("PRN");
				cbParentPRN.addItem(prn);
				name = rs.getString("NAME");
				address = rs.getString("ADDRESS");
				phone = rs.getString("PHONE");
				mail = rs.getString("MAIL");
				gender = rs.getString("GENDER");
				department = rs.getString("DEPARTMENT");
				//record[]{prn,name,address,phone,mail,gender,department};
				t.addRow(new Object[]{prn,name,address,phone,mail,gender,department});
				//t1.addRow(new Object[]{prn,name,address,phone,mail,gender,department});
			}

			rs = stmt.executeQuery(sql1);
			t = (DefaultTableModel) ParentTable.getModel();
			while(rs.next())
			{
				prn = rs.getString("PRN");
				name = rs.getString("Name");
				address = rs.getString("Address");
				phone = rs.getString("Phone");
				mail = rs.getString("mail");
				occupation = rs.getString("occupation");

				t.addRow(new Object[]{prn,name,address,phone,mail,occupation});
			}

			rs = stmt.executeQuery(sql2);
			t = (DefaultTableModel) StaffTable.getModel();
			while(rs.next())
			{
				staffid = rs.getString("StaffID");
				name = rs.getString("Name");
				address = rs.getString("Address");
				phone = rs.getString("Phone");
				mail = rs.getString("mail");
				join_year = rs.getString("join_year");

				t.addRow(new Object[]{staffid,name,address,phone,mail,join_year});
			}

		
			rs = stmt.executeQuery(sql3);
			t = (DefaultTableModel) PendingTable.getModel();
			while(rs.next())
			{
				prn = rs.getString("PRN");
				cbParentPRN.addItem(prn);
				name = rs.getString("NAME");
				address = rs.getString("ADDRESS");
				phone = rs.getString("PHONE");
				mail = rs.getString("MAIL");
				gender = rs.getString("GENDER");
				department = rs.getString("DEPARTMENT");
				//record[]{prn,name,address,phone,mail,gender,department};
				t.addRow(new Object[]{prn,name,address,phone,mail,gender,department});
				//t1.addRow(new Object[]{prn,name,address,phone,mail,gender,department});
			}


			myconn.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void StudentTableMouseclicked(MouseEvent evt)
	{
		tfStudentPRN.setEditable(false);
		DefaultTableModel t = (DefaultTableModel)StudentTable.getModel();
		JTable source = (JTable)evt.getSource();
		int row = source.rowAtPoint(evt.getPoint());
		String gender="Female";

		//Fill the textfield with selected row
		tfStudentPRN.setText(t.getValueAt(row,0).toString());

		tfParentPRN.setText(t.getValueAt(row,0).toString());

		tfStudentName.setText(t.getValueAt(row,1).toString());
		tfStudentAddress.setText(t.getValueAt(row,2).toString());
		tfStudentPhone.setText(t.getValueAt(row,3).toString());
		tfStudentMail.setText(t.getValueAt(row,4).toString());
		gender = t.getValueAt(row,5).toString();
		if(gender.equals("Male"))
		{
			rtbStudentMale.setSelected(true);
			rbtStudentFemale.setSelected(false);
		}
		else
		{
			rbtStudentFemale.setSelected(true);
			rtbStudentMale.setSelected(false);
		}
		cbStudentDepartment.setSelectedItem(t.getValueAt(row,6));
		/*System.out.println(t.getValueAt(row,0).toString());
		System.out.println("Slected row = "+row);*/
		btStudentSubmit.setText("Update");
		btStudentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateRecord(e);
			}
		});
	
	}

	static void PendingTableMouseclicked(MouseEvent evt)
	{
		DefaultTableModel t = (DefaultTableModel) PendingTable.getModel();
		JTable source = (JTable)evt.getSource();
		int row = source.rowAtPoint(evt.getPoint());

		tfParentPRN.setText(t.getValueAt(row, 0).toString());

	}

	static void ParentTableMouseclicked(MouseEvent evt)
	{
		cbParentPRN.setEditable(false);

		DefaultTableModel t = (DefaultTableModel) ParentTable.getModel();
		JTable source = (JTable) evt.getSource();
		int row = source.rowAtPoint(evt.getPoint());

		//Fill the TextField with the selected row
		tfParentPRN.setText(t.getValueAt(row, 0).toString());
		tfParentName.setText(t.getValueAt(row, 1).toString());
		tfParentAddress.setText(t.getValueAt(row, 2).toString());
		tfParentPhone.setText(t.getValueAt(row, 3).toString());
		tfParentMail.setText(t.getValueAt(row, 4).toString());
		tfParentOccupation.setText(t.getValueAt(row, 5).toString());

		//Attach different ActionListener
		btParentSubmit.setText("Upadte");
		btParentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateParentRecord(e);
			}
		});
	} 

	static void StaffTableMouseclicked(MouseEvent evt)
	{
		tfStaffID.setEditable(false);

		DefaultTableModel t = (DefaultTableModel) StaffTable.getModel();
		JTable source = (JTable) evt.getSource();
		int row = source.rowAtPoint(evt.getPoint());

		//Fill the TextField with the selected row
		tfStaffID.setText(t.getValueAt(row, 0).toString());
		tfStaffName.setText(t.getValueAt(row, 1).toString());
		tfStaffAddress.setText(t.getValueAt(row, 2).toString());
		tfStaffPhone.setText(t.getValueAt(row, 3).toString());
		tfStaffMail.setText(t.getValueAt(row, 4).toString());
		tfStaffJoinYear.setText(t.getValueAt(row, 5).toString());

		//Attach different ActionListener
		btStaffSubmit.setText("Upadte");
		btStaffSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateStaffRecord(e);
			}
		});
	}

	static void DeleteRecord(ActionEvent e)
	{
		DefaultTableModel t = (DefaultTableModel)StudentTable.getModel();
		int row = StudentTable.getSelectedRow();
		int record[] = StudentTable.getSelectedRows();

		if(row >= 0)
		{	
			//String prn = record[0];
			t.removeRow(row);

			//Delete from database
			DeleteFromDatabase();
			//Clear the above fields
			//clear the above fields
			tfStudentPRN.setText("");
			tfStudentName.setText("");
			tfStudentAddress.setText("");
			tfStudentPhone.setText("");
			tfStudentMail.setText("");
			cbStudentDepartment.setSelectedItem("Aerospace");

			


			JOptionPane.showMessageDialog(f, "Record Successfully Deleted");
			tfStudentPRN.requestFocusInWindow();
		}
		else
		{
			JOptionPane.showMessageDialog(f, "Please Select row to delete from Table");
		}
		tfStudentPRN.setEditable(true);
		btStudentSubmit.setText("Submit");
		btStudentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddDataToDatabase(e);
			}
		});
	}

	static void DeleteParentRecord(ActionEvent e)
	{
		DefaultTableModel t = (DefaultTableModel)ParentTable.getModel();
		int row = ParentTable.getSelectedRow();
		int record[] = ParentTable.getSelectedRows();

		if(row >= 0)
		{	
			//String prn = record[0];
			t.removeRow(row);

			//Delete from database
			DeleteFromParentTable();
			//Clear the above fields
			//clear the above fields
			tfParentPRN.setText("");
			tfParentName.setText("");
			tfParentAddress.setText("");
			tfParentPhone.setText("");
			tfParentMail.setText("");
			tfParentOccupation.setText("");
			


			JOptionPane.showMessageDialog(f, "Record Successfully Deleted");
		}
		else
		{
			JOptionPane.showMessageDialog(f, "Please Select row to delete from Table");
		}
		//tfStudentPRN.setEditable(true);
		btParentSubmit.setText("Submit");
		btParentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddToParentDatabase(e);
			}
		});
	}

	static void DeleteStaffRecord(ActionEvent e)
	{
		DefaultTableModel t = (DefaultTableModel)StaffTable.getModel();
		int row = StaffTable.getSelectedRow();

		if(row >= 0)
		{
			t.removeRow(row);

			//Delete from database
			DeleteFromSatffTable();

			//Clear the fields
			tfStaffID.setText("");
			tfStaffName.setText("");
			tfStaffAddress.setText("");
			tfStaffPhone.setText("");
			tfStaffMail.setText("");
			tfStaffJoinYear.setText("");

			JOptionPane.showMessageDialog(f, "Record Successfully Deleted");
			tfStudentPRN.requestFocusInWindow();
		}
		else
		{
			JOptionPane.showMessageDialog(f, "Please Select row to delete from Table");
		}

		//Attach the default action listener
		btStaffSubmit.setText("Submit");
		btStaffSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddToStaffDatabase(e);
			}
		});
		tfStaffID.setEditable(true);

	}

	static void UpdateRecord(ActionEvent e)
	{
		String prn,name,address,phone,mail,gender="Female",department;
		prn = tfStudentPRN.getText();
		name = tfStudentName.getText();
		address = tfStudentAddress.getText();
		phone = tfStudentPhone.getText();
		mail = tfStudentMail.getText();
		if(rtbStudentMale.isSelected())
			gender = "Male";
		if(rbtStudentFemale.isSelected())
			gender = "Female";
		department = cbStudentDepartment.getSelectedItem().toString();

		//String sql = "INSERT INTO STUDENT VALUES ("+prn+",'"+name+"','"+address+"','"+phone+"','"+mail+"','"+gender+"','"+department+"');";
		String sql1 = "UPDATE STUDENT SET NAME = '"+name+"' WHERE PRN = "+prn+";";
		String sql2 = "UPDATE STUDENT SET ADDRESS = '"+address+"' WHERE PRN = "+prn+";";
		String sql3 = "UPDATE STUDENT SET PHONE = '"+phone+"' WHERE PRN = "+prn+";";
		String sql4 = "UPDATE STUDENT SET MAIL = '"+mail+"' WHERE PRN = "+prn+";";
		String sql5 = "UPDATE STUDENT SET GENDER = '"+gender+"' WHERE PRN = "+prn+";";
		String sql6 = "UPDATE STUDENT SET DEPARTMENT = '"+department+"' WHERE PRN = "+prn+";";
		System.out.println(sql1);
		
		//Write here the code to enter into database
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
		Statement st = myconn.createStatement();
		st.executeUpdate(sql1);
		st.executeUpdate(sql2);
		st.executeUpdate(sql3);
		st.executeUpdate(sql4);
		st.executeUpdate(sql5);
		st.executeUpdate(sql6);
		myconn.close();

		//Add record to table
		DefaultTableModel t = (DefaultTableModel) StudentTable.getModel();
		Object[] a = {prn,name,address,phone,mail,gender,department};
		//t.addRow(a);
		int row = StudentTable.getSelectedRow();
		t.setValueAt(name,row,1);
		t.setValueAt(address,row,2);
		t.setValueAt(phone,row,3);
		t.setValueAt(mail,row,4);
		t.setValueAt(gender,row,5);
		t.setValueAt(department,row,6);

		}
		catch(Exception abc)
		{
			System.out.println("Error:In Exception");
			abc.printStackTrace();
		}

		//clear the above fields
		tfStudentPRN.setText("");
		tfStudentName.setText("");
		tfStudentAddress.setText("");
		tfStudentPhone.setText("");
		tfStudentMail.setText("");
		cbStudentDepartment.setSelectedItem("Aerospace");


		//Attach back the action listener of submit
		btStudentSubmit.setText("Submit");
		btStudentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddDataToDatabase(e);
			}
		});
		tfStudentPRN.setEditable(true);
		tfStudentPRN.requestFocusInWindow();
	}

	static void UpdateStaffRecord(ActionEvent e)
	{
		String staffId,name,address,phone,mail,join_year;

		staffId = tfStaffID.getText();
		name = tfStaffName.getText();
		address = tfStaffAddress.getText();
		phone = tfStaffPhone.getText();
		mail = tfStaffMail.getText();
		join_year = tfStaffJoinYear.getText();

		String sql1 = "UPDATE STAFF SET NAME = '"+name+"' WHERE StaffID = "+staffId+";";
		String sql2 = "UPDATE STAFF SET ADDRESS = '"+address+"' WHERE StaffID = "+staffId+";";
		String sql3 = "UPDATE STAFF SET PHONE = '"+phone+"' WHERE StaffID = "+staffId+";";
		String sql4 = "UPDATE STAFF SET MAIL = '"+mail+"' WHERE StaffID = "+staffId+";";
		String sql5 = "UPDATE STAFF SET join_year = '"+join_year+"' WHERE StaffID = "+staffId+";";

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement st = myconn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.executeUpdate(sql4);
			st.executeUpdate(sql5);
			myconn.close();

			//Add record to table
			DefaultTableModel t = (DefaultTableModel) StaffTable.getModel();
			Object[] a = {staffId,name,address,phone,mail,join_year};
			//t.addRow(a);
			int row = StaffTable.getSelectedRow();
			t.setValueAt(name,row,1);
			t.setValueAt(address,row,2);
			t.setValueAt(phone,row,3);
			t.setValueAt(mail,row,4);
			t.setValueAt(join_year,row,5);

		}
		catch(Exception abc)
		{
			abc.printStackTrace();
		}

		//Clear the above textfields
		tfStaffID.setText("");
		tfStaffName.setText("");
		tfStaffAddress.setText("");
		tfStaffPhone.setText("");
		tfStaffMail.setText("");
		tfStaffJoinYear.setText("");
		//Attach back the action listener of submit
		btStaffSubmit.setText("Submit");
		btStaffSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddToStaffDatabase(e);
			}
		});
		tfStaffID.setEditable(true);
		tfStaffID.requestFocusInWindow();
	}

	static void UpdateParentRecord(ActionEvent e)
	{
		String prn,name,address,phone,mail,occupation;

		prn = tfParentPRN.getText();
		name = tfParentName.getText();
		address = tfParentAddress.getText();
		phone = tfParentPhone.getText();
		mail = tfParentMail.getText();
		occupation = tfParentOccupation.getText();

		String sql1 = "UPDATE PARENT SET NAME = '"+name+"' WHERE PRN = "+prn+";";
		String sql2 = "UPDATE PARENT SET ADDRESS = '"+address+"' WHERE PRN = "+prn+";";
		String sql3 = "UPDATE PARENT SET PHONE = '"+phone+"' WHERE PRN = "+prn+";";
		String sql4 = "UPDATE PARENT SET MAIL = '"+mail+"' WHERE PRN = "+prn+";";
		String sql5 = "UPDATE PARENT SET OCCUPATION = '"+occupation+"' WHERE PRN = "+prn+";";

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement st = myconn.createStatement();
			st.executeUpdate(sql1);
			st.executeUpdate(sql2);
			st.executeUpdate(sql3);
			st.executeUpdate(sql4);
			st.executeUpdate(sql5);
			myconn.close();
   
			//Add record to table
			DefaultTableModel t = (DefaultTableModel) ParentTable.getModel();
			Object[] a = {prn,name,address,phone,mail,occupation};
			//t.addRow(a);
			int row = ParentTable.getSelectedRow();
			t.setValueAt(name,row,1);
			t.setValueAt(address,row,2);
			t.setValueAt(phone,row,3);
			t.setValueAt(mail,row,4);
			t.setValueAt(occupation,row,5);

		}
		catch(Exception abc)
		{
			abc.printStackTrace();
		}

		//Clear the above textfields
		//cbParentPRN.setSelectedItem(0);
		tfParentPRN.setText("");
		tfParentName.setText("");
		tfParentAddress.setText("");
		tfParentPhone.setText("");
		tfParentMail.setText("");
		tfParentOccupation.setText("");

		/*//Attach back the action listener of submit
		btParentSubmit.setText("Submit");
		btParentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddToParentDatabase(e);
			}
		});
		cbParentPRN.setEditable(true);*/

		btParentSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddToParentDatabase(e);
			}
		});
		tfParentPRN.requestFocusInWindow();
	}
	
	static  void DeleteFromDatabase()
	{
		String key = tfStudentPRN.getText();
		try
		{
			
			String sql = "DELETE FROM STUDENT WHERE PRN = "+key+";";
			String sql1 = "DELETE FROM PARENT WHERE PRN = "+key+";";
			System.out.print(sql);
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement st = myconn.createStatement();
			st.executeUpdate(sql);
			st.executeUpdate(sql1);
			myconn.close();

			fillParentTable();
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
	}

	static void fillParentTable()
	{
		//ParentTable.setRowCount(0);

		String prn,name,address,phone,mail,occupation;
		String sql = "SELECT * FROM PARENT";

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement stmt = myconn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			DefaultTableModel t = (DefaultTableModel) ParentTable.getModel();
			t.setRowCount(0);
			while(rs.next())
			{
				prn = rs.getString("PRN");
				name = rs.getString("Name");
				address = rs.getString("Address");
				phone = rs.getString("Phone");
				mail = rs.getString("mail");
				occupation = rs.getString("occupation");

				t.addRow(new Object[]{prn,name,address,phone,mail,occupation});
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tfStudentPRN.requestFocusInWindow();

	}

	static void refreshPendingTable()
	{
		String prn,name,address,phone,mail,gender,department;
		String sql = "SELECT * FROM PENDING";

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement stmt = myconn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			DefaultTableModel t = (DefaultTableModel) PendingTable.getModel();
			t.setRowCount(0);
			while(rs.next())
			{
				prn = rs.getString("PRN");
				name = rs.getString("Name");
				address = rs.getString("Address");
				phone = rs.getString("Phone");
				mail = rs.getString("mail");
				gender = rs.getString("gender");
				department = rs.getString("department");

				t.addRow(new Object[]{prn,name,address,phone,mail,gender,department});
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		tfStudentPRN.requestFocusInWindow();
	}

	static void DeleteFromParentTable()
	{
		String key = tfParentPRN.getText();

		try
		{
			String sql =  "DELETE FROM PARENT WHERE PRN = "+key+";";
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement st = myconn.createStatement();
			st.executeUpdate(sql);
			myconn.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void DeleteFromSatffTable()
	{
		String key = tfStaffID.getText();

		try
		{
			String sql =  "DELETE FROM STAFF WHERE StaffID = "+key+";";
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement st = myconn.createStatement();
			st.executeUpdate(sql);
			myconn.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	static void AddDataToDatabase(ActionEvent e)
	{
		String prn,name,address,phone,mail,gender="Female",department;
		prn = tfStudentPRN.getText();
		name = tfStudentName.getText();
		address = tfStudentAddress.getText();
		phone = tfStudentPhone.getText();
		mail = tfStudentMail.getText();
		if(rtbStudentMale.isSelected())
			gender = "Male";
		if(rbtStudentFemale.isSelected())
			gender = "Female";
		department = cbStudentDepartment.getSelectedItem().toString();

		String sql = "INSERT INTO STUDENT VALUES ("+prn+",'"+name+"','"+address+"','"+phone+"','"+mail+"','"+gender+"','"+department+"');";
		String sql1 = "INSERT INTO PENDING VALUES ("+prn+",'"+name+"','"+address+"','"+phone+"','"+mail+"','"+gender+"','"+department+"');";	

		System.out.println(sql);
		
		//Write here the code to enter into database
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
		Statement st = myconn.createStatement();
		st.executeUpdate(sql);
		st.executeUpdate(sql1);
		myconn.close();
		cbParentPRN.addItem(prn);

		//Add record to table
		DefaultTableModel t = (DefaultTableModel) StudentTable.getModel();
		DefaultTableModel t1 = (DefaultTableModel) PendingTable.getModel();
		Object[] a = {prn,name,address,phone,mail,gender,department};
		t.addRow(a);
		t1.addRow(a);

		}
		catch(SQLIntegrityConstraintViolationException e1)
		{
			JOptionPane.showMessageDialog(f, "PRN already Exists");
		}
		catch(Exception abc)
		{
			System.out.println("Error:In Exception");
			abc.printStackTrace();
		}

		//clear the above fields
		tfStudentPRN.setText("");
		tfStudentName.setText("");
		tfStudentAddress.setText("");
		tfStudentPhone.setText("");
		tfStudentMail.setText("");
		cbStudentDepartment.setSelectedItem("Aerospace");

		tfStudentPRN.setEditable(true);

		/*//Add record to table
		DefaultTableModel t = (DefaultTableModel) StudentTable.getModel();
		Object[] a = {prn,name,address,phone,mail,gender,department};
		t.addRow(a);*/
		tfStudentPRN.requestFocusInWindow();

	}

	static void AddToParentDatabase(ActionEvent e)
	{
		String prn,name,address,phone,mail,occupation;

		prn = tfParentPRN.getText();
		name = tfParentName.getText();
		address = tfParentAddress.getText();
		phone = tfParentPhone.getText();
		mail = tfParentMail.getText();
		occupation = tfParentOccupation.getText();

		String sql = "INSERT INTO PARENT VALUES ("+prn+",'"+name+"','"+address+"','"+phone+"','"+mail+"','"+occupation+"');";
		String sql1 = "DELETE FROM PENDING WHERE PRN = "+prn+";";
		System.out.println(sql);

		//if(name==null && name.isEmpty())
			//return;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement stmt = myconn.createStatement();
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);
			myconn.close();

			//Add record to table
			DefaultTableModel t = (DefaultTableModel) ParentTable.getModel();
			Object[] a = {prn,name,address,phone,mail,occupation};
			t.addRow(a);

			//Clear the above textfields
			//cbParentPRN.setSelectedItem(0);
			tfParentPRN.setText("");
			tfParentName.setText("");
			tfParentAddress.setText("");
			tfParentPhone.setText("");
			tfParentMail.setText("");
			tfParentOccupation.setText("");
		}
		catch(SQLIntegrityConstraintViolationException e2)
		{
			//cbParentPRN.setSelectedItem(0);
			JOptionPane.showMessageDialog(f, "PRN already Exists");	
		}
		catch(Exception abc)
		{
			abc.printStackTrace();
		}
		refreshPendingTable();

		/*//Clear the above textfields
		tfStaffID.setText("");
		tfStaffName.setText("");
		tfStaffAddress.setText("");
		tfStaffPhone.setText("");
		tfStaffMail.setText("");
		tfStaffJoinYear.setText("");*/

		//JOptionPane.showMessageDialog(f, "Record successfully added");
	}

	static void AddToStaffDatabase(ActionEvent e)
	{
		String staffId,name,address,phone,mail,join_year;

		staffId = tfStaffID.getText();
		name = tfStaffName.getText();
		address = tfStaffAddress.getText();
		phone = tfStaffPhone.getText();
		mail = tfStaffMail.getText();
		join_year = tfStaffJoinYear.getText();

		String sql = "INSERT INTO STAFF VALUES ("+staffId+",'"+name+"','"+address+"','"+phone+"','"+mail+"','"+join_year+"');";
		System.out.println(sql);

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost/JavaApplication","root","vu123");
			Statement stmt = myconn.createStatement();
			stmt.executeUpdate(sql);
			myconn.close();

			//Add record to table
			DefaultTableModel t = (DefaultTableModel) StaffTable.getModel();
			Object[] a = {staffId,name,address,phone,mail,join_year};
			t.addRow(a);

			//Clear the above textfields
			tfStaffID.setText("");
			tfStaffName.setText("");
			tfStaffAddress.setText("");
			tfStaffPhone.setText("");
			tfStaffMail.setText("");
			tfStaffJoinYear.setText("");
		}
		catch(SQLIntegrityConstraintViolationException e2)
		{
			JOptionPane.showMessageDialog(f, "Staff ID already Exists");	
		}
		catch(Exception abc)
		{
			abc.printStackTrace();
		}

		/*//Clear the above textfields
		tfStaffID.setText("");
		tfStaffName.setText("");
		tfStaffAddress.setText("");
		tfStaffPhone.setText("");
		tfStaffMail.setText("");
		tfStaffJoinYear.setText("");*/

		//JOptionPane.showMessageDialog(f, "Record successfully added");
	}

 	public static void main(String[] args)
	{
		UsingDatabase object = new UsingDatabase();
	}
}