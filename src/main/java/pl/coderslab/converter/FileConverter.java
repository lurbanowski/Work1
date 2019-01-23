package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.File;
import pl.coderslab.repository.FileRepository;


public class FileConverter implements Converter<String, File> {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public File convert(String s) { return fileRepository.findOne(Long.parseLong(s));
    }
}
