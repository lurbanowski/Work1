package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Document;
import pl.coderslab.repository.DocumentRepository;


public class DocumentConverter  implements Converter<String, Document> {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Document convert(String s) { return documentRepository.findOne(Long.parseLong(s));
    }
}
