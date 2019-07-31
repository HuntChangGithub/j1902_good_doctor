package com.qf.j1902.pojo;

import java.util.ArrayList;
import java.util.List;

public class TIllnessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TIllnessExample() {
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

        public Criteria andIllidIsNull() {
            addCriterion("illId is null");
            return (Criteria) this;
        }

        public Criteria andIllidIsNotNull() {
            addCriterion("illId is not null");
            return (Criteria) this;
        }

        public Criteria andIllidEqualTo(Integer value) {
            addCriterion("illId =", value, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidNotEqualTo(Integer value) {
            addCriterion("illId <>", value, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidGreaterThan(Integer value) {
            addCriterion("illId >", value, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidGreaterThanOrEqualTo(Integer value) {
            addCriterion("illId >=", value, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidLessThan(Integer value) {
            addCriterion("illId <", value, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidLessThanOrEqualTo(Integer value) {
            addCriterion("illId <=", value, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidIn(List<Integer> values) {
            addCriterion("illId in", values, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidNotIn(List<Integer> values) {
            addCriterion("illId not in", values, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidBetween(Integer value1, Integer value2) {
            addCriterion("illId between", value1, value2, "illid");
            return (Criteria) this;
        }

        public Criteria andIllidNotBetween(Integer value1, Integer value2) {
            addCriterion("illId not between", value1, value2, "illid");
            return (Criteria) this;
        }

        public Criteria andIllnameIsNull() {
            addCriterion("illName is null");
            return (Criteria) this;
        }

        public Criteria andIllnameIsNotNull() {
            addCriterion("illName is not null");
            return (Criteria) this;
        }

        public Criteria andIllnameEqualTo(String value) {
            addCriterion("illName =", value, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameNotEqualTo(String value) {
            addCriterion("illName <>", value, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameGreaterThan(String value) {
            addCriterion("illName >", value, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameGreaterThanOrEqualTo(String value) {
            addCriterion("illName >=", value, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameLessThan(String value) {
            addCriterion("illName <", value, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameLessThanOrEqualTo(String value) {
            addCriterion("illName <=", value, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameLike(String value) {
            addCriterion("illName like", value, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameNotLike(String value) {
            addCriterion("illName not like", value, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameIn(List<String> values) {
            addCriterion("illName in", values, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameNotIn(List<String> values) {
            addCriterion("illName not in", values, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameBetween(String value1, String value2) {
            addCriterion("illName between", value1, value2, "illname");
            return (Criteria) this;
        }

        public Criteria andIllnameNotBetween(String value1, String value2) {
            addCriterion("illName not between", value1, value2, "illname");
            return (Criteria) this;
        }

        public Criteria andIllpartIsNull() {
            addCriterion("illPart is null");
            return (Criteria) this;
        }

        public Criteria andIllpartIsNotNull() {
            addCriterion("illPart is not null");
            return (Criteria) this;
        }

        public Criteria andIllpartEqualTo(String value) {
            addCriterion("illPart =", value, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartNotEqualTo(String value) {
            addCriterion("illPart <>", value, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartGreaterThan(String value) {
            addCriterion("illPart >", value, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartGreaterThanOrEqualTo(String value) {
            addCriterion("illPart >=", value, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartLessThan(String value) {
            addCriterion("illPart <", value, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartLessThanOrEqualTo(String value) {
            addCriterion("illPart <=", value, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartLike(String value) {
            addCriterion("illPart like", value, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartNotLike(String value) {
            addCriterion("illPart not like", value, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartIn(List<String> values) {
            addCriterion("illPart in", values, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartNotIn(List<String> values) {
            addCriterion("illPart not in", values, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartBetween(String value1, String value2) {
            addCriterion("illPart between", value1, value2, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllpartNotBetween(String value1, String value2) {
            addCriterion("illPart not between", value1, value2, "illpart");
            return (Criteria) this;
        }

        public Criteria andIllsortIsNull() {
            addCriterion("illSort is null");
            return (Criteria) this;
        }

        public Criteria andIllsortIsNotNull() {
            addCriterion("illSort is not null");
            return (Criteria) this;
        }

        public Criteria andIllsortEqualTo(String value) {
            addCriterion("illSort =", value, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortNotEqualTo(String value) {
            addCriterion("illSort <>", value, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortGreaterThan(String value) {
            addCriterion("illSort >", value, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortGreaterThanOrEqualTo(String value) {
            addCriterion("illSort >=", value, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortLessThan(String value) {
            addCriterion("illSort <", value, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortLessThanOrEqualTo(String value) {
            addCriterion("illSort <=", value, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortLike(String value) {
            addCriterion("illSort like", value, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortNotLike(String value) {
            addCriterion("illSort not like", value, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortIn(List<String> values) {
            addCriterion("illSort in", values, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortNotIn(List<String> values) {
            addCriterion("illSort not in", values, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortBetween(String value1, String value2) {
            addCriterion("illSort between", value1, value2, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllsortNotBetween(String value1, String value2) {
            addCriterion("illSort not between", value1, value2, "illsort");
            return (Criteria) this;
        }

        public Criteria andIllcrowdIsNull() {
            addCriterion("illCrowd is null");
            return (Criteria) this;
        }

        public Criteria andIllcrowdIsNotNull() {
            addCriterion("illCrowd is not null");
            return (Criteria) this;
        }

        public Criteria andIllcrowdEqualTo(String value) {
            addCriterion("illCrowd =", value, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdNotEqualTo(String value) {
            addCriterion("illCrowd <>", value, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdGreaterThan(String value) {
            addCriterion("illCrowd >", value, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdGreaterThanOrEqualTo(String value) {
            addCriterion("illCrowd >=", value, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdLessThan(String value) {
            addCriterion("illCrowd <", value, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdLessThanOrEqualTo(String value) {
            addCriterion("illCrowd <=", value, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdLike(String value) {
            addCriterion("illCrowd like", value, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdNotLike(String value) {
            addCriterion("illCrowd not like", value, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdIn(List<String> values) {
            addCriterion("illCrowd in", values, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdNotIn(List<String> values) {
            addCriterion("illCrowd not in", values, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdBetween(String value1, String value2) {
            addCriterion("illCrowd between", value1, value2, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllcrowdNotBetween(String value1, String value2) {
            addCriterion("illCrowd not between", value1, value2, "illcrowd");
            return (Criteria) this;
        }

        public Criteria andIllducIsNull() {
            addCriterion("illDuc is null");
            return (Criteria) this;
        }

        public Criteria andIllducIsNotNull() {
            addCriterion("illDuc is not null");
            return (Criteria) this;
        }

        public Criteria andIllducEqualTo(String value) {
            addCriterion("illDuc =", value, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducNotEqualTo(String value) {
            addCriterion("illDuc <>", value, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducGreaterThan(String value) {
            addCriterion("illDuc >", value, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducGreaterThanOrEqualTo(String value) {
            addCriterion("illDuc >=", value, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducLessThan(String value) {
            addCriterion("illDuc <", value, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducLessThanOrEqualTo(String value) {
            addCriterion("illDuc <=", value, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducLike(String value) {
            addCriterion("illDuc like", value, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducNotLike(String value) {
            addCriterion("illDuc not like", value, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducIn(List<String> values) {
            addCriterion("illDuc in", values, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducNotIn(List<String> values) {
            addCriterion("illDuc not in", values, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducBetween(String value1, String value2) {
            addCriterion("illDuc between", value1, value2, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllducNotBetween(String value1, String value2) {
            addCriterion("illDuc not between", value1, value2, "illduc");
            return (Criteria) this;
        }

        public Criteria andIllinfoIsNull() {
            addCriterion("illInfo is null");
            return (Criteria) this;
        }

        public Criteria andIllinfoIsNotNull() {
            addCriterion("illInfo is not null");
            return (Criteria) this;
        }

        public Criteria andIllinfoEqualTo(String value) {
            addCriterion("illInfo =", value, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoNotEqualTo(String value) {
            addCriterion("illInfo <>", value, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoGreaterThan(String value) {
            addCriterion("illInfo >", value, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoGreaterThanOrEqualTo(String value) {
            addCriterion("illInfo >=", value, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoLessThan(String value) {
            addCriterion("illInfo <", value, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoLessThanOrEqualTo(String value) {
            addCriterion("illInfo <=", value, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoLike(String value) {
            addCriterion("illInfo like", value, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoNotLike(String value) {
            addCriterion("illInfo not like", value, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoIn(List<String> values) {
            addCriterion("illInfo in", values, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoNotIn(List<String> values) {
            addCriterion("illInfo not in", values, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoBetween(String value1, String value2) {
            addCriterion("illInfo between", value1, value2, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllinfoNotBetween(String value1, String value2) {
            addCriterion("illInfo not between", value1, value2, "illinfo");
            return (Criteria) this;
        }

        public Criteria andIllcauseIsNull() {
            addCriterion("illCause is null");
            return (Criteria) this;
        }

        public Criteria andIllcauseIsNotNull() {
            addCriterion("illCause is not null");
            return (Criteria) this;
        }

        public Criteria andIllcauseEqualTo(String value) {
            addCriterion("illCause =", value, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseNotEqualTo(String value) {
            addCriterion("illCause <>", value, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseGreaterThan(String value) {
            addCriterion("illCause >", value, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseGreaterThanOrEqualTo(String value) {
            addCriterion("illCause >=", value, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseLessThan(String value) {
            addCriterion("illCause <", value, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseLessThanOrEqualTo(String value) {
            addCriterion("illCause <=", value, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseLike(String value) {
            addCriterion("illCause like", value, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseNotLike(String value) {
            addCriterion("illCause not like", value, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseIn(List<String> values) {
            addCriterion("illCause in", values, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseNotIn(List<String> values) {
            addCriterion("illCause not in", values, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseBetween(String value1, String value2) {
            addCriterion("illCause between", value1, value2, "illcause");
            return (Criteria) this;
        }

        public Criteria andIllcauseNotBetween(String value1, String value2) {
            addCriterion("illCause not between", value1, value2, "illcause");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIsNull() {
            addCriterion("diagnosis is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIsNotNull() {
            addCriterion("diagnosis is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisEqualTo(String value) {
            addCriterion("diagnosis =", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotEqualTo(String value) {
            addCriterion("diagnosis <>", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisGreaterThan(String value) {
            addCriterion("diagnosis >", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisGreaterThanOrEqualTo(String value) {
            addCriterion("diagnosis >=", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLessThan(String value) {
            addCriterion("diagnosis <", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLessThanOrEqualTo(String value) {
            addCriterion("diagnosis <=", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLike(String value) {
            addCriterion("diagnosis like", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotLike(String value) {
            addCriterion("diagnosis not like", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIn(List<String> values) {
            addCriterion("diagnosis in", values, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotIn(List<String> values) {
            addCriterion("diagnosis not in", values, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisBetween(String value1, String value2) {
            addCriterion("diagnosis between", value1, value2, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotBetween(String value1, String value2) {
            addCriterion("diagnosis not between", value1, value2, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andCureIsNull() {
            addCriterion("cure is null");
            return (Criteria) this;
        }

        public Criteria andCureIsNotNull() {
            addCriterion("cure is not null");
            return (Criteria) this;
        }

        public Criteria andCureEqualTo(String value) {
            addCriterion("cure =", value, "cure");
            return (Criteria) this;
        }

        public Criteria andCureNotEqualTo(String value) {
            addCriterion("cure <>", value, "cure");
            return (Criteria) this;
        }

        public Criteria andCureGreaterThan(String value) {
            addCriterion("cure >", value, "cure");
            return (Criteria) this;
        }

        public Criteria andCureGreaterThanOrEqualTo(String value) {
            addCriterion("cure >=", value, "cure");
            return (Criteria) this;
        }

        public Criteria andCureLessThan(String value) {
            addCriterion("cure <", value, "cure");
            return (Criteria) this;
        }

        public Criteria andCureLessThanOrEqualTo(String value) {
            addCriterion("cure <=", value, "cure");
            return (Criteria) this;
        }

        public Criteria andCureLike(String value) {
            addCriterion("cure like", value, "cure");
            return (Criteria) this;
        }

        public Criteria andCureNotLike(String value) {
            addCriterion("cure not like", value, "cure");
            return (Criteria) this;
        }

        public Criteria andCureIn(List<String> values) {
            addCriterion("cure in", values, "cure");
            return (Criteria) this;
        }

        public Criteria andCureNotIn(List<String> values) {
            addCriterion("cure not in", values, "cure");
            return (Criteria) this;
        }

        public Criteria andCureBetween(String value1, String value2) {
            addCriterion("cure between", value1, value2, "cure");
            return (Criteria) this;
        }

        public Criteria andCureNotBetween(String value1, String value2) {
            addCriterion("cure not between", value1, value2, "cure");
            return (Criteria) this;
        }

        public Criteria andPreventIsNull() {
            addCriterion("prevent is null");
            return (Criteria) this;
        }

        public Criteria andPreventIsNotNull() {
            addCriterion("prevent is not null");
            return (Criteria) this;
        }

        public Criteria andPreventEqualTo(String value) {
            addCriterion("prevent =", value, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventNotEqualTo(String value) {
            addCriterion("prevent <>", value, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventGreaterThan(String value) {
            addCriterion("prevent >", value, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventGreaterThanOrEqualTo(String value) {
            addCriterion("prevent >=", value, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventLessThan(String value) {
            addCriterion("prevent <", value, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventLessThanOrEqualTo(String value) {
            addCriterion("prevent <=", value, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventLike(String value) {
            addCriterion("prevent like", value, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventNotLike(String value) {
            addCriterion("prevent not like", value, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventIn(List<String> values) {
            addCriterion("prevent in", values, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventNotIn(List<String> values) {
            addCriterion("prevent not in", values, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventBetween(String value1, String value2) {
            addCriterion("prevent between", value1, value2, "prevent");
            return (Criteria) this;
        }

        public Criteria andPreventNotBetween(String value1, String value2) {
            addCriterion("prevent not between", value1, value2, "prevent");
            return (Criteria) this;
        }

        public Criteria andDepidIsNull() {
            addCriterion("depId is null");
            return (Criteria) this;
        }

        public Criteria andDepidIsNotNull() {
            addCriterion("depId is not null");
            return (Criteria) this;
        }

        public Criteria andDepidEqualTo(Integer value) {
            addCriterion("depId =", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidNotEqualTo(Integer value) {
            addCriterion("depId <>", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidGreaterThan(Integer value) {
            addCriterion("depId >", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidGreaterThanOrEqualTo(Integer value) {
            addCriterion("depId >=", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidLessThan(Integer value) {
            addCriterion("depId <", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidLessThanOrEqualTo(Integer value) {
            addCriterion("depId <=", value, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidIn(List<Integer> values) {
            addCriterion("depId in", values, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidNotIn(List<Integer> values) {
            addCriterion("depId not in", values, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidBetween(Integer value1, Integer value2) {
            addCriterion("depId between", value1, value2, "depid");
            return (Criteria) this;
        }

        public Criteria andDepidNotBetween(Integer value1, Integer value2) {
            addCriterion("depId not between", value1, value2, "depid");
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