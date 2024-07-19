package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.models.Content;
import com.mh.api.MhAPI.models.Step;
import com.mh.api.MhAPI.repositories.ContentRepository;
import jakarta.transaction.RollbackException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ContentService {

    protected final ContentRepository contentRepository;
    protected final MinIOService minIOService;
    @Autowired
    public ContentService(ContentRepository contentRepository, MinIOService minIOService) {
        this.contentRepository = contentRepository;
        this.minIOService = minIOService;
    }


    public Content addContent(Content content, MultipartFile file) throws Exception{

          if(file != null && !file.isEmpty()) {
              String url = minIOService.uploadFile(file);
              content.setUrl(url);
          }
            content.setStep(null);
           return this.contentRepository.save(content);
    }


    public List<Content> getContentList() throws Exception{
        return contentRepository.findAll();
    }
}
