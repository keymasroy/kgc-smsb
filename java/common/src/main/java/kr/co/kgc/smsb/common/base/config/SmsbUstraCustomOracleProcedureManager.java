package kr.co.kgc.smsb.common.base.config;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallOption;
import com.gsitm.ustra.java.data.utils.procedure.ProcedureCallResult;
import com.gsitm.ustra.java.data.utils.procedure.UstraOracleProcedureManager;

import kr.co.kgc.smsb.common.base.exception.SmsbSpException;
import kr.co.kgc.smsb.common.base.model.SmsbProcBaseModel;

@Component
public class SmsbUstraCustomOracleProcedureManager extends UstraOracleProcedureManager {
	
	@Autowired SmsbCommonCodeDataMapper smsbCommonCodeDataMapper;

	public SmsbUstraCustomOracleProcedureManager(DataSource dataSource) {
		super(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> ProcedureCallResult<R> call(ProcedureCallOption<R> option) {
		ProcedureCallResult<R> procedureResult = super.call(option);

		// 응답 코드 비교
		if (procedureResult.getData() != null) {
			R bodyResult = procedureResult.getData();

			// map으로 반환될 경우
			if (bodyResult instanceof Map) {
				Map<String, Object> mapResult = (Map<String, Object>)bodyResult;

				// SP 정상 응답 코드가 아닐 경우 Exception 처리(RSPN_DVCD 공통코드의 ETC1 값이 Y 인 경우)
				if (smsbCommonCodeDataMapper.map("RSPN_DVCD", mapResult.get("otResponCode").toString(), "Y").isPresent()) {
					throw new SmsbSpException(mapResult.get("otResponCode").toString(), mapResult.get("otResMsg").toString()).exception();
				}
			}
			// model 인스턴스 일 경우
			else if(bodyResult instanceof SmsbProcBaseModel)  {
				// 상속받는 상위 model로 변환하여 SP 응답코드 점검
				SmsbProcBaseModel result = (SmsbProcBaseModel)bodyResult;
				
				// SP 정상 응답 코드가 아닐 경우 Exception 처리(RSPN_DVCD 공통코드의 ETC1 값이 Y 인 경우)
				if (smsbCommonCodeDataMapper.map("RSPN_DVCD", result.getOtResponCode(), "Y").isPresent()) {
					throw new SmsbSpException(result.getOtResponCode(), result.getOtResMsg());
				}
			}
		}

		return procedureResult;
	}
}