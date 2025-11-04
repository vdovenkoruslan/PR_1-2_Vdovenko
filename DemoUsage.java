public class DemoUsage {

    
    public static String numberToHex(Integer i) {
        return "0x" + Integer.toHexString(i).toUpperCase();
    }


    
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }



    public static void main(String[] args) {
  
        

        DataTransformer<Integer, String> intToString = (i) -> "Число: " + (i * 10);
        

        System.out.println(intToString.transform(5)); 
        intToString.logInput(5); 



        

        DataTransformer<Integer, String> staticRef = DemoUsage::numberToHex;
        System.out.println(staticRef.transform(255)); 

   
        DemoUsage demo = new DemoUsage();
       

        DataTransformer<String, String> instanceRef = demo::reverseString;
        System.out.println(instanceRef.transform("Java 8")); 



        System.out.println("Чи 'test' не null? " + DataTransformer.isNotNull("test"));
    }
}


