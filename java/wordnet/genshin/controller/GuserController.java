package wordnet.genshin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import wordnet.genshin.utils.MessageAndData;
import wordnet.genshin.domain.Guser;
import wordnet.genshin.service.GuserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping(value = "/Users")
public class GuserController {
    @Autowired
    private GuserService guserService;

//    @ResponseBody
//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public MessageAndData optAdd(
//            @RequestParam(value = "name") String name,
//            @RequestParam(value = "password") String password,
//            @RequestParam(value = "mail") String mail
//    ){
//        boolean b = guserService.addUser(name,password,mail);
//        if(b){
//            return MessageAndData.success().setMessage("用户创建成功");
//        }else{
//            return MessageAndData.error().setMessage("已存在同名用户");
//        }
//    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public MessageAndData optAdd(Guser guser){
        boolean b = guserService.addUser(guser.getUname(),guser.getUpassword(),guser.getUmail());
        if(b){
            return MessageAndData.success().setMessage("用户创建成功");
        }else{
            return MessageAndData.error().setMessage("已存在同名用户");
        }
    }
//    @RequestMapping("/login")
//    public ModelAndView login(Guser guser, HttpSession httpSession){
//        //ModelAndView  对象是spring封装model和view的通用容器
//        ModelAndView modelAndView = new ModelAndView();
//
//        //调用service进行登录验证
//        boolean status  = guserService.loginCheck(guser);
//        if(status){
//            //登录验证成功
//            //http是一个无状态协议，为了保持通信双方的身份识别，一般采用  session（cookie）
//            httpSession.setAttribute("EMP_SESSION",guser);
//            modelAndView.setViewName("redirect:../Home.html");//
//        }else{
//            //回到登录页面
//            modelAndView.setViewName("redirect:../Register.html");//设置视图页   , 默认springmvc使用了视图解析器，会自动填充前缀和后缀
//        }
//
//        return modelAndView;
//    }
    @ResponseBody
@RequestMapping(value = "/login",method = RequestMethod.POST)
public ModelAndView login(
        @RequestParam("name") String name,
        @RequestParam("password") String password,
        HttpSession httpSession
) {
    ModelAndView modelAndView = new ModelAndView();
//Guser guser=new Guser();
//guser.setUname(name);
//guser.setUpassword(password);
    // 调用service进行登录验证
   // System.out.println(guser);
        System.out.println(name+" and "+password);
    boolean status = guserService.loginCheck_(name,password);
    //boolean status =true;
    if (status) {
        // 登录验证成功
        // 将用户对象存储在session中
        httpSession.setAttribute("EMP_SESSION", name);

        String targetUrl = (String) httpSession.getAttribute("targetUrl");
        System.out.println("controller: "+targetUrl);
        if (targetUrl != null && !targetUrl.isEmpty()) {
            modelAndView.setViewName("redirect:" + targetUrl);
        } else {
            modelAndView.setViewName("redirect:../Home.html");
        }
    }else {
        System.out.println("用户名或密码错误！");
        modelAndView.setViewName("redirect:../Login.html");
    }

    return modelAndView;
}

@ResponseBody
    @RequestMapping("/setWordbook")
    public MessageAndData setWordbook(
            @RequestParam(value = "book") String book,
            HttpSession httpSession) {

        String username = (String) httpSession.getAttribute("EMP_SESSION"); // 获取保存在session中的guser对象
    System.out.println(username);
    System.out.println(book);
        if (username != null) {

            // 在这里使用username和book进行后续操作
            boolean status = guserService.setWordbook(book, username);//username一般放最后一个参数

            if (status) {
                return MessageAndData.success().setMessage("设置Wordbook成功");
            } else {
                return MessageAndData.error().setMessage("设置Wordbook失败");
            }
        } else {
            // 用户未登录或session失效，可以进行相应处理
            return MessageAndData.error().setMessage("用户未登录或session失效");
        }
    }

    @ResponseBody
    @RequestMapping("/wordRecord")
    public MessageAndData wordRecord(  @RequestParam(value = "wid") Long wid,
                                       HttpSession httpSession){
        String username = (String) httpSession.getAttribute("EMP_SESSION");
        boolean status=guserService.wordRecord(wid,username);
        if(status)
            return  MessageAndData.success().setMessage("记录更新成功");
        else
            return MessageAndData.error().setMessage("记录更新失败");

    }

    @RequestMapping("/checkWordnet")
    public ModelAndView checkWordnet(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
       String uname=(String) httpSession.getAttribute("EMP_SESSION");
        String bookUrl=null;
        if(guserService.checkBook(uname)) {
            bookUrl = guserService.getWordnet(uname);
            modelAndView.setViewName("redirect:/"+bookUrl);
        }
        else
            modelAndView.setViewName("redirect:../Login.html");

        return modelAndView;
    }
}
