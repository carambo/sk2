package parking.house.gui;

import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
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

public class ParkingHouseGUI {

	private Text labelLorry;
	private Text labelCar;
	private Text labelBus;
	private Text labelMotorcycle;

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

		// begin of menu

		setTestButtons(shell, display);
		setMenu(shell, display);
		setTab(shell, display);
		


		// end of menu

		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private void setTestButtons(Shell shell, Display display) {
		// label1 - Lorry

		labelLorry = new Text(shell, SWT.PUSH); // label mozem zmenit napr na
		// text -
		// https://www.eclipse.org/swt/widgets/
		labelLorry.setText("Lorry");
		labelLorry.setSize(400, 30);
		labelLorry.pack();

		Button buttonLorry = new Button(shell, SWT.PUSH);
		buttonLorry.setText("Open Lorries");
		buttonLorry.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Lorry car1 = new Lorry(DrivingLicenseType.D, 4, "BA882AB",
						"Scania", 420);
				labelLorry.setText(car1.toString());
				labelLorry.pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		// end of label1 - Lorry

		// label2 - Car

		labelCar = new Text(shell, SWT.PUSH); // I forgot to initialized label2
												// first time
		labelCar.setText("Car");
		labelCar.setSize(400, 30);
		labelCar.pack();

		Button buttonCar = new Button(shell, SWT.PUSH);
		buttonCar.setText("Open Cars");
		buttonCar.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Car car2 = new Car(DrivingLicenseType.B, 4, "BA255AA", "BMW", 3);
				labelCar.setText(car2.toString());
				labelCar.pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}

		});

		// end of label2 - Car

		// label3 - Bus

		labelBus = new Text(shell, SWT.PUSH);

		labelBus.setText("Bus");
		labelBus.setSize(400, 30);
		labelBus.pack();

		Button buttonBus = new Button(shell, SWT.PUSH);
		buttonBus.setText("Open Bus");
		buttonBus.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Bus car3 = new Bus(DrivingLicenseType.D, 4, "BA554NA",
						"Karosa", 70);
				labelBus.setText(car3.toString());
				labelBus.pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		// end of label3 - Bus

		// label4 - Motorcycle

		labelMotorcycle = new Text(shell, SWT.PUSH);

		labelMotorcycle.setText("Motorcycle");
		labelMotorcycle.setSize(400, 30);
		labelBus.pack();

		Button buttonMotorcycle = new Button(shell, SWT.PUSH);
		buttonMotorcycle.setText("Open Motorcycle");
		buttonMotorcycle.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Motorcycle car4 = new Motorcycle(DrivingLicenseType.A, 2,
						"BA112MN", "Honda", 140);
				labelMotorcycle.setText(car4.toString());
				labelMotorcycle.pack();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		// end of label4 - Motorcycle

		buttonLorry.pack();
		buttonCar.pack();
		buttonBus.pack();
		buttonMotorcycle.pack();
	}

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
				System.out.println("add car");
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

	// tab

	private void setTab(final Shell shell, final Display diplay) {

		
		Table table = new Table(shell, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		String[] titles = { "ID" /* 0 */, "DLT" /* 1 */,
				"Number of wheels"/* 2 */, "License Plate"/* 3 */,
				"Type"/* 4 */, "Number of seats (bus)"/* 5 */};
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
		}

		Bus bus1 = new Bus(DrivingLicenseType.D, 4, "BA554NA", "Karosa", 70);

		int count = 10;
		for (int i = 0; i < count; i++) {
			TableItem item = new TableItem(table, SWT.NONE);

			
			
			Button buttonAssVal = new Button(shell, SWT.PUSH);
			buttonAssVal.setText("Assign values to table");
			buttonAssVal.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent arg0) {
					item.setText(0, "ID"); // here I need to make some for to make new
					// ID for each new car added
					item.setText(1, "" + bus1.getDlt());
					item.setText(2, "" + bus1.getNumberOfWheels());
					item.setText(3, "" + bus1.getLicensePlate());
					item.setText(4, "" + bus1.getType());
					item.setText(5, "" + bus1.busSeats);
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent arg0) {
				}
			});
			
		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}
		
	}

	// tab
	
	
	

}
