package com.mh.api.MhAPI.projections;

import com.mh.api.MhAPI.models.Quizz;
import com.mh.api.MhAPI.models.Step;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


public interface CourseProjection {

     default Boolean getIsClosed(){
          LocalDate today =  LocalDate.now();
          if(getClosingDate() == null) return false;
          return today.isAfter(getClosingDate());

     } ;

     String getDescription();

     Long getId();


     String getName();


     LocalDate getOpeningDate();


     LocalDate getClosingDate();


     default Boolean getIsOpen() {
          LocalDate today =  LocalDate.now();
          if(getOpeningDate() == null) return true;
          return today.isAfter(getOpeningDate()) && today.isBefore(getClosingDate());
          }

}
