package com.labuz.campaignmanager.repository;

import com.labuz.campaignmanager.dto.CampaignDto;
import com.labuz.campaignmanager.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
