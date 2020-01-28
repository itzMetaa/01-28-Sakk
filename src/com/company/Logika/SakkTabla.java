package com.company.Logika;

public class SakkTabla {
    private int[][] tabla;

    public SakkTabla() {
        this.tabla = new int[][]{
                {22, 23, 24, 25, 26, 24, 23, 22},
                {21, 21, 21, 21, 21, 21, 21, 21},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {11, 11, 11, 11, 11, 11, 11, 11},
                {12, 13, 14, 15, 16, 14, 13, 12}
        };
    }

    public int getErtek(int x, int y){
        return this.tabla[x][y];
    }

    public void lep(int sx, int sy, int dx, int dy){
        this.tabla[dx][dy] = this.tabla[sx][sy];
        this.tabla[sx][sy] = 0;
    }

    public boolean isKivalasztottFigura(int x, int y, int figura){
        return this.tabla[x][y] == figura;
    }

    public boolean isUresHely(int x, int y){
        return isKivalasztottFigura(x,y,0);
    }

    public boolean isFigura(int x, int y){
        return !isUresHely(x,y);
    }

    public boolean isVilagosFigura(int x, int y){
        return this.tabla[x][y] >= 11 && this.tabla[x][y] <= 16;
    }

    public boolean isSotetFigura(int x, int y){
        return this.tabla[x][y] >= 21 && this.tabla[x][y] <= 26;
    }

    public int getFigurakSzama(int m, int n){
        int db = 0;
        for (int i=0; i<8; i++){
            for (int j = 0; j < 8; j++) {
                if(this.tabla[i][j] >= m && this.tabla[i][j] <= n){
                    db++;
                }
            }
        }
        return db;
    }

    public int getVilagosFigurakSzama(){
        return getFigurakSzama(11,16);
    }

    public int getsotetFigurakSzama(){
        return getFigurakSzama(21,26);
    }

    public int getFigurakSzama(){
        return getVilagosFigurakSzama() + getsotetFigurakSzama();
    }

    public boolean isErvenyesLepes(int sx, int sy, int dx, int dy){
        return true;
    }

    public boolean isMatt(){
        return true;
    }

    public boolean isSakk(){
        return true;
    }

}
