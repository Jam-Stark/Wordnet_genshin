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
    public String getUname(int id) {
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUidEqualTo(id);
        return userMapper.selectByExample(userExample).get(0).getUname();
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
    public boolean loginCheck(Guser user) {
        boolean flag= false;
        GuserExample userExample=new GuserExample();
        GuserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUnameEqualTo(user.getUname()).andUpasswordEqualTo(user.getUpassword());

        List<Guser> guserList=userMapper.selectByExample(userExample);
        if(!guserList.isEmpty())
            flag=true;
        else
            flag=false;

        return flag;
    }


}
