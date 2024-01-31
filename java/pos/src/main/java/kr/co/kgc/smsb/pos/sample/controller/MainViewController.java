package kr.co.kgc.smsb.pos.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gsitm.ustra.java.management.models.UstraUserModel;

import kr.co.kgc.smsb.pos.config.SmsbPosConfigProperties;
import kr.co.kgc.smsb.pos.sample.service.SampleService;

@Controller
public class MainViewController {

    @Autowired
    SampleService sampleService;

    @Autowired
    private SmsbPosConfigProperties smsbPosConfigProperties;

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/list")
    public String list(Model model) {

        List<UstraUserModel> users = sampleService.getUsers();

        model.addAttribute("prop", smsbPosConfigProperties);
        model.addAttribute("users", users);
        model.addAttribute("message", "test message");
        return "sample/list";
    }

    
    @PostMapping("/post-list")
    public String postList(Model model, @RequestParam("postValue") String param1) {

        List<UstraUserModel> users = sampleService.getUsers();

        model.addAttribute("prop", smsbPosConfigProperties);
        model.addAttribute("users", users);
        model.addAttribute("message", "test message");
        model.addAttribute("postParam", param1);
        return "sample/post-list";
    }

}
