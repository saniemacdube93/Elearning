package com.example.elearning;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


import com.example.elearning.Entity.Document;
import com.example.elearning.Repositories.DocumentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ElearningApplicationTests {


    @Autowired
    private DocumentRepository repo;


    @Autowired
    private TestEntityManager entityManager;


    @Test
    @Rollback(false)
    void testInsertDocument() throws IOException {
//        File file = new File("C:\\Users\\Workstation\\Desktop\\Official Resumes\\Tinashe.pdf");
//        Document document = new Document();
//        document.setName(file.getName());
//        byte[] bytes = Files.readAllBytes(file.toPath());
//        document.setContent(bytes);
//        long fileSize = bytes.length;
//        document.setSize(bytes.length);
//        repo.save(document);
//        Document savedDoc = repo.save(document);
//        Document existDoc = entityManager.find(Document.class , savedDoc);
//        assertThat(existDoc.getSize()).isEqualTo(fileSize);
    }

}
