public class WashCard {
    private String name;
    private String pin;
    private int amount;
    
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
}