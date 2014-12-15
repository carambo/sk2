package parking.house.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import parking.house.model.Car;
import parking.house.model.DrivingLicenseType;
import parking.house.model.Lorry;

public class ParkingHouseGUI {

	private Text label1; // for Lorry
	private Text label2; // for Car

	public ParkingHouseGUI() {
	} // prazdny konstruktor

	public void createGUI() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setMinimumSize(800, 200);

		// label1

		label1 = new Text(shell, SWT.DEFAULT); // label mozem zmenit napr na
												// text -
												// https://www.eclipse.org/swt/widgets/
		label1.setText("Lorry");
		label1.setSize(400, 30);
		label1.pack();

		Button button1 = new Button(shell, SWT.DEFAULT);
		button1.setText("Open Lorries");
		button1.setLocation(0, 30);
		button1.setSize(100, 50);
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

		// end of label1

		// label 2

		label2 = new Text(shell, SWT.DEFAULT); // I forgot to initialized label2
												// first time
		label2.setText("Car");
		label2.setSize(400, 30);
		label2.pack();

		Button button2 = new Button(shell, SWT.DEFAULT);
		button2.setText("Open Cars");
		button2.setLocation(0, 60);
		button2.setSize(100, 50);
		button2.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				Car car2 = new Car(DrivingLicenseType.B, 4, "BA255AA", "BMW", 3);
				label2.setText(car2.toString());
				label2.pack();
				
				// TODO Auto-generated method stub
				
			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			} 

			
		});

		// end of label2

		button1.pack();

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
