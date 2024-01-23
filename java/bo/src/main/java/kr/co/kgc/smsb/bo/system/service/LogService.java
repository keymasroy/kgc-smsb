package kr.co.kgc.smsb.bo.system.service;

import kr.co.kgc.smsb.bo.system.model.LogModel;
import kr.co.kgc.smsb.bo.system.model.LogRqVo;
import kr.co.kgc.smsb.bo.system.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    LogRepository logRepository;

    public List<LogModel> getQryHistory(String procId, String reqId) {
        return logRepository.select(procId, reqId);
    }

    public List<LogModel> getQryHistory(LogRqVo logRqVo) {
        return logRepository.selectWithVo(logRqVo);
    }
}
