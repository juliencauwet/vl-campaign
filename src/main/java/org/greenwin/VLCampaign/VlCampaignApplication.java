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
import java.util.List;

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

		Option pos = new Option("oui");
		Option neg = new Option("non");
		Option white = new Option("blanc");


		List<Option> referundumOptions = Arrays.asList(
				pos,
				neg,
				white
		);

		Campaign campaign1 = new Campaign();
		campaign1.setTopicId(1);
		campaign1.setStartDate(LocalDate.of(2019, 5, 1));
		campaign1.setEndDate(LocalDate.of(2019, 7,31));

		Vote vote1 = new Vote(1, campaign1, pos);
		Vote vote2 = new Vote(2, campaign1, neg);
		Vote vote3 = new Vote(1, campaign1, white);

		optionRepository.save(pos);
		optionRepository.save(neg);
		optionRepository.save(white);

		campaignRepository.save(campaign1);

		voteRepository.save(vote1);
		voteRepository.save(vote2);
		voteRepository.save(vote3);

	}
}
