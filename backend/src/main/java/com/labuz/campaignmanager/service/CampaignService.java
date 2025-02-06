package com.labuz.campaignmanager.service;

import com.labuz.campaignmanager.dto.CampaignDto;
import com.labuz.campaignmanager.entity.Campaign;
import com.labuz.campaignmanager.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    public CampaignDto createCampaign(CampaignDto campaignDto) {
        Campaign campaign = mapToEntity(campaignDto);
        Campaign savedCampaign = campaignRepository.save(campaign);
        return mapToDto(savedCampaign);
    }

    public List<CampaignDto> getAllCampaigns() {
        return campaignRepository.findAll().stream().map(this::mapToDto).toList();
    }

    public boolean existsById(Long id) {
        return campaignRepository.existsById(id);
    }

    public Optional<CampaignDto> getCampaignById(Long id) {
        return campaignRepository.findById(id).map(this::mapToDto);
    }


    public void deleteById(Long id) {
        campaignRepository.deleteById(id);
    }

    public Optional<CampaignDto> updateCampaign(Long id, CampaignDto updatedCampaignDto) {
        return campaignRepository.findById(id)
                .map(existingCampaign -> {
                    existingCampaign.setName(updatedCampaignDto.getName());
                    existingCampaign.setKeywords(updatedCampaignDto.getKeywords());
                    existingCampaign.setBidAmount(updatedCampaignDto.getBidAmount());
                    existingCampaign.setCampaignFund(updatedCampaignDto.getCampaignFund());
                    existingCampaign.setStatus(updatedCampaignDto.getStatus());
                    existingCampaign.setTown(updatedCampaignDto.getTown());
                    existingCampaign.setRadius(updatedCampaignDto.getRadius());
                    Campaign updatedCampaign = campaignRepository.save(existingCampaign);
                    return mapToDto(updatedCampaign);
                });
    }

    private CampaignDto mapToDto(Campaign campaign) {
        return new CampaignDto(
                campaign.getId(),
                campaign.getName(),
                campaign.getKeywords(),
                campaign.getBidAmount(),
                campaign.getCampaignFund(),
                campaign.getStatus(),
                campaign.getTown(),
                campaign.getRadius()
        );
    }

    private Campaign mapToEntity(CampaignDto campaignDto) {
        return new Campaign(
                campaignDto.getId(),
                campaignDto.getName(),
                campaignDto.getKeywords(),
                campaignDto.getBidAmount(),
                campaignDto.getCampaignFund(),
                campaignDto.getStatus(),
                campaignDto.getTown(),
                campaignDto.getRadius()
        );
    }
}
