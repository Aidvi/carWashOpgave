import java.util.ArrayList;
public class WashCard {
    private String name;
    private String pin;
    private int amount;

    private static ArrayList<String> paymentLog = new ArrayList<>();
    
    public WashCard(String name,String pin, int amount){
        this.name = name;
        this.pin = pin;
        this.amount = amount;
    }
    public WashCard(){
    }
    public String getName(){
        return this.name;
    }
    public String getPin(){
        return this.pin;
    }
    public int getAmount(){
        return this.amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }

    public void withdraw(int price){
        this.setAmount(this.getAmount() - price);
    }
    public void writeToLog(String name, String wash, int washPrice){
        String price = String.valueOf(washPrice);
        this.paymentLog.add(name+" bought "+ wash +" for "+price+"$");
    }
    public int logCount(){
        return WashCard.paymentLog.size();
    }
    public void printLog(){
        for(int i = 0; i < this.logCount(); i++){
            System.out.println("Payment History: " + WashCard.paymentLog.get(i));
        }
    }
    public String receipt(){
        System.out.println("Would you like a receipt?: ");
        String answer = System.console().readLine();
        return answer;
    }
}