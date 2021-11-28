package com.portfolio.service;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.portfolio.mapper.AssetMapper;
import com.portfolio.model.Asset;
import com.portfolio.service.dto.AllKouzaAssetOutDto;

@SpringBootTest
public class AssetServiceTest {

	@Autowired
	private AssetService assetService;

	@MockBean
	private AssetMapper assetMapper;

	@BeforeEach
	void setUp() {
		List<Asset> expectedAssetList = new ArrayList<Asset>();

		Asset assetA = new Asset();
		assetA.setUserId("hoge");
		assetA.setCompanyId("1");
		assetA.setKouzaKubun("1");
		assetA.setStockId("6");
		assetA.setStockNum("44");
		assetA.setAveUnitPrice("85.15");

		Asset assetB = new Asset();
		assetB.setUserId("hoge");
		assetB.setCompanyId("1");
		assetB.setKouzaKubun("2");
		assetB.setStockId("6");
		assetB.setStockNum("21");
		assetB.setAveUnitPrice("106.08");

		Asset assetC = new Asset();
		assetC.setUserId("hoge");
		assetC.setCompanyId("1");
		assetC.setKouzaKubun("3");
		assetC.setStockId("6");
		assetC.setStockNum("49");
		assetC.setAveUnitPrice("86.40");


		expectedAssetList.add(assetA);
		expectedAssetList.add(assetB);
		expectedAssetList.add(assetC);

		String userId="hoge";

		Mockito.when(assetMapper.findAllByUserId(userId))
			.thenReturn(expectedAssetList);
	}

	@Test
	public void findGrpByKouzaDataでAllKouzaAssetOutDtoを取得_正常() throws Exception {
		String userId = "hoge";
		List<AllKouzaAssetOutDto> actualDtoList=assetService.findGrpByKouzaData(userId);

		assertThat(actualDtoList).isNotNull();

		for (int i = 0; i < actualDtoList.size(); i++) {
			System.out.println(actualDtoList.get(i));

			//org.assertj.core.api.Assertions.assertThat
			assertThat(actualDtoList.get(i).getStockId()).isEqualTo("6");
			assertThat(actualDtoList.get(i).getStockNum()).isEqualTo("114");
		}
	}

}
