package com.example.spring.controllers;

import com.example.spring.models.TotalRewardPoints;
import com.example.spring.services.RewardPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reward-points")
@CrossOrigin(origins = "http://localhost:3000")
public class RewardPointsController {

    @Autowired
    private RewardPointsService rewardPointsService;

    @GetMapping("/{pid}")
    public TotalRewardPoints getTotalRewardPoints(@PathVariable String pid) {
        return rewardPointsService.calculateTotalRewardPoints(pid);
    }

}
