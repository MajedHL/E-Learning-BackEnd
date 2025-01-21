package com.mh.api.MhAPI.controllers;

import com.mh.api.MhAPI.dto.StepDTO;
import com.mh.api.MhAPI.models.Step;
import com.mh.api.MhAPI.services.StepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/{courseId}/step")
@Slf4j
public class StepController {

    private StepService stepService;

    @Autowired
    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

   @PostMapping()
   @ResponseStatus(HttpStatus.CREATED)
    public Step addStep(@RequestBody StepDTO stepDto, @PathVariable("courseId") Long courseId){
        log.info("stepDTO:{}",stepDto);
        stepDto.setCourseId(courseId);
        return this.stepService.addStep(stepDto);
    }
}
