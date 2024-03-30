// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import Domain.ComandaConverter;
import Domain.EntityConverter;
import Domain.Tort;
import Domain.Comanda;
import Repository.IRepository;
import Repository.TextFileRepository;
import Repository.Repository;
import Repository.RepositoryTort;
import Repository.Settings;
import UI.UI;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.menu();
//        IRepository<Comanda> repo = null;
//        EntityConverter<Comanda> ec = new ComandaConverter();
//
//        Settings setari = Settings.getInstance();
//        System.out.println(setari.getRepoType());
//        if (Objects.equals(setari.getRepoType(), "memory")) {
//            repo = new Repository<Comanda>();
//        }
//
//        if (Objects.equals(setari.getRepoType(), "text")) {
//            repo = new TextFileRepository<>(setari.getRepoFile(), ec);
//        }

//        for(Comanda c : repo)
//        {
//            System.out.println(c);
//        }
    }


}