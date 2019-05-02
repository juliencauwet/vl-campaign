package org.greenwin.VLCampaign;

import org.greenwin.VLCampaign.model.Campaign;
import org.greenwin.VLCampaign.model.Option;
import org.greenwin.VLCampaign.model.Vote;
import org.greenwin.VLCampaign.repository.CampaignRepository;
import org.greenwin.VLCampaign.repository.OptionRepository;
import org.greenwin.VLCampaign.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableFeignClients("org.greenwin")
@EnableDiscoveryClient
public class VlCampaignApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VlCampaignApplication.class, args);
	}

	@Autowired
	private VoteRepository voteRepository;

	@Autowired
	private OptionRepository optionRepository;

	@Autowired
	private CampaignRepository campaignRepository;

	@Override
	public void run(String... args) throws Exception {

		Campaign campaign1 = new Campaign();
		campaign1.setTopicId(1);
		campaign1.setStartDate(LocalDate.of(2019, 6, 1));
		campaign1.setEndDate(LocalDate.of(2019, 8,31));

		Campaign campaign2 = new Campaign();
		campaign2.setTopicId(2);
		campaign2.setStartDate(LocalDate.of(2019, 5, 1));
		campaign2.setEndDate(LocalDate.of(2019, 7,31));

		Campaign campaign3 = new Campaign();
		campaign3.setTopicId(3);
		campaign3.setStartDate(LocalDate.of(2019, 7, 1));
		campaign3.setEndDate(LocalDate.of(2019, 7,31));

		Campaign campaign4 = new Campaign();
		campaign4.setTopicId(4);
		campaign4.setStartDate(LocalDate.of(2019, 10, 1));
		campaign4.setEndDate(LocalDate.of(2019, 11,30));

		Option pos = new Option("oui", campaign1);
		Option neg = new Option("non", campaign1);
		Option white = new Option("blanc", campaign1);

		campaignRepository.save(campaign1);
		campaignRepository.save(campaign2);
		campaignRepository.save(campaign3);
		campaignRepository.save(campaign4);

		optionRepository.save(pos);
		optionRepository.save(neg);
		optionRepository.save(white);

		Vote vote1 = new Vote(1, campaign1, pos);
		Vote vote2 = new Vote(2, campaign1, neg);
		Vote vote3 = new Vote(1, campaign1, white);

		voteRepository.save(vote1);
		voteRepository.save(vote2);
		voteRepository.save(vote3);

	}
}
