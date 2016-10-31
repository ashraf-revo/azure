package org.revo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootApplication
public class AzureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureApplication.class, args);
    }
}

@RestController
class web {
    @GetMapping
    public String index(HttpServletRequest request) {

        NumberFormat nf = NumberFormat.getNumberInstance();


        return StreamSupport.stream(FileSystems.getDefault().getRootDirectories().spliterator(), false).map(path -> {
            String t = "";
            FileStore store = null;
            try {
                store = Files.getFileStore(path);
                t += path + " : " + "available=" + nf.format(store.getUsableSpace())
                        + ", total=" + nf.format(store.getTotalSpace());
            } catch (IOException e) {

            }
            return t;
        }).collect(Collectors.joining("\n"));

    }
}