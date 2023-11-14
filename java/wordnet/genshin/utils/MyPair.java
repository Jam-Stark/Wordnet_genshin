package wordnet.genshin.utils;

import wordnet.genshin.domain.Urank;

public class MyPair {
    private int number;

    private Urank urank;

    public MyPair( int number,Urank urank) {

        this.number = number;
        this.urank=urank;
    }


    public int getNumber() {
        return number;
    }

    public Urank getUrank(){return urank;}


    public void setNumber(int number) {
        this.number = number;
    }

    public void setUrank(Urank urank) {
        this.urank = urank;
    }

}  //自定义一个pair用于排序