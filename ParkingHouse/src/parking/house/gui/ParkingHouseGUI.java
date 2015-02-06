package parking.house.gui;

import java.io.PushbackInputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import parking.house.model.Bus;
import parking.house.model.Car;
import parking.house.model.DrivingLicenseType;
import parking.house.model.Lorry;
import parking.house.model.Motorcycle;

public class ParkingHouseGUI {

	private Text label1; // for Lorry
	private Text label2; // for Car
	private Text label3; // for Bus
	private Text label4; // for Motorcycle

	public ParkingHouseGUI() {
	} // empty constructor

	public void createGUI() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setMinimumSize(1000, 200);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		shell.setLayout(gridLayout);
		

		

		// label1 - Lorry

		label1 = new Text(shell, SWT.PUSH); // label mozem zmenit napr na
											// text -
											// https://www.eclipse.org/swt/widgets/
		label1.setText("Lorry");
		label1.setSize(400, 30);
		label1.pack();

		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Open Lorries");
		button1.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Lorry car1 = new Lorry(DrivingLicenseType.D, 4, "BA882AB",
						"Scania", 420);
				label1.setText(car1.toString());
				label1.pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// end of label1 - Lorry

		// label2 - Car

		label2 = new Text(shell, SWT.PUSH); // I forgot to initialized label2
											// first time
		label2.setText("Car");
		label2.setSize(400, 30);
		label2.pack();

		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Open Cars");
		button2.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Car car2 = new Car(DrivingLicenseType.B, 4, "BA255AA", "BMW", 3);
				label2.setText(car2.toString());
				label2.pack();

				// TODO Auto-generated method stub

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		// end of label2 - Car

		// label3 - Bus

		label3 = new Text(shell, SWT.PUSH);

		label3.setText("Bus");
		label3.setSize(400, 30);
		label3.pack();

		Button button3 = new Button(shell, SWT.PUSH);
		button3.setText("Open Bus");
		button3.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Bus car3 = new Bus(DrivingLicenseType.D, 4, "BA554NA",
						"Karosa", 70);
				label3.setText(car3.toString());
				label3.pack();

				// TODO Auto-generated method stub

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// end of label3 - Bus

		// label4 - Motorcycle

		label4 = new Text(shell, SWT.PUSH);

		label4.setText("Motorcycle");
		label4.setSize(400, 30);
		label3.pack();

		Button button4 = new Button(shell, SWT.PUSH);
		button4.setText("Open Motorcycle");
		button4.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Motorcycle car4 = new Motorcycle(DrivingLicenseType.A, 2,
						"BA112MN", "Honda", 140);
				label4.setText(car4.toString());
				label4.pack();
				// TODO Auto-generated method stub

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// end of label4 - Motorcycle

		button1.pack();
		button2.pack();
		button3.pack();
		button4.pack();

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
