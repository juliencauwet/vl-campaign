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
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Option c2o1 = new Option("Accepter les revendications", campaign2);
		Option c2o2 = new Option("Provoquer un référundum", campaign2);
		Option c2o3 = new Option("Ne céder sous aucun prétexte", campaign2);
		Option c3o1 = new Option("Interdire tous les produits toxiques", campaign3);
		Option c3o2 = new Option("Prendre des mesures de nettoyage", campaign3);
		Option c3o3 = new Option("Taxer les entreprises", campaign3);
		Option c4o1 = new Option("Investir dans les technologies", campaign4);
		Option c4o2 = new Option("Promouvoir l'artisanat", campaign4);

		/*
		Option pos = new Option("oui");
		Option neg = new Option("non");
		Option white = new Option("blanc");
		Option c2o1 = new Option("Accepter les revendications");
		Option c2o2 = new Option("Provoquer un référundum");
		Option c2o3 = new Option("Ne céder sous aucun prétexte");
		Option c3o1 = new Option("Interdire tous les produits toxiques");
		Option c3o2 = new Option("Prendre des mesures de nettoyage");
		Option c3o3 = new Option("Taxer les entreprises");
		Option c4o1 = new Option("Investir dans les technologies");
		Option c4o2 = new Option("Promouvoir l'artisanat");
		*/

		List<Campaign> campaigns = Arrays.asList(campaign1, campaign2, campaign3, campaign4);
		saveCampaigns(campaigns);

		Vote vote1 = new Vote(1, campaign1, pos);
		Vote vote2 = new Vote(2, campaign1, neg);
		Vote vote3 = new Vote(1, campaign1, white);


		List<Option> options = Arrays.asList(pos, neg, white, c2o1, c2o2, c2o3, c3o1, c3o2, c3o3, c4o1, c4o2);
		saveOptions(options);

		List<Vote> votes = Arrays.asList(vote1, vote2, vote3);
		saveVotes(votes);


	}

	public void saveOptions (List<Option> options){
		for (Option option : options)
			optionRepository.save(option);
	}

	public void saveCampaigns (List<Campaign> campaigns){
		for (Campaign campaign : campaigns)
			campaignRepository.save(campaign);
	}

	public void saveVotes (List<Vote> votes){
		for (Vote vote : votes)
			voteRepository.save(vote);
	}

}
