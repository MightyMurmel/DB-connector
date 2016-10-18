package de.inex;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class GUI {

	protected Shell shlDbconnector;
	private SQLConnection conn = null;

	private final String CONNECTTEXT = "Connect";
	private final String DISCONNECTTEXT = "Disconnect";
	private Text text_Nachname;
	private Text text_Vorname;
	private Text text_Email;
	private Text text_Telefon;
	private Text text_Geburtsdatum;
	private Table table;
	private Text text_id;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// try {
		// PrintStream myConsole = new PrintStream(new File("C://java.txt"));
		// System.setOut(myConsole);
		// myConsole.print("Logfile");
		// } catch (FileNotFoundException fx) {
		// System.out.println(fx);
		// }
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlDbconnector.open();
		shlDbconnector.layout();
		while (!shlDbconnector.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDbconnector = new Shell();
		shlDbconnector.setSize(656, 590);
		shlDbconnector.setText("DB-Connector");

		Button btnConnectWith = new Button(shlDbconnector, SWT.NONE);
		btnConnectWith.setBounds(530, 41, 100, 25);
		btnConnectWith.setText("Connect with..");
		btnConnectWith.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ConnectWithShell.screenConnectWith();
			}
		});

		Label lblDbconnector = new Label(shlDbconnector, SWT.NONE);
		lblDbconnector.setFont(SWTResourceManager.getFont("Times New Roman", 20, SWT.NORMAL));
		lblDbconnector.setBounds(208, 3, 168, 25);
		lblDbconnector.setText("DB-Connector");

		Button btnConnect = new Button(shlDbconnector, SWT.NONE);
		btnConnect.setBounds(530, 10, 100, 25);
		btnConnect.setText(CONNECTTEXT);

		Button btnCommit = new Button(shlDbconnector, SWT.NONE);
		btnCommit.setEnabled(false);
		btnCommit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					String a = text_Vorname.getText();
					String b = text_Nachname.getText();
					String c = text_Email.getText();
					String d = text_Telefon.getText();
					String f = text_Geburtsdatum.getText();
					conn.commit(a, b, c, d, f);
				}
			
		});
		btnCommit.setBounds(420, 10, 75, 25);
		btnCommit.setText("Commit");

		Button btnShowTable = new Button(shlDbconnector, SWT.NONE);
		btnShowTable.setEnabled(false);
		btnShowTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
				String sql = "select * from testdb";
				try {
					List<Testdb> userList = conn.checkData(sql);
					for (Testdb user : userList) {
						addUserToTable(user);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnShowTable.setBounds(420, 41, 75, 25);
		btnShowTable.setText("Show Table");

		Label lbl_id = new Label(shlDbconnector, SWT.NONE);
		lbl_id.setBounds(10, 50, 55, 15);
		lbl_id.setText("ID:");

		text_id = new Text(shlDbconnector, SWT.BORDER);
		text_id.setEditable(false);
		text_id.setBounds(85, 47, 150, 21);

		Label lblVorname = new Label(shlDbconnector, SWT.NONE);
		lblVorname.setBounds(10, 90, 55, 15);
		lblVorname.setText("Vorname: ");

		text_Vorname = new Text(shlDbconnector, SWT.BORDER);
		text_Vorname.setBounds(85, 87, 150, 21);

		Label lblNachname = new Label(shlDbconnector, SWT.NONE);
		lblNachname.setBounds(10, 130, 69, 15);
		lblNachname.setText("Nachname:");

		text_Nachname = new Text(shlDbconnector, SWT.BORDER);
		text_Nachname.setBounds(85, 127, 150, 21);

		Label lblEmail = new Label(shlDbconnector, SWT.NONE);
		lblEmail.setBounds(10, 170, 55, 15);
		lblEmail.setText("Email:");

		text_Email = new Text(shlDbconnector, SWT.BORDER);
		text_Email.setBounds(85, 164, 150, 21);

		Label lblTelefon = new Label(shlDbconnector, SWT.NONE);
		lblTelefon.setBounds(10, 210, 55, 15);
		lblTelefon.setText("Telefon:");

		text_Telefon = new Text(shlDbconnector, SWT.BORDER);
		text_Telefon.setBounds(85, 204, 150, 21);

		Label lblGeburtsdatum = new Label(shlDbconnector, SWT.NONE);
		lblGeburtsdatum.setBounds(0, 250, 79, 15);
		lblGeburtsdatum.setText("Geburtsdatum:");

		text_Geburtsdatum = new Text(shlDbconnector, SWT.BORDER);
		text_Geburtsdatum.setBounds(85, 244, 150, 21);

		Button btnQuit = new Button(shlDbconnector, SWT.NONE);
		btnQuit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					if (conn.isConnected()) {
						conn.dbDisconnect();
						shlDbconnector.close();
					}
				} catch (NullPointerException t) {
					shlDbconnector.close();
				}

			}
		});
		btnQuit.setBounds(555, 269, 75, 25);
		btnQuit.setText("Quit");

		table = new Table(shlDbconnector, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 300, 620, 241);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Button btnUpdate = new Button(shlDbconnector, SWT.NONE);
		btnUpdate.setEnabled(false);
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] selection = table.getSelection();
				TableItem ti = selection[0];
				Testdb user = (Testdb) ti.getData();
				user.setVorname(text_Vorname.getText());
				user.setNachname(text_Nachname.getText());
				user.setEmail(text_Email.getText());
				user.setTelefonnummer(text_Telefon.getText());
				user.setTelefonnummer(text_Geburtsdatum.getText());
				conn.update(user);
			}
		});
		btnUpdate.setBounds(160, 271, 75, 25);
		btnUpdate.setText("Update");

		table.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				TableItem[] selection = table.getSelection();
				TableItem ti = selection[0];
				Testdb user = (Testdb) ti.getData();
				text_id.setText(Integer.toString(user.getId()));
				text_Vorname.setText(user.getVorname());
				text_Nachname.setText(user.getNachname());
				text_Email.setText(user.getEmail());
				text_Telefon.setText(user.getTelefonnummer());
				text_Geburtsdatum.setText(user.getGeburtsdatum());
			}
		});

		String[] titles = { "ID", "Vorname", "Nachname", "Email", "Telefon", "Geburtsdatum" };
		for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
			TableColumn column = new TableColumn(table, SWT.NULL);
			column.setWidth(100);
			column.setText(titles[loopIndex]);
		}

		btnConnect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Establishing Connection...");
				if (conn == null) {
					conn = new SQLConnection();
				}
				if (!conn.isConnected()) {
					conn.dbConnector();
					if(conn.isConnected()) {
						btnConnect.setText(DISCONNECTTEXT);
						btnCommit.setEnabled(true);
						btnUpdate.setEnabled(true);
						btnShowTable.setEnabled(true);
					}
				} else {
					btnConnect.setText(CONNECTTEXT);
					conn.dbDisconnect();
					btnConnect.setText(DISCONNECTTEXT);
					btnCommit.setEnabled(false);
					btnUpdate.setEnabled(false);
					btnShowTable.setEnabled(false);
					conn = null;
				}
			}
		});
	}

	public void addUserToTable(Testdb user) {
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(0, Integer.toString(user.getId()));
		tableItem.setText(1, user.getVorname());
		tableItem.setText(2, user.getNachname());
		tableItem.setText(3, user.getEmail());
		tableItem.setText(4, user.getTelefonnummer());
		tableItem.setText(5, user.getGeburtsdatum());
		tableItem.setData(user);
	}
}
