import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BTracer {
    public static void main (String[] args) {
        String aclLine;
        String fields[];
        String path="";
        int lineCount;
        int count = 0;
        int position = 0;
        NetworkRule[] networkRules;

        Properties prop = new Properties();
        InputStream input = null;

        // load properties
        try {

            input = new FileInputStream("resources/config.properties");
            prop.load(input);

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

        // fill rules array
        try (BufferedReader aclFile =
                     new BufferedReader(new FileReader(path)))
        {
            lineCount = (int) Files.lines(Paths.get(path)).count();
            networkRules = new NetworkRule[lineCount];

            for(int i=0;i<lineCount;i++) {
                networkRules[i] = new NetworkRule();
            }

            while ((aclLine = aclFile.readLine()) != null) {
                //System.out.println(aclLine);
                aclLine = aclLine.trim();
                fields = aclLine.split(" ");

                position++;
                networkRules[count].setPolicy(fields[position]);
                position++;
                networkRules[count].setProtocol(fields[position]);
                position++;
                if (fields[position].equals("host")) {
                    networkRules[count].setSourceIP(fields[position+1]);
                    networkRules[count].setSourceIPmask("0.0.0.0");
                    position+=2;
                } else if (fields[position].equals("any")) {
                    networkRules[count].setSourceIP("0.0.0.0");
                    networkRules[count].setSourceIPmask("255.255.255.255");
                    position++;
                } else {
                    networkRules[count].setSourceIP(fields[position]);
                    networkRules[count].setSourceIPmask(fields[position+1]);
                    position+=2;
                }
                if (fields[position].equals("eq")) {
                    networkRules[count].setSourcePort(fields[position+1]);
                    position+=2;
                }
                if (fields[position].equals("host")) {
                    networkRules[count].setDestinationIP(fields[position+1]);
                    networkRules[count].setDestinationIPmask("0.0.0.0");
                    position+=2;
                } else if (fields[position].equals("any")) {
                    networkRules[count].setDestinationIP("0.0.0.0");
                    networkRules[count].setDestinationIPmask("255.255.255.255");
                    position++;
                } else {
                    networkRules[count].setDestinationIP(fields[position]);
                    networkRules[count].setDestinationIPmask(fields[position+1]);
                    position+=2;
                }
                if (position<fields.length) {
                    if (fields[position].equals("eq")) {
                        networkRules[count].setDestinationPort(fields[position + 1]);
                    }
                }
                count++;
                position=0;
            }

            System.out.println("lines: "+lineCount);

        } catch (IOException e) {
            System.out.println("Input/Output error: " + e);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
     }
}
