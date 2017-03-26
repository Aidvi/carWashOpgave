public class Main {
    public static void main(String[] args) {
        Operator test = new Operator();

        test.addWashCard(test.createWashCard());
        //test.addWashCard(test.createWashCard());
        //test.addWashCard(test.createWashCard());
        //test.addWashCard(test.createWashCard());
        //test.printCard();


        WashCard user = test.login();
        
        boolean valid = false;   
        while(!valid){
            String wash = test.chooseWash();
            if(wash.equals("")){
                System.out.println("Invalid wash chosen");
            }else{
                int washPrice =  WashType.getWashPrice(wash);
                if(user.getAmount()  -washPrice <= -200){
                    System.out.println("You dont have enough money for that, please choose another wash");
                } else {
                    user.withdraw(washPrice);
                    //user.writeToLog("User "+user.getName()+" has bought "+wash+" for "+washPrice);
                    valid = true;
                }
            }
        }   
    }
}