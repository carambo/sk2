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

import parking.house.model.Bus;
import parking.house.model.Car;
import parking.house.model.DrivingLicenseType;
import parking.house.model.Lorry;
import parking.house.model.Motorcycle;

public class AddVehicleDialog extends Dialog {
	
	// objects declaration
	Bus bus1 = new Bus(DrivingLicenseType.D, 4, "BA421IO", "Karosa", 70);
	Lorry lorry1 = new Lorry(DrivingLicenseType.C, 6, "TN214OO", "Iveco", 800);
	Car car1 = new Car(DrivingLicenseType.B, 4, "MY882AA", "BMW", 5);
	Motorcycle motorcycle1 = new Motorcycle(DrivingLicenseType.A, 2, "TT587MM",
			"Honda", 150);

	public AddVehicleDialog(Shell parent) {
		super(parent);
	}

	public void open() {
		Shell shell = new Shell(getParent());
		shell.setText("Add vehicle");

		draw(shell);
		setCombo(shell);

		shell.pack();
		shell.open();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void setCombo(final Shell shell) {
		final Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[] { "Bus", "Lorry", "Car", "Motorcycle" });
		Rectangle clientArea = shell.getClientArea();
		combo.setBounds(clientArea.x, clientArea.y, 400, 400);
	}

	private void draw(final Shell shell) {
		Button ok = new Button(shell, SWT.PUSH);
		ok.setText("ok");
		ok.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if (combo.getText().equals("Bus")) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, "ID");
					item.setText(1, "" + bus1.getDlt());
					item.setText(2, "" + bus1.getNumberOfWheels());
					item.setText(3, "" + bus1.getLicensePlate());
					item.setText(4, "" + bus1.getType());
					item.setText(5, "" + bus1.busSeats);
					labelvehicInTab.setText("Vehicles in tab: " + ++vehicInTab);
				} else if (combo.getText().equals("Lorry")) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, "ID");
					item.setText(1, "" + lorry1.getDlt());
					item.setText(2, "" + lorry1.getNumberOfWheels());
					item.setText(3, "" + lorry1.getLicensePlate());
					item.setText(4, "" + lorry1.getType());
					item.setText(5, "" + lorry1.maxLoad);
					labelvehicInTab.setText("Vehicles in tab:" + ++vehicInTab);
				} else if (combo.getText().equals("Car")) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, "ID");
					item.setText(1, "" + car1.getDlt());
					item.setText(2, "" + car1.getNumberOfWheels());
					item.setText(3, "" + car1.getLicensePlate());
					item.setText(4, "" + car1.getType());
					item.setText(5, "" + car1.passengers);
					labelvehicInTab.setText("Vehicles in tab:" + ++vehicInTab);
				} else if (combo.getText().equals("Motorcycle")) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, "ID");
					item.setText(1, "" + motorcycle1.getDlt());
					item.setText(2, "" + motorcycle1.getNumberOfWheels());
					item.setText(3, "" + motorcycle1.getLicensePlate());
					item.setText(4, "" + motorcycle1.getType());
					item.setText(5, "" + motorcycle1.horsepower);
					labelvehicInTab.setText("Vehicles in tab:" + ++vehicInTab);
				} else {
					// empty
				}

				shell.dispose();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		ok.pack();
	}
}
