package wordnet.genshin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import wordnet.genshin.domain.Employee;
import wordnet.genshin.utils.MessageAndData;
import wordnet.genshin.domain.Guser;
import wordnet.genshin.service.GuserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping(value = "/Home")
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
    @RequestMapping("/Register")
    public ModelAndView login(Guser guser, HttpSession httpSession){
        //ModelAndView  对象是spring封装model和view的通用容器
        ModelAndView modelAndView = new ModelAndView();

        //调用service进行登录验证
        boolean status  = guserService.loginCheck(guser);
        if(status){
            //登录验证成功
            //http是一个无状态协议，为了保持通信双方的身份识别，一般采用  session（cookie）
            httpSession.setAttribute("EMP_SESSION",guser);
            modelAndView.setViewName("redirect:../wordimpact.html");//
        }else{
            //回到登录页面
            modelAndView.setViewName("redirect:../index.html");//设置视图页   , 默认springmvc使用了视图解析器，会自动填充前缀和后缀
        }

        return modelAndView;
    }
}
