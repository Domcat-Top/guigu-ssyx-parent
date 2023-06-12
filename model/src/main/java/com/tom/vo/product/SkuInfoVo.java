package com.tom.vo.product;

import com.tom.model.product.*;
import com.tom.model.product.SkuAttrValue;
import com.tom.model.product.SkuImage;
import com.tom.model.product.SkuInfo;
import com.tom.model.product.SkuPoster;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SkuInfoVo extends SkuInfo {

	@ApiModelProperty(value = "海报列表")
	private List<SkuPoster> skuPosterList;

	@ApiModelProperty(value = "属性值")
	private List<SkuAttrValue> skuAttrValueList;

	@ApiModelProperty(value = "图片")
	private List<SkuImage> skuImagesList;

}

