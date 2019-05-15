package org.greenwin.VLCampaign.services;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;

import java.util.List;

public interface IOptionService {

    List<Option> getAllByCampaign(Campaign campaign);

    Option getOptionById(int id);
}
