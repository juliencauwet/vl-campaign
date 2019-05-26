package org.greenwin.VLCampaign.services;


import org.greenwin.VLCampaign.model.Category;

import java.util.List;

public interface ICategoryService {

    Category getById(int id);
    List<Category> getAll();

}
