package vip.epss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NewbookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewbookExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andNewidIsNull() {
            addCriterion("newid is null");
            return (Criteria) this;
        }

        public Criteria andNewidIsNotNull() {
            addCriterion("newid is not null");
            return (Criteria) this;
        }

        public Criteria andNewidEqualTo(Integer value) {
            addCriterion("newid =", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidNotEqualTo(Integer value) {
            addCriterion("newid <>", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidGreaterThan(Integer value) {
            addCriterion("newid >", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidGreaterThanOrEqualTo(Integer value) {
            addCriterion("newid >=", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidLessThan(Integer value) {
            addCriterion("newid <", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidLessThanOrEqualTo(Integer value) {
            addCriterion("newid <=", value, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidIn(List<Integer> values) {
            addCriterion("newid in", values, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidNotIn(List<Integer> values) {
            addCriterion("newid not in", values, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidBetween(Integer value1, Integer value2) {
            addCriterion("newid between", value1, value2, "newid");
            return (Criteria) this;
        }

        public Criteria andNewidNotBetween(Integer value1, Integer value2) {
            addCriterion("newid not between", value1, value2, "newid");
            return (Criteria) this;
        }

        public Criteria andNewwordIsNull() {
            addCriterion("newword is null");
            return (Criteria) this;
        }

        public Criteria andNewwordIsNotNull() {
            addCriterion("newword is not null");
            return (Criteria) this;
        }

        public Criteria andNewwordEqualTo(String value) {
            addCriterion("newword =", value, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordNotEqualTo(String value) {
            addCriterion("newword <>", value, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordGreaterThan(String value) {
            addCriterion("newword >", value, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordGreaterThanOrEqualTo(String value) {
            addCriterion("newword >=", value, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordLessThan(String value) {
            addCriterion("newword <", value, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordLessThanOrEqualTo(String value) {
            addCriterion("newword <=", value, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordLike(String value) {
            addCriterion("newword like", value, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordNotLike(String value) {
            addCriterion("newword not like", value, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordIn(List<String> values) {
            addCriterion("newword in", values, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordNotIn(List<String> values) {
            addCriterion("newword not in", values, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordBetween(String value1, String value2) {
            addCriterion("newword between", value1, value2, "newword");
            return (Criteria) this;
        }

        public Criteria andNewwordNotBetween(String value1, String value2) {
            addCriterion("newword not between", value1, value2, "newword");
            return (Criteria) this;
        }

        public Criteria andNewdataIsNull() {
            addCriterion("newdata is null");
            return (Criteria) this;
        }

        public Criteria andNewdataIsNotNull() {
            addCriterion("newdata is not null");
            return (Criteria) this;
        }

        public Criteria andNewdataEqualTo(Date value) {
            addCriterionForJDBCDate("newdata =", value, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataNotEqualTo(Date value) {
            addCriterionForJDBCDate("newdata <>", value, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataGreaterThan(Date value) {
            addCriterionForJDBCDate("newdata >", value, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("newdata >=", value, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataLessThan(Date value) {
            addCriterionForJDBCDate("newdata <", value, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("newdata <=", value, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataIn(List<Date> values) {
            addCriterionForJDBCDate("newdata in", values, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataNotIn(List<Date> values) {
            addCriterionForJDBCDate("newdata not in", values, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("newdata between", value1, value2, "newdata");
            return (Criteria) this;
        }

        public Criteria andNewdataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("newdata not between", value1, value2, "newdata");
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