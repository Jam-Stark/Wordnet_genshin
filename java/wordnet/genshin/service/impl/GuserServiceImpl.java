package wordnet.genshin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordnet.genshin.dao.GuserMapper;
import wordnet.genshin.domain.Guser;
import wordnet.genshin.domain.GuserExample;
import wordnet.genshin.service.GuserService;

import java.util.List;

@Service(value = "GuserService")
public class GuserServiceImpl implements GuserService {

    @Autowired
    private GuserMapper userMapper;

    @Override
    public Integer getUid(String name) {
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(name);
        return userMapper.selectByExample(userExample).get(0).getUid();
    }

    @Override
    public String getUname(Integer id) {
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUidEqualTo(id);
        return userMapper.selectByExample(userExample).get(0).getUname();
    }

    @Override
    public Long getUfinalword(String name) {
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(name);
        return userMapper.selectByExample(userExample).get(0).getUfinalword();
    }

    @Override
    public Integer getUdaily(String name) {
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(name);
        return userMapper.selectByExample(userExample).get(0).getUdaily();
    }

    @Override
    public boolean setUdaily(Integer daily,String uname) {

        boolean flag= false;
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(uname);

        List<Guser> guserList=userMapper.selectByExample(userExample);

        if(!guserList.get(0).getUwordnet().isEmpty()) {
            guserList.get(0).setUdaily(daily);
            flag = true;
        }
        return flag;
    }

    @Override
    public String getWordnet(String uname) {
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(uname);
        return userMapper.selectByExample(userExample).get(0).getUwordnet();
    }

    @Override
    public boolean addUser(String name, String password, String mail) {

        Guser record = new Guser();
        record.setUname(name);
        record.setUpassword(password);
        record.setUmail(mail);
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(name);

        List<Guser> guserList=userMapper.selectByExample(userExample);
        if(!guserList.isEmpty()) {
            System.out.println("存在同名用户");
            return false;
        }
        else{
            userMapper.insert(record);
            return true;
        }

    }

    @Override
    public boolean resetPass(String name, String password) {
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(name);

        userMapper.selectByExample(userExample).get(0).setUpassword(password);
        return false;
    }

    @Override
    public boolean loginCheck(Guser user) {
        boolean flag= false;
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(user.getUname()).andUpasswordEqualTo(user.getUpassword());

        List<Guser> guserList=userMapper.selectByExample(userExample);
        if(!guserList.isEmpty())
            flag=true;

        return flag;
    }

    @Override
    public boolean loginCheck_(String name, String password) {
        boolean flag= false;
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(name).andUpasswordEqualTo(password);

        List<Guser> guserList=userMapper.selectByExample(userExample);
        if(!guserList.isEmpty())
            flag=true;
        return flag;
    }

    @Override
    public boolean setWordbook(String book,String uname,Integer daily) {
        boolean flag= false;
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(uname);

        List<Guser> guserList=userMapper.selectByExample(userExample);
        guserList.get(0).setUwordnet(book);

        if(!guserList.get(0).getUwordnet().isEmpty()) {
            guserList.get(0).setUdaily(daily);
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean wordRecord(Long id,String uname) {
        boolean flag= false;
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(uname);

        List<Guser> guserList=userMapper.selectByExample(userExample);
        guserList.get(0).setUfinalword(id);
        if(!guserList.get(0).getUfinalword().toString().isEmpty())
            flag=true;
        return flag;
    }

    @Override
    public boolean checkBook(String uname) {
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(uname);

        if(userMapper.selectByExample(userExample).get(0).getUwordnet().isEmpty())
            return false;
        else
            return true;
    }

//    @Override
//    public String switchBook(String uname) {
//        GuserExample userExample=new GuserExample();
//        GuserExample.Criteria criteria=userExample.createCriteria();
//        criteria.andUnameEqualTo(uname);
//
//        List<Guser> guserList=userMapper.selectByExample(userExample);
//        return guserList.get(0).getUwordnet();
//    }

}
