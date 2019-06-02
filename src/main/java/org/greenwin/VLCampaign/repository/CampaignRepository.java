package org.greenwin.VLCampaign.repository;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

        Campaign findById(int id);
        List<Campaign> findAllByOrderByStartDateDesc();

        List<Campaign> findByCategoryAndStartDateAfterAndEndDateBefore(Category category, LocalDate start, LocalDate end);
        List<Campaign> findByStartDateAfterAndEndDateBefore(LocalDate start, LocalDate end);

        List<Campaign> getCampaignsByQuestionContainingIgnoreCase(String keyword);


}
