import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class MashtunMain extends RxTxComm {

	private JFrame frame;
	static String tempF;
	static String tempC;
	static JTextField fahrenheit_TextField;
	static JTextField celsius_TextField;
	private JLabel fahrenheit_lbl;
	private JLabel celcisus_lbl;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MashtunMain window = new MashtunMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public MashtunMain() {
		initialize();

	}



	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel temperature_lbl = new JLabel("Current Temperature");
		// °F
		fahrenheit_lbl = new JLabel("Fahrenheit");
		fahrenheit_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		fahrenheit_lbl.setBounds(25, 53, 112, 16);
		frame.getContentPane().add(fahrenheit_lbl);
		fahrenheit_TextField = new JTextField();
		fahrenheit_TextField.setEditable(false);
		fahrenheit_TextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		fahrenheit_TextField.setBounds(25, 71, 112, 28);
		frame.getContentPane().add(fahrenheit_TextField);
		fahrenheit_TextField.setColumns(10);
		temperature_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		temperature_lbl.setBounds(25, 25, 236, 16);
		frame.getContentPane().add(temperature_lbl);

		// °C
		celcisus_lbl = new JLabel("Celsius");
		celcisus_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		celcisus_lbl.setBounds(149, 53, 112, 16);
		frame.getContentPane().add(celcisus_lbl);
		celsius_TextField = new JTextField();
		celsius_TextField.setEditable(false);
		celsius_TextField.setColumns(10);
		celsius_TextField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		celsius_TextField.setBounds(149, 71, 112, 28);
		frame.getContentPane().add(celsius_TextField);

		// Create new RxTxComm object
		RxTxComm serial = new RxTxComm();
		serial.initialize();
	}

	// update the temperatures on event
	ActionListener actListner = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			if ( tempF != null && tempC != null ) {
			fahrenheit_TextField.setText(tempF + "°F");
			celsius_TextField.setText(tempC + "°C");
			}
			else {
				fahrenheit_TextField.setText("Not detected");
				celsius_TextField.setText("Not detected");
			}
		}
	};
	Timer timer = new Timer(2000, actListner); {
		timer.start();
		}

}







