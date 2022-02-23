import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StartReplaceSet {

    public static void main(String[] args) throws IOException {

        String pathString = System.getProperty("user.dir");
        if (args.length > 0) {
            pathString = args[0];
        }

        File folder = new File(pathString);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());

                Path path = Paths.get(folder + "/" + file.getName());
                Charset charset = StandardCharsets.UTF_8;

                String content = new String(Files.readAllBytes(path), charset);
                content = content.replaceAll("SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;", "-- SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;");
                content = content.replaceAll("SET @@SESSION.SQL_LOG_BIN= 0;", "-- SET @@SESSION.SQL_LOG_BIN= 0;");
                content = content.replaceAll("SET @@GLOBAL.GTID_PURGED=", "-- SET @@GLOBAL.GTID_PURGED=");
                content = content.replaceAll("SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;", "-- SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;");

                Files.write(path, content.getBytes(charset));
            }
        }

    }

}
