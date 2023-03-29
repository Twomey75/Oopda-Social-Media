
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * A GUI that will simulate Social Media posts to test an application
 * to create ads.
 * 
 * @author Jack Myers
 *
 */
public class SocialMediaGUI extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	// GUI elements involved in actions
	/**
	 * JavaFX WebView into which social media posts will appear
	 */
	private WebView postFeed = new WebView();
	
	/**
	 * JavaFX WebView into which we will add relevant media objects (events, ads, quizzes)
	 */
	private WebView mediaFeed = new WebView();
	
	/**
	 * the engine for the WebView control that displays post.  Needed to interact with its content
	 */
	private WebEngine postEngine = postFeed.getEngine();
	
	/**
	 * the engine for the WebView control that displays media.  Needed to interact with its content
	 */
	private WebEngine mediaEngine = mediaFeed.getEngine();

	/**
	 * interactive label to show status
	 */
	private Label lblStatus = new Label("Post Feed Not Started...");
	
	/**
	 * interactive label to show status
	 */
	private Label lblMedia = new Label("Media Feed Not Started...");

	/**
	 * the number of posts to generate in simulation
	 */
	private static final int NUMBER_OF_POSTS = 12;

	/**
	 * the most used token.
	 */
	private Topic mostUsed = null;

	private boolean showMedia = true;
	private boolean generatingPosts = false;

	Image bacon = new Image("bacon", "A slice", "assets\\bacon.jpg", Topic.Bacon);
	Video toothpaste = new Video("Toothpaste", "Minty Fresh", "assets\\toothpaste.mp4", Topic.Toothpaste);
	
	/**
	 * the start method of the JavaFX GUI
	 */
	@Override
	public void start(final Stage mainStage) {
		HBox root = new HBox();     			// make container to hold controls
		styleMainPane(root);					// set the style of the main pane
		setupControls(root);                    // initialize and place controls
		Scene scene = new Scene(root,600,800); 	// Setup the main scene
		setStage(mainStage, scene);             // Finalize and show the stage 		
	}


	/**
	 * Add style to the main pane of the GUI
	 * 
	 * @param root	the root node of the stage
	 */
	private void styleMainPane(Pane root) {
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;" +
				"-fx-background-color: aliceblue");  		
	}
	
	/**
	 * Set up any controls not needed by the event handlers
	 * 
	 * @param mainPane 	the root node of the stage
	 */
	private void setupControls(Pane mainPane) {
		// Set properties of controls that are instance variables
		postFeed.setPrefHeight(800);
		postFeed.setPrefWidth(400);
		mediaFeed.setPrefHeight(800);
		mediaFeed.setPrefWidth(400);
		
		postEngine.setUserStyleSheetLocation("data:,body { font: 10px Arial; }");
		
		// Set label heights to allow multi-line labels
		lblStatus.setMinHeight(30);
		lblMedia.setMinHeight(30);
		
		// Create the Buttons and place in HBoxes
		Button btnStart = new Button("Start");
		Button btnClear = new Button("Clear");
		Button btnExit = new Button("Exit");	
		
		btnStart.setOnAction(event -> startFeed());
		btnClear.setOnAction(event -> {postEngine.loadContent(""); mostUsed = "";}); 
		btnExit.setOnAction(event -> Platform.exit());

		HBox buttonBox = new HBox(5, btnStart, btnClear, btnExit);

		// Create a box for the social media feeds
		VBox postBox = new VBox(5, this.lblStatus, buttonBox, this.postFeed);

		// Create a show media button
		Button btnShowMedia = new Button("Show Media");
		btnShowMedia.setOnAction(event -> showMedia());

		// Create a box for the media feed
		VBox mediaBox = new VBox(5, this.lblMedia, btnShowMedia, this.mediaFeed);

		// Add both VBoxes to the HBox (mainPane)
		mainPane.getChildren().add(postBox);
		mainPane.getChildren().add(mediaBox);
		
	}

	/** Sets up the stage and shows (launches) it
	 * 
	 * @param mainStage		the window to launch
	 * @param scene			the scene that holds the contents of the window (stage)
	 */
	private void setStage(Stage mainStage, Scene scene) {
    	mainStage.setTitle("A Social Media Simulation");
    	mainStage.setScene(scene);
    	mainStage.show();			
	}

	/**
	 * This is the method that will run as the action when the Start button is
	 * pressed. It will start a new Thread that will act independently of the
	 * Thread on which the GUI is running.
	 * 
	 */
	private void startFeed() {
		generatingPosts = true;
		// Create a task 
		Runnable task = new Runnable() {
			public void run() {
				runTaskToSimulatePosts();
			}
		};

		// Run the task in a background thread
		Thread backgroundThread = new Thread(task);
		// Terminate the running thread if the application exits
		backgroundThread.setDaemon(true);
		// Start the thread
		backgroundThread.start();
	}
	
	/**
	 * This method shows the most talked about media
	 */
	private void showMedia() {
		if(showMedia) {
			showMedia = false;
			Runnable task = new Runnable() {
				public void run() {
					mostFrequentTopic();
				}
			};

			// Run the task in a background thread
			Thread backgroundThread = new Thread(task);
			// Terminate the running thread if the application exits
			backgroundThread.setDaemon(true);
			// Start the thread
			backgroundThread.start();
		}
	}

	/**
	 * This method can help identify the most frequent topic in a social media post
	 */
	private void mostFrequentTopic() {
	
		if(generatingPosts) {
			for (int i = 0; i < 4; i++) {
				try {
					// Now, interact with controls on the JavaFx Application Thread
					Platform.runLater(new Runnable() {
						@Override 
						public void run() {
							String content = (String) postEngine.executeScript("document.documentElement.outerHTML");
							Topic tokenizer = Tokenizer.mostUsedTopic(content);
							String prevMedia = (String) mediaEngine.executeScript("document.documentElement.outerHTML");

							if(mostUsed == null || !mostUsed.equals(tokenizer)){
								mostUsed = tokenizer;
								mediaEngine.loadContent(prevMedia + toothpaste.getHtmlString());
							}
						}
					});

					// Take a 5-6 second break
					Thread.sleep(5000 + (int) (Math.random() * 1000));
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		else {
			showMedia = true;
		}
	}

	/**
	 * This method will use the PostGenerator to create a list of sample posts.
	 */
	private void runTaskToSimulatePosts() {
		// First get the ten postings
		ArrayList<Post> samplePosts = PostGenerator.generatePosts(NUMBER_OF_POSTS);
		for (int i = 0; i < NUMBER_OF_POSTS; i++) {
			try {
				// Get the Status
				String status = "Getting post " + (i+1) + " of " + NUMBER_OF_POSTS + " in thread " + 
								Thread.currentThread().getName();
				Post samplePost = samplePosts.get(i);
				
				// Now, interact with controls on the JavaFx Application Thread
				Platform.runLater(new Runnable() {
		            @Override 
		            public void run() {
		            	lblStatus.setText(status);
		            	String content = (String)
		            			postEngine.executeScript("document.documentElement.outerHTML");
						postEngine.loadContent(content + samplePost);
		            }
		        });

				// Take a 2-3 second break
				Thread.sleep(2000 + (int) (Math.random() * 1000));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/*******************************************************************/
	
	
}
