import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        File workingDirGames = new File("D://Games/");
        StringBuilder log = new StringBuilder();


        String[] gameDir = {"/src", "/res", "/savegames", "/temp"};
        String[] gameScrDir = {"/main", "/test"};
        String[] gameResDir = {"/drawables", "/vectors", "/icons"};

        for (int i = 0; i < gameDir.length; i++) {
            File directoryConstructor = new File((workingDirGames + gameDir[i]));
            if (directoryConstructor.mkdirs()) {
                System.out.println("Создана директория " + gameDir[i] + ".");
                log.append("Создана директория " + gameDir[i] + ". \n");
            } else {
                System.err.println("Не удалось создать директорию " + gameDir[i] + ".");
                log.append("Не удалось создать директорию " + gameDir[i] + ". \n");
            }
        }

        for (int i = 0; i < gameScrDir.length; i++) {
            File directoryConstructor = new File((workingDirGames + "/src" + gameScrDir[i]));
            if (directoryConstructor.mkdirs()) {
                System.out.println("Создана директория " + gameScrDir[i] + ".");
                log.append("Создана директория " + gameScrDir[i] + ". \n");
            } else {
                System.err.println("Не удалось создать директорию " + gameScrDir[i] + ".");
                log.append("Не удалось создать директорию " + gameScrDir[i] + ". \n");
            }
        }

        for (int i = 0; i < gameResDir.length; i++) {
            File directoryConstructor = new File((workingDirGames + "/res" + gameResDir[i]));
            if (directoryConstructor.mkdirs()) {
                System.out.println("Создана директория " + gameResDir[i] + ".");
                log.append("Создана директория " + gameResDir[i] + ". \n");
            } else {
                System.err.println("Не удалось создать директорию " + gameResDir[i] + ".");
                log.append("Не удалось создать директорию " + gameResDir[i] + ". \n");
            }
        }

        File workingDirGamesSrcMainToFile = new File("D://Games//src//main");

        File mainJava = new File(workingDirGamesSrcMainToFile, "Main.java");

        if (!mainJava.exists()) {
            try {
                if (mainJava.createNewFile())
                    System.out.println("Создан файл " + mainJava + ".");
                log.append("Создан файл " + mainJava + ". \n");
            } catch (IOException ex) {
                System.err.println("Не удалось создать файл " + mainJava + ".");
            }
        } else {
            System.out.println("Файл " + mainJava + " уже существует.");
            log.append("Файл " + mainJava + " уже существует \n");
        }


        File utilsJava = new File(workingDirGamesSrcMainToFile, "Utils.java");
        if (!utilsJava.exists()) {
            try {
                if (utilsJava.createNewFile())
                    System.out.println("Создан файл " + utilsJava + ".");
                log.append("Создан файл " + utilsJava + ". \n");
            } catch (IOException ex) {
                System.err.println("Не удалось создать файл " + utilsJava + ".");
            }
        } else {
            System.out.println("Файл " + utilsJava + " уже существует.");
            log.append("Файл " + utilsJava + " уже существует \n");
        }

        File workingDirGamesTempToFile = new File("D://Games//temp");

        File tempTxt = new File(workingDirGamesTempToFile, "temp.txt");

        if (!tempTxt.exists()) {
            try {
                if (tempTxt.createNewFile())
                    System.out.println("Создан файл " + tempTxt + ". \n");
                log.append("Создан файл " + tempTxt + ".");
            } catch (IOException ex) {
                System.err.println("Не удалось создать файл " + tempTxt + ".");
            }
        } else {
            System.out.println("Файл " + tempTxt + " уже существует.");
            log.append("Файл " + tempTxt + " уже существует \n");
        }


        try (FileWriter logToFile = new FileWriter("D://Games//temp//temp.txt", true)) {
            logToFile.write(String.valueOf(log));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}