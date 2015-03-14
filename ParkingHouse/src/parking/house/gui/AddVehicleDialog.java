package parking.house.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;

import parking.house.model.Bus;
import parking.house.model.Car;
import parking.house.model.DrivingLicenseType;
import parking.house.model.Lorry;
import parking.house.model.Motorcycle;
import parking.house.model.Vehicle;

public class AddVehicleDialog extends Dialog {

	private Vehicle vehicle;
	private Shell shell;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public AddVehicleDialog(Shell parent) {
		super(parent, SWT.APPLICATION_MODAL);
	}

	public void open() {
		shell = new Shell(getParent(), getStyle());
		shell.setText("Add vehicle");
		shell.setMinimumSize(500, 200);
		draw(shell);
		shell.pack();
		shell.open();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void draw(final Shell shell) {

		final Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[] { "Bus", "Lorry", "Car", "Motorcycle" });
		combo.setLocation(new Point(20, 20));
		Rectangle clientArea = shell.getClientArea();
		combo.setBounds(clientArea.x, clientArea.y, 400, 400);

		final Text t = new Text(shell, SWT.BORDER | SWT.MULTI);
		t.setText("enter license plate");
		t.setSize(200, 25);
		t.setLocation(new Point(20, 40));
		

		Button ok = new Button(shell, SWT.PUSH);
		ok.setLocation(new Point(20, 60)); // Point from swt.graphics -imported
		ok.setText("ok");
		ok.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Vehicle v = null;
				String s; // mam to, staci si to dostat hentak z gettextu a potom dam premennu normalne ako parameter
				s = t.getText();
				if (combo.getText().equals("Bus")) {
					v = new Bus(1, DrivingLicenseType.D, 20, "Karosa", "Yellow",
							s);
				} else if (combo.getText().equals("Lorry")) {
					v = new Lorry(2, DrivingLicenseType.C, 40, "Iveco", "White",
							s);
				} else if (combo.getText().equals("Car")) {
					v = new Car(3, DrivingLicenseType.B, 50, "Mercedes", "Blue",
							s);
				} else if (combo.getText().equals("Motorcycle")) {
					v = new Motorcycle(4, DrivingLicenseType.A, 60, "Honda", "Red",
							s);
				} else {
					System.out.println("else");
				}
			

				vehicle = v;
			
				
				shell.close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		
		
		ok.pack();
	}
	

		
	}