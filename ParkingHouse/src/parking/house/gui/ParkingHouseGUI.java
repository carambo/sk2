package parking.house.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import parking.house.model.Bus;
import parking.house.model.Car;
import parking.house.model.DrivingLicenseType;
import parking.house.model.Lorry;
import parking.house.model.Motorcycle;
import org.eclipse.swt.graphics.Rectangle;

public class ParkingHouseGUI {
	// BEGIN OF VARIABLES/OBJECTS/LABELS INITIALIZATION
	// creating objects of all types of vehicle
	Bus bus1 = new Bus(DrivingLicenseType.D, 4, "BA421IO", "Karosa", 70);
	Lorry lorry1 = new Lorry(DrivingLicenseType.C, 6, "TN214OO", "Iveco", 800);
	Car car1 = new Car(DrivingLicenseType.B, 4, "MY882AA", "BMW", 5);
	Motorcycle motorcycle1 = new Motorcycle(DrivingLicenseType.A, 2, "TT587MM",
			"Honda", 150);
	// end of creating objects of all types of vehicle
	// begin text labels
	private Text labelvehicInTab;
	// end text labels
	// begin variables
	int vehicInTab;

	// end variables
	// END OF VARIABLES/OBJECTS/LABELS INITIALIZATION
	public ParkingHouseGUI() {
		createGUI();
	}

	public void createGUI() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setMinimumSize(1000, 200);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		shell.setLayout(gridLayout);
		setMenu(shell, display);
		setLabelVehicInTab(shell, display);
		setTab(shell, display);
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	// begin of menu
	private void setMenu(final Shell shell, final Display display) {
		Menu menuBar, fileMenu;
		MenuItem fileMenuHeader;
		MenuItem fileAddCarItem, fileDelCarItem, fileExitItem;
		final Label label;
		label = new Label(shell, SWT.CENTER);
		label.setBounds(shell.getClientArea());
		menuBar = new Menu(shell, SWT.BAR);
		fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&File");
		fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);
		fileAddCarItem = new MenuItem(fileMenu, SWT.PUSH);
		fileAddCarItem.setText("&Add car");
		fileDelCarItem = new MenuItem(fileMenu, SWT.PUSH);
		fileDelCarItem.setText("&Delete car");
		fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("&Exit");
		fileAddCarItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				AddVehicleDialog dialog = new AddVehicleDialog(shell);
				dialog.open();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		fileDelCarItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.out.println("delete car");
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		fileExitItem.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.close();
				display.dispose();
				System.out.println("exit");
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		shell.setMenuBar(menuBar);
	}

	// end of menu
	// label setLabelVehicleInItab
	public void setLabelVehicInTab(final Shell shell, final Display display) {
		labelvehicInTab = new Text(shell, SWT.PUSH);
		labelvehicInTab.setText("Vehicles in tab: " + vehicInTab);
		// labelvehicInTab.setSize(400, 30); - setSize is now not active,
		// because when it is, I see only one-digit number, when it's not active
		// I can see at least part of two-digit number
		labelvehicInTab.pack();
	}

	// end of that label
	// begin of tab
	private void setTab(final Shell shell, final Display diplay) {
		final Table table = new Table(shell, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		String[] titles = { "ID" /* 0 */, "DLT" /* 1 */,
				"Number of wheels"/* 2 */, "License Plate"/* 3 */,
				"Type"/* 4 */,
				"number of seats, horse power, etc (this will be edited)"/* 5 */};
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}
		// combobox
		final Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[] { "Bus", "Lorry", "Car", "Motorcycle" });
		Rectangle clientArea = shell.getClientArea();
		combo.setBounds(clientArea.x, clientArea.y, 400, 400);
		// end of combobox
		// begin of ok button
		Button okButton = new Button(shell, SWT.PUSH);
		okButton.setText("OK");
		okButton.addSelectionListener(new SelectionListener() {
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
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		// end of ok button
	}
	// end of tab
	// dat vsetkoy tieto buttony do spolocnej metody, nie tam kde je tab. pri
	// tych
	// prvych buttonoch mam na konic napisany .pack(); spytat sa doda ci to bude
	// treba
	// spravit aj teraz
}