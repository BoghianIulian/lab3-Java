package Tests;

import Domain.Comanda;
import Domain.EntityConverter;
import Domain.Tort;
import Domain.TortConverter;
import Repository.IRepository;
import Repository.Repository;
import Repository.DuplicateObjectException;
import Repository.TextFileRepository;
import Repository.RepositoryException;
import org.junit.Test;

import java.util.ArrayList;

public class TestRepo {
    @Test
    public void testMemoryRepo() {
        IRepository<Comanda> repoComanda = new Repository<Comanda>();
        ArrayList<Tort> lista_tort = new ArrayList<>();
        Tort t1 = new Tort(1, "Cioco");
        Tort t = new Tort(2, "vani");
        lista_tort.add(t1);
        lista_tort.add(t);
        Comanda c = new Comanda(10, lista_tort);
        ArrayList<Tort> lista_tortn = new ArrayList<>();
        Tort t2 = new Tort(3, "zmeura");
        lista_tortn.add(t2);
        try {
            repoComanda.addElem(c);
        } catch (DuplicateObjectException e) {
            assert false;
        }
        try{
            repoComanda.addElem(c);
        }catch (DuplicateObjectException e){
            assert true;
        }
        try {
            Comanda comanda = repoComanda.getById(10);
            assert comanda.getLista().size()==2;
        }catch (RepositoryException e){
            assert false;
        }
        assert repoComanda.findById(10) ;
        try{
            repoComanda.updateElem(c,new Comanda(11,lista_tortn));
            assert repoComanda.getSize()==1;
        }catch (RepositoryException e){
            assert false;}
        try {
            repoComanda.removeElem(11);
            assert repoComanda.getSize() == 0;
        }catch (RepositoryException e){
            assert false;
        }

    }

    @Test
    public void testFileRepo()
    {
        EntityConverter<Tort> ecTort = new TortConverter();
        IRepository<Tort> repoTort = new TextFileRepository<>("C:\\Users\\Iulian\\Desktop\\MAP\\lab2\\lab2\\src\\Tests\\tortTest.txt",ecTort);
        assert repoTort.getSize()==2;
        try{
            Tort t1 = repoTort.getById(1);
            assert "Cioco".equals(t1.getTip());
        }catch (RepositoryException e){
            assert false;
        }
        try {
            repoTort.addElem(new Tort(3,"Zmeura"));
            assert repoTort.getSize()==3;
        }catch (DuplicateObjectException e){
            assert false;
        }
        try {
            Tort t2 = repoTort.getById(3);
            repoTort.updateElem(t2,new Tort(3,"Banane"));
            t2=repoTort.getById(3);
            assert "Banane".equals(t2.getTip());
        }catch (RepositoryException e){
            assert false;
        }
        try {
            repoTort.removeElem(3);
            assert repoTort.getSize()==2;
        }catch (RepositoryException e){
            assert false;
        }
    }

}
