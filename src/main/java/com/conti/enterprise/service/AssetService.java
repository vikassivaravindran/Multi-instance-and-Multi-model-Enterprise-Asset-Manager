/**
 * 
 */
package com.conti.enterprise.service;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.conti.enterprise.mapper.AssetRowMapper;
import com.conti.enterprise.model.Asset;
import com.conti.enterprise.model.AssetDTO;
import com.conti.enterprise.repository.AssetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Vikas Siva Ravindran
 *
 */
@Service
public class AssetService {

	@Autowired
	public AssetRepository assetRepo;

	@Value("${snipeit.application.token}")
	private String API_Token;

	@Value("${snipeit.application.url}")
	private String URL;

	private RestTemplate restTemplate = new RestTemplate();

	private HttpHeaders httpheaders = new HttpHeaders();

	private static final String HEADER = "Asset Tag,HPAM Reference,Model ID";

	FileWriter fileWriter = null;

	@Autowired
	private JdbcTemplate jdbctemplate;

	private static final String LINE_SEPARATOR = "\n";

	private static final String COLUMN_SEPARATOR = ",";

	public void updateReference(int id) {

		httpheaders.setContentType(MediaType.APPLICATION_JSON);
		httpheaders.set("Authorization", "Bearer " + API_Token);
		HttpEntity<Asset> entity = new HttpEntity<>(httpheaders);
		ResponseEntity<Asset> response = restTemplate.exchange(URL + "/hardware/" + id, HttpMethod.GET, entity,
				Asset.class);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + API_Token);
		headers.set("Accept", "application/json");

		// Code to generate Random HPAM ID
		RandomStringGenerator g = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(Character::isLetterOrDigit).build();

		String hpam_reference_id = g.generate(10).toUpperCase();

		AssetDTO createdAsset = new AssetDTO();
		createdAsset.setId(response.getBody().getId());
		createdAsset.setName(response.getBody().getName());
		createdAsset.setAsset_tag(response.getBody().getAsset_tag());
		createdAsset.setSerial(response.getBody().getSerial());
		createdAsset.set_snipeit_hpam_reference_3(hpam_reference_id);
		createdAsset.setStatus_id(response.getBody().getStatus_label().getId());
		createdAsset.setModel_id(response.getBody().getModel().getId());
		HttpEntity<AssetDTO> assetEntity = new HttpEntity<AssetDTO>(createdAsset, headers);
		ResponseEntity<AssetDTO> details = restTemplate.exchange(URL + "/hardware/" + id, HttpMethod.PUT, assetEntity,
				AssetDTO.class);
		assetRepo.save(createdAsset);

	}

	/**
	 * @param asset
	 */
	public void createAsset(AssetDTO asset) {
		// TODO Auto-generated method stub

		httpheaders.setContentType(MediaType.APPLICATION_JSON);
		httpheaders.set("Authorization", "Bearer " + API_Token);
		httpheaders.set("Accept", "application/json");
		RandomStringGenerator g = new RandomStringGenerator.Builder().withinRange('0', 'z')
				.filteredBy(Character::isLetterOrDigit).build();

		String hpam_id = g.generate(10).toUpperCase();

		AssetDTO assets = new AssetDTO();
		assets.setAsset_tag(asset.getAsset_tag());
		assets.setStatus_id(asset.getStatus_id());
		assets.set_snipeit_hpam_reference_3(hpam_id);
		assets.setModel_id(asset.getModel_id());
		HttpEntity<AssetDTO> entity = new HttpEntity<AssetDTO>(assets, httpheaders);
		restTemplate.exchange(URL + "/hardware", HttpMethod.POST, entity, AssetDTO.class);
		String sql = "SELECT MAX(id) from assets";

		AssetDTO maxAssetDetails = new AssetDTO();
		maxAssetDetails = jdbctemplate.queryForObject(sql, new AssetRowMapper());
		System.out.println(maxAssetDetails.getId());
		int assetId = (maxAssetDetails.getId() + 1);
		System.out.println(assetId);

		assets.setId(assetId);

		assetRepo.save(assets);
	}

	/**
	 * @throws IOException
	 * 
	 */
	public String importDetailstoCSVFile() throws IOException {
		// TODO Auto-generated method stub

		List<AssetDTO> updatedAssets = assetRepo.findAll();

		File f = new File("C:\\Users\\vikas\\Documents\\Assets.csv");

		FileWriter writer = new FileWriter(f);

		try {

			writer.write(HEADER);

			for (AssetDTO asset : updatedAssets) {

				writer.write(LINE_SEPARATOR);
				writer.write(asset.getAsset_tag());
				writer.write(COLUMN_SEPARATOR);
				writer.write(asset.get_snipeit_hpam_reference_3());
				writer.write(COLUMN_SEPARATOR);
				writer.write(String.valueOf(asset.getModel_id()));
				writer.write(COLUMN_SEPARATOR);

			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "The Asset Details are stored in Assets.CSV file";
	}
}
