package com.example.spring.services;

import com.example.spring.models.TotalRewardPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RewardPointsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TotalRewardPoints calculateTotalRewardPoints(String pid) {
        String query = """
            SELECT 
                COALESCE(SUM(fs.marks), 0) AS final_submission_marks,
                COALESCE(SUM(isub.marks), 0) AS initial_submission_marks,
                COALESCE(SUM(pm.marks), 0) AS plagiarism_marks,
                COALESCE(SUM(wm.marks), 0) AS worklog_marks,
                COALESCE(SUM(tcm.total_communication_marks), 0) AS team_communication_marks,
                COALESCE(SUM(m.total_marks), 0) AS total_marks,
                 COALESCE(MAX(isub.project_details), '') AS project_details
            FROM 
                final_submission fs
            LEFT JOIN 
                initial_submission isub ON fs.pid = isub.pid
            LEFT JOIN 
                plagiarism_marks pm ON fs.pid = pm.pid
            LEFT JOIN 
                worklog_marks wm ON fs.pid = wm.pid
            LEFT JOIN 
                team_communication_marks tcm ON fs.pid = tcm.pid
            LEFT JOIN 
                marks m ON fs.pid = m.pid
            WHERE 
                fs.pid = ?
        """;

        return jdbcTemplate.queryForObject(query, new Object[]{pid}, (rs, rowNum) -> {
            TotalRewardPoints rewardPoints = new TotalRewardPoints();
            rewardPoints.setPid(pid);
            rewardPoints.setFinalSubmissionMarks(rs.getInt("final_submission_marks"));
            rewardPoints.setInitialSubmissionMarks(rs.getInt("initial_submission_marks"));
            rewardPoints.setPlagiarismMarks(rs.getInt("plagiarism_marks"));
            rewardPoints.setWorklogMarks(rs.getInt("worklog_marks"));
            rewardPoints.setTeamCommunicationMarks(rs.getInt("team_communication_marks"));
            rewardPoints.setTotalMarks(rs.getInt("total_marks"));
            rewardPoints.setProjectDetails(rs.getString("project_details"));
            rewardPoints.calculateTotal();
            return rewardPoints;
        });
    }
}
