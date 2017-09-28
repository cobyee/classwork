package chatboxproject;

public class Chatbot {

	private String userName;
	private Topic coby;
	private boolean chatting;
	
	public Chatbot() {
		coby = new ChatboxCoby();
		userName = "unknown user";
		chatting = true;
	}
	
	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What do you want to talk about?");
			String response = ChatbotMain.getInput();
			if(coby.isTriggered(response)) {
				chatting = false;
				coby.startChatting();
			}else {
				ChatbotMain.print("I'm sorry. I don't understand.");
			}
		}
	}

}
