import java.util.*;
import java.io.*;

class MainMenu
{
  public void menu()
  {
    System.out.println("\t\t*******************************************");
    System.out.println("\t\t\t  GESTION DES UTILISATEURS");
    System.out.println("\t\t*******************************************");
    
    System.out.println("\n\nPress 1 : Pour ajouter des utilisateurs");
    System.out.println("Press 2 : Pour voir les utlistaeurs ");
    System.out.println("Press 3 : Pour supprimer un utilisateur");
    System.out.println("Press 4 : Pour modifeir un utilisateur");
    System.out.println("Press 5 : Pour quitter");

  }
}


class AjouterUtilisateur
{
    public void createFile()
    {
        Scanner sc=new Scanner(System.in);

        DetailUser user=new DetailUser();
        user.getInfo();
        try{
            File f1=new File("file"+user.user_id+".txt");
            if(f1.createNewFile()){
                FileWriter myWriter = new FileWriter("file"+user.user_id+".txt");
                myWriter.write("ID utilisateur:"+user.user_id+"\n"+"Nom de l'utilisateur     :"+user.nom+"\n"+
                "Prenom utilisateur     :"+user.prenom+"\n"+"Role de l'utilisateur  :"+user.roles+"\n"+);
                myWriter.close();
                System.out.println("\nUtilisateur a été ajouter :)\n");

                System.out.print("\nAppuies sur entrer pour continuer..");
                sc.nextLine();
            }
            else {
                System.out.println("\nL'utilisateur existe déja :(");
                System.out.print("\nAppuies sur entrer pour continuer...");
                sc.nextLine();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}



class DetailUser
{
    String nom;
    String prenom;
    String roles;
    public void getInfo()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Entrer un ID----------: ");
        user_id=sc.nextLine();
        System.out.print("Entrer un nom  --------: ");
        nom=sc.nextLine();
        System.out.print("Entrer un prenom -: ");
        prenom=sc.nextLine();
        System.out.print("Entrer un role ----: ");
        roles=sc.nextLine();
        
    }
}



class User_Show
{
  public void viewFile(String s) throws Exception
  {
    File file = new File("file"+s+".txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine())
     {
       System.out.println(sc.nextLine());
     }
   }
}



class User_Remove
{
    public void removeFile(String ID)
    {

    File file = new File("file"+ID+".txt");
      if(file.exists())
       {
         if(file.delete());
         {
           System.out.println("\nUtilisateur supprimer avec succés");
         }
       }
      else
       {
            System.out.println("\nL'utilisateur n'existe pas :( ");
       }
     }
}



class User_Update
{
  public void updateFile(String s,String o,String n) throws IOException
  {
   File file = new File("file"+s+".txt");
   Scanner sc = new Scanner(file);
   String fileContext="";
   while (sc.hasNextLine())
       {
         fileContext =fileContext+"\n"+sc.nextLine();
       }
   FileWriter myWriter = new FileWriter("file"+s+".txt");
   fileContext = fileContext.replaceAll(o,n);
   myWriter.write(fileContext);
   myWriter.close();

  }
}


class GestionUtilisateur
{
  public static void main(String arv[])
  {
    System.out.print("\033[H\033[2J");

    Scanner sc=new Scanner(System.in);
    User_Show epv =new User_Show();

    int i=0;

    MainMenu obj1 = new MainMenu();
    obj1.menu();

    while(i<6)
    {

      System.out.print("\nPlease Enter choice :");
      i=Integer.parseInt(sc.nextLine());

      switch(i)
      {
        case 1:
        {
        AjouterUtilisateur ep =new AjouterUtilisateur();
        ep.createFile();

        System.out.print("\033[H\033[2J");
        obj1.menu();
        break;
        }
        case 2:
        {
          System.out.print("\nEntrez l'ID de l'utilisateur s'il vous plait :");
          String s=sc.nextLine();
          try
          {
            epv.viewFile(s);}
            catch(Exception e){System.out.println(e);}


            System.out.print("\nAppuyez sur entrer pour continuer...");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            obj1.menu();
            break;
          }

        case 3:
        {
          System.out.print("\nEntrez l'ID de l'utilisateur s'il vous plait :");
          String s=sc.nextLine();
          Employee_Remove epr =new Employee_Remove();
          epr.removeFile(s);

          System.out.print("\nAppuyez sur entrer pour continuer...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }
        case 4:
        {
            System.out.print("\nEntrez l'ID de l'utilisateur s'il vous plait :");
            String I=sc.nextLine();
            try
            {
              epv.viewFile(I);
            }
            catch(Exception e)
            {
              System.out.println(e);
            }
            User_Update epu = new User_Update();
            System.out.print("Saisir le nom pour pouvoir modifier :");
    	      System.out.print("\nPar exemple :\n");
            System.out.println("Si tu veux changer le nom, il faut saisir le nom à changer puis appuyer sur entrer. Et puis saisir le nouveau nom.\n");
            String s=sc.nextLine();
            System.out.print("Appuyez sur entrer pour modifier:");
            String n=sc.nextLine();
            try
            {
              epu.updateFile(I,s,n);

              System.out.print("\nAppuyez sur entrer pour continuer...");
              sc.nextLine();
              System.out.print("\033[H\033[2J");
              obj1.menu();
              break;
            }
            catch(IOException e)
            {
              System.out.println(e);
            }
        }
        case 5:
        {
          CodeExit obj = new CodeExit();
          obj.out();
        }
      }
    }
  }
}

