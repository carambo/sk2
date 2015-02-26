package parking.house.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AddVehicleDialog extends Dialog {

	public AddVehicleDialog(Shell parent) {
		super(parent);
	}

	public void open() {
		Shell shell = new Shell(getParent());
		shell.setText("Add vehicle");
		
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
	
	private void draw(final Shell shell){
		Button ok = new Button(shell, SWT.PUSH);
		ok.setText("ok");
		ok.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				shell.dispose();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});
		ok.pack();
	}
}
