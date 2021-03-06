package com.coremedia.livecontext.ecommerce.magento.rest.resources;

import com.coremedia.livecontext.ecommerce.magento.rest.documents.CategoryDocument;
import com.coremedia.livecontext.ecommerce.magento.rest.documents.CategoryProductLinkDocument;
import com.coremedia.livecontext.ecommerce.magento.rest.documents.ProductDocument;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Integration test for the rest connector accessing the catalog as a JSON resource.
 */
class CatalogResourceIT extends MagentoResourceITBase {

  @InjectMocks
  private CatalogResource catalogResource = new CatalogResource();

  private String storeId = "default";

  @Test
  void testListCategories() {
    CategoryDocument cat = catalogResource.getCategoryById(storeId, "9");

    assertThat(cat.getId()).as("Unexpected ID for catalog resource queried via ID.").isEqualTo("9");
    assertThat(cat.getName()).as("Unexpected name for catalog resource with ID 9.").isEqualTo("Training");
  }

  @Test
  @Ignore
  void testGetLinkedProducts() {
    List<CategoryProductLinkDocument> links = catalogResource.getLinkedProducts(storeId, "2");

    assertThat(links).as("Unexpected number of links encountered.").hasSize(187);
  }

  @Test
  @Ignore
  void testGetProductBySku() {
    ProductDocument productDocument = catalogResource.getProductBySku(storeId, "240-LV06");
    assertThat(productDocument.getName()).as("Unexpected name for product queried via its SKU.").isEqualTo("Yoga Adventure");

    List<String> catIds = (List<String>) productDocument.getCustomAttribute("category_ids");
    assertThat(catIds).as("Unexpected numger of custom attributes encountered.").hasSize(2);
  }

  @Test
  @Ignore
  void testGetProductsBySku() {
    List<String> skus = Arrays.asList(
            "24-MB01",
            "24-MB04",
            "24-MB03",
            "24-MB05",
            "24-MB06",
            "24-MB02",
            "24-UB02",
            "24-WB01",
            "24-WB02",
            "24-WB05",
            "24-WB06",
            "24-WB03",
            "24-WB07",
            "24-WB04",
            "24-UG06",
            "24-UG07",
            "24-UG04",
            "24-UG02",
            "24-UG05",
            "24-UG01",
            "24-WG084",
            "24-WG088",
            "24-UG03",
            "24-MG04",
            "24-MG01",
            "24-MG03",
            "24-MG05",
            "24-MG02",
            "24-WG09",
            "24-WG01",
            "24-WG03",
            "24-WG02",
            "24-WG080",
            "240-LV04",
            "240-LV05",
            "240-LV06",
            "240-LV07",
            "240-LV08",
            "240-LV09",
            "MH01",
            "MH02",
            "MH03",
            "MH04",
            "MH05",
            "MH06",
            "MH07",
            "MH08",
            "MH09",
            "MH10",
            "MH11",
            "MH12",
            "MH13",
            "MJ01",
            "MJ02",
            "MJ04",
            "MJ07",
            "MJ08",
            "MJ09",
            "MJ10",
            "MJ11",
            "MJ06",
            "MJ03",
            "MJ12",
            "MS04",
            "MS05",
            "MS09",
            "MS11",
            "MS12",
            "MS03",
            "MS06",
            "MS01",
            "MS02",
            "MS10",
            "MS07",
            "MS08",
            "MT01",
            "MT02",
            "MT03",
            "MT04",
            "MT05",
            "MT06",
            "MT07",
            "MT08",
            "MT09",
            "MT10",
            "MT11",
            "MT12",
            "MP01",
            "MP02",
            "MP03",
            "MP04",
            "MP05",
            "MP06",
            "MP07",
            "MP08",
            "MP09",
            "MP10",
            "MP11",
            "MP12",
            "MSH01",
            "MSH02",
            "MSH03",
            "MSH04",
            "MSH05",
            "MSH06",
            "MSH07",
            "MSH08",
            "MSH09",
            "MSH10",
            "MSH11",
            "MSH12",
            "WH01",
            "WH02",
            "WH03",
            "WH04",
            "WH05",
            "WH06",
            "WH07",
            "WH08",
            "WH09",
            "WH10",
            "WH11",
            "WH12",
            "WJ01",
            "WJ02",
            "WJ03",
            "WJ04",
            "WJ05",
            "WJ07",
            "WJ08",
            "WJ09",
            "WJ10",
            "WJ11",
            "WJ06",
            "WJ12",
            "WS02",
            "WS03",
            "WS04",
            "WS06",
            "WS07",
            "WS08",
            "WS09",
            "WS10",
            "WS11",
            "WS12",
            "WS01",
            "WS05",
            "WB01",
            "WB02",
            "WB03",
            "WB04",
            "WB05",
            "WT01",
            "WT02",
            "WT03",
            "WT04",
            "WT05",
            "WT06",
            "WT07",
            "WT08",
            "WT09",
            "WP01",
            "WP02",
            "WP03",
            "WP04",
            "WP05",
            "WP06",
            "WP07",
            "WP08",
            "WP09",
            "WP10",
            "WP11",
            "WP12",
            "WP13",
            "WSH01",
            "WSH02",
            "WSH03",
            "WSH04",
            "WSH05",
            "WSH06",
            "WSH07",
            "WSH08",
            "WSH09",
            "WSH10",
            "WSH11",
            "WSH12",
            "24-WG085_Group"
    );

    List<ProductDocument> productDocuments = catalogResource.getProductsBySku(storeId, skus);

    assertThat(productDocuments).as("Unexpected number of products queried via their respectice SKUs.").hasSize(187);
  }
}
