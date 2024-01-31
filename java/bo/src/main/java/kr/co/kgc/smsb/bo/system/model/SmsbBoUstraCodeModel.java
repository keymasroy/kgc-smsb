package kr.co.kgc.smsb.bo.system.model;

import java.util.List;

import com.gsitm.ustra.java.core.utils.annotation.MapField;
import com.gsitm.ustra.java.management.models.UstraCodeModel;

import kr.co.kgc.smsb.common.base.model.SmsbBaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
public class SmsbBoUstraCodeModel extends UstraCodeModel {

	@MapField("ot_out_cursor")
	private List<UstraCodeModel> record;
	
	/**
	 * SP 상태 코드
	 */
	@MapField("OT_STATUS_CODE")
	private String otStatusCode;
	/**
	 * SP 응답 코드
	 */
	@MapField("OT_RESPON_CODE")
	private String otResponCode;
	/**
	 * SP 응답 메시지
	 */
	@MapField("OT_RES_MSG")
	private String otResMsg;
	
	/**
	 * SP 기본 입력, 화면 ID
	 */
	@MapField("IO_UI_ID")
	private String ioUiId;
	
	/**
	 * SP 기본 입력, 프로세스 ID
	 */
	@MapField("IO_PRCD_ID")
	private String ioPrcdId;
	
	/**
	 * 검색 조건
	 * @author RoyLee
	 *
	 */
    @Data
    @SuperBuilder
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(callSuper=false)
    public static class Criteria extends SmsbBaseModel {

    	/**
    	 * 그룹 코드
    	 */
    	private String grpCd;

    	/**
    	 * 상세 코드
    	 */
    	private String dtlCd;

    	/**
    	 * 사용 여부
    	 */
    	private String useYn;

    	/**
    	 * 그룹 코드 목록
    	 */
    	private String[] grpCds;

    	/**
    	 * 그룹 명
    	 */
    	private String grpNm;
    	private String lclsCd;
    	private String mclsCd;

    	/**
    	 * 코드 명
    	 */
    	private String cdNm;

    	/**
    	 * 정렬 아이템
    	 */
        private String sortItem;

        /**
         * 정렬 방향
         */
    	private String sortDirection;
    }
}
