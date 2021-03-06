package parking.house.gui;

import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import parking.house.gui.AddProgressBar;

import parking.house.model.Vehicle;

import org.eclipse.swt.graphics.Rectangle;

import parking.house.gui.AddProgressBar; // toto mozem vymazat pri najblizssom commite na github

public class ParkingHouseGUI {

	private Table table;
	private int Id;

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
		AddToolbar.setToolbar(shell, display); // treba ho nejako dostat hore
		setMenu(shell, display);
		setTab(shell, display);
		AddProgressBar.setProgressBar(shell, display); // v tejto triede mam
														// spraveny aj
														// konstruktor, ktory
														// vsak vyzera to tak
														// nie je treba, mozem
														// ho teda vymazat
		testButtUpdateProgbar(shell, display);
		testButtId(shell, display);
		setMaxCapacityLabel(shell, display);
		getCurrentCapacityLabel(shell, display);

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
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
				AddVehicleDialog dialog = new AddVehicleDialog(shell);
				dialog.open();
				Vehicle v = dialog.getVehicle();
				if (v != null) {
					System.out.println("Choosed vehicle:" + v);
					setValue(v);
				}
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

	private void setValue(Vehicle v) {
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0, "" + ++Id);
		item.setText(1, "" + v.getDlt());
		item.setText(2, "" + v.getStayTime());
		item.setText(3, "" + v.getVehType());
		item.setText(4, "" + v.getVehColor());
		item.setText(5, "" + v.getLicensePlate());

	}

	private void testButtUpdateProgbar(final Shell shell, final Display display) {
		Button b = new Button(shell, SWT.PUSH);
		b.setText("Here you can test progress bar");
		b.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				AddVehicleDialog.numberOfCars++;

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

	}

	private void testButtId(final Shell shell, final Display display) {
		Button b2 = new Button(shell, SWT.PUSH);
		b2.setText("Here you can test whether adding unique ID works");
		b2.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, "" + ++Id);
				item.setText(1, "Q");
				item.setText(2, "00");
				item.setText(3, "test");
				item.setText(4, "test");
				item.setText(5, "test");

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

	}

	private void setMaxCapacityLabel(final Shell shell, final Display display) {
		Label maxCapacity = new Label(shell, SWT.PUSH);
		maxCapacity.setText("Maximal capacity is 150 cars");
	}

	private void getCurrentCapacityLabel(final Shell shell,
			final Display display) {
		Label currentCapacity = new Label(shell, SWT.PUSH);
		currentCapacity
				.setText("Parked cars: " + AddVehicleDialog.numberOfCars);

	}

	private void setTab(final Shell shell, final Display diplay) {
		table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		String[] titles = { "ID", "DLT", "Will stay for", "Type", "Color",
				"License Plate" };
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}

	}

}