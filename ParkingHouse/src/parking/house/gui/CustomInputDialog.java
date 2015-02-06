package parking.house.gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CustomInputDialog {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		InputDialog dlg = new InputDialog(shell);
		String input = dlg.open();
		if (input != null) {
			// User clicked OK; set the text into the label
			System.out.println(input);
		}

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}