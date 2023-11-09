package vip.epss.service;

import java.util.Date;

public interface NewbookService {
    public boolean InsertOne(String word, Date date);
    public boolean DeleteOne(String word);
}
