package wordnet.genshin.domain;

import java.util.ArrayList;
import java.util.List;

public class Words_en_cnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Words_en_cnExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWordIsNull() {
            addCriterion("word is null");
            return (Criteria) this;
        }

        public Criteria andWordIsNotNull() {
            addCriterion("word is not null");
            return (Criteria) this;
        }

        public Criteria andWordEqualTo(String value) {
            addCriterion("word =", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotEqualTo(String value) {
            addCriterion("word <>", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThan(String value) {
            addCriterion("word >", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordGreaterThanOrEqualTo(String value) {
            addCriterion("word >=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThan(String value) {
            addCriterion("word <", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLessThanOrEqualTo(String value) {
            addCriterion("word <=", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordLike(String value) {
            addCriterion("word like", value, "word%");
            return (Criteria) this;
        }

        public Criteria andWordNotLike(String value) {
            addCriterion("word not like", value, "word");
            return (Criteria) this;
        }

        public Criteria andWordIn(List<String> values) {
            addCriterion("word in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotIn(List<String> values) {
            addCriterion("word not in", values, "word");
            return (Criteria) this;
        }

        public Criteria andWordBetween(String value1, String value2) {
            addCriterion("word between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andWordNotBetween(String value1, String value2) {
            addCriterion("word not between", value1, value2, "word");
            return (Criteria) this;
        }

        public Criteria andPhoneticIsNull() {
            addCriterion("phonetic is null");
            return (Criteria) this;
        }

        public Criteria andPhoneticIsNotNull() {
            addCriterion("phonetic is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneticEqualTo(String value) {
            addCriterion("phonetic =", value, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticNotEqualTo(String value) {
            addCriterion("phonetic <>", value, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticGreaterThan(String value) {
            addCriterion("phonetic >", value, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticGreaterThanOrEqualTo(String value) {
            addCriterion("phonetic >=", value, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticLessThan(String value) {
            addCriterion("phonetic <", value, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticLessThanOrEqualTo(String value) {
            addCriterion("phonetic <=", value, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticLike(String value) {
            addCriterion("phonetic like", value, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticNotLike(String value) {
            addCriterion("phonetic not like", value, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticIn(List<String> values) {
            addCriterion("phonetic in", values, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticNotIn(List<String> values) {
            addCriterion("phonetic not in", values, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticBetween(String value1, String value2) {
            addCriterion("phonetic between", value1, value2, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPhoneticNotBetween(String value1, String value2) {
            addCriterion("phonetic not between", value1, value2, "phonetic");
            return (Criteria) this;
        }

        public Criteria andPosIsNull() {
            addCriterion("pos is null");
            return (Criteria) this;
        }

        public Criteria andPosIsNotNull() {
            addCriterion("pos is not null");
            return (Criteria) this;
        }

        public Criteria andPosEqualTo(String value) {
            addCriterion("pos =", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotEqualTo(String value) {
            addCriterion("pos <>", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosGreaterThan(String value) {
            addCriterion("pos >", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosGreaterThanOrEqualTo(String value) {
            addCriterion("pos >=", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLessThan(String value) {
            addCriterion("pos <", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLessThanOrEqualTo(String value) {
            addCriterion("pos <=", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLike(String value) {
            addCriterion("pos like", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotLike(String value) {
            addCriterion("pos not like", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosIn(List<String> values) {
            addCriterion("pos in", values, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotIn(List<String> values) {
            addCriterion("pos not in", values, "pos");
            return (Criteria) this;
        }

        public Criteria andPosBetween(String value1, String value2) {
            addCriterion("pos between", value1, value2, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotBetween(String value1, String value2) {
            addCriterion("pos not between", value1, value2, "pos");
            return (Criteria) this;
        }

        public Criteria andCollinsIsNull() {
            addCriterion("collins is null");
            return (Criteria) this;
        }

        public Criteria andCollinsIsNotNull() {
            addCriterion("collins is not null");
            return (Criteria) this;
        }

        public Criteria andCollinsEqualTo(Integer value) {
            addCriterion("collins =", value, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsNotEqualTo(Integer value) {
            addCriterion("collins <>", value, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsGreaterThan(Integer value) {
            addCriterion("collins >", value, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsGreaterThanOrEqualTo(Integer value) {
            addCriterion("collins >=", value, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsLessThan(Integer value) {
            addCriterion("collins <", value, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsLessThanOrEqualTo(Integer value) {
            addCriterion("collins <=", value, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsIn(List<Integer> values) {
            addCriterion("collins in", values, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsNotIn(List<Integer> values) {
            addCriterion("collins not in", values, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsBetween(Integer value1, Integer value2) {
            addCriterion("collins between", value1, value2, "collins");
            return (Criteria) this;
        }

        public Criteria andCollinsNotBetween(Integer value1, Integer value2) {
            addCriterion("collins not between", value1, value2, "collins");
            return (Criteria) this;
        }

        public Criteria andOxfordIsNull() {
            addCriterion("oxford is null");
            return (Criteria) this;
        }

        public Criteria andOxfordIsNotNull() {
            addCriterion("oxford is not null");
            return (Criteria) this;
        }

        public Criteria andOxfordEqualTo(Integer value) {
            addCriterion("oxford =", value, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordNotEqualTo(Integer value) {
            addCriterion("oxford <>", value, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordGreaterThan(Integer value) {
            addCriterion("oxford >", value, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordGreaterThanOrEqualTo(Integer value) {
            addCriterion("oxford >=", value, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordLessThan(Integer value) {
            addCriterion("oxford <", value, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordLessThanOrEqualTo(Integer value) {
            addCriterion("oxford <=", value, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordIn(List<Integer> values) {
            addCriterion("oxford in", values, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordNotIn(List<Integer> values) {
            addCriterion("oxford not in", values, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordBetween(Integer value1, Integer value2) {
            addCriterion("oxford between", value1, value2, "oxford");
            return (Criteria) this;
        }

        public Criteria andOxfordNotBetween(Integer value1, Integer value2) {
            addCriterion("oxford not between", value1, value2, "oxford");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andBncIsNull() {
            addCriterion("bnc is null");
            return (Criteria) this;
        }

        public Criteria andBncIsNotNull() {
            addCriterion("bnc is not null");
            return (Criteria) this;
        }

        public Criteria andBncEqualTo(Integer value) {
            addCriterion("bnc =", value, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncNotEqualTo(Integer value) {
            addCriterion("bnc <>", value, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncGreaterThan(Integer value) {
            addCriterion("bnc >", value, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncGreaterThanOrEqualTo(Integer value) {
            addCriterion("bnc >=", value, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncLessThan(Integer value) {
            addCriterion("bnc <", value, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncLessThanOrEqualTo(Integer value) {
            addCriterion("bnc <=", value, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncIn(List<Integer> values) {
            addCriterion("bnc in", values, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncNotIn(List<Integer> values) {
            addCriterion("bnc not in", values, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncBetween(Integer value1, Integer value2) {
            addCriterion("bnc between", value1, value2, "bnc");
            return (Criteria) this;
        }

        public Criteria andBncNotBetween(Integer value1, Integer value2) {
            addCriterion("bnc not between", value1, value2, "bnc");
            return (Criteria) this;
        }

        public Criteria andFrqIsNull() {
            addCriterion("frq is null");
            return (Criteria) this;
        }

        public Criteria andFrqIsNotNull() {
            addCriterion("frq is not null");
            return (Criteria) this;
        }

        public Criteria andFrqEqualTo(Integer value) {
            addCriterion("frq =", value, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqNotEqualTo(Integer value) {
            addCriterion("frq <>", value, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqGreaterThan(Integer value) {
            addCriterion("frq >", value, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqGreaterThanOrEqualTo(Integer value) {
            addCriterion("frq >=", value, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqLessThan(Integer value) {
            addCriterion("frq <", value, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqLessThanOrEqualTo(Integer value) {
            addCriterion("frq <=", value, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqIn(List<Integer> values) {
            addCriterion("frq in", values, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqNotIn(List<Integer> values) {
            addCriterion("frq not in", values, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqBetween(Integer value1, Integer value2) {
            addCriterion("frq between", value1, value2, "frq");
            return (Criteria) this;
        }

        public Criteria andFrqNotBetween(Integer value1, Integer value2) {
            addCriterion("frq not between", value1, value2, "frq");
            return (Criteria) this;
        }

        public Criteria andExchangeIsNull() {
            addCriterion("exchange is null");
            return (Criteria) this;
        }

        public Criteria andExchangeIsNotNull() {
            addCriterion("exchange is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeEqualTo(String value) {
            addCriterion("exchange =", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotEqualTo(String value) {
            addCriterion("exchange <>", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeGreaterThan(String value) {
            addCriterion("exchange >", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeGreaterThanOrEqualTo(String value) {
            addCriterion("exchange >=", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLessThan(String value) {
            addCriterion("exchange <", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLessThanOrEqualTo(String value) {
            addCriterion("exchange <=", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeLike(String value) {
            addCriterion("exchange like", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotLike(String value) {
            addCriterion("exchange not like", value, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeIn(List<String> values) {
            addCriterion("exchange in", values, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotIn(List<String> values) {
            addCriterion("exchange not in", values, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeBetween(String value1, String value2) {
            addCriterion("exchange between", value1, value2, "exchange");
            return (Criteria) this;
        }

        public Criteria andExchangeNotBetween(String value1, String value2) {
            addCriterion("exchange not between", value1, value2, "exchange");
            return (Criteria) this;
        }

        public Criteria andAudioIsNull() {
            addCriterion("audio is null");
            return (Criteria) this;
        }

        public Criteria andAudioIsNotNull() {
            addCriterion("audio is not null");
            return (Criteria) this;
        }

        public Criteria andAudioEqualTo(String value) {
            addCriterion("audio =", value, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioNotEqualTo(String value) {
            addCriterion("audio <>", value, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioGreaterThan(String value) {
            addCriterion("audio >", value, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioGreaterThanOrEqualTo(String value) {
            addCriterion("audio >=", value, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioLessThan(String value) {
            addCriterion("audio <", value, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioLessThanOrEqualTo(String value) {
            addCriterion("audio <=", value, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioLike(String value) {
            addCriterion("audio like", value, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioNotLike(String value) {
            addCriterion("audio not like", value, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioIn(List<String> values) {
            addCriterion("audio in", values, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioNotIn(List<String> values) {
            addCriterion("audio not in", values, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioBetween(String value1, String value2) {
            addCriterion("audio between", value1, value2, "audio");
            return (Criteria) this;
        }

        public Criteria andAudioNotBetween(String value1, String value2) {
            addCriterion("audio not between", value1, value2, "audio");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}