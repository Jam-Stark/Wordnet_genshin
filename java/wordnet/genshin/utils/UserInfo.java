package wordnet.genshin.utils;

import wordnet.genshin.domain.Calendar;

import java.util.List;

public class UserInfo {
    private List<Calendar> calendarList;
    private Image sculpture;

    public List<Calendar> getCalendarList() {
        return calendarList;
    }

    public void setCalendarList(List<Calendar> calendarList) {
        this.calendarList = calendarList;
    }

    public Image getSculpture() {
        return sculpture;
    }

    public void setSculpture(Image sculpture) {
        this.sculpture = sculpture;
    }
}

