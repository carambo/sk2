package parking.house.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
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
		shell.setMinimumSize(800, 400);
		draw(shell);
		setLabels(shell);
		shell.pack();
		shell.open();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public String stayTimeValue;
	public String vehTypeValue;
	public String vehColorValue;
	public String licensePlateValue;

	public int stayTimeValueint;

	private void setLabels(final Shell shell) {
		
		final Label label = new Label(shell, SWT.MULTI);
		label.setText("Title: ");
		label.setLocation(new Point(100, 70));

	}

	private void draw(final Shell shell) {

		

		final Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[] { "Bus", "Lorry", "Car", "Motorcycle" });
		Rectangle clientArea = shell.getClientArea();
		combo.setBounds(clientArea.x, clientArea.y, 400, 400);
		
		

		final Text stayTimeInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		stayTimeInput.setText("enter stayTime");
		stayTimeInput.setSize(200, 25);
		stayTimeInput.setLocation(new Point(100, 80));

		final Text vehTypeInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		vehTypeInput.setText("enter vehcile type");
		vehTypeInput.setSize(200, 25);
		vehTypeInput.setLocation(new Point(100, 120));

		final Text vehColorInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		vehColorInput.setText("enter vehicle color");
		vehColorInput.setSize(200, 25);
		vehColorInput.setLocation(new Point(100, 160));

		final Text licensePlateInput = new Text(shell, SWT.BORDER | SWT.MULTI);
		licensePlateInput.setText("enter license plate");
		licensePlateInput.setSize(200, 25);
		licensePlateInput.setLocation(new Point(100, 200));

		 Label label = new Label(shell, SWT.CENTER);
		 label.setText("Will stay for");
		 label.setBounds(shell.getClientArea());
		    
		  
		    
		
		    Button ok = new Button(shell, SWT.PUSH);
		ok.setLocation(new Point(230, 230));
		ok.setText("ok");
		ok.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Vehicle v = null;
				stayTimeValue = stayTimeInput.getText();
				stayTimeValueint = Integer.parseInt(stayTimeValue);

				vehTypeValue = vehTypeInput.getText();
				vehColorValue = vehColorInput.getText();
				licensePlateValue = licensePlateInput.getText();

				if (combo.getText().equals("Bus")) {
					v = new Bus(1, DrivingLicenseType.D, stayTimeValueint,
							vehTypeValue, vehColorValue, licensePlateValue);
				} else if (combo.getText().equals("Lorry")) {
					v = new Lorry(2, DrivingLicenseType.C, stayTimeValueint,
							vehTypeValue, vehColorValue, licensePlateValue);
				} else if (combo.getText().equals("Car")) {
					v = new Car(3, DrivingLicenseType.B, stayTimeValueint,
							vehTypeValue, vehColorValue, licensePlateValue);
				} else if (combo.getText().equals("Motorcycle")) {
					v = new Motorcycle(4, DrivingLicenseType.A,
							stayTimeValueint, vehTypeValue, vehColorValue,
							licensePlateValue);
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

// nastavit aby sa to dlt automaticky nastavilo podla typu vozidla, tj
// ked je vozidlo car tak dlt bude B, ked je vozidlo bus dlt bude D
// apod.
// vsetko to potom podavat do samostatnej metody, tj kazde toto okno
// bude v samostatnej metode a bolo by dobre aby v nej bolo aj
// pridadenie hpdnoty s inicializacoiu toho pomocneho stringu alebo int
// ako som mal teraz String s
// bude treba vyriesit toto tak, aby som dostaval typ int, pripadne ten
// sting budem musoiet potom na int zkonvertovat
