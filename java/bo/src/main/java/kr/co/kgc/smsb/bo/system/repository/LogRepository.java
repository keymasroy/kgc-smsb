package kr.co.kgc.smsb.bo.system.repository;

import kr.co.kgc.smsb.bo.system.model.LogModel;
import kr.co.kgc.smsb.bo.system.model.LogRqVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogRepository {
    List<LogModel> select(String procId, String reqId);

    List<LogModel> selectWithVo(LogRqVo logRqVo);
}
