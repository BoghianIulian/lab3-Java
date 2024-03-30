package UI;

import Domain.Comanda;
import Domain.Tort;
import Repository.DuplicateObjectException;
import Repository.RepositoryException;
import Repository.Settings;
import Service.ServiceComanda;
import Service.ServiceTort;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private ServiceTort serviceT = new ServiceTort();
    private ServiceComanda serviceC =  new ServiceComanda();


    public void addTort()
    {
        try {
            int id;
            String tip;
            System.out.println("Id tort:");
            Scanner cin = new Scanner(System.in);
            id = cin.nextInt();
            System.out.println("Tip tort");
            tip = cin.next();
            serviceT.addTort(id,tip);
            System.out.println("Tortul a fost adaugat");
        }
        catch (DuplicateObjectException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void addComanda()
    {
        try{
            int idC,idT,nr;
            ArrayList<Tort> lista = new ArrayList<Tort>();
            Scanner cin = new Scanner(System.in);
            System.out.println("ID comanda:");
            idC = cin.nextInt();
            System.out.println("Nr de torturi pt aceasta comanda");
            nr = cin.nextInt();
            for(int i=0;i<nr;i++)
            {
                System.out.println("Torturi disponibile:");
                afisareTort();
                System.out.println("ID tort de comandat");
                idT = cin.nextInt();
                Tort t1 = serviceT.getByYd(idT);
                lista.add(t1);
            }
            serviceC.addComanda(idC,lista);
            System.out.println("Comanda a fost adaugata");

        }
        catch (RepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void removeComanda()
    {
        try
        {
            int id;
            System.out.println("Id comanda:");
            Scanner cin = new Scanner(System.in);
            id = cin.nextInt();
            serviceC.removeComanda(id);
            System.out.println("Comanda a fost stearsa");
        }
        catch (RepositoryException e)
        {
            System.out.println();
        }

    }

    public void updateComanda()
    {
        try
        {
            int id1,id2,nr,idT;
            ArrayList<Tort> lista = new ArrayList<Tort>();
            System.out.println("Id comanda de modificat:");
            Scanner cin = new Scanner(System.in);
            id1 = cin.nextInt();
            System.out.println("ID comanda noua");
            id2 = cin.nextInt();
            System.out.println("Nr de torturi pt aceasta comanda");
            nr = cin.nextInt();
            for(int i=0;i<nr;i++)
            {
                System.out.println("Torturi disponibile:");
                afisareTort();
                System.out.println("ID tort de comandat");
                idT = cin.nextInt();
                Tort t1 = serviceT.getByYd(idT);
                lista.add(t1);
            }
            serviceC.updateComanda(id1 , id2 ,lista);
        }
        catch (RepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }



    public void addFive()
    {
        try {
            serviceT.addTort(1,"Ciocolata");
            serviceT.addTort(2,"Vanilie");
            serviceT.addTort(3,"Capsuni");
            serviceT.addTort(4,"Zmeura");
            serviceT.addTort(5,"Banane");
            System.out.println("Cele 5 torturi au fost adaugate");
        }
        catch (DuplicateObjectException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void removeTort()
    {
        try {
            int id;
            System.out.println("Id tort:");
            Scanner cin = new Scanner(System.in);
            id = cin.nextInt();
            serviceT.removeTort(id);
            System.out.println("Tortul a fost sters");
        }
        catch (RepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void updateTort()
    {
        try
        {
            int id1,id2;
            String tip;
            System.out.println("Id tort de modificat:");
            Scanner cin = new Scanner(System.in);
            id1 = cin.nextInt();
            System.out.println("Id tort nou:");
            id2 = cin.nextInt();
            System.out.println("Tip tort nou:");
            tip = cin.next();
            Tort t1 =serviceT.getByYd(id1);
            serviceT.updateTort(id1 , id2 , t1.getTip() , tip);
        }
        catch (RepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void afisareTort()
    {
        try {
            for (Tort t : serviceT.getAllT()) {
                System.out.println(t);
            }
        }
        catch (RepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void afisareComanda()
    {
        try {
            for (Comanda c: serviceC.getAllT())
            {
                System.out.println(c);
            }
        }
        catch (RepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }



    public void optiuniTort()
    {
        System.out.println("1.Adauga tort");
        System.out.println("2.Sterge tort");
        System.out.println("3.Modifica tort");
        System.out.println("4.Adauga 5 torturi");
        System.out.println("5.Afiseaza torturi");
        System.out.println("6.Adauga comanda");
        System.out.println("7.Sterge comanda");
        System.out.println("8.Modifica comanda");
        System.out.println("9.Afiseaza comenzi");
        System.out.println("0.Inchide program");
    }

    public void menu()
    {
        boolean isTrue=true;
        while (isTrue)
        {
            optiuniTort();
            int opt;
            Scanner cin = new Scanner(System.in);
            System.out.println("Optiunea ta:");
            opt = cin.nextInt();
            switch (opt)
            {
                case 1:
                    addTort();
                    break;
                case 2:
                    removeTort();
                    break;
                case 3:
                    updateTort();
                    break;
                case 4:
                    addFive();
                    break;
                case 5:
                    afisareTort();
                    break;
                case 0:
                    isTrue = false;
                    break;
                case 6:
                    addComanda();
                    break;
                case 7:
                    removeComanda();
                    break;
                case 8:
                    updateComanda();
                    break;
                case 9:
                    afisareComanda();
                    break;

            }
        }
    }

}
