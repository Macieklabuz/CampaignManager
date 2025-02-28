package com.labuz.campaignmanager.dto;



public class CampaignDto {
    private Long id;
    private String name;
    private String keywords;
    private Double bidAmount;
    private Double campaignFund;
    private Boolean status;
    private String town;
    private Integer radius;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getCampaignFund() {
        return campaignFund;
    }

    public void setCampaignFund(Double campaignFund) {
        this.campaignFund = campaignFund;
    }

    public Double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CampaignDto(Long id, String name, String keywords, Double bidAmount, Double campaignFund, Boolean status, String town, Integer radius) {
        this.id = id;
        this.name = name;
        this.keywords = keywords;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public CampaignDto() {}
}
