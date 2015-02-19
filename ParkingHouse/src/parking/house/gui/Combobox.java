package parking.house.gui;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class Combobox {

public static void main (String [] args) {
	Display display = new Display ();
	Shell shell = new Shell (display);
	Combo combo = new Combo (shell, SWT.READ_ONLY);
	combo.setItems (new String [] {"Bus", "Lorry", "Car", "Motorcycle"});
	Rectangle clientArea = shell.getClientArea ();
	combo.setBounds (clientArea.x, clientArea.y, 400, 400);
	shell.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}

} 
