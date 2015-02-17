package parking.house.gui;

import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import parking.house.model.Bus;
import parking.house.model.DrivingLicenseType;

public class Tab {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		Table table = new Table(shell, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		String[] titles = { "ID" /* 1 */, "DLT" /* 2 */,
				"Number of wheels"/* 3 */, "License Plate"/* 4 */,
				"Type"/* 5 */, "Number of seats (bus)"/* 6 */};
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
		}

		
		Bus bus1 = new Bus(DrivingLicenseType.D, 4, "BA554NA", "Karosa", 70);

		int count = 10;
		for (int i = 0; i < count; i++) {
			TableItem item = new TableItem(table, SWT.NONE);

			item.setText(0, "ID"); // here I need to make some for to make new
									// ID for each new car added
			item.setText(1, "" + bus1.getDlt());
			item.setText(2, "" + bus1.getNumberOfWheels());
			item.setText(3, "" + bus1.getLicensePlate());
			item.setText(4, "" + bus1.getType());
			item.setText(5, "" + bus1.busSeats);
		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
