package parking.house.gui;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class AddProgressBar {

	public AddProgressBar() {
		// TODO Auto-generated constructor stub
	}

	public static void setProgressBar(final Shell shell, final Display display) {
		final ProgressBar bar = new ProgressBar(shell, SWT.SMOOTH);
		Rectangle clientArea = shell.getClientArea();
		bar.setBounds(clientArea.x, clientArea.y, 200, 32);
		shell.open();

		display.timerExec(150, new Runnable() {

			@Override
			public void run() {
				if (bar.isDisposed())
					return;
				bar.setSelection(AddVehicleDialog.numberOfCars);
				bar.setMaximum(150);
				if (AddVehicleDialog.numberOfCars <= bar.getMaximum())
					display.timerExec(150, this);
			}
		});

	}

}
