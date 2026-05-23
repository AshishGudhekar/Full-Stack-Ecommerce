package com.ecommerce.project.service.implenetation;

import com.ecommerce.project.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // file name of current/original file
        String originalFileName = file.getOriginalFilename();

        //generate unique file name

/* we can also Use FilenameUtils from Apache Commons IO
String extension = "." + FilenameUtils.getExtension(originalFileName);
String fileName = randomId + extension; */

        String randomId = UUID.randomUUID().toString(); // image.jpg --> 123542 --> 123542.jpg
        String fileName = randomId + (originalFileName.substring(originalFileName.lastIndexOf('.')));
        String filePath = path + File.separator + fileName;

        // check if path exist and created
        File folder = new File(path);
        if (!folder.exists())
            folder.mkdir();

        //upload to server
        Files.copy(file.getInputStream(), Paths.get(filePath));

        // return file name
        return fileName;
    }
}
