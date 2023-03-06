public class main {
    public static void main(String[] args) {
        String x = "pjatk";
        String[] xTab = x.split("");
        String y = "abcdefghijklmnopqrstuvwxyz";
        String[] yTab = y.split("");
        int m = x.length();
        int n = y.length();

        int[][] c = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            c[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            c[0][j]=0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(xTab[i-1].equals(yTab[j-1])){
                    c[i][j]=c[i-1][j-1]+1;
                }
                else {
                    if(c[i-1][j]>=c[i][j-1]){
                        c[i][j]=c[i-1][j];
                    }
                    else {
                        c[i][j]=c[i][j-1];
                    }
                }
            }
        }
        int wynik = n-c[m][n];
        System.out.println("Trzeba dopisać "+ wynik + " znaków/znaki/znaks");

    }
}
