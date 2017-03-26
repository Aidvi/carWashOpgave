import java.util.ArrayList;
import java.util.Random;
public class Operator{
    
    ArrayList<WashCard> washCards = new ArrayList<WashCard>();
    public int washCount(){
        return this.washCards.size();
    }
    public void printCard(){
        for(int i = 0; i < this.washCount(); i++){
            WashCard currentWashCard = this.washCards.get(i);
            System.out.println(currentWashCard.getName() + "," + currentWashCard.getPin() + "," + currentWashCard.getAmount());
        }
    }
    public void addWashCard(WashCard card){
        this.washCards.add(card);
    }
    public WashCard createWashCard(){
        Random generator = new Random();
        String pin = String.format("%04d", generator.nextInt(10000));

        System.out.print("What is your name: ");
        String name = System.console().readLine();


        int amount = 0;
        while(amount > 1200 || amount <= 0){
            System.out.println("What amount would you like on your card? the amount should be between 0 - 1200$");
            String input = System.console().readLine();
            amount = Integer.parseInt(input);
        }

        if(this.washCount() != 0){
            for(int i = 0; i < this.washCount(); i++){
                if(this.washCards.get(i).getPin().equals(pin)){
                    pin = String.format("%04d", generator.nextInt(10000));
                }
            }
        }

        WashCard card = new WashCard(name, pin, amount);

        System.out.println("Hello "+card.getName()+", you have "+card.getAmount()+"$, and your pin is "+card.getPin());
        System.out.println("");

        return card;
    }
    public String chooseWash(){
        System.out.println("What kind of wash would you like on your car?:");
        String input = System.console().readLine();

        if(input.equalsIgnoreCase("SilverWash")){
            return "SilverWash";
        }
        if(input.equalsIgnoreCase("GoldWash")){
            return "GoldWash";
        }
        if(input.equalsIgnoreCase("CrystalWash")){
            return "CrystalWash";
        }
        return "";
    }
   public WashCard login(){
        String input = null;
        WashCard user = new WashCard();
        Boolean foundUser = false;
        while(!foundUser){
            System.out.println("Please write your pin code ");
            input = System.console().readLine();
            for(int i = 0; i < this.washCount(); i++){
                if(input.equals(this.washCards.get(i).getPin())){
                    user = this.washCards.get(i);
                    foundUser = true;
                }
            }
        }
        return user;
    }
}