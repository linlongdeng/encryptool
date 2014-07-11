package com.deng;


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EncryptionApplication {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EncryptionApplication window = new EncryptionApplication();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("加密解密工具");
		shell.setLayout(null);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(85, 7, 259, 23);
		formToolkit.adapt(text, true, true);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(shell, SWT.OPEN);
				fileDialog.setFilterPath("");
			}
		});
		button.setFont(SWTResourceManager.getFont("微软雅黑", 9, SWT.NORMAL));
		button.setBounds(350, 5, 61, 27);
		formToolkit.adapt(button, true, true);
		button.setText("浏 览");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 13, 61, 17);
		formToolkit.adapt(label, true, true);
		label.setText("选择文件:");

	}
}
