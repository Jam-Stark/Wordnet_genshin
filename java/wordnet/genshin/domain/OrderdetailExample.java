package wordnet.genshin.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailExample() {
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

        public Criteria andOdidIsNull() {
            addCriterion("odid is null");
            return (Criteria) this;
        }

        public Criteria andOdidIsNotNull() {
            addCriterion("odid is not null");
            return (Criteria) this;
        }

        public Criteria andOdidEqualTo(Integer value) {
            addCriterion("odid =", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotEqualTo(Integer value) {
            addCriterion("odid <>", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidGreaterThan(Integer value) {
            addCriterion("odid >", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidGreaterThanOrEqualTo(Integer value) {
            addCriterion("odid >=", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidLessThan(Integer value) {
            addCriterion("odid <", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidLessThanOrEqualTo(Integer value) {
            addCriterion("odid <=", value, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidIn(List<Integer> values) {
            addCriterion("odid in", values, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotIn(List<Integer> values) {
            addCriterion("odid not in", values, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidBetween(Integer value1, Integer value2) {
            addCriterion("odid between", value1, value2, "odid");
            return (Criteria) this;
        }

        public Criteria andOdidNotBetween(Integer value1, Integer value2) {
            addCriterion("odid not between", value1, value2, "odid");
            return (Criteria) this;
        }

        public Criteria andOddesIsNull() {
            addCriterion("oddes is null");
            return (Criteria) this;
        }

        public Criteria andOddesIsNotNull() {
            addCriterion("oddes is not null");
            return (Criteria) this;
        }

        public Criteria andOddesEqualTo(String value) {
            addCriterion("oddes =", value, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesNotEqualTo(String value) {
            addCriterion("oddes <>", value, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesGreaterThan(String value) {
            addCriterion("oddes >", value, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesGreaterThanOrEqualTo(String value) {
            addCriterion("oddes >=", value, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesLessThan(String value) {
            addCriterion("oddes <", value, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesLessThanOrEqualTo(String value) {
            addCriterion("oddes <=", value, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesLike(String value) {
            addCriterion("oddes like", value, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesNotLike(String value) {
            addCriterion("oddes not like", value, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesIn(List<String> values) {
            addCriterion("oddes in", values, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesNotIn(List<String> values) {
            addCriterion("oddes not in", values, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesBetween(String value1, String value2) {
            addCriterion("oddes between", value1, value2, "oddes");
            return (Criteria) this;
        }

        public Criteria andOddesNotBetween(String value1, String value2) {
            addCriterion("oddes not between", value1, value2, "oddes");
            return (Criteria) this;
        }

        public Criteria andFoidIsNull() {
            addCriterion("foid is null");
            return (Criteria) this;
        }

        public Criteria andFoidIsNotNull() {
            addCriterion("foid is not null");
            return (Criteria) this;
        }

        public Criteria andFoidEqualTo(Integer value) {
            addCriterion("foid =", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotEqualTo(Integer value) {
            addCriterion("foid <>", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidGreaterThan(Integer value) {
            addCriterion("foid >", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("foid >=", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidLessThan(Integer value) {
            addCriterion("foid <", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidLessThanOrEqualTo(Integer value) {
            addCriterion("foid <=", value, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidIn(List<Integer> values) {
            addCriterion("foid in", values, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotIn(List<Integer> values) {
            addCriterion("foid not in", values, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidBetween(Integer value1, Integer value2) {
            addCriterion("foid between", value1, value2, "foid");
            return (Criteria) this;
        }

        public Criteria andFoidNotBetween(Integer value1, Integer value2) {
            addCriterion("foid not between", value1, value2, "foid");
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