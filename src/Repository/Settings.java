package Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static Settings instance;

    private String repoType;

    private final String repoFile;

    private Settings(String repoType , String repoFile)
    {
        this.repoFile = repoFile;
        this.repoType = repoType;
    }

    public String getRepoType(){
        return repoType;
    }
    public String getRepoFile()
    {
        return repoFile;
    }

    private static Properties loadSettings()
    {
        try(FileReader fr = new FileReader("C:\\Users\\Iulian\\Documents\\GitHub\\a3-BoghianIulian\\src\\Repository\\settings.properties"))
        {
            Properties settings = new Properties();
            settings.load(fr);
            return settings;
        }catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static synchronized Settings getInstance(){
        Properties properties = loadSettings();
        instance = new Settings(properties.getProperty("repo_type"),properties.getProperty("repo_file"));
        return instance;
    }
}
