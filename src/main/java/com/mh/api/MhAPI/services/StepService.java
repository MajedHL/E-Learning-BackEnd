package com.mh.api.MhAPI.services;

import com.mh.api.MhAPI.dto.StepDTO;
import com.mh.api.MhAPI.models.Step;
import com.mh.api.MhAPI.repositories.CourseRepository;
import com.mh.api.MhAPI.repositories.StepRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StepService {

    private StepRepository stepRepository;
    private CourseRepository courseRepository;
    @Autowired
    public StepService(StepRepository stepRepository, CourseRepository courseRepository) {
        this.stepRepository = stepRepository;
        this.courseRepository = courseRepository;
    }

    public Step addStep(StepDTO stepDto) {
        Step step = new Step();
        step.setCourse(courseRepository.findById(stepDto.getCourseId()).orElseThrow(()-> new NoSuchElementException()));
        step.setTitle(stepDto.getTitle());
        step.setOrderNumber(stepDto.getOrderNumber());
        return this.stepRepository.save(step);
    }
}
