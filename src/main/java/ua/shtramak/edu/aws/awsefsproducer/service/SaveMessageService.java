package ua.shtramak.edu.aws.awsefsproducer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class SaveMessageService {
    @Value("${file.path}")
    private String filePath;

    public void saveMessageToFile(String message) {
        try {
            String messageWithNewLine = message + "\n";
            Files.write(Paths.get(filePath), messageWithNewLine.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMessages() {
        try {
            return String.join("\n", Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
