package com.elasticsearch.cvssearch.controller;

import com.elasticsearch.cvssearch.model.Cv;
import com.elasticsearch.cvssearch.repository.CVRepository;
import com.elasticsearch.cvssearch.service.CVService;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/cvs")
public class CVController {

    private final CVRepository repository;
    private final CVService cvService;

    Logger logger = LoggerFactory.getLogger(CVController.class);


    @Autowired
    public CVController(CVRepository repository, CVService cvService) {
        this.repository = repository;
        this.cvService = cvService;
    }

    @PostMapping(path = {"", "/"})
    public String saveCV(@RequestParam("file") MultipartFile file) throws IOException, InvalidFormatException {
        Cv cv = new Cv(file.getOriginalFilename(), cvService.getContentFromFileByType(file));
        repository.save(cv);
        logger.info("Created CV: {}", cv.getFullname());
        return cv.getId() + cv.getFullname();
    }


    @GetMapping(path = {"", "/"})
    public Iterable<Cv> findByCv(@RequestParam(value = "keyword", required = false) String keyword) {
        if (keyword == null) {
            logger.error("CV Not Found : Error");
            return repository.findAll();
        }
        logger.info("CV Found");
        return repository.findByCv(keyword);
    }

}