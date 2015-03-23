package parking.house.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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
import org.eclipse.swt.layout.*;

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
		super(parent, SWT.DIALOG_TRIM);
	}

	public void open() {
		shell = new Shell(getParent(), getStyle());
		shell.setText("Add vehicle");
		shell.setMinimumSize(250, 250);
		shell.setMinimumSize(250, 250);
		GridLayout layout = new GridLayout(2, true);
		shell.setLayout(layout);

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

	private String stayTimeValue;
	private String vehTypeValue;
	private String vehColorValue;
	private String licensePlateValue;

	public int stayTimeValueint;

	private void draw(final Shell shell) {

		final Combo combo = new Combo(shell, SWT.READ_ONLY);

		Label labelDlt = new Label(shell, SWT.CENTER);

		Label labelStayTime = new Label(shell, SWT.CENTER);

		final Text stayTimeInput = new Text(shell, SWT.BORDER | SWT.MULTI);

		Label labelVehType = new Label(shell, SWT.CENTER);

		final Text vehTypeInput = new Text(shell, SWT.BORDER | SWT.MULTI);

		Label labelVehColor = new Label(shell, SWT.CENTER);

		final Text vehColorInput = new Text(shell, SWT.BORDER | SWT.MULTI);

		Label labelLicPlate = new Label(shell, SWT.CENTER);

		final Text licensePlateInput = new Text(shell, SWT.BORDER | SWT.MULTI);

		Button buttonCancel = new Button(shell, SWT.PUSH);
		buttonCancel.setText("Cancel");
		buttonCancel.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				shell.close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		Button buttonOk = new Button(shell, SWT.PUSH);
		
		setContext(combo, labelLicPlate, labelStayTime, labelVehColor,
				labelVehType, stayTimeInput, vehTypeInput, vehColorInput,
				licensePlateInput, labelDlt);
		setButton(buttonOk, combo, stayTimeInput, vehTypeInput, vehColorInput,
				licensePlateInput);
		buttonOk.pack();
		buttonCancel.pack();
	}

	private void setButton(Button buttonOk, Combo combo, Text stayTimeInput,
			Text vehTypeInput, Text vehColorInput, Text licensePlateInput) {
		buttonOk.setText("OK");
		buttonOk.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {

				setValues(combo, stayTimeInput, vehTypeInput, vehColorInput,
						licensePlateInput);
				shell.close();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
	}

	private void setValues(Combo combo, Text stayTimeInput, Text vehTypeInput,
			Text vehColorInput, Text licensePlateInput) {
		stayTimeValue = stayTimeInput.getText();
		stayTimeValueint = Integer.parseInt(stayTimeValue);

		vehTypeValue = vehTypeInput.getText();
		vehColorValue = vehColorInput.getText();
		licensePlateValue = licensePlateInput.getText();
		Vehicle v = null;

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
			v = new Motorcycle(4, DrivingLicenseType.A, stayTimeValueint,
					vehTypeValue, vehColorValue, licensePlateValue);
		} else {
			System.out.println("else");
		}

		vehicle = v;

	}

	private void setContext(Combo combo, Label labelLicPlate,
			Label labelStayTime, Label labelVehColor, Label labelVehType,
			Text stayTimeInput, Text vehTypeInput, Text vehColorInput,
			Text licensePlateInput, Label labelDlt) {
		combo.setItems(new String[] { "Bus", "Lorry", "Car", "Motorcycle" });
		combo.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				String comboValue = combo.getText();
				setDltValue(labelDlt, comboValue);
			}
		});
		labelStayTime.setText("Will stay for:");
		labelVehType.setText("Vehicle type:");
		labelVehColor.setText("Vehicle color:");
		labelLicPlate.setText("License plate:");
		stayTimeInput.setSize(200, 25);
		vehTypeInput.setSize(200, 25);
		vehColorInput.setSize(200, 25);
		licensePlateInput.setSize(200, 25);

	}

	private void setDltValue(Label labelDlt, String comboValue) {
		switch (comboValue) {
		case "Bus":
			labelDlt.setText("License type: D");
			break;
		case "Lorry":
			labelDlt.setText("License type: C");
			break;
		case "Car":
			labelDlt.setText("License type: B");
			break;
		case "Motorcycle":
			labelDlt.setText("License type: A");
			break;
		default:
			throw new IllegalArgumentException("dlt combo value: " + comboValue);
		}

		labelDlt.pack();
		labelDlt.redraw();
	}
}




// nastavit labely texstboxy atd, buttony OK,
// vytvorit triedu parking hoyuse 2 parametre, aktualne naplnenie, maxinalna
// kapacita, v parkingh hosue gui vytvorit na zaciatku, podal pridavania a
// odstarovania vbozidiel, pridat progress bar, dat tam setProgressm axu
// kapocata ako konstana, kapacita 250 - bude to treba pre[pocitatvat v prograss
// nare podla percent , na hlavnom dat dole progress bar aj s labelopm bude mi
// to ukazovat aj cislo, percenta apod;

// dalsi dialog na odstarnovanie aut
// do stavovaeho ruadka dat add car , delet car a pod./ 

// urobit automaticke pridavanie ID
