package Tests;



import Domain.Tort;
import Repository.DuplicateObjectException;
import Repository.RepositoryException;
import Service.ServiceComanda;
import Service.ServiceTort;
import org.junit.Test;

import java.util.ArrayList;


public class TestService {
    @Test
    public void serviceTort()
    {
        ServiceTort serviceTort = new ServiceTort();
        boolean thrown = false;
        try {
            serviceTort.addTort(7, "cioco");
            assert serviceTort.getAllT().size() == 6;
        }
        catch (RepositoryException e){
            thrown= true;
        }
        assert thrown == false;
        try {
            serviceTort.removeTort(7);
            assert serviceTort.getAllT().size() ==5;
        }
        catch (RepositoryException e){
            thrown = true;
        }
        assert thrown == false;
        try {
            serviceTort.removeTort(7);
        }
        catch (RepositoryException e){
            thrown = true;
        }
        assert thrown ==true;

    }

    @Test
    public void serviceComanda()
    {
        ServiceComanda serviceComanda = new ServiceComanda();
        try {
            assert serviceComanda.getAllT().size()==2;
        }
        catch (RepositoryException e)
        {
            assert false;
        }
        ArrayList<Tort> lista_tort = new ArrayList<>();
        Tort t1 = new Tort(6, "Cioco");
        Tort t = new Tort(7, "vani");
        lista_tort.add(t1);
        lista_tort.add(t);

        try {
            serviceComanda.addComanda(10,lista_tort);
            assert serviceComanda.getAllT().size()==3;
        }
        catch (RepositoryException e){
            assert false;
        }
        try {
            serviceComanda.removeComanda(10);
            assert serviceComanda.getAllT().size()==2;
        }
        catch (RepositoryException e)
        {
            assert false;
        }
    }
}
