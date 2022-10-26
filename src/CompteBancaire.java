import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Scanner;

public class CompteBancaire {
    private String nom;
    private double solde=0.0;
    private long numero;
    private static long nbreComptes=0;

    public CompteBancaire(String nom) {
        this.nom = nom;
        this.numero=++nbreComptes;
    }
    // interractive constructor
    public CompteBancaire() {
         Scanner scanner=new Scanner(System.in);
         //String  input_user="";
        System.out.println("Enter votre nom :") ;
        this.nom= scanner.next();
        this.solde=0.0;
        this.numero=++nbreComptes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public static long getNbreComptes() {
        return nbreComptes;
    }

    public static void setNbreComptes(long nbreComptes) {
        CompteBancaire.nbreComptes = nbreComptes;
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "nom='" + nom + '\'' +
                ", solde=" + solde +
                ", numero=" + numero +
                '}';
    }
    // la methode verser sans arguments
    public void verser(){
        double mantant;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter le solde à verser :");
        mantant=scanner.nextDouble();
        this.verser(mantant);
    }
    public void verser(double mantant){
        this.solde+=mantant;
    }
    public void retirer(double mantant ){
        // check if the amount is enought
        if(mantant>this.solde){
            // indicate that's the amount isn't enought to get money
            System.out.println("Le solde est insiffisante !!");
        }
        else{
            this.solde-=mantant;
        }
    }
    public void retirer(){
        double mantant;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter le solde à retirer :");
        mantant=scanner.nextDouble();
        this.retirer(mantant);
    }
    // Le men des Operations
    public void menu(){

        System.out.println("\n***************** Le menu du compte num°"+this.getNumero()+"*****************************\n");
        System.out.println("afficher .... a");
        System.out.println("Verser .......v");
        System.out.println("Retirer.......r");
        System.out.println("Quiter........q");
        System.out.println("\n********************************************************\n");


    }
    // Operations
    public  void operations(){
        char choix=' ' ;
        Scanner scanner=new Scanner(System.in);
        do {
            this.menu();
            System.out.println("Saisir l'operation ! :");
            choix=scanner.next().charAt(0);
            switch (choix) {
                case 'a':
                    System.out.println(this);
                    break;
                case 'v':
                    this.verser();
                    break;
                case 'r':
                    this.retirer();
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Operation  Invalide !!!");

            }
        }while (choix!='q');
    }
}
