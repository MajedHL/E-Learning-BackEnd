package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.dto.ContentDTO;
import com.mh.api.MhAPI.models.Content;
import com.mh.api.MhAPI.repositories.ContentRepository;
import com.mh.api.MhAPI.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ContentService {

    protected final ContentRepository contentRepository;
    protected final MinIOService minIOService;

    protected final StepRepository stepRepository;
    @Autowired
    public ContentService(ContentRepository contentRepository, MinIOService minIOService, StepRepository stepRepository) {
        this.contentRepository = contentRepository;
        this.minIOService = minIOService;
        this.stepRepository = stepRepository;
    }


    public Content addContent(ContentDTO contentdto, MultipartFile file) throws Exception{
            Content content = new Content();
            content.setText(contentdto.getText());
            content.setStep(stepRepository.findById(contentdto.getStepId()).orElseThrow(()->new NoSuchElementException()));
            content.setTitle(contentdto.getTitle());
            content.setType(contentdto.getType());
            content.setOrderNumber(contentdto.getOrderNumber());

          if(file != null && !file.isEmpty()) {
              String url = minIOService.uploadFile(file);
              content.setUrl(url);
          }

           return this.contentRepository.save(content);
    }


    public List<Content> getContentList(Long stepId) throws Exception{
        return contentRepository.getContentListByStepId(stepId);
    }
}
