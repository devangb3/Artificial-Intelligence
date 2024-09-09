import java.util.*;
public class ChatBot{
    Scanner sc = new Scanner(System.in);
    HashMap<String,String> knowledgeBase= new HashMap<String,String>();
    public ChatBot() {
        knowledgeBase.put("hey", "hello");
        knowledgeBase.put("red", "Good");
    }
    public void answer(String question) {
        Set<String> keys = knowledgeBase.keySet();
        for(String key:keys) {
            String lowerKey = key.toLowerCase();
            String lowerQuestion = question.toLowerCase();
            if(lowerKey.contains(lowerQuestion)) {
                System.out.println("SPD : "+ knowledgeBase.get(key));
                return;
            }
        }
        if(!question.equalsIgnoreCase(question)) {
            trainMe(question);
        }
        else {
            stop();
        }
    }
    public void stop() {
        System.out.println("SPD : Bye");
        sc.close();
    }
    public void trainMe(String question) {
        System.out.println("Specify correct answer please");
        System.out.println("User suggestion : ");
        String userInput = sc.nextLine();
        knowledgeBase.put(question, userInput);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        ChatBot chatbot = new ChatBot();
        while(!userInput.equalsIgnoreCase("bye")) {
            System.out.println("User : " + "\n");
            userInput = sc.nextLine();
            chatbot.answer(userInput.toLowerCase());
        }
        sc.close();
    }
}