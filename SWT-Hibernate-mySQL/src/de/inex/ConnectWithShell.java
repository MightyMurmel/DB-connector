package de.inex;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;

public class ConnectWithShell {

	protected Shell shellConnectTo;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 * @wbp.parser.entryPoint
	 */
	public static void screenConnectWith() {
		try {
			ConnectWithShell window = new ConnectWithShell();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shellConnectTo.open();
		shellConnectTo.layout();
		while (!shellConnectTo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shellConnectTo = new Shell();
		shellConnectTo.setMinimumSize(new Point(140, 40));
		shellConnectTo.setSize(420, 250);
		shellConnectTo.setText("Connect to...");
		
		Label lblConnectTo = new Label(shellConnectTo, SWT.NONE);
		lblConnectTo.setBounds(146, 10, 119, 15);
		lblConnectTo.setText("Connect to Database");
		
		Label lblUrlmysql = new Label(shellConnectTo, SWT.NONE);
		lblUrlmysql.setBounds(10, 60, 73, 15);
		lblUrlmysql.setText("URL(mySQL): ");
		
		Label lblNewLabel = new Label(shellConnectTo, SWT.NONE);
		lblNewLabel.setBounds(10, 100, 73, 15);
		lblNewLabel.setText("Username: ");
		
		Label lblPassword = new Label(shellConnectTo, SWT.NONE);
		lblPassword.setBounds(10, 140, 73, 15);
		lblPassword.setText("Password: ");
		
		text = new Text(shellConnectTo, SWT.BORDER);
		text.setBounds(89, 57, 239, 21);
		
		text_1 = new Text(shellConnectTo, SWT.BORDER);
		text_1.setBounds(89, 100, 239, 21);
		
		text_2 = new Text(shellConnectTo, SWT.BORDER);
		text_2.setBounds(89, 140, 239, 21);
		
		Button btnApply = new Button(shellConnectTo, SWT.NONE);
		btnApply.setBounds(319, 176, 75, 25);
		btnApply.setText("Apply");
		
		Button btnCancel = new Button(shellConnectTo, SWT.NONE);
		btnCancel.setBounds(10, 176, 75, 25);
		btnCancel.setText("Cancel");

	}
}
