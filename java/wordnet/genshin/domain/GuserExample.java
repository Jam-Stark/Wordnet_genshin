package wordnet.genshin.domain;

import java.util.ArrayList;
import java.util.List;

public class GuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuserExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUpasswordIsNull() {
            addCriterion("upassword is null");
            return (Criteria) this;
        }

        public Criteria andUpasswordIsNotNull() {
            addCriterion("upassword is not null");
            return (Criteria) this;
        }

        public Criteria andUpasswordEqualTo(String value) {
            addCriterion("upassword =", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotEqualTo(String value) {
            addCriterion("upassword <>", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordGreaterThan(String value) {
            addCriterion("upassword >", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("upassword >=", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLessThan(String value) {
            addCriterion("upassword <", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLessThanOrEqualTo(String value) {
            addCriterion("upassword <=", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordLike(String value) {
            addCriterion("upassword like", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotLike(String value) {
            addCriterion("upassword not like", value, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordIn(List<String> values) {
            addCriterion("upassword in", values, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotIn(List<String> values) {
            addCriterion("upassword not in", values, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordBetween(String value1, String value2) {
            addCriterion("upassword between", value1, value2, "upassword");
            return (Criteria) this;
        }

        public Criteria andUpasswordNotBetween(String value1, String value2) {
            addCriterion("upassword not between", value1, value2, "upassword");
            return (Criteria) this;
        }

        public Criteria andUmailIsNull() {
            addCriterion("umail is null");
            return (Criteria) this;
        }

        public Criteria andUmailIsNotNull() {
            addCriterion("umail is not null");
            return (Criteria) this;
        }

        public Criteria andUmailEqualTo(String value) {
            addCriterion("umail =", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotEqualTo(String value) {
            addCriterion("umail <>", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailGreaterThan(String value) {
            addCriterion("umail >", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailGreaterThanOrEqualTo(String value) {
            addCriterion("umail >=", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLessThan(String value) {
            addCriterion("umail <", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLessThanOrEqualTo(String value) {
            addCriterion("umail <=", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLike(String value) {
            addCriterion("umail like", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotLike(String value) {
            addCriterion("umail not like", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailIn(List<String> values) {
            addCriterion("umail in", values, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotIn(List<String> values) {
            addCriterion("umail not in", values, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailBetween(String value1, String value2) {
            addCriterion("umail between", value1, value2, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotBetween(String value1, String value2) {
            addCriterion("umail not between", value1, value2, "umail");
            return (Criteria) this;
        }

        public Criteria andUwordnetIsNull() {
            addCriterion("uwordnet is null");
            return (Criteria) this;
        }

        public Criteria andUwordnetIsNotNull() {
            addCriterion("uwordnet is not null");
            return (Criteria) this;
        }

        public Criteria andUwordnetEqualTo(String value) {
            addCriterion("uwordnet =", value, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetNotEqualTo(String value) {
            addCriterion("uwordnet <>", value, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetGreaterThan(String value) {
            addCriterion("uwordnet >", value, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetGreaterThanOrEqualTo(String value) {
            addCriterion("uwordnet >=", value, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetLessThan(String value) {
            addCriterion("uwordnet <", value, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetLessThanOrEqualTo(String value) {
            addCriterion("uwordnet <=", value, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetLike(String value) {
            addCriterion("uwordnet like", value, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetNotLike(String value) {
            addCriterion("uwordnet not like", value, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetIn(List<String> values) {
            addCriterion("uwordnet in", values, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetNotIn(List<String> values) {
            addCriterion("uwordnet not in", values, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetBetween(String value1, String value2) {
            addCriterion("uwordnet between", value1, value2, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUwordnetNotBetween(String value1, String value2) {
            addCriterion("uwordnet not between", value1, value2, "uwordnet");
            return (Criteria) this;
        }

        public Criteria andUfinalwordIsNull() {
            addCriterion("ufinalword is null");
            return (Criteria) this;
        }

        public Criteria andUfinalwordIsNotNull() {
            addCriterion("ufinalword is not null");
            return (Criteria) this;
        }

        public Criteria andUfinalwordEqualTo(Long value) {
            addCriterion("ufinalword =", value, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordNotEqualTo(Long value) {
            addCriterion("ufinalword <>", value, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordGreaterThan(Long value) {
            addCriterion("ufinalword >", value, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordGreaterThanOrEqualTo(Long value) {
            addCriterion("ufinalword >=", value, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordLessThan(Long value) {
            addCriterion("ufinalword <", value, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordLessThanOrEqualTo(Long value) {
            addCriterion("ufinalword <=", value, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordIn(List<Long> values) {
            addCriterion("ufinalword in", values, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordNotIn(List<Long> values) {
            addCriterion("ufinalword not in", values, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordBetween(Long value1, Long value2) {
            addCriterion("ufinalword between", value1, value2, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUfinalwordNotBetween(Long value1, Long value2) {
            addCriterion("ufinalword not between", value1, value2, "ufinalword");
            return (Criteria) this;
        }

        public Criteria andUdailyIsNull() {
            addCriterion("udaily is null");
            return (Criteria) this;
        }

        public Criteria andUdailyIsNotNull() {
            addCriterion("udaily is not null");
            return (Criteria) this;
        }

        public Criteria andUdailyEqualTo(Integer value) {
            addCriterion("udaily =", value, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyNotEqualTo(Integer value) {
            addCriterion("udaily <>", value, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyGreaterThan(Integer value) {
            addCriterion("udaily >", value, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyGreaterThanOrEqualTo(Integer value) {
            addCriterion("udaily >=", value, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyLessThan(Integer value) {
            addCriterion("udaily <", value, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyLessThanOrEqualTo(Integer value) {
            addCriterion("udaily <=", value, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyIn(List<Integer> values) {
            addCriterion("udaily in", values, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyNotIn(List<Integer> values) {
            addCriterion("udaily not in", values, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyBetween(Integer value1, Integer value2) {
            addCriterion("udaily between", value1, value2, "udaily");
            return (Criteria) this;
        }

        public Criteria andUdailyNotBetween(Integer value1, Integer value2) {
            addCriterion("udaily not between", value1, value2, "udaily");
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