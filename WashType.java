public class WashType {

    public static int getWashPrice(String wash){
        int result = 0;
        if(wash.equals("SilverWash")){
            result = 200;
        }else if(wash.equals("GoldWash")){
            result = 300;
        }else if(wash.equals("CrystalWash")){
            result = 500;
        }

        return result;
    }
}