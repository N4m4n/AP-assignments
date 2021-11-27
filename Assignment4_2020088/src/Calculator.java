public class Calculator <T> {
    public T solve(T a, T b) throws IllegalArgumentException {
        if((a instanceof String) && (b instanceof String)){

            String res = a.toString()+b.toString();
            try{
                T toRet = (T) res;
                return toRet;
            }catch(ClassCastException cce){
                System.out.println("Sorry, there was an error in casting.");
            }
            
            

        }else if((a instanceof Integer) && (b instanceof Integer)){
            try{
                Integer frst = (Integer) a;
                Integer secnd = (Integer) b;
                Integer res = frst/secnd;
                T toRet = (T) res;
                return toRet;
            }catch(ClassCastException cce){
                System.out.println("Sorry, there was an error in calculation.");
            }catch(ArithmeticException ae){
                System.out.println(ae.getMessage()+": You cannot divide by 0");
            }
        }else{
            throw new IllegalArgumentException("The arguments entered are invalid.");
            
        }
        return null;
        
    }
}
