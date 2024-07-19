package com.mh.api.MhAPI.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.api.MhAPI.models.Content;
import com.mh.api.MhAPI.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "api/content")
public class ContentController {

    protected final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping()
    public Content addContent(@RequestParam("content") String contentJson, @RequestParam(value = "file", required = false) MultipartFile file){

        // Deserialize JSON content to Content object
        Content content;
        try {
            System.out.println("json:"+contentJson);
            System.out.println("file:"+file);
            ObjectMapper objectMapper = new ObjectMapper();
            content = objectMapper.readValue(contentJson, Content.class);
            ResponseEntity.ok("Content added successfully");
             return  this.contentService.addContent(content, file);
        } catch (Exception e) {
            ResponseEntity.badRequest().body(e.getMessage());
            return null;
        }



    }

    @GetMapping
    public List<Content> getContentList(){
        try {
            return contentService.getContentList();
        }catch (Exception e){
             ResponseEntity.badRequest().body(e.getMessage());
             return null;
        }
    }
}
