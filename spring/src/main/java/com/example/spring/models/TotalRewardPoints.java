package com.example.spring.models;

public class TotalRewardPoints {
    private String pid;
    private int finalSubmissionMarks;
    private int initialSubmissionMarks;
    private int plagiarismMarks;
    private int worklogMarks;
    private int teamCommunicationMarks;
    private int totalMarks;
    private int totalRewardPoints;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getFinalSubmissionMarks() {
        return finalSubmissionMarks;
    }

    public void setFinalSubmissionMarks(int finalSubmissionMarks) {
        this.finalSubmissionMarks = finalSubmissionMarks;
    }

    public int getInitialSubmissionMarks() {
        return initialSubmissionMarks;
    }

    public void setInitialSubmissionMarks(int initialSubmissionMarks) {
        this.initialSubmissionMarks = initialSubmissionMarks;
    }

    public int getPlagiarismMarks() {
        return plagiarismMarks;
    }

    public void setPlagiarismMarks(int plagiarismMarks) {
        this.plagiarismMarks = plagiarismMarks;
    }

    public int getWorklogMarks() {
        return worklogMarks;
    }

    public void setWorklogMarks(int worklogMarks) {
        this.worklogMarks = worklogMarks;
    }

    public int getTeamCommunicationMarks() {
        return teamCommunicationMarks;
    }

    public void setTeamCommunicationMarks(int teamCommunicationMarks) {
        this.teamCommunicationMarks = teamCommunicationMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public void calculateTotal() {
        this.totalRewardPoints = finalSubmissionMarks + initialSubmissionMarks +
                plagiarismMarks + worklogMarks + teamCommunicationMarks + totalMarks;
    }
    private String projectDetails;

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }
}
