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
		Rectangle clientArea = shell.getClientArea();
		combo.setBounds(clientArea.x, clientArea.y, 400, 400);

		Button ok = new Button(shell, SWT.PUSH);
		ok.setLocation(new Point(20, 20)); // Point from swt.graphics -imported
		ok.setText("ok");
		ok.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Vehicle v = null;
				if (combo.getText().equals("Bus")) {
					v = new Bus(DrivingLicenseType.D, 4, "BA421IO", "Karosa",
							70);
					// labelvehicInTab.setText("Vehicles in tab: " +
					// ++vehicInTab);
				} else if (combo.getText().equals("Lorry")) {
					v = new Lorry(DrivingLicenseType.C, 6, "BA700DD", "Scania",
							5000);
					// labelvehicInTab.setText("Vehicles in tab:" +
					// ++vehicInTab);
				} else if (combo.getText().equals("Car")) {
					v = new Car(DrivingLicenseType.B, 4, "BO777SS", "skoda", 2);
					// labelvehicInTab.setText("Vehicles in tab:" +
					// ++vehicInTab);
				} else if (combo.getText().equals("Motorcycle")) {
					v = new Motorcycle(DrivingLicenseType.A, 2, "MY000AA",
							"honda", 200);
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