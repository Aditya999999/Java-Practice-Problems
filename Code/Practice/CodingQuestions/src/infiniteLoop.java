public class infiniteLoop {
    public static void main(String[] args) {
        for(int i = 0; ;i++){
            System.out.println("this is "+ i);
            if(i == 4){
                break;
            }
        }
    }
}
