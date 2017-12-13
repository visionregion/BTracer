import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Properties;

public class BTracer {
    public static void main (String[] args) {
        String aclLine;
        String path="";
        String findWord;
        String sRegex;
        Pattern pattern;
        Matcher replaced;
        int count;

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("resources/config.properties");
            prop.load(input);

            //System.out.println(prop.getProperty("path"));
            path = prop.getProperty("path");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        findWord = "deny";
        sRegex = "(.*)"+"("+findWord+")"+"(.*)";
        pattern = Pattern.compile("[a]+");
        count = 0;

        try (BufferedReader aclFile =
                     new BufferedReader(new FileReader(path)))
        {
            while ((aclLine = aclFile.readLine()) != null) {
                System.out.println(aclLine);
                if(aclLine.matches(sRegex)) System.out.println("found: " + aclLine.replaceAll(sRegex, "$2"));
                replaced = pattern.matcher(aclLine);
                while (replaced.find()) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e);
        }

        System.out.println("count: " + count);
    }
}
