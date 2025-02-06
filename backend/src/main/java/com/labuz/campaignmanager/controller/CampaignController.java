package com.labuz.campaignmanager.controller;

import com.labuz.campaignmanager.dto.CampaignDto;
import com.labuz.campaignmanager.service.CampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping
    public ResponseEntity<List<CampaignDto>> getAllCampaigns() {
        List<CampaignDto> campaigns = campaignService.getAllCampaigns();
        return ResponseEntity.ok(campaigns);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampaignDto> getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CampaignDto> createCampaign(@RequestBody CampaignDto campaignDto) {
        CampaignDto savedCampaign = campaignService.createCampaign(campaignDto);
        return ResponseEntity.ok(savedCampaign);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampaignDto> updateCampaign(@PathVariable Long id, @RequestBody CampaignDto updatedCampaignDto) {
        return campaignService.updateCampaign(id, updatedCampaignDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        if (campaignService.existsById(id)) {
            campaignService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

