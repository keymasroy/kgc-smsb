package kr.co.kgc.smsb.bo.system.model;

import com.gsitm.ustra.java.data.base.UstraBaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class LogModel extends UstraBaseModel {

    /**
     * 쿼리 이력 아이디
     */
    private String dbmsQryHistId;

    /**
     * 프로세스 아이디
     */
    private String procId;

    /**
     * 요청 아이디
     */
    private String reqId;


    /**
     * 처리 시간 (MS)
     */
    private Long procMs;

    @Getter
    @Builder.Default()
    private String orgQryCont = "";

    @Getter
    @Builder.Default()
    private String execQryCont = "";

//    public void setOrgQryCont(String orgQryCont) {
//        this.orgQryCont = StringUtils.defaultString(orgQryCont, "");
//    }
//
//    public void setExecQryCont(String execQryCont) {
//        this.execQryCont = StringUtils.defaultString(execQryCont, "");
//    }

}
