package Tests;

import Domain.Comanda;
import Domain.Tort;
import org.junit.Test;

import java.util.ArrayList;

public class TestEntity {

    @Test
    public void testTort(){
        Tort t = new Tort(1,"Cioco");
        assert t.getId() == 1;
        assert "Cioco".equals(t.getTip());
    }

    @Test
    public void testComanda(){
        ArrayList<Tort> lista_tort = new ArrayList<>();
        Tort t1 = new Tort(1,"Cioco");
        Tort t = new Tort(2,"vani");
        lista_tort.add(t1);
        lista_tort.add(t);
        Comanda c = new Comanda(10,lista_tort);
        assert c.getId() == 10;
        assert c.getLista().size()==2;
    }

}
