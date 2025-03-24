package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader
{
    private Properties getData(String filName)
    {
        ClassLoader classLoader=getClass().getClassLoader();
        File file=new File(classLoader.getResource(filName+".properties").getFile());
        FileInputStream fileInputStream=null;
        try {
            fileInputStream =new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties=new Properties();
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public String getProperty(String fileName,String key)
    {
        return getData(fileName).getProperty(key);
    }
}
