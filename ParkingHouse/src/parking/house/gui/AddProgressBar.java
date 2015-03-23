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

		display.timerExec(100, new Runnable() {
			int i = 0;

			@Override
			public void run() {
				if (bar.isDisposed())
					return;
				bar.setSelection(i++);
				if (i <= bar.getMaximum())
					display.timerExec(100, this);
			}
		});

	}

}
