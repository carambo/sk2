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

import parking.house.model.Bus;
import parking.house.model.Car;
import parking.house.model.DrivingLicenseType;
import parking.house.model.Lorry;
import parking.house.model.Motorcycle;
import parking.house.model.Vehicle;

import org.eclipse.swt.graphics.Rectangle;

public class ParkingHouseGUI {



	
	
	private Table table;

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
		setTab(shell, display);
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
				System.out.println("Choosed vehicle:" + v);
				SetValue(v);
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

	

	private void SetValue(Vehicle v) {
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(0, "ID");
		item.setText(1, "" + v.getDlt());
		item.setText(2, "" + v.getStayTime());
		item.setText(3, "" + v.getVehType());
		item.setText(4, "" + v.getVehColor());
		item.setText(5, "" + v.getLicensePlate());
 
	}

	private void setTab(final Shell shell, final Display diplay) {
		table = new Table(shell, SWT.MULTI | SWT.BORDER
				| SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.heightHint = 200;
		table.setLayoutData(data);
		String[] titles = { "ID", "DLT", "Will stay for", "Type",
				"Color",
				"License Plate"};
		for (int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(titles[i]);
		}
		for (int i = 0; i < titles.length; i++) {
			table.getColumn(i).pack();
		}

		

	}

}