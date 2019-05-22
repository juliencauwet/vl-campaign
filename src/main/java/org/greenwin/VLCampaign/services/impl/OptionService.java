package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.greenwin.VLCampaign.repository.OptionRepository;
import org.greenwin.VLCampaign.services.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService implements IOptionService {

    @Autowired
    OptionRepository optionRepository;

    @Autowired
    CampaignRepository campaignRepository;

    @Override
    public List<Option> getAllByCampaign(Campaign campaign) {
        return optionRepository.findAllByCampaign(campaign);
    }

    @Override
    public Option getOptionById(int id) {
        return optionRepository.getById(id);
    }

    @Override
    public Option saveOption(Option option) {
        option.setCampaign(campaignRepository.findById(option.getCampaignId()));
        return optionRepository.save(option);
    }


}
