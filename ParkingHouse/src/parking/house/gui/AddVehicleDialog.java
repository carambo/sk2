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

		final Text dltInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		dltInput.setText("enter license plate");
		dltInput.setSize(200, 25);
		dltInput.setLocation(new Point(20, 40));
		
		final Text stayTimeInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		stayTimeInput.setText("enter stayTime"); // bude treba vyriesit toto tak, aby som dostaval typ int, pripadne ten sting budem musoiet potom na int zkonvertovat
		stayTimeInput.setSize(200, 25); // vsetko to potom podavat do samostatnej metody, tj kazde toto okno bude v samostatnej metode a bolo by dobre aby v nej bolo aj pridadenie hpdnoty s inicializacoiu toho pomocneho stringu alebo int ako som mal teraz String s
		stayTimeInput.setLocation(new Point(20, 80)); // a dat pozor na umiestnenie, teraz su tie suradnice vsade rovnake takze to bude na sebe, treba to pekne rozdelit a dat pod seba
		// nastavit aby sa to dlt automaticky nastavilo podla typu vozidla, tj ked je vozidlo car tak dlt bude B, ked je vozidlo bus dlt bude D apod. 
		final Text vehTypeInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		vehTypeInput.setText("enter vehcile type");
		vehTypeInput.setSize(200, 25);
		vehTypeInput.setLocation(new Point(20, 120));
		
		final Text vehColorInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		vehColorInput.setText("enter vehicle color");
		vehColorInput.setSize(200, 25);
		vehColorInput.setLocation(new Point(20, 160));
		
		final Text LicensePlateInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		LicensePlateInput.setText("enter license type");
		LicensePlateInput.setSize(200, 25);
		LicensePlateInput.setLocation(new Point(20, 200));
		

		Button ok = new Button(shell, SWT.PUSH);
		ok.setLocation(new Point(20, 60)); 
		ok.setText("ok");
		ok.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Vehicle v = null;
				String s; 
				s = dltInput.getText();
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