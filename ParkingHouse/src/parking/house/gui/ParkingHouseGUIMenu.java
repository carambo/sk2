package parking.house.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class ParkingHouseGUIMenu {

	Display display;

	Shell shell;

	Menu menuBar, fileMenu;

	MenuItem fileMenuHeader;

	MenuItem fileAddCarItem, fileDelCarItem, fileExitItem;

	Label label;

	public ParkingHouseGUIMenu() {

		display = new Display();
		shell = new Shell(display);
		shell.setText("Menu Example");
		shell.setSize(300, 200);

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

		fileAddCarItem.addSelectionListener(new fileAddCarItemListener());
		fileDelCarItem.addSelectionListener(new fileDelCarItemListener());
		fileExitItem.addSelectionListener(new fileExitItemListener());

		shell.setMenuBar(menuBar);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	class fileExitItemListener implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
			shell.close();
			display.dispose();
		}

		public void widgetDefaultSelected(SelectionEvent event) {
			shell.close();
			display.dispose();
		}
	}

	class fileAddCarItemListener implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
			label.setText("Add some new car");
		}

		public void widgetDefaultSelected(SelectionEvent event) {
			label.setText("Add some new car");
		}
	}

	class fileDelCarItemListener implements SelectionListener {
		public void widgetSelected(SelectionEvent event) {
			label.setText("Delete cars that left");
		}

		public void widgetDefaultSelected(SelectionEvent event) {
			label.setText("Delete cars that left");
		}
	}

	public static void main(String[] args) {
		ParkingHouseGUIMenu GUImenu = new ParkingHouseGUIMenu();
	}
}