package com.mh.api.MhAPI.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mh.api.MhAPI.dto.ContentDTO;
import com.mh.api.MhAPI.models.Content;
import com.mh.api.MhAPI.services.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "api/{stepId}/content")
@Slf4j
public class ContentController {

    protected final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Content addContent(@PathVariable(value = "stepId") Long stepId, @RequestParam("content") String contentJson, @RequestParam(value = "file", required = false) MultipartFile file){

        // Deserialize JSON content to Content object
        ContentDTO contentdto;
        try {
            System.out.println("json:"+contentJson);
            System.out.println("file:"+file);
            ObjectMapper objectMapper = new ObjectMapper();
            contentdto = objectMapper.readValue(contentJson, ContentDTO.class);
            contentdto.setStepId(stepId);
             return  this.contentService.addContent(contentdto, file);
        } catch (Exception e) {
            ResponseEntity.badRequest().body(e.getMessage());
            return null;
        }



    }

    @GetMapping
    public List<Content> getContentList(@RequestParam("step") Long stepId){
        try {
            log.info("get content list of step: {}",+stepId);
            return contentService.getContentList(stepId);
        }catch (Exception e){
             ResponseEntity.badRequest().body(e.getMessage());
             return null;
        }
    }

}
