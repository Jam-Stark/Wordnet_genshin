package wordnet.genshin.service;

import wordnet.genshin.domain.Calendar;

import java.util.List;

public interface CalendarService {

    public boolean updateRecord(Integer number,String medal,String uname);

    public boolean completed_(String Date,String uname);

    public List<Calendar> showByUser(String uname);


}
