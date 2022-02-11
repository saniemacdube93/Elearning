package com.example.elearning.Repositories;

import com.example.elearning.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DocumentRepository extends JpaRepository<Document , Long> {

    @Query("SELECT new Document(d.id, d.name, d.size) FROM Document d order by d.uploadTime DESC")
    List<Document> findAll();

}
