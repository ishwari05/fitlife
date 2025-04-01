package com.example.fitlife1.controller;

import com.example.fitlife1.dto.ActivityDto;
import com.example.fitlife1.services.activity.ActivityService;
import com.example.fitlife1.services.activity.ActivityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {
    private final ActivityService activityService;

    public ResponseEntity<?> postActivity(@RequestBody ActivityDto dto) {
        ActivityDto createActivity = activityService.postActivity(dto);

        if(createActivity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong");
        }
    }

}
