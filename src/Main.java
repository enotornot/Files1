import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        File workingDirGames = new File("D://Games/");
        StringBuilder log = new StringBuilder();

        List<String> creatingDirs = new ArrayList<>(Arrays.asList(
                "/savegames",
                "/temp",
                "/src/main",
                "/src/test",
                "/res/drawables",
                "/res/vectors",
                "/res/icons"
        ));

        List<String> creatingFiles = new ArrayList<>(Arrays.asList(
                "/src/main/Main.java",
                "/src/main/Utils.java",
                "/temp/temp.txt"
        ));

        for (String newDir : creatingDirs) {
            File directoryConstructor = new File((workingDirGames + newDir));
            if (directoryConstructor.mkdirs()) {
                log.append("Создана директория " + newDir + ". \n");
            } else {
                log.append("Не удалось создать директорию " + newDir + ". \n");
            }
        }


        for (String newFile : creatingFiles) {
            try {
                File creatingFile = new File(workingDirGames + newFile);
                if (!creatingFile.exists()) {
                    if (creatingFile.createNewFile())
                    log.append("Создан файл " + creatingFile + ". \n");
                } else {
                    log.append("Файл " + creatingFile + " уже существует \n");
                }
            } catch (IOException ex) {
                log.append("Файл не создан: " + ex.getMessage() + " \n");
            }

            try (FileWriter logToFile = new FileWriter("D://Games//temp//temp.txt", true)) {
                logToFile.write(String.valueOf(log));
            } catch (IOException e) {
                log.append(e.getMessage());
            }

        }
    }
}