package parking.house.gui;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

import parking.house.model.Vehicle;


public class AddToolbar {

public static void setToolbar(final Shell shell, final Display display) {
	
	

    
	ToolBar bar = new ToolBar (shell, SWT.BORDER);
		ToolItem addCarItem = new ToolItem (bar, SWT.PUSH);
		addCarItem.setText ("Add car");
	
		ToolItem deleteCarItem = new ToolItem(bar, SWT.PUSH);
		deleteCarItem.setText("Delete car");
		
		 Listener listener = new Listener() {
		      public void handleEvent(Event event) {
		    	  AddVehicleDialog dialog = new AddVehicleDialog(shell);
					dialog.open();
					Vehicle v = dialog.getVehicle();
				//	ParkingHouseGUI.setValue(v); 
					// ked toto pouzijem, napise mi t ze to nie je viditelne. 
					

		      }
		    };
		    addCarItem.addListener(SWT.Selection, listener);
		
	Rectangle clientArea = shell.getClientArea ();
	bar.setLocation (clientArea.x, clientArea.y);
	bar.pack ();
	shell.open ();
	
} 
}