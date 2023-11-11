package wordnet.genshin.domain;

import java.util.ArrayList;
import java.util.List;

public class DictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictExample() {
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

        public Criteria andSynsetidIsNull() {
            addCriterion("synsetid is null");
            return (Criteria) this;
        }

        public Criteria andSynsetidIsNotNull() {
            addCriterion("synsetid is not null");
            return (Criteria) this;
        }

        public Criteria andSynsetidEqualTo(Integer value) {
            addCriterion("synsetid =", value, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidNotEqualTo(Integer value) {
            addCriterion("synsetid <>", value, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidGreaterThan(Integer value) {
            addCriterion("synsetid >", value, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("synsetid >=", value, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidLessThan(Integer value) {
            addCriterion("synsetid <", value, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidLessThanOrEqualTo(Integer value) {
            addCriterion("synsetid <=", value, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidIn(List<Integer> values) {
            addCriterion("synsetid in", values, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidNotIn(List<Integer> values) {
            addCriterion("synsetid not in", values, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidBetween(Integer value1, Integer value2) {
            addCriterion("synsetid between", value1, value2, "synsetid");
            return (Criteria) this;
        }

        public Criteria andSynsetidNotBetween(Integer value1, Integer value2) {
            addCriterion("synsetid not between", value1, value2, "synsetid");
            return (Criteria) this;
        }

        public Criteria andWordidIsNull() {
            addCriterion("wordid is null");
            return (Criteria) this;
        }

        public Criteria andWordidIsNotNull() {
            addCriterion("wordid is not null");
            return (Criteria) this;
        }

        public Criteria andWordidEqualTo(Integer value) {
            addCriterion("wordid =", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidNotEqualTo(Integer value) {
            addCriterion("wordid <>", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidGreaterThan(Integer value) {
            addCriterion("wordid >", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wordid >=", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidLessThan(Integer value) {
            addCriterion("wordid <", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidLessThanOrEqualTo(Integer value) {
            addCriterion("wordid <=", value, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidIn(List<Integer> values) {
            addCriterion("wordid in", values, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidNotIn(List<Integer> values) {
            addCriterion("wordid not in", values, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidBetween(Integer value1, Integer value2) {
            addCriterion("wordid between", value1, value2, "wordid");
            return (Criteria) this;
        }

        public Criteria andWordidNotBetween(Integer value1, Integer value2) {
            addCriterion("wordid not between", value1, value2, "wordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidIsNull() {
            addCriterion("casedwordid is null");
            return (Criteria) this;
        }

        public Criteria andCasedwordidIsNotNull() {
            addCriterion("casedwordid is not null");
            return (Criteria) this;
        }

        public Criteria andCasedwordidEqualTo(Integer value) {
            addCriterion("casedwordid =", value, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidNotEqualTo(Integer value) {
            addCriterion("casedwordid <>", value, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidGreaterThan(Integer value) {
            addCriterion("casedwordid >", value, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidGreaterThanOrEqualTo(Integer value) {
            addCriterion("casedwordid >=", value, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidLessThan(Integer value) {
            addCriterion("casedwordid <", value, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidLessThanOrEqualTo(Integer value) {
            addCriterion("casedwordid <=", value, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidIn(List<Integer> values) {
            addCriterion("casedwordid in", values, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidNotIn(List<Integer> values) {
            addCriterion("casedwordid not in", values, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidBetween(Integer value1, Integer value2) {
            addCriterion("casedwordid between", value1, value2, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andCasedwordidNotBetween(Integer value1, Integer value2) {
            addCriterion("casedwordid not between", value1, value2, "casedwordid");
            return (Criteria) this;
        }

        public Criteria andLemmaIsNull() {
            addCriterion("lemma is null");
            return (Criteria) this;
        }

        public Criteria andLemmaIsNotNull() {
            addCriterion("lemma is not null");
            return (Criteria) this;
        }

        public Criteria andLemmaEqualTo(String value) {
            addCriterion("lemma =", value, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaNotEqualTo(String value) {
            addCriterion("lemma <>", value, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaGreaterThan(String value) {
            addCriterion("lemma >", value, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaGreaterThanOrEqualTo(String value) {
            addCriterion("lemma >=", value, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaLessThan(String value) {
            addCriterion("lemma <", value, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaLessThanOrEqualTo(String value) {
            addCriterion("lemma <=", value, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaLike(String value) {
            addCriterion("lemma like", value, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaNotLike(String value) {
            addCriterion("lemma not like", value, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaIn(List<String> values) {
            addCriterion("lemma in", values, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaNotIn(List<String> values) {
            addCriterion("lemma not in", values, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaBetween(String value1, String value2) {
            addCriterion("lemma between", value1, value2, "lemma");
            return (Criteria) this;
        }

        public Criteria andLemmaNotBetween(String value1, String value2) {
            addCriterion("lemma not between", value1, value2, "lemma");
            return (Criteria) this;
        }

        public Criteria andSenseidIsNull() {
            addCriterion("senseid is null");
            return (Criteria) this;
        }

        public Criteria andSenseidIsNotNull() {
            addCriterion("senseid is not null");
            return (Criteria) this;
        }

        public Criteria andSenseidEqualTo(Integer value) {
            addCriterion("senseid =", value, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidNotEqualTo(Integer value) {
            addCriterion("senseid <>", value, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidGreaterThan(Integer value) {
            addCriterion("senseid >", value, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("senseid >=", value, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidLessThan(Integer value) {
            addCriterion("senseid <", value, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidLessThanOrEqualTo(Integer value) {
            addCriterion("senseid <=", value, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidIn(List<Integer> values) {
            addCriterion("senseid in", values, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidNotIn(List<Integer> values) {
            addCriterion("senseid not in", values, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidBetween(Integer value1, Integer value2) {
            addCriterion("senseid between", value1, value2, "senseid");
            return (Criteria) this;
        }

        public Criteria andSenseidNotBetween(Integer value1, Integer value2) {
            addCriterion("senseid not between", value1, value2, "senseid");
            return (Criteria) this;
        }

        public Criteria andSensenumIsNull() {
            addCriterion("sensenum is null");
            return (Criteria) this;
        }

        public Criteria andSensenumIsNotNull() {
            addCriterion("sensenum is not null");
            return (Criteria) this;
        }

        public Criteria andSensenumEqualTo(Short value) {
            addCriterion("sensenum =", value, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumNotEqualTo(Short value) {
            addCriterion("sensenum <>", value, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumGreaterThan(Short value) {
            addCriterion("sensenum >", value, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumGreaterThanOrEqualTo(Short value) {
            addCriterion("sensenum >=", value, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumLessThan(Short value) {
            addCriterion("sensenum <", value, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumLessThanOrEqualTo(Short value) {
            addCriterion("sensenum <=", value, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumIn(List<Short> values) {
            addCriterion("sensenum in", values, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumNotIn(List<Short> values) {
            addCriterion("sensenum not in", values, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumBetween(Short value1, Short value2) {
            addCriterion("sensenum between", value1, value2, "sensenum");
            return (Criteria) this;
        }

        public Criteria andSensenumNotBetween(Short value1, Short value2) {
            addCriterion("sensenum not between", value1, value2, "sensenum");
            return (Criteria) this;
        }

        public Criteria andLexidIsNull() {
            addCriterion("lexid is null");
            return (Criteria) this;
        }

        public Criteria andLexidIsNotNull() {
            addCriterion("lexid is not null");
            return (Criteria) this;
        }

        public Criteria andLexidEqualTo(Short value) {
            addCriterion("lexid =", value, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidNotEqualTo(Short value) {
            addCriterion("lexid <>", value, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidGreaterThan(Short value) {
            addCriterion("lexid >", value, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidGreaterThanOrEqualTo(Short value) {
            addCriterion("lexid >=", value, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidLessThan(Short value) {
            addCriterion("lexid <", value, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidLessThanOrEqualTo(Short value) {
            addCriterion("lexid <=", value, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidIn(List<Short> values) {
            addCriterion("lexid in", values, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidNotIn(List<Short> values) {
            addCriterion("lexid not in", values, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidBetween(Short value1, Short value2) {
            addCriterion("lexid between", value1, value2, "lexid");
            return (Criteria) this;
        }

        public Criteria andLexidNotBetween(Short value1, Short value2) {
            addCriterion("lexid not between", value1, value2, "lexid");
            return (Criteria) this;
        }

        public Criteria andTagcountIsNull() {
            addCriterion("tagcount is null");
            return (Criteria) this;
        }

        public Criteria andTagcountIsNotNull() {
            addCriterion("tagcount is not null");
            return (Criteria) this;
        }

        public Criteria andTagcountEqualTo(Integer value) {
            addCriterion("tagcount =", value, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountNotEqualTo(Integer value) {
            addCriterion("tagcount <>", value, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountGreaterThan(Integer value) {
            addCriterion("tagcount >", value, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("tagcount >=", value, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountLessThan(Integer value) {
            addCriterion("tagcount <", value, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountLessThanOrEqualTo(Integer value) {
            addCriterion("tagcount <=", value, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountIn(List<Integer> values) {
            addCriterion("tagcount in", values, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountNotIn(List<Integer> values) {
            addCriterion("tagcount not in", values, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountBetween(Integer value1, Integer value2) {
            addCriterion("tagcount between", value1, value2, "tagcount");
            return (Criteria) this;
        }

        public Criteria andTagcountNotBetween(Integer value1, Integer value2) {
            addCriterion("tagcount not between", value1, value2, "tagcount");
            return (Criteria) this;
        }

        public Criteria andSensekeyIsNull() {
            addCriterion("sensekey is null");
            return (Criteria) this;
        }

        public Criteria andSensekeyIsNotNull() {
            addCriterion("sensekey is not null");
            return (Criteria) this;
        }

        public Criteria andSensekeyEqualTo(String value) {
            addCriterion("sensekey =", value, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyNotEqualTo(String value) {
            addCriterion("sensekey <>", value, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyGreaterThan(String value) {
            addCriterion("sensekey >", value, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyGreaterThanOrEqualTo(String value) {
            addCriterion("sensekey >=", value, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyLessThan(String value) {
            addCriterion("sensekey <", value, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyLessThanOrEqualTo(String value) {
            addCriterion("sensekey <=", value, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyLike(String value) {
            addCriterion("sensekey like", value, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyNotLike(String value) {
            addCriterion("sensekey not like", value, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyIn(List<String> values) {
            addCriterion("sensekey in", values, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyNotIn(List<String> values) {
            addCriterion("sensekey not in", values, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyBetween(String value1, String value2) {
            addCriterion("sensekey between", value1, value2, "sensekey");
            return (Criteria) this;
        }

        public Criteria andSensekeyNotBetween(String value1, String value2) {
            addCriterion("sensekey not between", value1, value2, "sensekey");
            return (Criteria) this;
        }

        public Criteria andCasedIsNull() {
            addCriterion("cased is null");
            return (Criteria) this;
        }

        public Criteria andCasedIsNotNull() {
            addCriterion("cased is not null");
            return (Criteria) this;
        }

        public Criteria andCasedEqualTo(String value) {
            addCriterion("cased =", value, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedNotEqualTo(String value) {
            addCriterion("cased <>", value, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedGreaterThan(String value) {
            addCriterion("cased >", value, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedGreaterThanOrEqualTo(String value) {
            addCriterion("cased >=", value, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedLessThan(String value) {
            addCriterion("cased <", value, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedLessThanOrEqualTo(String value) {
            addCriterion("cased <=", value, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedLike(String value) {
            addCriterion("cased like", value, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedNotLike(String value) {
            addCriterion("cased not like", value, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedIn(List<String> values) {
            addCriterion("cased in", values, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedNotIn(List<String> values) {
            addCriterion("cased not in", values, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedBetween(String value1, String value2) {
            addCriterion("cased between", value1, value2, "cased");
            return (Criteria) this;
        }

        public Criteria andCasedNotBetween(String value1, String value2) {
            addCriterion("cased not between", value1, value2, "cased");
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

        public Criteria andLexdomainidIsNull() {
            addCriterion("lexdomainid is null");
            return (Criteria) this;
        }

        public Criteria andLexdomainidIsNotNull() {
            addCriterion("lexdomainid is not null");
            return (Criteria) this;
        }

        public Criteria andLexdomainidEqualTo(Short value) {
            addCriterion("lexdomainid =", value, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidNotEqualTo(Short value) {
            addCriterion("lexdomainid <>", value, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidGreaterThan(Short value) {
            addCriterion("lexdomainid >", value, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidGreaterThanOrEqualTo(Short value) {
            addCriterion("lexdomainid >=", value, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidLessThan(Short value) {
            addCriterion("lexdomainid <", value, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidLessThanOrEqualTo(Short value) {
            addCriterion("lexdomainid <=", value, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidIn(List<Short> values) {
            addCriterion("lexdomainid in", values, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidNotIn(List<Short> values) {
            addCriterion("lexdomainid not in", values, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidBetween(Short value1, Short value2) {
            addCriterion("lexdomainid between", value1, value2, "lexdomainid");
            return (Criteria) this;
        }

        public Criteria andLexdomainidNotBetween(Short value1, Short value2) {
            addCriterion("lexdomainid not between", value1, value2, "lexdomainid");
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