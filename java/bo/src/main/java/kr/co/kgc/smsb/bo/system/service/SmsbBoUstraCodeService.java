package kr.co.kgc.smsb.bo.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallOption;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallResult;
import com.gsitm.ustra.java.management.models.UstraCodeModel;
import com.gsitm.ustra.java.management.services.defaults.DefaultDbUstraCodeService;

import kr.co.kgc.smsb.bo.system.model.SmsbBoUstraCodeModel;
import kr.co.kgc.smsb.common.base.config.SmsbUstraCustomOracleProcedureManager;

@Component
@Transactional
public class SmsbBoUstraCodeService extends DefaultDbUstraCodeService {
	
	@Autowired private SmsbUstraCustomOracleProcedureManager oracleProcedureManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UstraCodeModel> getCodes(UstraCodeModel.Criteria in) {
		
		SmsbBoUstraCodeModel.Criteria criteria = new SmsbBoUstraCodeModel.Criteria();
		criteria.setCdNm(in.getCdNm());
		criteria.setDtlCd(in.getDtlCd());
		criteria.setGrpCd(in.getGrpCd());
		criteria.setGrpCds(in.getGrpCds());
		criteria.setGrpNm(in.getGrpNm());
		criteria.setLclsCd(in.getLclsCd());
		criteria.setMclsCd(in.getMclsCd());
		criteria.setSortDirection(in.getSortDirection());
		criteria.setSortItem(in.getSortItem());
		criteria.setUseYn(in.getUseYn());
		criteria.setRegUserId("APP");
		criteria.setRegUserIp("127.0.0.1");
		
		ProcedureCallResult<SmsbBoUstraCodeModel> result = oracleProcedureManager.call(
				ProcedureCallOption.returnObjectBuilder("SP_SY_CD_0001_LST", in, SmsbBoUstraCodeModel.class)
					.convertReturnKeyToCamelCase(false)
					.convertParameterKeyToUnderScore(false)
					.schemaName("KGC")
					.datasourceName("rds1")
					.resultRowMapper("ot_out_cursor", SmsbBoUstraCodeModel.class)
					.build()
		);
		
		List<UstraCodeModel> rtn = (List<UstraCodeModel>) result.getData().getRecord();
		
		return rtn;
		
	}
}
