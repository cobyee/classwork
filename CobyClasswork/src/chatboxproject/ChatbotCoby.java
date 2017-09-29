package chatboxproject;

public class ChatbotCoby implements Topic {

	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatbotCoby() {
		String[] temp = {"food","entertainment","Internet","videogames"};
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "pug";
	}
	
	@Override
	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyWord(response, keywords[i], 0) >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void startChatting(String response) {
		ChatbotMain.print("Hey! It sounds like you and I have common interests! Let's talk some more!");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyWord(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else {
				if(ChatbotMain.findKeyWord(response, secretWord, 0) >= 0) {
					ChatbotMain.print("Oh my goodness! You guessed my favorite thing ever. We are friends now.");
				} else {
					ChatbotMain.print("Huh. I don't really get you. Tell me something else?");
				}
			}
		}
	}
}