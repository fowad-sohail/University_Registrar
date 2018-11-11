import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class RegistrarGUI extends JFrame {

	private Dimension dim;
	private int xLoc;
	private int yLoc;
	private JPanel panel;
	private int numSections = 0; // will change according to how many sections there are
	private String bottomText = "Matching Sections";
	private String registered = "";

	public RegistrarGUI(ArrayList<Section> sections, Student student) {
		xLoc = 400;
		yLoc = 100;
		dim = new Dimension(1200, 120);

		panel = makeBackground();

		constructGUI(sections);
	}

	private JPanel makeBackground() {
		panel = new JPanel();
		BorderLayout border = new BorderLayout();
		panel.setLayout(border);
		panel.setSize(dim);
		panel.setBackground(Color.white); // maybe change this later?
		add(panel);

		return panel;
	}

	public JComboBox makeDropDown() {
		JComboBox departmentSelection = new JComboBox(Department.values());

		departmentSelection.insertItemAt("", 0);
		departmentSelection.setSelectedIndex(0);

		departmentSelection.setSize(new Dimension(200, 100));
		return departmentSelection;
	}

	public void constructGUI(ArrayList<Section> sections) {
		setTitle("Banner Self Service for Sohail");

		// setMinimumSize(dim);
		setPreferredSize(dim);
		setLocation(xLoc, yLoc);

		add(panel);

		/*
		 * CENTER BORDERLAYOUT SECTION Use a GridLayout for it 5 columns x (num of
		 * sectiosn found)
		 */
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);

		GridLayout g = new GridLayout();
		centerPanel.setLayout(g);

   //		GridBagConstraints gbc = new GridBagConstraints();
//		gbc.gridx = 1;
   	//	gbc.gridy = 5;
        //gbc.fill = GridBagConstraints.BOTH;
		
		panel.add(centerPanel, BorderLayout.CENTER);

		/*
		 * NORTH BORDERLAYOUT SECTION JPanel add a JLabel and a JComboBox
		 */
		JPanel northSection = new JPanel();
		JLabel deptLabel = new JLabel("Select a department");
		northSection.add(deptLabel);
		JComboBox dropDown = makeDropDown();
		
		
		JLabel numSecText = new JLabel();	//this is used in South region but needs to be instantiated here
		

		// Anonymous inner class for dropDown actionListener
		dropDown.addActionListener(new ActionListener() {
			// int x = 0;
			public void actionPerformed(ActionEvent arg0) {
				centerPanel.removeAll();
				setSize(dim);
				numSections = 0;
				bottomText = "Matching Sections";
				
				numSecText.setText(bottomText);
				
				Department sel = null;
				try {
					//gbc.weighty = 10;
					centerPanel.add(new JLabel("CRN"));
					centerPanel.add(new JLabel("Course Number"));
					centerPanel.add(new JLabel("Title"));
					centerPanel.add(new JLabel("Instructor"));
					centerPanel.add(new JLabel("Schedule"));
					sel = (Department) dropDown.getSelectedItem();
					g.setRows(1);
					//gbc.gridx = 1;
				for (Section s : sections) {

					Department d = s.getCourse().getDepartment();
					if (sel.equals(d)) {
						numSections = numSections + 1;
						// display the sections for the given department
						int height = (int) g.preferredLayoutSize(panel).getHeight();
					    g.setRows(numSections+1);
						//gbc.gridx = numSections+1;
						/*
						 * setting the VGap for Departments with few sections was giving me lots of issues
						 * Departments with lots of Sections were scaling a bit better
						 * I had other issues to solve in the code
						 */
						g.setVgap(-5);
						centerPanel.setLayout(g);
						if(sel.equals(Department.Economics) || sel.equals(Department.Psychology) || 
								sel.equals(Department.Physics) || sel.equals(Department.Music)) {
							height = 300;
						}
						else if(sel.equals(Department.Computer_Science))
							{
							g.setVgap(-11);
							height = 1000;
							}
						setPreferredSize((new Dimension(1200, height)));
						JPanel panButton = new JPanel();
						panButton.setLayout(new FlowLayout(FlowLayout.LEFT));
						panButton.setPreferredSize(panButton.getPreferredSize());
						panButton.setBackground(Color.WHITE);
						JButton reg = new JButton(String.valueOf(s.getCRN()));
						panButton.add(reg);
//						panButton.setAlignmentX(LEFT_ALIGNMENT);
						reg.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(s instanceof HybridSection) {
									if(((HybridSection) s).validateChoice())
										registered = registered + s.getCRN() + " " + s.getCourse().getTitle() + ", ";
								}
								else if(s instanceof OnlineSection) {
									if(((OnlineSection) s).validateChoice())
										registered = registered + s.getCRN() + " " + s.getCourse().getTitle() + ", ";
								}
								else {
									registered = registered + s.getCRN() + " " + s.getCourse().getTitle() + ", ";
								}
								numSecText.setText(registered);
							}
						});
						
						centerPanel.add(panButton);
						centerPanel.add(new JLabel(s.getCourse().getCourseNumber()));
						centerPanel.add(new JLabel(s.getCourse().getTitle()));
						centerPanel.add(new JLabel(s.getInstructor().getLastName()));
						centerPanel.add(new JLabel(s.getSchedule()));
						bottomText = numSections + " sections of " + sel + " found.";
						numSecText.setText(bottomText);
						
						setVisible(true);

						pack();
					

						// }

					}
				}
			}
			catch(Exception e) {
				
				centerPanel.removeAll();
				setVisible(true);
			}
			}
		});
		northSection.add(dropDown);
		panel.add(northSection, BorderLayout.NORTH);

		/*
		 * SOUTH BORDERLAYOUT SECTION "number of (Department) found"
		 */
		JPanel southPanel = new JPanel();
		
		numSecText.setText(bottomText);
		southPanel.setLayout(new FlowLayout());
		southPanel.add(numSecText);
		panel.add(southPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
