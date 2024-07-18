package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.models.Content;
import com.mh.api.MhAPI.repositories.ContentRepository;
import jakarta.transaction.RollbackException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class ContentService {

    protected final ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Transactional()
    public void addContent(Content content) throws Exception{

            System.out.println("Content received:"+content);
//            this.contentRepository.save(content);



    }
}
