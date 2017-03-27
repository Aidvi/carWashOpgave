
public class Main {
    public static void main(String[] args) {
        Operator test = new Operator();
        WashCard printer = new WashCard();

        test.addWashCard(test.createWashCard());
        //test.addWashCard(test.createWashCard());
        //test.addWashCard(test.createWashCard());
        //test.addWashCard(test.createWashCard());
        //test.printCard();


        Main.test(test);
        //Main.test(test);
        printer.printLog();
    }

    public static void test(Operator test){
        WashCard user = test.login();
        
        boolean valid = false;   
        while(!valid){
            String wash = test.chooseWash();
            if(wash.equals("")){
                System.out.println("Invalid wash chosen");
            }else{
                int washPrice = WashType.getWashPrice(wash);
                if(user.getAmount()  -washPrice <= -200){
                    System.out.println("You dont have enough money for that, please choose another wash");
                } else {
                    user.withdraw(washPrice);
                    user.writeToLog(user.getName(), wash, washPrice);
                    if(user.receipt().equalsIgnoreCase("Yes")){
                        System.out.println(user.getName() + " has bought " + wash + " for " + washPrice + "$");
                        System.out.println(washPrice + "$" + " has been charged from your account, have a nice day");
                        valid = true;
                    } else { 
                        valid = true;
                    }
                }
            }
        } 
    }
}