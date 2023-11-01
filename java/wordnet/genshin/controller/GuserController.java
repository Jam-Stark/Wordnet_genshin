package wordnet.genshin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import wordnet.genshin.domain.Employee;
import wordnet.genshin.utils.MessageAndData;
import wordnet.genshin.domain.Guser;
import wordnet.genshin.service.GuserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping(value = "/User")
public class GuserController {
    @Autowired
    private GuserService guserService;

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public MessageAndData optAdd(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "mail") String mail
    ){
        boolean b = guserService.addUser(name,password,mail);
        if(b){
            return MessageAndData.success().setMessage("用户创建成功");
        }else{
            return MessageAndData.error().setMessage("已存在同名用户");
        }
    }
}
