package kr.co.kgc.smsb.bo.system.controller;

import kr.co.kgc.smsb.bo.system.model.LogModel;
import kr.co.kgc.smsb.bo.system.model.LogRqVo;
import kr.co.kgc.smsb.bo.system.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/system/log")
public class LogController {

    @Autowired
    LogService logService;

    @PostMapping("/qryHistory1")
    public List<LogModel> getQryHistory(@RequestBody Map<String, String> paramMap) {

        log.info("procId: {}", paramMap.get("procId"));
        log.info("reqId: {}", paramMap.get("reqId"));
        return logService.getQryHistory(paramMap.get("procId"), paramMap.get("reqId"));

    }

    @PostMapping("/qryHistory2")
    public List<LogModel> getQryHistory(@RequestBody LogRqVo logRqVo) {
        log.info("logRqVo: {}", logRqVo);
        return logService.getQryHistory(logRqVo);
    }
}
