package vaccineSlotChecker;

import data.Districts;
import data.Iterations;
import data.TimeInterval;
import script.SlotChecker;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class CovidVaccineSlotChecker extends JFrame {
    private JPanel contentPane;
    SlotChecker slotChecker = new SlotChecker();
    Districts distId;
    Iterations iterations;
    TimeInterval timeInt;
    JComboBox<Districts> comboBox = new JComboBox<>();
    JComboBox<TimeInterval> comboBox_1 = new JComboBox<>();
    JComboBox<Iterations> comboBox_1_1 = new JComboBox<>();
    public static JTextArea textArea = new JTextArea();
    public static JLabel lblSlotsAreAvailable = new JLabel();
	public static JLabel lblLoginTo = new JLabel();


    /**
     * Launch the application.œ
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CovidVaccineSlotChecker frame = new CovidVaccineSlotChecker();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CovidVaccineSlotChecker() {
    	initGUI();
    }
    private void initGUI() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBounds(100, 100, 755, 596);
    	contentPane = new JPanel();
    	contentPane.setOpaque(false);
    	contentPane.setVisible(true);
    	contentPane.setBackground(new Color(160, 255, 238));
    	setContentPane(contentPane);
    	contentPane.setLayout(null);
    	
    	        JLabel lblCovidVaccineSlot = new JLabel("Covid Vaccine Slot Checker (18+)");
    	lblCovidVaccineSlot.setFont(new Font("Verdana", Font.BOLD, 25));
    	lblCovidVaccineSlot.setBounds(131, 17, 486, 27);
    	contentPane.add(lblCovidVaccineSlot);
    	
    	        JLabel lblSelectDistricts = new JLabel("Select Districts: ");
    	lblSelectDistricts.setBounds(215, 72, 113, 16);
    	contentPane.add(lblSelectDistricts);
    	
    	
    	        comboBox.setBounds(362, 68, 131, 27);
    	comboBox.setModel(new DefaultComboBoxModel<>(Districts.values()));
    	contentPane.add(comboBox);
    	
    	        JLabel lblRunForEvery = new JLabel("Time Interval* : ");
    	        lblRunForEvery.setToolTipText("");
    	lblRunForEvery.setBounds(25, 121, 113, 16);
    	contentPane.add(lblRunForEvery);
    	
    	        comboBox_1.setBounds(150, 117, 150, 27);
    	comboBox_1.setModel(new DefaultComboBoxModel<>(TimeInterval.values()));
    	contentPane.add(comboBox_1);
    	
    	        comboBox_1_1.setBounds(528, 117, 150, 27);
    	comboBox_1_1.setModel(new DefaultComboBoxModel<>(Iterations.values()));
    	contentPane.add(comboBox_1_1);
    	
    	
    	        JLabel lblTimeInterval = new JLabel("Iterations** : ");
    	lblTimeInterval.setBounds(431, 121, 93, 16);
    	contentPane.add(lblTimeInterval);

    	        JButton btnRun = new JButton("Run");
    	btnRun.setBounds(291, 210, 117, 35);
    	btnRun.setBackground(new Color(51, 255, 0));
    	contentPane.add(btnRun);
    	btnRun.addActionListener(new java.awt.event.ActionListener() {
    	    public void actionPerformed(java.awt.event.ActionEvent evt) {
    	        try {
    	            SwingWorker worker = new SwingWorker() {
    	                @Override
    	                protected Object doInBackground() throws Exception {
    	                    btnRunActionPerformed(evt);
    	                    return null;
    	                }
    	            };
    	           worker.execute();
    	        } catch (Exception e) {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	        }
    	    }
    	});
    	
    	        JButton btnCancel = new JButton("Cancel");
    	btnCancel.setBackground(new java.awt.Color(255, 102, 102));
    	btnCancel.setBounds(500, 210, 117, 35);
    	contentPane.add(btnCancel);
    	btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
				    btnCancel.setEnabled(true);
					btnCancelActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
    	
    	lblSlotsAreAvailable.setForeground(new Color(0, 204, 0));
    	lblSlotsAreAvailable.setFont(new Font("Verdana", Font.BOLD, 18));
    	lblSlotsAreAvailable.setBounds(240, 156, 335, 27);
    	contentPane.add(lblSlotsAreAvailable);
    	

    	textArea.setBounds(6, 255, 743, 313);
        DefaultCaret caret = (DefaultCaret)textArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        textArea.setForeground(new java.awt.Color(51, 102, 255));
        textArea.setLineWrap(true);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
    	//contentPane.add(textArea);
    	
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.setBounds(6, 255, 743, 313);
        scrollPane.setViewportView(textArea);
    	contentPane.add(scrollPane);
    	
    	JLabel lblTheVaccination = new JLabel("* The time interval between each vaccination slot check");
    	lblTheVaccination.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
    	lblTheVaccination.setBounds(6, 222, 386, 16);
    	contentPane.add(lblTheVaccination);
    	
    	JLabel lblTheVaccinationCheck = new JLabel("** The number of times the vaccination slot check will be done");
    	lblTheVaccinationCheck.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
    	lblTheVaccinationCheck.setBounds(6, 239, 312, 16);
    	contentPane.add(lblTheVaccinationCheck);
    	
    	lblLoginTo.setForeground(SystemColor.controlHighlight);
    	lblLoginTo.setBounds(177, 188, 440, 16);
    	contentPane.add(lblLoginTo);
    }

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        distId = (Districts) comboBox.getSelectedItem();
		timeInt = (TimeInterval) comboBox_1.getSelectedItem();
		iterations = (Iterations) comboBox_1_1.getSelectedItem();
		textArea.setText(null);
		textArea.append("***********The Vaccination slot check for "+distId+ " with "+iterations.iterations+ " iterations for every "+timeInt.interval+" millisec*************\n");
        slotChecker.getCoWinVaccinationSlots(distId.districtId, iterations.iterations, timeInt.interval);
    }

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
		System.exit(0);
	}
}
