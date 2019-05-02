package org.greenwin.VLCampaign.services;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;

import java.util.Set;

public interface IOptionService {

    Set<Option> getAllByCampaign(Campaign campaign);
}
