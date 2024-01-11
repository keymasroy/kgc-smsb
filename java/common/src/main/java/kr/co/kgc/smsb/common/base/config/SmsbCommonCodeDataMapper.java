package kr.co.kgc.smsb.common.base.config;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.gsitm.ustra.java.data.store.CommonDataStore;
import com.gsitm.ustra.java.management.data.mapper.UstraCommonCodeDataMapper;
import com.gsitm.ustra.java.management.models.UstraCodeModel;
import com.gsitm.ustra.java.management.services.UstraCodeService;

@Component
public class SmsbCommonCodeDataMapper extends UstraCommonCodeDataMapper {

	public SmsbCommonCodeDataMapper(CommonDataStore store, UstraCodeService codeService) {
		super(store, codeService);
	}

	@Override
	public Optional<UstraCodeModel> map(Object key1, Object key2, Object key3) {
		return this.getData().stream().filter(data -> {
			return data.getGrpCd().equals(key1) && data.getDtlCd().equals(key2) && ( data.getEtc1() != null && data.getEtc1().equals(key3));
		}).findFirst();
	}
}