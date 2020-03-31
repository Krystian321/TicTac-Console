import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Witam w grze. Powodzenia !");
    int wymiar = 3;
    char obecnySymbol = 'X';
    char[][] plansza = new char[wymiar][wymiar];

    int liczbaRuchow = 0;
    boolean czyKontynuowac = true;
    while(czyKontynuowac && liczbaRuchow < wymiar * wymiar) {
        Main.drukujPlansze(plansza);
        boolean ruchPoprawny = wykonajRuch(plansza, obecnySymbol);


        if(ruchPoprawny) {
            liczbaRuchow++;
            boolean wygranaWiersze = sprawdzWiersze(plansza,obecnySymbol);
            boolean wygranaKolumny = sprawdzkolumny(plansza,obecnySymbol);
            boolean wygranaSkos1 = sprawdzSkos1(plansza,obecnySymbol);
            boolean wygranaSkos2 = sprawdzSkos2(plansza,obecnySymbol);

            if(wygranaKolumny || wygranaWiersze || wygranaSkos1 || wygranaSkos2){
                Main.drukujPlansze(plansza);
                System.out.print("Gratulacje Wygrałes " + obecnySymbol);
                czyKontynuowac = false;
            }


            if (obecnySymbol == 'X') {
                obecnySymbol = 'O';
            } else {
                obecnySymbol = 'X';
            }
        }
    }
    }
    public static boolean sprawdzSkos2(char[][] plansza, char symbol){
        int wymiar = plansza.length;

            for(int i = 0; i < wymiar; i++){
                if(plansza[i][wymiar - i - 1] != symbol){
                    return false;
                }
            }


        return true;
    }
    public static boolean sprawdzSkos1(char[][] plansza, char symbol){
        int wymiar = plansza.length;
        for(int i = 0; i < wymiar; i++){
            if(plansza[i][i] != symbol){
                return false;
            }
        }
        return true;
    }
    public static boolean sprawdzkolumny(char[][] plansza, char symbol){
        int wymiar = plansza.length;
        for(int kolumna = 0; kolumna < wymiar;kolumna++){
            boolean wygrana = true;
            for(int wiersz = 0; wiersz < wymiar; wiersz++){
                if(plansza[wiersz][kolumna] != symbol){
                    wygrana = false;
                    break;
                }
            }
            if(wygrana){
                return true;
            }
        }
        return false;
    }
    public static boolean sprawdzWiersze(char[][] plansza, char symbol){
        int wymiar = plansza.length;

        for(int wiersz = 0; wiersz < wymiar; wiersz++){
            boolean wygrana = true;
            for(int kolumna = 0; kolumna < wymiar; kolumna++){
                if(plansza[wiersz][kolumna] != symbol){
                    wygrana = false;
                    break;
                }

            }
            if(wygrana){
                return true;
            }

        }

        return false;
    }
    public static void drukujPlansze(char[][] plansza){
        int wymiar = plansza.length;

        System.out.print("\t");
        for(int i = 0; i < wymiar; i++){
            System.out.print(i + "\t");
        }
        System.out.println();
        for(int wiersz=0; wiersz < wymiar; wiersz++){
            System.out.print(wiersz);
            for(int kolumna = 0; kolumna < wymiar; kolumna++){
                System.out.print("\t" + plansza[wiersz][kolumna]);
            }
            System.out.println();
        }

    }
    public static boolean wykonajRuch(char[][] plansza , char symbol){
        System.out.println(symbol + " twoj ruch");
        System.out.print("Podaj numer wiersza: ");
        int wiersz = new Scanner(System.in).nextInt();
        System.out.print("Podaj numer kolumny: ");
        int kolumna = new Scanner(System.in).nextInt();
        boolean ruchPoprawny = plansza[wiersz][kolumna] == 0;
        if(!ruchPoprawny){
            System.out.println("Zły ruch!. Sprobuj jeszcze raz");
            return false;

        }
        plansza[wiersz][kolumna] = symbol;
        return true;

    }

}
