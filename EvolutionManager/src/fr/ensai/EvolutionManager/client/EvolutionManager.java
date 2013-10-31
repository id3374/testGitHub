package fr.ensai.EvolutionManager.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import fr.ensai.EvolutionManager.shared.HitGoogle;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EvolutionManager implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button sendButton = new Button("Go");
		final TextBox fromNameField = new TextBox();
		fromNameField.setText("FromName");
		final TextBox fromVersionField = new TextBox();
		fromVersionField.setText("FromVersion");
		final TextBox toNameField = new TextBox();
		toNameField.setText("ToName");
		final TextBox toVersionField = new TextBox();
		toVersionField.setText("ToVersion");

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("fromNameFieldContainer").add(fromNameField);
		RootPanel.get("fromVersionFieldContainer").add(fromVersionField);
		RootPanel.get("toNameFieldContainer").add(toNameField);
		RootPanel.get("toVersionFieldContainer").add(toVersionField);
		RootPanel.get("sendButtonContainer").add(sendButton);

		// Focus the cursor on the name field when the app loads
		fromNameField.setFocus(true);
		fromNameField.selectAll();

		final CheckBox googleBox = new CheckBox();
		final CheckBox crawlingBox = new CheckBox();
		final CheckBox gitHubBox = new CheckBox();

		RootPanel.get("hitGoogle").add(googleBox);
		RootPanel.get("webCrawling").add(crawlingBox);
		RootPanel.get("gitHubAPI").add(gitHubBox);

		sendButton.setEnabled(true);
		googleBox.setEnabled(true);
		sendButton.addClickHandler(new ClickHandler(){

			@SuppressWarnings("deprecation")
			@Override
			public void onClick(ClickEvent event) {
				// There will be what we want it to be
				// For now, just the number of Hit by the search google
				String recherche = "from "+fromNameField.getText()+" "+fromVersionField.getText()+" to "+toNameField.getText()+" "+toVersionField.getText();
				String res = HitGoogle.getHitGoogle(recherche);
				Window.alert("Nombre de résultats pour \""+recherche+"\" = "+res+"\"");

				//Voilà faudrait faire ça en fonction des checkboxs
				// peut être faire des handlers pour les boxs => à voir }
			};

		});
	}
}
