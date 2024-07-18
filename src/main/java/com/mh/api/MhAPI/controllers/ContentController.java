package com.mh.api.MhAPI.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.api.MhAPI.models.Content;
import com.mh.api.MhAPI.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "api/content")
public class ContentController {

    protected final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping()
    public ResponseEntity<String> addContent(@RequestParam("content") String contentJson, @RequestParam("file") MultipartFile file){

        // Deserialize JSON content to Content object
        Content content;
        try {
            System.out.println("json:"+contentJson);
            System.out.println("file:"+file);
            ObjectMapper objectMapper = new ObjectMapper();
            content = objectMapper.readValue(contentJson, Content.class);
            this.contentService.addContent(content);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to parse content data");
        }



        return ResponseEntity.ok("Content added successfully");

    }
}
