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

import wordnet.genshin.domain.Tofel;
import wordnet.genshin.service.TofelService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller

@RequestMapping(value = "/Users")
public class GuserController {
    @Autowired
    private GuserService guserService;

    @Autowired
    private TofelService tofelService;

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView optAdd(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "mail") String mail,
            HttpSession httpSession
    ){
        ModelAndView modelAndView=new ModelAndView();
        boolean status = guserService.addUser(name,password,mail);
        if(status){
            String targetUrl = (String) httpSession.getAttribute("targetUrl");
            if (targetUrl != null && !targetUrl.isEmpty()) {
                modelAndView.setViewName("redirect:" + targetUrl); //这里可能会重定向出问题
            } else {
                modelAndView.setViewName("redirect:../Home.html");
            }
        }
        else {
            //modelAndView.setViewName("redirect:../Login.html");
            modelAndView.addObject("error", "该用户名已存在");
        }
        return modelAndView;
    }
//    @RequestMapping(value = "/register",method = RequestMethod.GET)
//    public MessageAndData optAdd(Guser guser){
//        boolean b = guserService.addUser(guser.getUname(),guser.getUpassword(),guser.getUmail());
//        if(b){
//            return MessageAndData.success().setMessage("用户创建成功");
//        }else{
//            return MessageAndData.error().setMessage("已存在同名用户");
//        }
//    }
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
    @RequestMapping(value = "/resetpassword",method = RequestMethod.POST)
    public ModelAndView resetPass(
            @RequestParam("name") String name,
            @RequestParam("prePassword") String prePassword,
            @RequestParam("newPassword") String newPassword,
            HttpSession httpSession
    ) {
        ModelAndView modelAndView = new ModelAndView();
      //  System.out.println(name+" and "+password);
        boolean status = guserService.loginCheck_(name,prePassword);
        if (status) {
            guserService.resetPass(name,newPassword);
            modelAndView.setViewName("redirect:../Login.html");
        }else {
            System.out.println("用户名或原密码错误！");
        }

        return modelAndView;
    }


@ResponseBody
    @RequestMapping("/setWordbook")
    public MessageAndData setWordbook(
            @RequestParam(value = "book") String book,
            @RequestParam(value = "daily",defaultValue = "30") Integer daily,
            HttpSession httpSession) {

        String username = (String) httpSession.getAttribute("UserName"); // 获取保存在session中的guser对象
    System.out.println(username);
    System.out.println(book);
        if (username != null) {

            // 在这里使用username和book进行后续操作
            boolean status = guserService.setWordbook(book, username,daily);//username一般放最后一个参数

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
    @RequestMapping("/wordRecord")   //单词本关闭时调用，记录最后背的单词
    public MessageAndData wordRecord(
                                       HttpSession httpSession){
        String username = (String) httpSession.getAttribute("UserName");
         Long wid=(Long) httpSession.getAttribute("Current");
        boolean status=guserService.wordRecord(wid,username);
        if(status)
            return  MessageAndData.success().setMessage("记录更新成功");
        else
            return MessageAndData.error().setMessage("记录更新失败");

    }

    @RequestMapping("/checkWordnet")
    public ModelAndView checkWordnet(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
       String uname=(String) httpSession.getAttribute("UserName");
        String bookUrl=null;
        if(guserService.checkBook(uname)) {
            bookUrl = guserService.getWordnet(uname);
            modelAndView.setViewName("redirect:/"+bookUrl+".html"); //跳转到对应单词本的地址
        }
        else
            modelAndView.setViewName("redirect:../Login.html");

        return modelAndView;
    }

    @RequestMapping(value="browse")//未登记单词本用户浏览单词本
    @ResponseBody
    public MessageAndData browse(
            @RequestParam(value="from",defaultValue="1")Integer from,
            HttpSession httpSession
    ){
        String uname=(String) httpSession.getAttribute("UserName");

        from=guserService.getUfinalword(uname).intValue();
        httpSession.setAttribute("Current",from);
        Integer to=guserService.getUdaily(uname)+from;
        List<Tofel> tofelList = tofelService.selectMuti(from, to);
        PageHelper.startPage(from, to);  //左闭右开 [from,to)
        PageInfo pageInfo = new PageInfo(tofelList, 0);
        return MessageAndData.success().add("pageInfo",pageInfo);
    }

    @RequestMapping(value="tablet")  //已选择单词本情况下,每次刷新页面调用一次
    @ResponseBody
    public MessageAndData tablet(
            HttpSession httpSession
    ){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer from=guserService.getUfinalword(uname).intValue();  //取得最后记录的单词位置
        httpSession.setAttribute("Current",from);        //current记录用户会话内阅读的单词id
        Integer to=guserService.getUdaily(uname)+from;           //取得每日计划
        String book=guserService.getWordnet(uname);
        List<?> dataList = null; // 声明一个模板列表，初始为null

        if (Objects.equals(book, "toefl")) {
            dataList = tofelService.selectMuti(from, to);
//        } else if (Objects.equals(book, "gre")) {
//            dataList = greService.selectMuti(from, to);
//        } else if (Objects.equals(book, "zk")) {
//            dataList = zkService.selectMuti(from, to);
//        } else if (Objects.equals(book, "gk")) {
//            dataList = gkService.selectMuti(from, to);
//        } else if (Objects.equals(book, "ielts")) {
//            dataList = ieltsService.selectMuti(from, to);
//        } else if (Objects.equals(book, "cet4")) {
//            dataList = cet4Service.selectMuti(from, to);
//        } else if (Objects.equals(book, "cet6")) {
//            dataList = cet6Service.selectMuti(from, to);
        }

        if (dataList != null) {
            PageHelper.startPage(from, to);  //左闭右开 [from,to)
            PageInfo pageInfo = new PageInfo(dataList, 0);
            return MessageAndData.success().add("pageInfo",pageInfo);
        }else
            return MessageAndData.error().setMessage("获取失败！");
    }

    @RequestMapping(value="tablet/nextpage") //往后翻页
    public MessageAndData nextpage(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");
        Integer next=guserService.getUdaily(uname);
        if(next==null)            //未注册单词本用户默认30
        {
            current+=30;
        }
        httpSession.setAttribute("Current",current);
        return MessageAndData.success().setMessage("下一页");
    }

    @RequestMapping(value="tablet/prepage")  //往前翻页
    public MessageAndData prepage(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");
        Integer next=guserService.getUdaily(uname);
        if(next==null)
        {
            current-=30;
        }
        current-=next;
        httpSession.setAttribute("Current",current);
        return MessageAndData.success().setMessage("上一页");
    }

    @RequestMapping(value="browser/nextone") //往前一个
    public MessageAndData nextone(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");
        Integer next=guserService.getUdaily(uname);
        current++;
        httpSession.setAttribute("Current",current);
        return MessageAndData.success().setMessage("下一页");
    }

    @RequestMapping(value="browser/preone")  //往后一个
    public MessageAndData preone(HttpSession httpSession){
        String uname=(String) httpSession.getAttribute("UserName");
        Integer current=(Integer) httpSession.getAttribute("Current");
        Integer next=guserService.getUdaily(uname);
        current--;
        httpSession.setAttribute("Current",current);
        return MessageAndData.success().setMessage("下一页");
    }

}
