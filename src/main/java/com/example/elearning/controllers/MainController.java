package com.example.elearning.controllers;


import com.example.elearning.Entity.Document;
import com.example.elearning.Repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {



    @Autowired
    private DocumentRepository repo;

    @GetMapping("/")
    public String viewHomePage(Model model){
        List<Document> listDocs = repo.findAll();
        model.addAttribute("listDocs" , listDocs);
        return "home";
    }


    @GetMapping("/add")
    public String viemwHomePage(Model model){
        List<Document> listDocs = repo.findAll();
        model.addAttribute("listDocs" , listDocs);
        return "add";
    }

    @GetMapping("/view")
    public String viemHomePage(Model model){
        List<Document> listDocs = repo.findAll();
        model.addAttribute("listDocs" , listDocs);
        return "view";
    }

    @GetMapping("/logs")
    public String viewLogin(Model model){
        List<Document> listDocs = repo.findAll();
        model.addAttribute("listDocs" , listDocs);
        return "index";
    }


    @GetMapping("/home")
    public String viewHome(Model model){
        List<Document> listDocs = repo.findAll();
        model.addAttribute("listDocs" , listDocs);
        return "index";
    }

    @GetMapping("/download")
    public void downFile(@Param("id") Long id , HttpServletResponse response) throws Exception {
        Optional<Document> result = repo.findById(id);
        if (!result.isPresent()){
            throw new Exception("Could not find the document with ID : " + id );
        }

        Document document = result.get();
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + document.getName();

        response.setHeader(headerKey, headerValue);

        ServletOutputStream outputStream = response.getOutputStream();

        outputStream.write(document.getContent());
        outputStream.close();

    }



    @GetMapping("/Assignments")
    public String viewAssignments(Model model){
        List<Document> listDocs = repo.findAll();
        model.addAttribute("listDocs" , listDocs);
        return "studentassignments";
    }


    @PostMapping("/upload")
    public String uploadFiles(@RequestParam("document")MultipartFile multipartFile , RedirectAttributes ra,Model model) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        Document document =  new Document();
        document.setName(fileName);
        document.setContent(multipartFile.getBytes());
        document.setSize(multipartFile.getSize());
        document.setUploadTime(new Date());
        repo.save(document);

        ra.addFlashAttribute("message", "The file has been uploaded succesfully.");

        List<Document> listDocs = repo.findAll();
        model.addAttribute("listDocs" , listDocs);
        return "add";
    }


}
