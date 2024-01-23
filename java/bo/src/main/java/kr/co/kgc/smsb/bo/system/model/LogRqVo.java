package kr.co.kgc.smsb.bo.system.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LogRqVo {

    /**
     * 프로세스 아이디
     */
    @NotEmpty
    private String procId;

    /**
     * 요청 아이디
     */
    @NotEmpty
    private String reqId;

}
