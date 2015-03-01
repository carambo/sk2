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
import parking.house.model.DrivingLicenseType;

public class AddVehicleDialog extends Dialog {
	public AddVehicleDialog(Shell parent) {
		super(parent);
	}

	public void open() {
		Shell shell = new Shell(getParent());
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

				if (combo.getText().equals("Bus")) {
					Bus bus1 = new Bus(DrivingLicenseType.D, 4, "BA421IO", "Karosa", 70);
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, "ID");
					item.setText(1, "" + bus1.getDlt());
					item.setText(2, "" + bus1.getNumberOfWheels());
					item.setText(3, "" + bus1.getLicensePlate());
					item.setText(4, "" + bus1.getType());
					item.setText(5, "" + bus1.busSeats);
					//labelvehicInTab.setText("Vehicles in tab: " + ++vehicInTab);
				} else if (combo.getText().equals("Lorry")) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, "ID");
					item.setText(1, "" + lorry1.getDlt());
					item.setText(2, "" + lorry1.getNumberOfWheels());
					item.setText(3, "" + lorry1.getLicensePlate());
					item.setText(4, "" + lorry1.getType());
					item.setText(5, "" + lorry1.maxLoad);
					//labelvehicInTab.setText("Vehicles in tab:" + ++vehicInTab);
				} else if (combo.getText().equals("Car")) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, "ID");
					item.setText(1, "" + car1.getDlt());
					item.setText(2, "" + car1.getNumberOfWheels());
					item.setText(3, "" + car1.getLicensePlate());
					item.setText(4, "" + car1.getType());
					item.setText(5, "" + car1.passengers);
					//labelvehicInTab.setText("Vehicles in tab:" + ++vehicInTab);
				} else if (combo.getText().equals("Motorcycle")) {
					TableItem item = new TableItem(table, SWT.NONE);
					item.setText(0, "ID");
					item.setText(1, "" + motorcycle1.getDlt());
					item.setText(2, "" + motorcycle1.getNumberOfWheels());
					item.setText(3, "" + motorcycle1.getLicensePlate());
					item.setText(4, "" + motorcycle1.getType());
					item.setText(5, "" + motorcycle1.horsepower);
					//labelvehicInTab.setText("Vehicles in tab:" + ++vehicInTab);
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