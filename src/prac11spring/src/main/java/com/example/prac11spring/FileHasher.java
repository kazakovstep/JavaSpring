package prac11spring.src.main.java.com.example.prac11spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class FileHasher {
    private String inputFile;
    private String hashedFile;

    public FileHasher(String inputFile, String hashedFile) {
        this.inputFile = inputFile;
        this.hashedFile = hashedFile;
    }

    @PostConstruct
    public void hashFileOnStartup() throws IOException, NoSuchAlgorithmException {
        File file = new File(inputFile);
        if (!file.exists()) {
            Files.writeString(Path.of(hashedFile), "null", StandardOpenOption.CREATE);
            return;
        }

        String data = Files.readString(Path.of(inputFile));

        byte[] hashedData = hashData(data);

        Files.write(Path.of(hashedFile), hashedData, StandardOpenOption.CREATE);
    }

    @PreDestroy
    public void deleteInputFileOnShutdown() {
        File file = new File(inputFile);
        if (file.exists()) {
            file.delete();
        }
    }

    private byte[] hashData(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("-256");
        return digest.digest(data.getBytes(StandardCharsets.UTF_8));
    }
}
