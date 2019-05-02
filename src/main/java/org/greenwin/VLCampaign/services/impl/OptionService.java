package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.repository.OptionRepository;
import org.greenwin.VLCampaign.services.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OptionService implements IOptionService {

    @Autowired
    OptionRepository optionRepository;

    @Override
    public Set<Option> getAllByCampaign(Campaign campaign) {
        return optionRepository.findAllByCampaign(campaign);

    }
}
