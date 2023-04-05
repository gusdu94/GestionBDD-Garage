import com.mysql.cj.conf.PropertyDefinitions;
import dao.VoitureDao;
import models.Voiture;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            boolean menu = true;
            Database database = new Database("jdbc:mysql://localhost:3306/", "garage", "root", "");
            VoitureDao VoitureDao = new VoitureDao(database.getConnection());
            while(menu) {
                List<Voiture> Voitures = VoitureDao.getVoiture();
                System.out.println("Quel est votre choix?");
                System.out.println("1 : Afficher le garage");
                System.out.println("2 : Ajouter des voitures");
                System.out.println("3 : Modifier des voitures");
                System.out.println("4 : Retirer des voitures");
                System.out.println("5 : Exit");
                String xMenuOn = utils.saisieString();
                switch (xMenuOn) {
                    case "1":
                        for (Voiture Voiture : Voitures) {
                            System.out.println(Voiture.getMarque());
                            System.out.println(Voiture.getModel());
                            System.out.println(Voiture.getEtat());
                            System.out.println(Voiture.getDate());
                            System.out.println(Voiture.getCouleur());
                            System.out.println();
                        }
                        break;
                    case "2":
                        System.out.println("De quel marque est la voiture que vous voulez ajouter?");
                        String marque = utils.saisieString();
                        System.out.println("quel est le model de la voiture?");
                        String model = utils.saisieString();
                        System.out.println("Quel est l'état de la voiture?");
                        String Etat = utils.saisieString();
                        System.out.println("Quand l'avez vous obtenu?");
                        String date = utils.saisieString();
                        System.out.println("De quel couleur est la voiture?");
                        String couleur = utils.saisieString();
                        VoitureDao.setVoiture(marque, model, Etat, date, couleur);
                        break;
                    case"3":
                        for (Voiture Voiture : Voitures) {
                            System.out.print(Voiture.getID() + " ");
                            System.out.print(Voiture.getMarque() + " ");
                            System.out.print(Voiture.getModel());
                            System.out.println(" ");
                        }
                        System.out.println("Quelle voiture voulez vous modifiez ?");
                        String update = utils.saisieString();
                        System.out.println("Que voulez vous modifier?");
                        System.out.println("1. La marque");
                        System.out.println("2. Le model");
                        System.out.println("3. La couleur");
                        System.out.println("4. La date");
                        System.out.println("5. L'etat");
                        String column = utils.saisieString();
                        System.out.println(column);
                        System.out.println("Par quoi voulez-vous modifier?");
                        String modif = utils.saisieString();
                        switch (column) {
                            case"1":
                                VoitureDao.UpdateVoiture("Marque",update,modif);
                                break;
                            case"2":
                                VoitureDao.UpdateVoiture("Model",update,modif);
                                break;
                            case"3":
                                VoitureDao.UpdateVoiture("Couleur",update,modif);
                                break;
                            case"4":
                                VoitureDao.UpdateVoiture("Date",update,modif);
                                break;
                            case"5":
                                VoitureDao.UpdateVoiture("Etat",update,modif);
                                break;
                        }
                        break;
                    case "4":
                        for (Voiture Voiture : Voitures) {
                            System.out.print(Voiture.getID() + " ");
                            System.out.print(Voiture.getMarque() + " ");
                            System.out.print(Voiture.getModel());
                            System.out.println(" ");
                        }
                        System.out.println("Quelle voiture voulez vous supprimez ?");
                        String delet = utils.saisieString();
                        VoitureDao.DeletVoiture(delet);
                        break;
                    case"5":
                        menu = false;
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}