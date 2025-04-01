package com.example.fitlife1.services.activity;

import com.example.fitlife1.dto.ActivityDto;
import com.example.fitlife1.entity.Activity;
import com.example.fitlife1.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements  ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityDto postActivity(ActivityDto dto) {
        Activity activity = new Activity();

        activity.setDate(dto.getDate());
        activity.setSteps(dto.getSteps());
        activity.setDistance(dto.getDistance());
        activity.setCaloriesBurned(dto.getCaloriesBurned());

        return activityRepository.save(activity).getActivityDto();
    }
}
