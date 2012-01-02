package org.eclipse.emf.emfstore.client.ui.views.users;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class UserCreateDataWizardPage extends WizardPage {
	private Text firstNameText;
	private Text lastNameText;
	private Text loginText;
	private Text descriptionText;
	private PageKeyListener listener;

	private class PageKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			handleEvent();
		}

		public void keyReleased(KeyEvent e) {
		}

	}

	/**
	 * Create the wizard.
	 */
	public UserCreateDataWizardPage() {
		super("wizardPage");
		setTitle("User data");
		setDescription("Please provide user information");
	}

	public void handleEvent() {
		String errorMgs = null;
		Map<Text, String> fieldNames = new HashMap<Text, String>();
		fieldNames.put(loginText, "Login");
		Text[] requiredFields = new Text[] { loginText };
		for (Text text : requiredFields) {
			if (text.getText().isEmpty()) {
				errorMgs = "The following field is required: " + fieldNames.get(text);
				break;
			}
		}
		setErrorMessage(errorMgs);
		getContainer().updateMessage();
		getContainer().updateButtons();
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(2, false));

		Label lblFirstName = new Label(container, SWT.CENTER);
		lblFirstName.setText("First name");

		firstNameText = new Text(container, SWT.BORDER);
		GridData gd_firstNameText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_firstNameText.horizontalIndent = 30;
		gd_firstNameText.widthHint = 100;
		firstNameText.setLayoutData(gd_firstNameText);

		Label lblLastName = new Label(container, SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLastName.setText("Last name");

		lastNameText = new Text(container, SWT.BORDER);
		lastNameText.setText("");
		GridData gd_lastNameText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_lastNameText.widthHint = 100;
		gd_lastNameText.horizontalIndent = 30;
		lastNameText.setLayoutData(gd_lastNameText);

		Label lblLogin = new Label(container, SWT.NONE);
		lblLogin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLogin.setText("Login");

		loginText = new Text(container, SWT.BORDER);
		GridData gd_loginText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_loginText.widthHint = 80;
		gd_loginText.horizontalIndent = 30;
		loginText.setLayoutData(gd_loginText);

		Label lblDescription = new Label(container, SWT.NONE);
		GridData gd_lblDescription = new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1);
		gd_lblDescription.verticalIndent = 5;
		lblDescription.setLayoutData(gd_lblDescription);
		lblDescription.setText("Description");

		descriptionText = new Text(container, SWT.BORDER | SWT.MULTI);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text.heightHint = 100;
		gd_text.horizontalIndent = 30;
		gd_text.widthHint = 300;
		descriptionText.setLayoutData(gd_text);

		listener = new PageKeyListener();

		for (Text textField : new Text[] { firstNameText, lastNameText, loginText, descriptionText }) {
			textField.addKeyListener(listener);
		}

	}

	@Override
	public void dispose() {
		for (Text textField : new Text[] { firstNameText, lastNameText, loginText, descriptionText }) {
			textField.removeKeyListener(listener);
		}
		super.dispose();
	}

	/**
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {

		if (getErrorMessage() != null)
			return false;
		return true;
	}

	public String getFirstName() {
		return firstNameText.getText();
	}

	public String getLastName() {
		return lastNameText.getText();
	}

	public String getLogin() {
		return loginText.getText();
	}

	public String getUserDescription() {
		return descriptionText.getText();
	}
}
