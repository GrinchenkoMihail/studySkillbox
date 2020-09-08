public class Main {
    public static void main(String[] args) {
        String[][] arrX = new String[7][7];
        for(int i =0;i<arrX.length;i++){
            for(int j =0; j< arrX.length;j++){
                arrX[i][j]=" ";
            }
        }
        for (int i = 0; i < arrX.length / 2+1; i++) {
            arrX[i][i] = "X";
            arrX[i][arrX.length - i - 1] = "X";
            arrX[arrX.length - i - 1][i] = "X";
            arrX[arrX.length - i - 1][arrX.length - i - 1] = "X";
        }
        for (String[] strAr : arrX) {
            for (String str : strAr) {
                System.out.print(str);
            }
            System.out.println("\n");
        }
    }
}





