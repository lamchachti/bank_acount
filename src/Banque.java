import java.util.Arrays;
import java.util.Scanner;

public class Banque {
    private int MAX =0;
    private int nombreComptes=0;
    CompteBancaire comptes[];

    public Banque(int MAX ) {
        this.MAX = MAX;
        this.comptes=new CompteBancaire[MAX];
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
    }

    public int getNombreComptes() {
        return nombreComptes;
    }

    public void setNombreComptes(int nombreComptes) {
        this.nombreComptes = nombreComptes;
    }

    public CompteBancaire[] getComptes() {
        return comptes;
    }

    public void setComptes(CompteBancaire[] comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.comptes);
    }

    /* la méthode chercher : chercher un compte par son numero */

    private int chercherParNumero(long numero ){
        CompteBancaire compte;
        for(int i=0 ; i<this.MAX ; i++){
            if (comptes[i]!=null && comptes[i].getNumero()==numero ){
                return i;
            }
        }
        return -1;
    }

    /* les operations Banque */
    public  void operations(){
        char choix=' ' ;
        long numero;
        int index;
        Scanner scanner=new Scanner(System.in);
        do {
            this.menu();
            System.out.println("Saisir l'operation ! :");
            choix=scanner.next().charAt(0);
            switch (choix) {
                case 'c':
                    if (nombreComptes<MAX){
                        comptes[nombreComptes++]=new CompteBancaire();
                    }
                    else {
                        System.out.println("On ne peut pas vous créer un compte");
                    }
                    break;
                case 'l':
                    System.out.printf(this.toString());
                    break;
                case 'o':
                    System.out.printf("Enter le numero du compte :");
                    numero=scanner.nextLong();
                    if ((index=chercherParNumero(numero))!=-1){
                        comptes[index].operations();
                    }
                    else{
                        System.out.println("Compte Introuvable!");
                    }
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Operation  Invalide !!!");

            }
        }while (choix!='q');
    }
    /* menu Banque */
    public void menu(){

        System.out.println("\n***************** Le menu du banque *****************************\n");
        System.out.println("Créer un nouveau compte .... c");
        System.out.println("Lister .......l");
        System.out.println("Opérations.......o");
        System.out.println("Quiter........q");



    }
}
